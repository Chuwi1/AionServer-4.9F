/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 */
package quest.daevation;

import com.aionemu.gameserver.model.DialogAction;
import com.aionemu.gameserver.model.TeleportAnimation;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.questEngine.handlers.QuestHandler;
import com.aionemu.gameserver.questEngine.model.QuestEnv;
import com.aionemu.gameserver.questEngine.model.QuestState;
import com.aionemu.gameserver.questEngine.model.QuestStatus;
import com.aionemu.gameserver.services.QuestService;


/**
 * @author FrozenKiller
 */
public class _15324UnyieldingSpirit extends QuestHandler {
	
    public static final int questId = 15324;
	private final static int[] mobs = {235939, 235940, 235941, 235942, 235944, 235947, };
	private final static int[] mobs2 = {233929, 233930, 233931, 233932, 233933, 233934, 233935, 233936};
	private final static int[] mobs3 = {234277, 234279, 234280, 234524, 234531, 234532};
    
	public _15324UnyieldingSpirit() {
        super(questId);
    }

    @Override
    public void register() {
		qe.registerQuestNpc(805331).addOnQuestStart(questId); 
        qe.registerQuestNpc(805331).addOnTalkEvent(questId); // Machina
		for (int mob : mobs) {
			qe.registerQuestNpc(mob).addOnKillEvent(questId);
        }
		for (int mob2 : mobs2) {
			qe.registerQuestNpc(mob2).addOnKillEvent(questId);
        }
		for (int mob3 : mobs3) {
			qe.registerQuestNpc(mob3).addOnKillEvent(questId);
        }
    }
	
	@Override
	public boolean onDialogEvent(QuestEnv env) {
		Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        int targetId = env.getTargetId();
        DialogAction dialog = env.getDialog();
		
		if (qs == null || qs.getStatus() == QuestStatus.NONE || qs.canRepeat()) {
            if (targetId == 805331) { // Machina
				switch (dialog) {
                    case QUEST_SELECT: {
                        return sendQuestDialog(env, 4762);
                    }
                    case QUEST_ACCEPT_1:
                    case QUEST_ACCEPT_SIMPLE:
						QuestService.startQuest(env);
                        return closeDialogWindow(env);
					case QUEST_REFUSE_1:
					case QUEST_REFUSE_SIMPLE:
						return closeDialogWindow(env);
				default:
					break;
                }
            }
        } else if (qs.getStatus() == QuestStatus.REWARD) {
			if (targetId == 805331){
				switch (dialog) {
                    case USE_OBJECT: {
                        return sendQuestDialog(env, 10002);
                    }
                    case SELECT_QUEST_REWARD: {
                        return sendQuestDialog(env, 5);
                    }
                    case SELECTED_QUEST_NOREWARD: {
                        return sendQuestEndDialog(env);
                    }
                    default:
                        break;
                }
			}
		}
		return false;
	}
	@Override
    public boolean onKillEvent(QuestEnv env) {
		Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        if (qs == null || qs.getStatus() != QuestStatus.START) {
            return false;
        }
		
		int var = qs.getQuestVarById(0);
		int var1 = qs.getQuestVarById(1);
		int targetId = env.getTargetId();
		if (var == 0 && var1 >= 0 && var1 < 19) {
			return defaultOnKillEvent(env, mobs, var1, var1 + 1, 1);
		} else if (var == 0 && var1 == 19) {
			qs.setQuestVarById(1, 0);
			changeQuestStep(env, 0, 1, false); // 1
			updateQuestStatus(env);
			return true;
		}
		if (var == 1 && var1 >= 0 && var1 < 19) {
			return defaultOnKillEvent(env, mobs2, var1, var1 + 1, 1);
		} else if (var == 1 && var1 == 19) {
			qs.setQuestVarById(1, 0);
			changeQuestStep(env, 1, 2, false); // 2
			updateQuestStatus(env);
			return true;
		}
		if (var == 2 && var1 >= 0 && var1 < 19) {
			return defaultOnKillEvent(env, mobs3, var1, var1 + 1, 1);
		} else if (var == 2 && var1 == 19) {
			qs.setQuestVarById(1, 0);
			qs.setQuestVar(3);
			qs.setStatus(QuestStatus.REWARD);
			updateQuestStatus(env);
			return true;
		}
		return false;
	}
}
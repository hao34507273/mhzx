/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.common.IOutFightObject;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.OpSummonMonster;
/*     */ import mzm.gsp.monster.main.Monster;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FighterMonster
/*     */   extends Fighter
/*     */ {
/*     */   private static final int TYPE_NPC_MONSTER = 1;
/*     */   private static final int TYPE_INVINCIBLE_MONSTER = 2;
/*     */   
/*     */   FighterMonster(int fighterid, xbean.Fighter xFighter, FightGroup fightGroup)
/*     */   {
/*  28 */     super(fighterid, xFighter, fightGroup);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean canPlayerOperate()
/*     */   {
/*  34 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void init(Monster monster, int pos)
/*     */   {
/*  44 */     init(monster, pos, FightArgs.getInstance().getDefaultRate());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void init(Monster monster, int pos, int hprate)
/*     */   {
/*  55 */     setPos(pos);
/*     */     
/*     */ 
/*  58 */     setMonsterid(monster.getId());
/*     */     
/*     */ 
/*  61 */     setLevel(monster.getLevel());
/*     */     
/*     */ 
/*  64 */     double d = hprate * 1.0D / FightArgs.getInstance().getDefaultRate();
/*  65 */     setHp((int)(monster.getHP() * d));
/*  66 */     setMp(monster.getMP());
/*  67 */     setAnger(monster.getMaxAnger());
/*  68 */     setGender(monster);
/*  69 */     setOccupation(monster.getOccupationId());
/*     */     
/*     */ 
/*  72 */     monster.fillSelfFixFightProperty(getAttrsMap());
/*     */     
/*  74 */     monster.fillOtherFightProperty(getExa_AttrsMap());
/*     */     
/*     */ 
/*  77 */     List<Integer> skillList = monster.getMonsterSkillIdList();
/*  78 */     for (Iterator i$ = skillList.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*     */       
/*  80 */       addSkill(skillid, monster.getLevel());
/*     */     }
/*  82 */     if (this.fightGroup.getGroupAI() == null)
/*     */     {
/*  84 */       setAi(new AI(monster.getStrategy()).getAi());
/*     */     }
/*     */     
/*  87 */     for (SOutFightEffectGroup outFightEffectGroup : monster.getFighterEffect())
/*     */     {
/*  89 */       FighterEffect fighterEffect = getPassiveEffect(outFightEffectGroup.effectId, outFightEffectGroup.formulaList);
/*  90 */       addPassiveEffect(fighterEffect);
/*     */     }
/*  92 */     initOutFightCommon(monster);
/*     */   }
/*     */   
/*     */ 
/*     */   protected IOutFightObject getOutFightObj()
/*     */   {
/*  98 */     return MonsterInterface.getMonster(getMonsterid(), getLevel());
/*     */   }
/*     */   
/*     */ 
/*     */   public void childFillModelInfo(ModelInfo modelInfo)
/*     */   {
/* 104 */     ModelInfo tempModelInfo = getFightParamModelInfo();
/* 105 */     if (tempModelInfo == null)
/*     */     {
/* 107 */       super.childFillModelInfo(modelInfo);
/*     */     }
/*     */     else
/*     */     {
/* 111 */       modelInfo.extramap.putAll(tempModelInfo.extramap);
/* 112 */       modelInfo.modelid = tempModelInfo.modelid;
/* 113 */       modelInfo.name = tempModelInfo.name;
/*     */     }
/*     */   }
/*     */   
/*     */   private ModelInfo getFightParamModelInfo()
/*     */   {
/* 119 */     FightParam fightParam = this.fightGroup.fightTeam.fight.getFightParam();
/* 120 */     if (fightParam == null)
/*     */     {
/* 122 */       return null;
/*     */     }
/* 124 */     if (fightParam.pveRoleRowModleInfos.size() < 0)
/*     */     {
/* 126 */       return null;
/*     */     }
/* 128 */     int perRowNum = FightManager.getPosNumberPerRow();
/* 129 */     int posPior = getPos() - 1 * perRowNum;
/* 130 */     List<Integer> posPiorList = FightManager.getPosPiorList();
/* 131 */     int index = posPiorList.indexOf(Integer.valueOf(posPior));
/* 132 */     if (index < 0)
/*     */     {
/* 134 */       return null;
/*     */     }
/* 136 */     if (index >= fightParam.pveRoleRowModleInfos.size())
/*     */     {
/* 138 */       return null;
/*     */     }
/* 140 */     return ((RoleRowModleInfo)fightParam.pveRoleRowModleInfos.get(index)).modelInfo;
/*     */   }
/*     */   
/*     */   public int getMonsterid()
/*     */   {
/* 145 */     return getExtra(FighterExtra.Monsterid);
/*     */   }
/*     */   
/*     */   protected void setMonsterid(int monsterid)
/*     */   {
/* 150 */     setExtra(FighterExtra.Monsterid, monsterid);
/*     */   }
/*     */   
/*     */   protected void setLevel(int level)
/*     */   {
/* 155 */     setExtra(FighterExtra.Monster_Level, level);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 161 */     return getExtra(FighterExtra.Monster_Level);
/*     */   }
/*     */   
/*     */ 
/*     */   public String getName()
/*     */   {
/* 167 */     ModelInfo tempModelInfo = getFightParamModelInfo();
/* 168 */     if (tempModelInfo == null)
/*     */     {
/* 170 */       return super.getName();
/*     */     }
/*     */     
/*     */ 
/* 174 */     return tempModelInfo.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean isAuto()
/*     */   {
/* 181 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected int getAutoSkill()
/*     */   {
/* 187 */     return getNormalSkill();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setAuto() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void broadCastSelectOperInTeam() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onFightEnd()
/*     */   {
/* 209 */     this.fightGroup.addLeaveFightFighter(this);
/* 210 */     this.fightGroup.removeFighter(this.fighterid);
/*     */   }
/*     */   
/*     */   protected void setNpcMonster()
/*     */   {
/* 215 */     setExtra(FighterExtra.MONSTER_MINI_TYPE, 1);
/*     */   }
/*     */   
/*     */   protected boolean isNpcMonster()
/*     */   {
/* 220 */     return getExtra(FighterExtra.MONSTER_MINI_TYPE) == 1;
/*     */   }
/*     */   
/*     */   static boolean isNpcMonseter(xbean.Fighter xFighter)
/*     */   {
/* 225 */     Integer value = (Integer)xFighter.getExtra().get(Integer.valueOf(FighterExtra.MONSTER_MINI_TYPE.ordinal()));
/* 226 */     if (value == null)
/*     */     {
/* 228 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 232 */     return value.intValue() == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setInvincibleMonster()
/*     */   {
/* 241 */     setExtra(FighterExtra.MONSTER_MINI_TYPE, 2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean isInvincibleMonster()
/*     */   {
/* 251 */     return getExtra(FighterExtra.MONSTER_MINI_TYPE) == 2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static boolean isInvincibleMonster(xbean.Fighter xFighter)
/*     */   {
/* 262 */     Integer value = (Integer)xFighter.getExtra().get(Integer.valueOf(FighterExtra.MONSTER_MINI_TYPE.ordinal()));
/* 263 */     if (value == null)
/*     */     {
/* 265 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 269 */     return value.intValue() == 2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void excuteOpSummonMonster(OpSummonMonster opSummonMonster, ExcuteCmdResult excuteCmdResult)
/*     */   {
/* 276 */     if ((isFakeDead()) || (isDead()))
/*     */     {
/* 278 */       return;
/*     */     }
/* 280 */     int size = opSummonMonster.monsterids.size();
/* 281 */     if (size <= 0)
/*     */     {
/* 283 */       return;
/*     */     }
/*     */     
/* 286 */     if (opSummonMonster.sameteam == 0)
/*     */     {
/* 288 */       this.fightGroup.fightTeam.excuteOpSummonMonster(getid(), opSummonMonster.monsterids, opSummonMonster.positions, opSummonMonster.level, excuteCmdResult);
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/* 293 */     else if (this.fightGroup.fightTeam.isActive)
/*     */     {
/* 295 */       this.fightGroup.fightTeam.fight.getPassiveTeam().excuteOpSummonMonster(getid(), opSummonMonster.monsterids, opSummonMonster.positions, opSummonMonster.level, excuteCmdResult);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 300 */       this.fightGroup.fightTeam.fight.getActiveTeam().excuteOpSummonMonster(getid(), opSummonMonster.monsterids, opSummonMonster.positions, opSummonMonster.level, excuteCmdResult);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 306 */     addActionCount();
/*     */   }
/*     */   
/*     */ 
/*     */   void onDead()
/*     */   {
/* 312 */     if (isNotLeave())
/*     */     {
/* 314 */       setFakeDead();
/*     */     }
/*     */     else
/*     */     {
/* 318 */       setDead();
/*     */     }
/* 320 */     super.onFighterDead();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isMyOwner(Fighter fighter)
/*     */   {
/* 326 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void initChangeModelCard()
/*     */   {
/* 349 */     int cfgId = getMonsterid();
/* 350 */     initChangeModelCard(MonsterInterface.getMonsterClassType(cfgId), MonsterInterface.getMonsterClassLevel(cfgId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FighterMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
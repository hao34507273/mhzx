/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.AllMoveSteps;
/*     */ import mzm.gsp.question.AnswerInfo;
/*     */ import mzm.gsp.question.MoveStep;
/*     */ import mzm.gsp.question.SSyncPictureInfo;
/*     */ import mzm.gsp.question.SSyncPictureQuestionInfo;
/*     */ import mzm.gsp.question.confbean.SPictureQuestionItemCfg;
/*     */ import mzm.gsp.question.confbean.SPictureQuestionItemResourceCfg;
/*     */ import mzm.gsp.question.confbean.SPictureQuestionLevelCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RolePictureQuestionInfo;
/*     */ import xdb.Xdb;
/*     */ import xtable.Picturequestion;
/*     */ import xtable.Role2picturequestion;
/*     */ 
/*     */ public class PictureQuestionManager
/*     */ {
/*  29 */   private static PictureQuestionManager instance = new PictureQuestionManager();
/*  30 */   static Logger logger = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static PictureQuestionManager getInstance()
/*     */   {
/*  38 */     return instance;
/*     */   }
/*     */   
/*     */   void init()
/*     */   {
/*  43 */     logger = Logger.getLogger(PictureQuestionManager.class);
/*     */   }
/*     */   
/*     */   void fillMember(long roleId, AnswerInfo info)
/*     */   {
/*  48 */     info.roleid = roleId;
/*  49 */     info.gender = RoleInterface.getGender(roleId);
/*  50 */     info.occupationid = RoleInterface.getOccupationId(roleId);
/*  51 */     info.rolename = RoleInterface.getName(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   SSyncPictureInfo randomPictureAndQuestions(xbean.PictureInfo xPictureInfo)
/*     */   {
/*  63 */     SPictureQuestionLevelCfg levelCfg = SPictureQuestionLevelCfg.get(xPictureInfo.getQuestionlevelcfgid());
/*     */     
/*  65 */     xPictureInfo.setQuestionlevelcfgid(levelCfg.id);
/*     */     
/*  67 */     Map<Integer, Integer> type2countMap = new HashMap();
/*     */     
/*  69 */     List<Integer> resourceList = randomTotalResource(levelCfg, type2countMap);
/*     */     
/*  71 */     SSyncPictureInfo sSyncPictureInfo = new SSyncPictureInfo();
/*     */     
/*  73 */     sSyncPictureInfo.info.resourcelist.addAll(resourceList);
/*  74 */     sSyncPictureInfo.info.difficultylevelid = xPictureInfo.getQuestionlevelcfgid();
/*  75 */     randomPath(levelCfg, resourceList, sSyncPictureInfo);
/*  76 */     generateAnswer1(levelCfg, resourceList, levelCfg.questionNum, sSyncPictureInfo, xPictureInfo);
/*     */     
/*  78 */     return sSyncPictureInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void generateAnswer1(SPictureQuestionLevelCfg levelCfg, List<Integer> resourceIdList, int questionNum, SSyncPictureInfo info, xbean.PictureInfo xPictureInfo)
/*     */   {
/*  85 */     Map<Integer, List<Integer>> type2resourceMap = new HashMap();
/*  86 */     int bianYiNum = 0;
/*  87 */     int shiPinNum = 0;
/*     */     
/*  89 */     Map<Integer, List<Integer>> resourceId2posList = new HashMap();
/*  90 */     for (int i = 0; i < resourceIdList.size(); i++)
/*     */     {
/*  92 */       List<Integer> posList = (List)resourceId2posList.get(resourceIdList.get(i));
/*  93 */       if (posList == null)
/*     */       {
/*  95 */         posList = new ArrayList();
/*  96 */         resourceId2posList.put(resourceIdList.get(i), posList);
/*     */       }
/*  98 */       posList.add(Integer.valueOf(i + 1));
/*     */     }
/*     */     
/* 101 */     for (Iterator i$ = resourceIdList.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/* 104 */       SPictureQuestionItemResourceCfg cfg = SPictureQuestionItemResourceCfg.get(id);
/* 105 */       List<Integer> resourceList = (List)type2resourceMap.get(Integer.valueOf(cfg.type));
/* 106 */       if (resourceList == null)
/*     */       {
/* 108 */         resourceList = new ArrayList();
/* 109 */         type2resourceMap.put(Integer.valueOf(cfg.type), resourceList);
/*     */       }
/* 111 */       resourceList.add(Integer.valueOf(id));
/*     */       
/* 113 */       if (cfg.isEquipDecorate)
/*     */       {
/* 115 */         shiPinNum++;
/*     */       }
/* 117 */       if (cfg.isBianyi)
/*     */       {
/* 119 */         bianYiNum++;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 125 */     List<Integer> finalQuetionItemTypeList = new ArrayList();
/* 126 */     finalQuetionItemTypeList.addAll(SPictureQuestionItemCfg.getAll().keySet());
/*     */     
/* 128 */     int roleSize = xPictureInfo.getRoleidlist().size();
/* 129 */     int answerRoleIdx = 0;
/* 130 */     List<Integer> typeLists = new ArrayList();
/* 131 */     typeLists.addAll(type2resourceMap.keySet());
/* 132 */     List<Integer> hasrandomquestiontype = new ArrayList();
/* 133 */     int rdmIdx = Xdb.random().nextInt(finalQuetionItemTypeList.size());
/* 134 */     while (xPictureInfo.getQuestionlist().size() < questionNum)
/*     */     {
/* 136 */       if (hasrandomquestiontype.containsAll(finalQuetionItemTypeList))
/*     */       {
/* 138 */         hasrandomquestiontype.clear();
/* 139 */         rdmIdx = Xdb.random().nextInt(finalQuetionItemTypeList.size());
/*     */       }
/*     */       
/* 142 */       int questiontype = ((Integer)finalQuetionItemTypeList.get(rdmIdx++)).intValue();
/* 143 */       hasrandomquestiontype.add(Integer.valueOf(questiontype));
/* 144 */       if (rdmIdx >= finalQuetionItemTypeList.size())
/*     */       {
/* 146 */         rdmIdx = 0;
/*     */       }
/*     */       
/* 149 */       SPictureQuestionItemCfg itemCfg = SPictureQuestionItemCfg.get(questiontype);
/*     */       
/* 151 */       xbean.PictureQuestionInfo xPictureQuestionInfo = xbean.Pod.newPictureQuestionInfo();
/* 152 */       xPictureQuestionInfo.setQuestionid(itemCfg.id);
/* 153 */       if (itemCfg.questionType == 1)
/*     */       {
/*     */ 
/* 156 */         int size = typeLists.size();
/*     */         
/* 158 */         int randomIdx = Xdb.random().nextInt(size);
/* 159 */         int selecttype = ((Integer)typeLists.get(randomIdx)).intValue();
/* 160 */         int count = ((List)type2resourceMap.get(Integer.valueOf(selecttype))).size();
/*     */         
/* 162 */         xPictureQuestionInfo.setRightanswer(count);
/* 163 */         xPictureQuestionInfo.getParammap().put(Integer.valueOf(0), Integer.valueOf(selecttype));
/*     */ 
/*     */       }
/* 166 */       else if (itemCfg.questionType == 5)
/*     */       {
/*     */ 
/* 169 */         xPictureQuestionInfo.setRightanswer(bianYiNum);
/*     */       }
/* 171 */       else if (itemCfg.questionType == 6)
/*     */       {
/*     */ 
/* 174 */         xPictureQuestionInfo.setRightanswer(resourceIdList.size() - bianYiNum);
/*     */       }
/* 176 */       else if (itemCfg.questionType == 7)
/*     */       {
/*     */ 
/* 179 */         xPictureQuestionInfo.setRightanswer(shiPinNum);
/*     */       }
/* 181 */       else if (itemCfg.questionType == 8)
/*     */       {
/*     */ 
/* 184 */         xPictureQuestionInfo.setRightanswer(resourceIdList.size() - shiPinNum);
/*     */       }
/* 186 */       else if (itemCfg.questionType == 3)
/*     */       {
/*     */ 
/* 189 */         int size = typeLists.size();
/*     */         
/* 191 */         int randomIdx = Xdb.random().nextInt(size);
/* 192 */         int selecttype = ((Integer)typeLists.get(randomIdx)).intValue();
/* 193 */         List<Integer> residList = (List)type2resourceMap.get(Integer.valueOf(selecttype));
/* 194 */         Set<Integer> resSet = new java.util.HashSet(residList);
/*     */         
/* 196 */         int count = 0;
/* 197 */         for (Iterator i$ = resSet.iterator(); i$.hasNext();) { int resid = ((Integer)i$.next()).intValue();
/*     */           
/* 199 */           posList = (List)resourceId2posList.get(Integer.valueOf(resid));
/*     */           
/* 201 */           for (AllMoveSteps allStep : info.info.movepath)
/*     */           {
/* 203 */             for (MoveStep step : allStep.steps)
/*     */             {
/* 205 */               if (posList.contains(Integer.valueOf(step.resourceno)))
/*     */               {
/* 207 */                 count++;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         List<Integer> posList;
/* 213 */         xPictureQuestionInfo.setRightanswer(count);
/* 214 */         xPictureQuestionInfo.getParammap().put(Integer.valueOf(0), Integer.valueOf(selecttype));
/*     */       }
/* 216 */       else if (itemCfg.questionType == 2)
/*     */       {
/* 218 */         int size = typeLists.size();
/*     */         
/* 220 */         int randomIdx = Xdb.random().nextInt(size);
/* 221 */         int selecttype = ((Integer)typeLists.get(randomIdx)).intValue();
/* 222 */         List<Integer> residList = (List)type2resourceMap.get(Integer.valueOf(selecttype));
/* 223 */         int count = 0;
/* 224 */         for (Iterator i$ = residList.iterator(); i$.hasNext();) { int resid = ((Integer)i$.next()).intValue();
/*     */           
/* 226 */           SPictureQuestionItemResourceCfg cfg = SPictureQuestionItemResourceCfg.get(resid);
/* 227 */           if ((cfg != null) && (cfg.isBianyi))
/*     */           {
/* 229 */             count++;
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 234 */         xPictureQuestionInfo.setRightanswer(count);
/* 235 */         xPictureQuestionInfo.getParammap().put(Integer.valueOf(0), Integer.valueOf(selecttype));
/*     */ 
/*     */       }
/* 238 */       else if (itemCfg.questionType == 4)
/*     */       {
/* 240 */         int size = typeLists.size();
/*     */         
/* 242 */         int randomIdx = Xdb.random().nextInt(size);
/* 243 */         int selecttype = ((Integer)typeLists.get(randomIdx)).intValue();
/* 244 */         List<Integer> residList = (List)type2resourceMap.get(Integer.valueOf(selecttype));
/* 245 */         Set<Integer> resSet = new java.util.HashSet(residList);
/* 246 */         int count = 0;
/* 247 */         for (Iterator i$ = resSet.iterator(); i$.hasNext();) { int resid = ((Integer)i$.next()).intValue();
/*     */           
/* 249 */           SPictureQuestionItemResourceCfg cfg = SPictureQuestionItemResourceCfg.get(resid);
/* 250 */           if ((cfg != null) && (cfg.isBianyi))
/*     */           {
/*     */ 
/*     */ 
/* 254 */             posList = (List)resourceId2posList.get(Integer.valueOf(resid));
/*     */             
/* 256 */             for (AllMoveSteps allStep : info.info.movepath)
/*     */             {
/* 258 */               for (MoveStep step : allStep.steps)
/*     */               {
/* 260 */                 if (posList.contains(Integer.valueOf(step.resourceno)))
/*     */                 {
/* 262 */                   count++; }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         List<Integer> posList;
/* 268 */         xPictureQuestionInfo.setRightanswer(count);
/* 269 */         xPictureQuestionInfo.getParammap().put(Integer.valueOf(0), Integer.valueOf(selecttype));
/*     */       }
/* 271 */       List<Integer> wrongAnswerList = randomWrongAnswer(xPictureQuestionInfo.getRightanswer());
/* 272 */       xPictureQuestionInfo.getWronganswerlist().addAll(wrongAnswerList);
/* 273 */       if (answerRoleIdx >= roleSize)
/*     */       {
/* 275 */         answerRoleIdx = 0;
/*     */       }
/* 277 */       long roleId = ((Long)xPictureInfo.getRoleidlist().get(answerRoleIdx++)).longValue();
/* 278 */       xPictureQuestionInfo.setAnswerroleid(roleId);
/* 279 */       xPictureInfo.getQuestionlist().add(xPictureQuestionInfo);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Integer> randomWrongAnswer(int rightAnswer)
/*     */   {
/* 292 */     List<Integer> answerList = new ArrayList();
/* 293 */     int answerSize = 4;
/*     */     int start;
/* 295 */     int start; if (rightAnswer < answerSize)
/*     */     {
/* 297 */       start = CommonUtils.random(0, rightAnswer);
/*     */     }
/*     */     else
/*     */     {
/* 301 */       start = CommonUtils.random(rightAnswer - answerSize + 1, rightAnswer);
/*     */     }
/* 303 */     int end = start + answerSize;
/* 304 */     for (int i = start; i < end; i++)
/*     */     {
/* 306 */       if (i != rightAnswer)
/*     */       {
/* 308 */         answerList.add(Integer.valueOf(i)); }
/*     */     }
/* 310 */     return answerList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void randomPath(SPictureQuestionLevelCfg levelCfg, List<Integer> resourceList, SSyncPictureInfo sSyncPictureInfo)
/*     */   {
/* 321 */     int moveCount = CommonUtils.random(levelCfg.moveCountLowLimit, levelCfg.moveCountHighLimit);
/* 322 */     List<Integer> resourceNo = new ArrayList();
/* 323 */     for (int i = 0; i < resourceList.size(); i++)
/*     */     {
/* 325 */       resourceNo.add(Integer.valueOf(i));
/*     */     }
/*     */     
/* 328 */     Map<Integer, Integer> no2posMap = new HashMap();
/* 329 */     for (int i = 0; i < resourceNo.size(); i++)
/*     */     {
/* 331 */       no2posMap.put(Integer.valueOf(i), Integer.valueOf(i));
/*     */     }
/* 333 */     for (int i = 0; i < moveCount; i++)
/*     */     {
/* 335 */       randomStep1(levelCfg.moveMonsterCountPerTime, no2posMap, sSyncPictureInfo);
/*     */     }
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
/*     */   void randomStep1(int moveMonsterCountPerTime, Map<Integer, Integer> tomoveNo2Pos, SSyncPictureInfo sSyncPictureInfo)
/*     */   {
/* 350 */     List<Integer> srcno = new ArrayList(tomoveNo2Pos.keySet());
/* 351 */     List<Integer> tomoveNo = new ArrayList();
/* 352 */     CommonUtils.regionRandom(srcno, moveMonsterCountPerTime, tomoveNo);
/*     */     
/* 354 */     int sr = Xdb.random().nextInt(tomoveNo.size());
/* 355 */     if (sr == 0)
/*     */     {
/* 357 */       sr = 1;
/*     */     }
/*     */     
/* 360 */     Map<Integer, Integer> afterno2pos = new HashMap();
/* 361 */     for (int i = 0; i < tomoveNo.size(); i++)
/*     */     {
/* 363 */       int des = (i + sr) % tomoveNo.size();
/* 364 */       afterno2pos.put(tomoveNo.get(i), tomoveNo2Pos.get(tomoveNo.get(des)));
/*     */     }
/*     */     
/* 367 */     for (Iterator i$ = afterno2pos.keySet().iterator(); i$.hasNext();) { int moveno = ((Integer)i$.next()).intValue();
/*     */       
/* 369 */       tomoveNo2Pos.put(Integer.valueOf(moveno), afterno2pos.get(Integer.valueOf(moveno)));
/*     */     }
/* 371 */     AllMoveSteps allMoveSteps = new AllMoveSteps();
/* 372 */     for (Iterator i$ = afterno2pos.keySet().iterator(); i$.hasNext();) { int moveno = ((Integer)i$.next()).intValue();
/*     */       
/* 374 */       MoveStep moveStep1 = new MoveStep(moveno + 1, ((Integer)afterno2pos.get(Integer.valueOf(moveno))).intValue() + 1);
/* 375 */       allMoveSteps.steps.add(moveStep1);
/*     */     }
/*     */     
/* 378 */     sSyncPictureInfo.info.movepath.add(allMoveSteps);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> randomTotalResource(SPictureQuestionLevelCfg levelCfg, Map<Integer, Integer> type2countMap)
/*     */   {
/* 390 */     int totalWeight = 0;
/* 391 */     for (Iterator i$ = levelCfg.petTypeWeightTypeList.iterator(); i$.hasNext();) { int weight = ((Integer)i$.next()).intValue();
/*     */       
/* 393 */       totalWeight += weight;
/*     */     }
/* 395 */     int totalNum = 0;
/* 396 */     for (int i = 0; i < levelCfg.petTypeWeightTypeList.size(); i++)
/*     */     {
/* 398 */       int weight = ((Integer)levelCfg.petTypeWeightTypeList.get(i)).intValue();
/* 399 */       int typeINum = (int)(weight / totalWeight * levelCfg.totalMonsterNum);
/* 400 */       type2countMap.put(Integer.valueOf(i + 1), Integer.valueOf(typeINum));
/* 401 */       totalNum += typeINum;
/* 402 */       if (totalNum == levelCfg.totalMonsterNum) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/* 407 */     totalNum = Math.min(totalNum, levelCfg.totalMonsterNum);
/* 408 */     while (totalNum < levelCfg.totalMonsterNum)
/*     */     {
/* 410 */       int randomType = Xdb.random().nextInt(levelCfg.petTypeWeightTypeList.size()) + 1;
/* 411 */       Integer oldTypeNum = (Integer)type2countMap.get(Integer.valueOf(randomType));
/* 412 */       if (oldTypeNum == null)
/* 413 */         oldTypeNum = Integer.valueOf(0);
/* 414 */       type2countMap.put(Integer.valueOf(randomType), Integer.valueOf(oldTypeNum.intValue() + 1));
/* 415 */       totalNum++;
/*     */     }
/* 417 */     List<Integer> resourceList = new ArrayList();
/* 418 */     for (java.util.Map.Entry<Integer, Integer> entry : type2countMap.entrySet())
/*     */     {
/* 420 */       resourceList.addAll(randomResourceByTypeNum(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue()));
/*     */     }
/* 422 */     return resourceList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> randomResourceByTypeNum(int type, int num)
/*     */   {
/* 434 */     List<Integer> allIdList = mzm.gsp.question.confbean.STypeId2PicQuesItemResId.get(type).picQuesItemResIds;
/* 435 */     List<Integer> randomList = new ArrayList();
/* 436 */     CommonUtils.randomList(allIdList, num, randomList);
/* 437 */     return randomList;
/*     */   }
/*     */   
/*     */   void startPictureQuestion(long questionid)
/*     */   {
/* 442 */     new StartPictureQuestion(questionid).execute();
/*     */   }
/*     */   
/*     */   private static class StartPictureQuestion extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long questionid;
/*     */     
/*     */     public StartPictureQuestion(long questionid)
/*     */     {
/* 451 */       this.questionid = questionid;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 458 */       xbean.PictureInfo xPictureInfo = Picturequestion.get(Long.valueOf(this.questionid));
/* 459 */       if (xPictureInfo == null)
/*     */       {
/* 461 */         return false;
/*     */       }
/* 463 */       SSyncPictureInfo sSyncPictureInfo = PictureQuestionManager.getInstance().randomPictureAndQuestions(xPictureInfo);
/* 464 */       SPictureQuestionLevelCfg levelCfg = SPictureQuestionLevelCfg.get(xPictureInfo.getQuestionlevelcfgid());
/*     */       
/* 466 */       PictureQuestionStartSession startSession = new PictureQuestionStartSession((sSyncPictureInfo.info.movepath.size() + 1) * levelCfg.moveIntervalSec + levelCfg.totalMonsterNum, this.questionid);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 471 */       xPictureInfo.setState(1);
/* 472 */       xPictureInfo.setSessionid(startSession.getSessionId());
/* 473 */       OnlineManager.getInstance().sendMulti(sSyncPictureInfo, xPictureInfo.getRoleidlist());
/* 474 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   void preparePictureQuestion(final List<Long> roleIdList, final int levelCfgId, final Object attachObject)
/*     */   {
/* 480 */     SPictureQuestionLevelCfg levelCfg = SPictureQuestionLevelCfg.get(levelCfgId);
/* 481 */     if (levelCfg == null)
/*     */     {
/* 483 */       String logStr = String.format("[picquestion]PictureQuestionManager.preparePictureQuestion@SPictureQuestionLevelCfg is null|roleids=%s|levelCfgId=%d", new Object[] { roleIdList.toString(), Integer.valueOf(levelCfgId) });
/*     */       
/*     */ 
/*     */ 
/* 487 */       logger.error(logStr);
/* 488 */       return;
/*     */     }
/* 490 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 496 */         lock(Role2picturequestion.getTable(), roleIdList);
/* 497 */         for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 499 */           RolePictureQuestionInfo roleInfo = Role2picturequestion.get(Long.valueOf(roleId));
/* 500 */           if (roleInfo != null)
/*     */           {
/* 502 */             String logStr = String.format("[picquestion]PictureQuestionManager.preparePictureQuestion@Role is already in picture quession session|roleid=%d|roleids=%s|levelCfgId=%d", new Object[] { Long.valueOf(roleId), roleIdList.toString(), Integer.valueOf(levelCfgId) });
/*     */             
/*     */ 
/*     */ 
/* 506 */             PictureQuestionManager.logger.error(logStr);
/*     */             
/* 508 */             PictureQuestionManager.this.sendErrorRes(1, roleIdList);
/* 509 */             return false;
/*     */           }
/*     */         }
/* 512 */         xbean.PictureInfo xPictureInfo = xbean.Pod.newPictureInfo();
/* 513 */         xPictureInfo.setAttachobject(attachObject);
/* 514 */         xPictureInfo.getRoleidlist().addAll(roleIdList);
/* 515 */         xPictureInfo.setQuestionlevelcfgid(levelCfgId);
/* 516 */         xPictureInfo.setState(0);
/* 517 */         long questionid = Picturequestion.insert(xPictureInfo).longValue();
/* 518 */         for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 520 */           RolePictureQuestionInfo roleInfo = Role2picturequestion.get(Long.valueOf(roleId));
/* 521 */           if (roleInfo == null)
/*     */           {
/* 523 */             roleInfo = xbean.Pod.newRolePictureQuestionInfo();
/* 524 */             Role2picturequestion.add(Long.valueOf(roleId), roleInfo);
/*     */           }
/* 526 */           roleInfo.setPicinfoid(questionid);
/* 527 */           roleInfo.setUsehelpnum(0);
/*     */         }
/*     */         
/* 530 */         new StartPictureQuestionTimeObserver(mzm.gsp.question.confbean.SEveryDayQuestionConsts.getInstance().PICTURE_QUESTION_TIME, questionid);
/*     */         
/* 532 */         mzm.gsp.question.SPreparePictureQuestionRes res = new mzm.gsp.question.SPreparePictureQuestionRes();
/* 533 */         OnlineManager.getInstance().sendMulti(res, roleIdList);
/* 534 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void sendErrorRes(int rescode, List<Long> roleIdList)
/*     */   {
/* 543 */     mzm.gsp.question.SPictureQuestionError res = new mzm.gsp.question.SPictureQuestionError(rescode);
/* 544 */     OnlineManager.getInstance().sendMultiAtOnce(res, roleIdList);
/*     */   }
/*     */   
/*     */   void startQuestionItemSession(long pictureInfoId, xbean.PictureInfo xPictureInfo)
/*     */   {
/* 549 */     SPictureQuestionLevelCfg cfg = SPictureQuestionLevelCfg.get(xPictureInfo.getQuestionlevelcfgid());
/* 550 */     PictureQuestionItemSession observer = new PictureQuestionItemSession(cfg.everyQuestionPersistTime, pictureInfoId, xPictureInfo.getQuestionidx());
/*     */     
/* 552 */     xPictureInfo.setSessionid(observer.getSessionId());
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
/*     */   void moveToCurrentQuestion(long infoId, xbean.PictureInfo xPictureInfo, boolean isRight, int nowAnswer)
/*     */   {
/* 565 */     SPictureQuestionLevelCfg cfg = SPictureQuestionLevelCfg.get(xPictureInfo.getQuestionlevelcfgid());
/* 566 */     int rightCount = xPictureInfo.getRightanswercount();
/* 567 */     int wrongCount = xPictureInfo.getQuestionidx() + 1 - rightCount;
/* 568 */     if (cfg.rightScore * rightCount + cfg.wrongScore * wrongCount >= cfg.passScore)
/*     */     {
/* 570 */       xPictureInfo.getQuestionlist().clear();
/*     */     }
/* 572 */     mzm.gsp.question.SAnswerPictureQuestionRes res = new mzm.gsp.question.SAnswerPictureQuestionRes();
/* 573 */     res.isright = (isRight ? 1 : 0);
/* 574 */     res.rightnum = xPictureInfo.getRightanswercount();
/* 575 */     res.totalnum = xPictureInfo.getQuestionidx();
/* 576 */     res.lastanswer = nowAnswer;
/*     */     
/* 578 */     if (xPictureInfo.getQuestionlist().size() <= xPictureInfo.getQuestionidx())
/*     */     {
/* 580 */       res.nextanswerroleid = -1L;
/* 581 */       getInstance().end(infoId, xPictureInfo.getRoleidlist());
/*     */     }
/*     */     else
/*     */     {
/* 585 */       xbean.PictureQuestionInfo xPInfo = (xbean.PictureQuestionInfo)xPictureInfo.getQuestionlist().get(xPictureInfo.getQuestionidx());
/* 586 */       res.nextanswerroleid = xPInfo.getAnswerroleid();
/* 587 */       getInstance().fillPictureQuestionInfo(res.nextquestioninfo, xPInfo);
/* 588 */       startQuestionItemSession(infoId, xPictureInfo);
/*     */     }
/* 590 */     OnlineManager.getInstance().sendMulti(res, xPictureInfo.getRoleidlist());
/*     */   }
/*     */   
/*     */   void end(final long infoId, final List<Long> roleList)
/*     */   {
/* 595 */     mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 600 */         lock(Role2picturequestion.getTable(), roleList);
/* 601 */         xbean.PictureInfo xPictureInfo = Picturequestion.get(Long.valueOf(infoId));
/* 602 */         List<Long> roleIdList = xPictureInfo.getRoleidlist();
/*     */         
/* 604 */         SPictureQuestionLevelCfg cfg = SPictureQuestionLevelCfg.get(xPictureInfo.getQuestionlevelcfgid());
/*     */         
/* 606 */         int totalScore = 0;
/* 607 */         Map<Long, Integer> scoreMap = new HashMap();
/* 608 */         Map<Long, Integer> rightMap = new HashMap();
/* 609 */         Map<Long, Integer> allMap = new HashMap();
/*     */         
/* 611 */         for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 613 */           RolePictureQuestionInfo xRoleInfo = Role2picturequestion.get(Long.valueOf(roleId));
/* 614 */           int score = xRoleInfo.getRightnum() * cfg.rightScore;
/* 615 */           totalScore += score;
/* 616 */           scoreMap.put(Long.valueOf(roleId), Integer.valueOf(score));
/* 617 */           rightMap.put(Long.valueOf(roleId), Integer.valueOf(xRoleInfo.getRightnum()));
/* 618 */           allMap.put(Long.valueOf(roleId), Integer.valueOf(xRoleInfo.getTotalnum()));
/*     */         }
/* 620 */         boolean isPass = totalScore >= cfg.passScore;
/*     */         
/* 622 */         mzm.gsp.question.event.PictureQuestionArg arg = new mzm.gsp.question.event.PictureQuestionArg();
/* 623 */         arg.roleList.addAll(roleIdList);
/* 624 */         arg.roleScoreMap = scoreMap;
/* 625 */         arg.rightNumMap = rightMap;
/* 626 */         arg.questionNumMap = allMap;
/* 627 */         arg.isPass = isPass;
/* 628 */         arg.attachObject = xPictureInfo.getAttachobject();
/* 629 */         mzm.event.TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.question.event.FinishPictureQuestion(), arg);
/*     */         
/*     */ 
/* 632 */         lock(Role2picturequestion.getTable(), roleIdList);
/* 633 */         for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 635 */           Role2picturequestion.remove(Long.valueOf(roleId));
/*     */         }
/* 637 */         Picturequestion.remove(Long.valueOf(infoId));
/*     */         
/* 639 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   void fillPictureQuestionInfo(mzm.gsp.question.PictureQuestionInfo info, xbean.PictureQuestionInfo xInfo)
/*     */   {
/* 646 */     info.questionitemid = xInfo.getQuestionid();
/* 647 */     info.answerlist.add(Integer.valueOf(xInfo.getRightanswer()));
/* 648 */     info.answerlist.addAll(xInfo.getWronganswerlist());
/* 649 */     Integer selectId = (Integer)xInfo.getParammap().get(Integer.valueOf(0));
/*     */     
/* 651 */     info.parammap.put(Integer.valueOf(0), selectId + "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void notifyCurrentQuestion(long infoId, xbean.PictureInfo xPictureInfo)
/*     */   {
/* 658 */     SSyncPictureQuestionInfo sSyncPictureQuestionInfo = new SSyncPictureQuestionInfo();
/* 659 */     xbean.PictureQuestionInfo xQuestionInfo = (xbean.PictureQuestionInfo)xPictureInfo.getQuestionlist().get(xPictureInfo.getQuestionidx());
/*     */     
/* 661 */     SPictureQuestionLevelCfg cfg = SPictureQuestionLevelCfg.get(xPictureInfo.getQuestionlevelcfgid());
/* 662 */     sSyncPictureQuestionInfo.answerroleid = xQuestionInfo.getAnswerroleid();
/* 663 */     sSyncPictureQuestionInfo.remainhelpercount = cfg.helpCount;
/* 664 */     for (Iterator i$ = xPictureInfo.getRoleidlist().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 666 */       AnswerInfo answerInfo = new AnswerInfo();
/* 667 */       getInstance().fillMember(roleId, answerInfo);
/* 668 */       sSyncPictureQuestionInfo.answerlist.add(answerInfo);
/*     */     }
/* 670 */     sSyncPictureQuestionInfo.difficultylevelid = xPictureInfo.getQuestionlevelcfgid();
/* 671 */     sSyncPictureQuestionInfo.endtime = ((int)(java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()) + cfg.everyQuestionPersistTime));
/* 672 */     fillPictureQuestionInfo(sSyncPictureQuestionInfo.info, xQuestionInfo);
/* 673 */     OnlineManager.getInstance().sendMulti(sSyncPictureQuestionInfo, xPictureInfo.getRoleidlist());
/* 674 */     startQuestionItemSession(infoId, xPictureInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void notifyLogin(long roleId, xbean.PictureInfo xPictureInfo)
/*     */   {
/* 685 */     mzm.gsp.timer.main.Session session = mzm.gsp.timer.main.Session.getSession(xPictureInfo.getSessionid());
/* 686 */     if (!(session instanceof PictureQuestionItemSession))
/*     */     {
/* 688 */       return;
/*     */     }
/* 690 */     SSyncPictureQuestionInfo sSyncPictureQuestionInfo = new SSyncPictureQuestionInfo();
/* 691 */     xbean.PictureQuestionInfo xQuestionInfo = (xbean.PictureQuestionInfo)xPictureInfo.getQuestionlist().get(xPictureInfo.getQuestionidx());
/*     */     
/* 693 */     SPictureQuestionLevelCfg cfg = SPictureQuestionLevelCfg.get(xPictureInfo.getQuestionlevelcfgid());
/* 694 */     sSyncPictureQuestionInfo.answerroleid = xQuestionInfo.getAnswerroleid();
/* 695 */     RolePictureQuestionInfo xRoleInfo = Role2picturequestion.get(Long.valueOf(roleId));
/* 696 */     sSyncPictureQuestionInfo.remainhelpercount = (cfg.helpCount - xRoleInfo.getUsehelpnum());
/* 697 */     for (Iterator i$ = xPictureInfo.getRoleidlist().iterator(); i$.hasNext();) { long _roleId = ((Long)i$.next()).longValue();
/*     */       
/* 699 */       AnswerInfo answerInfo = new AnswerInfo();
/* 700 */       getInstance().fillMember(_roleId, answerInfo);
/* 701 */       sSyncPictureQuestionInfo.answerlist.add(answerInfo);
/*     */     }
/* 703 */     sSyncPictureQuestionInfo.difficultylevelid = xPictureInfo.getQuestionlevelcfgid();
/* 704 */     sSyncPictureQuestionInfo.rightcount = xPictureInfo.getRightanswercount();
/* 705 */     sSyncPictureQuestionInfo.totalcount = xPictureInfo.getQuestionidx();
/* 706 */     PictureQuestionItemSession pictureQuestionItemSession = (PictureQuestionItemSession)session;
/* 707 */     sSyncPictureQuestionInfo.endtime = pictureQuestionItemSession.getEndTime();
/* 708 */     fillPictureQuestionInfo(sSyncPictureQuestionInfo.info, xQuestionInfo);
/* 709 */     OnlineManager.getInstance().send(roleId, sSyncPictureQuestionInfo);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PictureQuestionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
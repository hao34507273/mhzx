/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.fight.handle.AddAngerHandle;
/*      */ import mzm.gsp.fight.handle.AddBuffHandle;
/*      */ import mzm.gsp.fight.handle.AftUseSkilHandle;
/*      */ import mzm.gsp.fight.handle.AfterAttackHandle;
/*      */ import mzm.gsp.fight.handle.AfterSummonHandle;
/*      */ import mzm.gsp.fight.handle.BeDamageHandle;
/*      */ import mzm.gsp.fight.handle.BeKilledHandle;
/*      */ import mzm.gsp.fight.handle.BeforeAttackHandle;
/*      */ import mzm.gsp.fight.handle.BeforeHealHandle;
/*      */ import mzm.gsp.fight.handle.BeforePoisonHandle;
/*      */ import mzm.gsp.fight.handle.BeforeSealHandle;
/*      */ import mzm.gsp.fight.handle.BeforeUseSkilHandle;
/*      */ import mzm.gsp.fight.handle.ChildEnterFightHandle;
/*      */ import mzm.gsp.fight.handle.CounterHandle;
/*      */ import mzm.gsp.fight.handle.DamageHandle;
/*      */ import mzm.gsp.fight.handle.DrugHandle;
/*      */ import mzm.gsp.fight.handle.EnterFightHandle;
/*      */ import mzm.gsp.fight.handle.EscapeHandle;
/*      */ import mzm.gsp.fight.handle.FighterDeadHandle;
/*      */ import mzm.gsp.fight.handle.KillOtherHandle;
/*      */ import mzm.gsp.fight.handle.LoseHpHandle;
/*      */ import mzm.gsp.fight.handle.OtherBeKilledAfterHandle;
/*      */ import mzm.gsp.fight.handle.PetEnterFightHandle;
/*      */ import mzm.gsp.fight.handle.ProtectHandle;
/*      */ import mzm.gsp.fight.handle.RebirthHandle;
/*      */ import mzm.gsp.fight.handle.ReboundHandle;
/*      */ import mzm.gsp.fight.handle.RoundEndHandle;
/*      */ import mzm.gsp.fight.handle.RoundStartHandle;
/*      */ import mzm.gsp.fight.handle.SealedHandle;
/*      */ import mzm.gsp.fight.handle.SkillCausingDeathHandle;
/*      */ import mzm.gsp.fight.handle.SkillCostHandle;
/*      */ import mzm.gsp.fight.handle.TargetNumHandle;
/*      */ import mzm.gsp.fight.handle.TauntHandle;
/*      */ import mzm.gsp.fight.main.AI;
/*      */ import mzm.gsp.map.MapModelInfo;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xbean.FighterBuffs;
/*      */ import xbean.FighterHealthInfo;
/*      */ import xbean.SkillData;
/*      */ import xbean.Targets;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ import xdb.logs.ListenableSet;
/*      */ import xdb.logs.LogFloat;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogObject;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class Fighter
/*      */   extends XBean
/*      */   implements xbean.Fighter
/*      */ {
/*      */   private int type;
/*      */   private int fighterid;
/*      */   private int pos;
/*      */   private int hp;
/*      */   private int mp;
/*      */   private float anger;
/*      */   private HashMap<Integer, Integer> attrs;
/*      */   private HashMap<Integer, Integer> ex_attrs;
/*      */   private AI ai;
/*      */   private HashMap<Integer, Integer> extra;
/*      */   private HashMap<Integer, Integer> skills;
/*      */   private HashMap<Integer, SkillData> skilldatas;
/*      */   private int state;
/*      */   private HashMap<Integer, Integer> buff_states;
/*      */   private HashMap<Integer, FighterBuffs> buffs;
/*      */   private MapModelInfo originalmodelid;
/*      */   private ArrayList<Integer> protecterids;
/*      */   private ArrayList<Integer> changemodelids;
/*      */   private HashMap<Integer, Targets> targetstatusbuffs;
/*      */   private SetX<RoundStartHandle> handleonroundstart;
/*      */   private SetX<RoundEndHandle> handleonroundend;
/*      */   private SetX<DamageHandle> handleondamage;
/*      */   private SetX<BeDamageHandle> handleonbedamage;
/*      */   private SetX<BeKilledHandle> handleonbekilled;
/*      */   private SetX<KillOtherHandle> handleonkillother;
/*      */   private SetX<RebirthHandle> handleonrebirth;
/*      */   private SetX<BeforeAttackHandle> handleonbeforeattack;
/*      */   private SetX<AfterAttackHandle> handleonafterattack;
/*      */   private SetX<SkillCostHandle> handleonskillcost;
/*      */   private SetX<AddBuffHandle> handleonaddbuff;
/*      */   private SetX<SealedHandle> handleonsealed;
/*      */   private SetX<CounterHandle> handleoncounter;
/*      */   private SetX<ProtectHandle> handleonprotect;
/*      */   private SetX<TauntHandle> handleontaunt;
/*      */   private SetX<ReboundHandle> handleonrebound;
/*      */   private SetX<EnterFightHandle> handleonenterfight;
/*      */   private SetX<FighterDeadHandle> handleonfighterdead;
/*      */   private SetX<BeforeUseSkilHandle> handleonbeforeuseskill;
/*      */   private SetX<AftUseSkilHandle> handleonaftuseskill;
/*      */   private SetX<BeforeHealHandle> handleonbeforeheal;
/*      */   private SetX<TargetNumHandle> handleontargetnumhandle;
/*      */   private SetX<BeforePoisonHandle> handleonbeforepoisonhandle;
/*      */   private SetX<PetEnterFightHandle> handleonpetenterfighthandle;
/*      */   private SetX<AddAngerHandle> handleonaddangerhandle;
/*      */   private SetX<DrugHandle> handleondrughandle;
/*      */   private SetX<LoseHpHandle> handleonlosehphandle;
/*      */   private SetX<AfterSummonHandle> handleonaftsummonhandle;
/*      */   private xbean.FighterMounts fightermounts;
/*      */   private LinkedList<Integer> nextroundaddbuffids;
/*      */   private SetX<SkillCausingDeathHandle> handleonskillcausingdeath;
/*      */   private SetX<ChildEnterFightHandle> handleonchildenterfighthandle;
/*      */   private xbean.SkillResult skillresult;
/*      */   private ArrayList<Integer> deadrounds;
/*      */   private xbean.FighterModelCard changemodelcard;
/*      */   private HashMap<Integer, FighterHealthInfo> healthatroundstart;
/*      */   private SetX<BeforeSealHandle> handleonbeforeseal;
/*      */   private HashMap<Integer, xbean.FightState> fightstates;
/*      */   private xbean.FightState defaultfightstate;
/*      */   private HashMap<Integer, Targets> effecttargets;
/*      */   private xbean.FighterOutFightInfo outfightinfo;
/*      */   private SetX<EscapeHandle> handleonescape;
/*      */   private SetX<OtherBeKilledAfterHandle> handleonotherbekilledafter;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*  140 */     this.type = 0;
/*  141 */     this.fighterid = 0;
/*  142 */     this.pos = 0;
/*  143 */     this.hp = 0;
/*  144 */     this.mp = 0;
/*  145 */     this.anger = 0.0F;
/*  146 */     this.attrs.clear();
/*  147 */     this.ex_attrs.clear();
/*  148 */     this.ai = null;
/*  149 */     this.extra.clear();
/*  150 */     this.skills.clear();
/*  151 */     this.skilldatas.clear();
/*  152 */     this.state = 0;
/*  153 */     this.buff_states.clear();
/*  154 */     this.buffs.clear();
/*  155 */     this.originalmodelid = null;
/*  156 */     this.protecterids.clear();
/*  157 */     this.changemodelids.clear();
/*  158 */     this.targetstatusbuffs.clear();
/*  159 */     this.handleonroundstart.clear();
/*  160 */     this.handleonroundend.clear();
/*  161 */     this.handleondamage.clear();
/*  162 */     this.handleonbedamage.clear();
/*  163 */     this.handleonbekilled.clear();
/*  164 */     this.handleonkillother.clear();
/*  165 */     this.handleonrebirth.clear();
/*  166 */     this.handleonbeforeattack.clear();
/*  167 */     this.handleonafterattack.clear();
/*  168 */     this.handleonskillcost.clear();
/*  169 */     this.handleonaddbuff.clear();
/*  170 */     this.handleonsealed.clear();
/*  171 */     this.handleoncounter.clear();
/*  172 */     this.handleonprotect.clear();
/*  173 */     this.handleontaunt.clear();
/*  174 */     this.handleonrebound.clear();
/*  175 */     this.handleonenterfight.clear();
/*  176 */     this.handleonfighterdead.clear();
/*  177 */     this.handleonbeforeuseskill.clear();
/*  178 */     this.handleonaftuseskill.clear();
/*  179 */     this.handleonbeforeheal.clear();
/*  180 */     this.handleontargetnumhandle.clear();
/*  181 */     this.handleonbeforepoisonhandle.clear();
/*  182 */     this.handleonpetenterfighthandle.clear();
/*  183 */     this.handleonaddangerhandle.clear();
/*  184 */     this.handleondrughandle.clear();
/*  185 */     this.handleonlosehphandle.clear();
/*  186 */     this.handleonaftsummonhandle.clear();
/*  187 */     this.fightermounts._reset_unsafe_();
/*  188 */     this.nextroundaddbuffids.clear();
/*  189 */     this.handleonskillcausingdeath.clear();
/*  190 */     this.handleonchildenterfighthandle.clear();
/*  191 */     this.skillresult._reset_unsafe_();
/*  192 */     this.deadrounds.clear();
/*  193 */     this.changemodelcard._reset_unsafe_();
/*  194 */     this.healthatroundstart.clear();
/*  195 */     this.handleonbeforeseal.clear();
/*  196 */     this.fightstates.clear();
/*  197 */     this.defaultfightstate._reset_unsafe_();
/*  198 */     this.effecttargets.clear();
/*  199 */     this.outfightinfo._reset_unsafe_();
/*  200 */     this.handleonescape.clear();
/*  201 */     this.handleonotherbekilledafter.clear();
/*      */   }
/*      */   
/*      */   Fighter(int __, XBean _xp_, String _vn_)
/*      */   {
/*  206 */     super(_xp_, _vn_);
/*  207 */     this.hp = 0;
/*  208 */     this.mp = 0;
/*  209 */     this.anger = 0.0F;
/*  210 */     this.attrs = new HashMap();
/*  211 */     this.ex_attrs = new HashMap();
/*  212 */     this.ai = null;
/*  213 */     this.extra = new HashMap();
/*  214 */     this.skills = new HashMap();
/*  215 */     this.skilldatas = new HashMap();
/*  216 */     this.state = 0;
/*  217 */     this.buff_states = new HashMap();
/*  218 */     this.buffs = new HashMap();
/*  219 */     this.originalmodelid = null;
/*  220 */     this.protecterids = new ArrayList();
/*  221 */     this.changemodelids = new ArrayList();
/*  222 */     this.targetstatusbuffs = new HashMap();
/*  223 */     this.handleonroundstart = new SetX();
/*  224 */     this.handleonroundend = new SetX();
/*  225 */     this.handleondamage = new SetX();
/*  226 */     this.handleonbedamage = new SetX();
/*  227 */     this.handleonbekilled = new SetX();
/*  228 */     this.handleonkillother = new SetX();
/*  229 */     this.handleonrebirth = new SetX();
/*  230 */     this.handleonbeforeattack = new SetX();
/*  231 */     this.handleonafterattack = new SetX();
/*  232 */     this.handleonskillcost = new SetX();
/*  233 */     this.handleonaddbuff = new SetX();
/*  234 */     this.handleonsealed = new SetX();
/*  235 */     this.handleoncounter = new SetX();
/*  236 */     this.handleonprotect = new SetX();
/*  237 */     this.handleontaunt = new SetX();
/*  238 */     this.handleonrebound = new SetX();
/*  239 */     this.handleonenterfight = new SetX();
/*  240 */     this.handleonfighterdead = new SetX();
/*  241 */     this.handleonbeforeuseskill = new SetX();
/*  242 */     this.handleonaftuseskill = new SetX();
/*  243 */     this.handleonbeforeheal = new SetX();
/*  244 */     this.handleontargetnumhandle = new SetX();
/*  245 */     this.handleonbeforepoisonhandle = new SetX();
/*  246 */     this.handleonpetenterfighthandle = new SetX();
/*  247 */     this.handleonaddangerhandle = new SetX();
/*  248 */     this.handleondrughandle = new SetX();
/*  249 */     this.handleonlosehphandle = new SetX();
/*  250 */     this.handleonaftsummonhandle = new SetX();
/*  251 */     this.fightermounts = new FighterMounts(0, this, "fightermounts");
/*  252 */     this.nextroundaddbuffids = new LinkedList();
/*  253 */     this.handleonskillcausingdeath = new SetX();
/*  254 */     this.handleonchildenterfighthandle = new SetX();
/*  255 */     this.skillresult = new SkillResult(0, this, "skillresult");
/*  256 */     this.deadrounds = new ArrayList();
/*  257 */     this.changemodelcard = new FighterModelCard(0, this, "changemodelcard");
/*  258 */     this.healthatroundstart = new HashMap();
/*  259 */     this.handleonbeforeseal = new SetX();
/*  260 */     this.fightstates = new HashMap();
/*  261 */     this.defaultfightstate = new FightState(0, this, "defaultfightstate");
/*  262 */     this.effecttargets = new HashMap();
/*  263 */     this.outfightinfo = new FighterOutFightInfo(0, this, "outfightinfo");
/*  264 */     this.handleonescape = new SetX();
/*  265 */     this.handleonotherbekilledafter = new SetX();
/*      */   }
/*      */   
/*      */   public Fighter()
/*      */   {
/*  270 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Fighter(Fighter _o_)
/*      */   {
/*  275 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Fighter(xbean.Fighter _o1_, XBean _xp_, String _vn_)
/*      */   {
/*  280 */     super(_xp_, _vn_);
/*  281 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  287 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  293 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  299 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  305 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  311 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Fighter copy()
/*      */   {
/*  317 */     _xdb_verify_unsafe_();
/*  318 */     return new Fighter(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Fighter toData()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Fighter toBean()
/*      */   {
/*  330 */     _xdb_verify_unsafe_();
/*  331 */     return new Fighter(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Fighter toDataIf()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Fighter toBeanIf()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getType()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return this.type;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFighterid()
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     return this.fighterid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPos()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     return this.pos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHp()
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     return this.hp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMp()
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     return this.mp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public float getAnger()
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     return this.anger;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getAttrs()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     return Logs.logMap(new LogKey(this, "attrs"), this.attrs);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getAttrsAsData()
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*      */     
/*  416 */     Fighter _o_ = this;
/*  417 */     Map<Integer, Integer> attrs = new HashMap();
/*  418 */     for (Map.Entry<Integer, Integer> _e_ : _o_.attrs.entrySet())
/*  419 */       attrs.put(_e_.getKey(), _e_.getValue());
/*  420 */     return attrs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getEx_attrs()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     return Logs.logMap(new LogKey(this, "ex_attrs"), this.ex_attrs);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getEx_attrsAsData()
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*      */     
/*  437 */     Fighter _o_ = this;
/*  438 */     Map<Integer, Integer> ex_attrs = new HashMap();
/*  439 */     for (Map.Entry<Integer, Integer> _e_ : _o_.ex_attrs.entrySet())
/*  440 */       ex_attrs.put(_e_.getKey(), _e_.getValue());
/*  441 */     return ex_attrs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public AI getAi()
/*      */   {
/*  448 */     _xdb_verify_unsafe_();
/*  449 */     return this.ai;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getExtra()
/*      */   {
/*  456 */     _xdb_verify_unsafe_();
/*  457 */     return Logs.logMap(new LogKey(this, "extra"), this.extra);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getExtraAsData()
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*      */     
/*  466 */     Fighter _o_ = this;
/*  467 */     Map<Integer, Integer> extra = new HashMap();
/*  468 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/*  469 */       extra.put(_e_.getKey(), _e_.getValue());
/*  470 */     return extra;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkills()
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     return Logs.logMap(new LogKey(this, "skills"), this.skills);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillsAsData()
/*      */   {
/*  485 */     _xdb_verify_unsafe_();
/*      */     
/*  487 */     Fighter _o_ = this;
/*  488 */     Map<Integer, Integer> skills = new HashMap();
/*  489 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skills.entrySet())
/*  490 */       skills.put(_e_.getKey(), _e_.getValue());
/*  491 */     return skills;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, SkillData> getSkilldatas()
/*      */   {
/*  498 */     _xdb_verify_unsafe_();
/*  499 */     return Logs.logMap(new LogKey(this, "skilldatas"), this.skilldatas);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, SkillData> getSkilldatasAsData()
/*      */   {
/*  506 */     _xdb_verify_unsafe_();
/*      */     
/*  508 */     Fighter _o_ = this;
/*  509 */     Map<Integer, SkillData> skilldatas = new HashMap();
/*  510 */     for (Map.Entry<Integer, SkillData> _e_ : _o_.skilldatas.entrySet())
/*  511 */       skilldatas.put(_e_.getKey(), new SkillData.Data((SkillData)_e_.getValue()));
/*  512 */     return skilldatas;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  519 */     _xdb_verify_unsafe_();
/*  520 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBuff_states()
/*      */   {
/*  527 */     _xdb_verify_unsafe_();
/*  528 */     return Logs.logMap(new LogKey(this, "buff_states"), this.buff_states);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBuff_statesAsData()
/*      */   {
/*  535 */     _xdb_verify_unsafe_();
/*      */     
/*  537 */     Fighter _o_ = this;
/*  538 */     Map<Integer, Integer> buff_states = new HashMap();
/*  539 */     for (Map.Entry<Integer, Integer> _e_ : _o_.buff_states.entrySet())
/*  540 */       buff_states.put(_e_.getKey(), _e_.getValue());
/*  541 */     return buff_states;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, FighterBuffs> getBuffs()
/*      */   {
/*  548 */     _xdb_verify_unsafe_();
/*  549 */     return Logs.logMap(new LogKey(this, "buffs"), this.buffs);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public MapModelInfo getOriginalmodelid()
/*      */   {
/*  556 */     _xdb_verify_unsafe_();
/*  557 */     return this.originalmodelid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getProtecterids()
/*      */   {
/*  564 */     _xdb_verify_unsafe_();
/*  565 */     return Logs.logList(new LogKey(this, "protecterids"), this.protecterids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getProtecteridsAsData()
/*      */   {
/*  571 */     _xdb_verify_unsafe_();
/*      */     
/*  573 */     Fighter _o_ = this;
/*  574 */     List<Integer> protecterids = new ArrayList();
/*  575 */     protecterids.addAll(_o_.protecterids);
/*  576 */     return protecterids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getChangemodelids()
/*      */   {
/*  583 */     _xdb_verify_unsafe_();
/*  584 */     return Logs.logList(new LogKey(this, "changemodelids"), this.changemodelids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getChangemodelidsAsData()
/*      */   {
/*  590 */     _xdb_verify_unsafe_();
/*      */     
/*  592 */     Fighter _o_ = this;
/*  593 */     List<Integer> changemodelids = new ArrayList();
/*  594 */     changemodelids.addAll(_o_.changemodelids);
/*  595 */     return changemodelids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Targets> getTargetstatusbuffs()
/*      */   {
/*  602 */     _xdb_verify_unsafe_();
/*  603 */     return Logs.logMap(new LogKey(this, "targetstatusbuffs"), this.targetstatusbuffs);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Targets> getTargetstatusbuffsAsData()
/*      */   {
/*  610 */     _xdb_verify_unsafe_();
/*      */     
/*  612 */     Fighter _o_ = this;
/*  613 */     Map<Integer, Targets> targetstatusbuffs = new HashMap();
/*  614 */     for (Map.Entry<Integer, Targets> _e_ : _o_.targetstatusbuffs.entrySet())
/*  615 */       targetstatusbuffs.put(_e_.getKey(), new Targets.Data((Targets)_e_.getValue()));
/*  616 */     return targetstatusbuffs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<RoundStartHandle> getHandleonroundstart()
/*      */   {
/*  623 */     _xdb_verify_unsafe_();
/*  624 */     return Logs.logSet(new LogKey(this, "handleonroundstart"), this.handleonroundstart);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<RoundEndHandle> getHandleonroundend()
/*      */   {
/*  631 */     _xdb_verify_unsafe_();
/*  632 */     return Logs.logSet(new LogKey(this, "handleonroundend"), this.handleonroundend);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<DamageHandle> getHandleondamage()
/*      */   {
/*  639 */     _xdb_verify_unsafe_();
/*  640 */     return Logs.logSet(new LogKey(this, "handleondamage"), this.handleondamage);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<BeDamageHandle> getHandleonbedamage()
/*      */   {
/*  647 */     _xdb_verify_unsafe_();
/*  648 */     return Logs.logSet(new LogKey(this, "handleonbedamage"), this.handleonbedamage);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<BeKilledHandle> getHandleonbekilled()
/*      */   {
/*  655 */     _xdb_verify_unsafe_();
/*  656 */     return Logs.logSet(new LogKey(this, "handleonbekilled"), this.handleonbekilled);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<KillOtherHandle> getHandleonkillother()
/*      */   {
/*  663 */     _xdb_verify_unsafe_();
/*  664 */     return Logs.logSet(new LogKey(this, "handleonkillother"), this.handleonkillother);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<RebirthHandle> getHandleonrebirth()
/*      */   {
/*  671 */     _xdb_verify_unsafe_();
/*  672 */     return Logs.logSet(new LogKey(this, "handleonrebirth"), this.handleonrebirth);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<BeforeAttackHandle> getHandleonbeforeattack()
/*      */   {
/*  679 */     _xdb_verify_unsafe_();
/*  680 */     return Logs.logSet(new LogKey(this, "handleonbeforeattack"), this.handleonbeforeattack);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<AfterAttackHandle> getHandleonafterattack()
/*      */   {
/*  687 */     _xdb_verify_unsafe_();
/*  688 */     return Logs.logSet(new LogKey(this, "handleonafterattack"), this.handleonafterattack);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<SkillCostHandle> getHandleonskillcost()
/*      */   {
/*  695 */     _xdb_verify_unsafe_();
/*  696 */     return Logs.logSet(new LogKey(this, "handleonskillcost"), this.handleonskillcost);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<AddBuffHandle> getHandleonaddbuff()
/*      */   {
/*  703 */     _xdb_verify_unsafe_();
/*  704 */     return Logs.logSet(new LogKey(this, "handleonaddbuff"), this.handleonaddbuff);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<SealedHandle> getHandleonsealed()
/*      */   {
/*  711 */     _xdb_verify_unsafe_();
/*  712 */     return Logs.logSet(new LogKey(this, "handleonsealed"), this.handleonsealed);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<CounterHandle> getHandleoncounter()
/*      */   {
/*  719 */     _xdb_verify_unsafe_();
/*  720 */     return Logs.logSet(new LogKey(this, "handleoncounter"), this.handleoncounter);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<ProtectHandle> getHandleonprotect()
/*      */   {
/*  727 */     _xdb_verify_unsafe_();
/*  728 */     return Logs.logSet(new LogKey(this, "handleonprotect"), this.handleonprotect);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<TauntHandle> getHandleontaunt()
/*      */   {
/*  735 */     _xdb_verify_unsafe_();
/*  736 */     return Logs.logSet(new LogKey(this, "handleontaunt"), this.handleontaunt);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<ReboundHandle> getHandleonrebound()
/*      */   {
/*  743 */     _xdb_verify_unsafe_();
/*  744 */     return Logs.logSet(new LogKey(this, "handleonrebound"), this.handleonrebound);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<EnterFightHandle> getHandleonenterfight()
/*      */   {
/*  751 */     _xdb_verify_unsafe_();
/*  752 */     return Logs.logSet(new LogKey(this, "handleonenterfight"), this.handleonenterfight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<FighterDeadHandle> getHandleonfighterdead()
/*      */   {
/*  759 */     _xdb_verify_unsafe_();
/*  760 */     return Logs.logSet(new LogKey(this, "handleonfighterdead"), this.handleonfighterdead);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<BeforeUseSkilHandle> getHandleonbeforeuseskill()
/*      */   {
/*  767 */     _xdb_verify_unsafe_();
/*  768 */     return Logs.logSet(new LogKey(this, "handleonbeforeuseskill"), this.handleonbeforeuseskill);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<AftUseSkilHandle> getHandleonaftuseskill()
/*      */   {
/*  775 */     _xdb_verify_unsafe_();
/*  776 */     return Logs.logSet(new LogKey(this, "handleonaftuseskill"), this.handleonaftuseskill);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<BeforeHealHandle> getHandleonbeforeheal()
/*      */   {
/*  783 */     _xdb_verify_unsafe_();
/*  784 */     return Logs.logSet(new LogKey(this, "handleonbeforeheal"), this.handleonbeforeheal);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<TargetNumHandle> getHandleontargetnumhandle()
/*      */   {
/*  791 */     _xdb_verify_unsafe_();
/*  792 */     return Logs.logSet(new LogKey(this, "handleontargetnumhandle"), this.handleontargetnumhandle);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<BeforePoisonHandle> getHandleonbeforepoisonhandle()
/*      */   {
/*  799 */     _xdb_verify_unsafe_();
/*  800 */     return Logs.logSet(new LogKey(this, "handleonbeforepoisonhandle"), this.handleonbeforepoisonhandle);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<PetEnterFightHandle> getHandleonpetenterfighthandle()
/*      */   {
/*  807 */     _xdb_verify_unsafe_();
/*  808 */     return Logs.logSet(new LogKey(this, "handleonpetenterfighthandle"), this.handleonpetenterfighthandle);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<AddAngerHandle> getHandleonaddangerhandle()
/*      */   {
/*  815 */     _xdb_verify_unsafe_();
/*  816 */     return Logs.logSet(new LogKey(this, "handleonaddangerhandle"), this.handleonaddangerhandle);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<DrugHandle> getHandleondrughandle()
/*      */   {
/*  823 */     _xdb_verify_unsafe_();
/*  824 */     return Logs.logSet(new LogKey(this, "handleondrughandle"), this.handleondrughandle);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<LoseHpHandle> getHandleonlosehphandle()
/*      */   {
/*  831 */     _xdb_verify_unsafe_();
/*  832 */     return Logs.logSet(new LogKey(this, "handleonlosehphandle"), this.handleonlosehphandle);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<AfterSummonHandle> getHandleonaftsummonhandle()
/*      */   {
/*  839 */     _xdb_verify_unsafe_();
/*  840 */     return Logs.logSet(new LogKey(this, "handleonaftsummonhandle"), this.handleonaftsummonhandle);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.FighterMounts getFightermounts()
/*      */   {
/*  847 */     _xdb_verify_unsafe_();
/*  848 */     return this.fightermounts;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getNextroundaddbuffids()
/*      */   {
/*  855 */     _xdb_verify_unsafe_();
/*  856 */     return Logs.logList(new LogKey(this, "nextroundaddbuffids"), this.nextroundaddbuffids);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<SkillCausingDeathHandle> getHandleonskillcausingdeath()
/*      */   {
/*  863 */     _xdb_verify_unsafe_();
/*  864 */     return Logs.logSet(new LogKey(this, "handleonskillcausingdeath"), this.handleonskillcausingdeath);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<ChildEnterFightHandle> getHandleonchildenterfighthandle()
/*      */   {
/*  871 */     _xdb_verify_unsafe_();
/*  872 */     return Logs.logSet(new LogKey(this, "handleonchildenterfighthandle"), this.handleonchildenterfighthandle);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.SkillResult getSkillresult()
/*      */   {
/*  879 */     _xdb_verify_unsafe_();
/*  880 */     return this.skillresult;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getDeadrounds()
/*      */   {
/*  887 */     _xdb_verify_unsafe_();
/*  888 */     return Logs.logList(new LogKey(this, "deadrounds"), this.deadrounds);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getDeadroundsAsData()
/*      */   {
/*  894 */     _xdb_verify_unsafe_();
/*      */     
/*  896 */     Fighter _o_ = this;
/*  897 */     List<Integer> deadrounds = new ArrayList();
/*  898 */     deadrounds.addAll(_o_.deadrounds);
/*  899 */     return deadrounds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.FighterModelCard getChangemodelcard()
/*      */   {
/*  906 */     _xdb_verify_unsafe_();
/*  907 */     return this.changemodelcard;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, FighterHealthInfo> getHealthatroundstart()
/*      */   {
/*  914 */     _xdb_verify_unsafe_();
/*  915 */     return Logs.logMap(new LogKey(this, "healthatroundstart"), this.healthatroundstart);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, FighterHealthInfo> getHealthatroundstartAsData()
/*      */   {
/*  922 */     _xdb_verify_unsafe_();
/*      */     
/*  924 */     Fighter _o_ = this;
/*  925 */     Map<Integer, FighterHealthInfo> healthatroundstart = new HashMap();
/*  926 */     for (Map.Entry<Integer, FighterHealthInfo> _e_ : _o_.healthatroundstart.entrySet())
/*  927 */       healthatroundstart.put(_e_.getKey(), new FighterHealthInfo.Data((FighterHealthInfo)_e_.getValue()));
/*  928 */     return healthatroundstart;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<BeforeSealHandle> getHandleonbeforeseal()
/*      */   {
/*  935 */     _xdb_verify_unsafe_();
/*  936 */     return Logs.logSet(new LogKey(this, "handleonbeforeseal"), this.handleonbeforeseal);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.FightState> getFightstates()
/*      */   {
/*  943 */     _xdb_verify_unsafe_();
/*  944 */     return Logs.logMap(new LogKey(this, "fightstates"), this.fightstates);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.FightState> getFightstatesAsData()
/*      */   {
/*  951 */     _xdb_verify_unsafe_();
/*      */     
/*  953 */     Fighter _o_ = this;
/*  954 */     Map<Integer, xbean.FightState> fightstates = new HashMap();
/*  955 */     for (Map.Entry<Integer, xbean.FightState> _e_ : _o_.fightstates.entrySet())
/*  956 */       fightstates.put(_e_.getKey(), new FightState.Data((xbean.FightState)_e_.getValue()));
/*  957 */     return fightstates;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.FightState getDefaultfightstate()
/*      */   {
/*  964 */     _xdb_verify_unsafe_();
/*  965 */     return this.defaultfightstate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Targets> getEffecttargets()
/*      */   {
/*  972 */     _xdb_verify_unsafe_();
/*  973 */     return Logs.logMap(new LogKey(this, "effecttargets"), this.effecttargets);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Targets> getEffecttargetsAsData()
/*      */   {
/*  980 */     _xdb_verify_unsafe_();
/*      */     
/*  982 */     Fighter _o_ = this;
/*  983 */     Map<Integer, Targets> effecttargets = new HashMap();
/*  984 */     for (Map.Entry<Integer, Targets> _e_ : _o_.effecttargets.entrySet())
/*  985 */       effecttargets.put(_e_.getKey(), new Targets.Data((Targets)_e_.getValue()));
/*  986 */     return effecttargets;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.FighterOutFightInfo getOutfightinfo()
/*      */   {
/*  993 */     _xdb_verify_unsafe_();
/*  994 */     return this.outfightinfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<EscapeHandle> getHandleonescape()
/*      */   {
/* 1001 */     _xdb_verify_unsafe_();
/* 1002 */     return Logs.logSet(new LogKey(this, "handleonescape"), this.handleonescape);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<OtherBeKilledAfterHandle> getHandleonotherbekilledafter()
/*      */   {
/* 1009 */     _xdb_verify_unsafe_();
/* 1010 */     return Logs.logSet(new LogKey(this, "handleonotherbekilledafter"), this.handleonotherbekilledafter);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setType(int _v_)
/*      */   {
/* 1017 */     _xdb_verify_unsafe_();
/* 1018 */     Logs.logIf(new LogKey(this, "type")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1022 */         new LogInt(this, Fighter.this.type)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1026 */             Fighter.this.type = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1030 */     });
/* 1031 */     this.type = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFighterid(int _v_)
/*      */   {
/* 1038 */     _xdb_verify_unsafe_();
/* 1039 */     Logs.logIf(new LogKey(this, "fighterid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1043 */         new LogInt(this, Fighter.this.fighterid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1047 */             Fighter.this.fighterid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1051 */     });
/* 1052 */     this.fighterid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPos(int _v_)
/*      */   {
/* 1059 */     _xdb_verify_unsafe_();
/* 1060 */     Logs.logIf(new LogKey(this, "pos")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1064 */         new LogInt(this, Fighter.this.pos)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1068 */             Fighter.this.pos = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1072 */     });
/* 1073 */     this.pos = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHp(int _v_)
/*      */   {
/* 1080 */     _xdb_verify_unsafe_();
/* 1081 */     Logs.logIf(new LogKey(this, "hp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1085 */         new LogInt(this, Fighter.this.hp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1089 */             Fighter.this.hp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1093 */     });
/* 1094 */     this.hp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMp(int _v_)
/*      */   {
/* 1101 */     _xdb_verify_unsafe_();
/* 1102 */     Logs.logIf(new LogKey(this, "mp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1106 */         new LogInt(this, Fighter.this.mp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1110 */             Fighter.this.mp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1114 */     });
/* 1115 */     this.mp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAnger(float _v_)
/*      */   {
/* 1122 */     _xdb_verify_unsafe_();
/* 1123 */     Logs.logIf(new LogKey(this, "anger")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1127 */         new LogFloat(this, Fighter.this.anger)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1131 */             Fighter.this.anger = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1135 */     });
/* 1136 */     this.anger = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAi(AI _v_)
/*      */   {
/* 1143 */     _xdb_verify_unsafe_();
/* 1144 */     Logs.logIf(new LogKey(this, "ai")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1148 */         new LogObject(this, Fighter.this.ai)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1152 */             Fighter.this.ai = ((AI)this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/* 1156 */     });
/* 1157 */     this.ai = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/* 1164 */     _xdb_verify_unsafe_();
/* 1165 */     Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1169 */         new LogInt(this, Fighter.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1173 */             Fighter.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1177 */     });
/* 1178 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOriginalmodelid(MapModelInfo _v_)
/*      */   {
/* 1185 */     _xdb_verify_unsafe_();
/* 1186 */     Logs.logIf(new LogKey(this, "originalmodelid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1190 */         new LogObject(this, Fighter.this.originalmodelid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1194 */             Fighter.this.originalmodelid = ((MapModelInfo)this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/* 1198 */     });
/* 1199 */     this.originalmodelid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1205 */     _xdb_verify_unsafe_();
/* 1206 */     Fighter _o_ = null;
/* 1207 */     if ((_o1_ instanceof Fighter)) { _o_ = (Fighter)_o1_;
/* 1208 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1209 */       return false;
/* 1210 */     if (this.type != _o_.type) return false;
/* 1211 */     if (this.fighterid != _o_.fighterid) return false;
/* 1212 */     if (this.pos != _o_.pos) return false;
/* 1213 */     if (this.hp != _o_.hp) return false;
/* 1214 */     if (this.mp != _o_.mp) return false;
/* 1215 */     if (this.anger != _o_.anger) return false;
/* 1216 */     if (!this.attrs.equals(_o_.attrs)) return false;
/* 1217 */     if (!this.ex_attrs.equals(_o_.ex_attrs)) return false;
/* 1218 */     if (((null == this.ai) && (null != _o_.ai)) || ((null != this.ai) && (null == _o_.ai)) || ((null != this.ai) && (null != _o_.ai) && (!this.ai.equals(_o_.ai)))) return false;
/* 1219 */     if (!this.extra.equals(_o_.extra)) return false;
/* 1220 */     if (!this.skills.equals(_o_.skills)) return false;
/* 1221 */     if (!this.skilldatas.equals(_o_.skilldatas)) return false;
/* 1222 */     if (this.state != _o_.state) return false;
/* 1223 */     if (!this.buff_states.equals(_o_.buff_states)) return false;
/* 1224 */     if (!this.buffs.equals(_o_.buffs)) return false;
/* 1225 */     if (((null == this.originalmodelid) && (null != _o_.originalmodelid)) || ((null != this.originalmodelid) && (null == _o_.originalmodelid)) || ((null != this.originalmodelid) && (null != _o_.originalmodelid) && (!this.originalmodelid.equals(_o_.originalmodelid)))) return false;
/* 1226 */     if (!this.protecterids.equals(_o_.protecterids)) return false;
/* 1227 */     if (!this.changemodelids.equals(_o_.changemodelids)) return false;
/* 1228 */     if (!this.targetstatusbuffs.equals(_o_.targetstatusbuffs)) return false;
/* 1229 */     if (!this.handleonroundstart.equals(_o_.handleonroundstart)) return false;
/* 1230 */     if (!this.handleonroundend.equals(_o_.handleonroundend)) return false;
/* 1231 */     if (!this.handleondamage.equals(_o_.handleondamage)) return false;
/* 1232 */     if (!this.handleonbedamage.equals(_o_.handleonbedamage)) return false;
/* 1233 */     if (!this.handleonbekilled.equals(_o_.handleonbekilled)) return false;
/* 1234 */     if (!this.handleonkillother.equals(_o_.handleonkillother)) return false;
/* 1235 */     if (!this.handleonrebirth.equals(_o_.handleonrebirth)) return false;
/* 1236 */     if (!this.handleonbeforeattack.equals(_o_.handleonbeforeattack)) return false;
/* 1237 */     if (!this.handleonafterattack.equals(_o_.handleonafterattack)) return false;
/* 1238 */     if (!this.handleonskillcost.equals(_o_.handleonskillcost)) return false;
/* 1239 */     if (!this.handleonaddbuff.equals(_o_.handleonaddbuff)) return false;
/* 1240 */     if (!this.handleonsealed.equals(_o_.handleonsealed)) return false;
/* 1241 */     if (!this.handleoncounter.equals(_o_.handleoncounter)) return false;
/* 1242 */     if (!this.handleonprotect.equals(_o_.handleonprotect)) return false;
/* 1243 */     if (!this.handleontaunt.equals(_o_.handleontaunt)) return false;
/* 1244 */     if (!this.handleonrebound.equals(_o_.handleonrebound)) return false;
/* 1245 */     if (!this.handleonenterfight.equals(_o_.handleonenterfight)) return false;
/* 1246 */     if (!this.handleonfighterdead.equals(_o_.handleonfighterdead)) return false;
/* 1247 */     if (!this.handleonbeforeuseskill.equals(_o_.handleonbeforeuseskill)) return false;
/* 1248 */     if (!this.handleonaftuseskill.equals(_o_.handleonaftuseskill)) return false;
/* 1249 */     if (!this.handleonbeforeheal.equals(_o_.handleonbeforeheal)) return false;
/* 1250 */     if (!this.handleontargetnumhandle.equals(_o_.handleontargetnumhandle)) return false;
/* 1251 */     if (!this.handleonbeforepoisonhandle.equals(_o_.handleonbeforepoisonhandle)) return false;
/* 1252 */     if (!this.handleonpetenterfighthandle.equals(_o_.handleonpetenterfighthandle)) return false;
/* 1253 */     if (!this.handleonaddangerhandle.equals(_o_.handleonaddangerhandle)) return false;
/* 1254 */     if (!this.handleondrughandle.equals(_o_.handleondrughandle)) return false;
/* 1255 */     if (!this.handleonlosehphandle.equals(_o_.handleonlosehphandle)) return false;
/* 1256 */     if (!this.handleonaftsummonhandle.equals(_o_.handleonaftsummonhandle)) return false;
/* 1257 */     if (!this.fightermounts.equals(_o_.fightermounts)) return false;
/* 1258 */     if (!this.nextroundaddbuffids.equals(_o_.nextroundaddbuffids)) return false;
/* 1259 */     if (!this.handleonskillcausingdeath.equals(_o_.handleonskillcausingdeath)) return false;
/* 1260 */     if (!this.handleonchildenterfighthandle.equals(_o_.handleonchildenterfighthandle)) return false;
/* 1261 */     if (!this.skillresult.equals(_o_.skillresult)) return false;
/* 1262 */     if (!this.deadrounds.equals(_o_.deadrounds)) return false;
/* 1263 */     if (!this.changemodelcard.equals(_o_.changemodelcard)) return false;
/* 1264 */     if (!this.healthatroundstart.equals(_o_.healthatroundstart)) return false;
/* 1265 */     if (!this.handleonbeforeseal.equals(_o_.handleonbeforeseal)) return false;
/* 1266 */     if (!this.fightstates.equals(_o_.fightstates)) return false;
/* 1267 */     if (!this.defaultfightstate.equals(_o_.defaultfightstate)) return false;
/* 1268 */     if (!this.effecttargets.equals(_o_.effecttargets)) return false;
/* 1269 */     if (!this.outfightinfo.equals(_o_.outfightinfo)) return false;
/* 1270 */     if (!this.handleonescape.equals(_o_.handleonescape)) return false;
/* 1271 */     if (!this.handleonotherbekilledafter.equals(_o_.handleonotherbekilledafter)) return false;
/* 1272 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1278 */     _xdb_verify_unsafe_();
/* 1279 */     int _h_ = 0;
/* 1280 */     _h_ += this.type;
/* 1281 */     _h_ += this.fighterid;
/* 1282 */     _h_ += this.pos;
/* 1283 */     _h_ += this.hp;
/* 1284 */     _h_ += this.mp;
/* 1285 */     _h_ = (int)(_h_ + this.anger);
/* 1286 */     _h_ += this.attrs.hashCode();
/* 1287 */     _h_ += this.ex_attrs.hashCode();
/* 1288 */     _h_ += (this.ai == null ? 0 : this.ai.hashCode());
/* 1289 */     _h_ += this.extra.hashCode();
/* 1290 */     _h_ += this.skills.hashCode();
/* 1291 */     _h_ += this.skilldatas.hashCode();
/* 1292 */     _h_ += this.state;
/* 1293 */     _h_ += this.buff_states.hashCode();
/* 1294 */     _h_ += this.buffs.hashCode();
/* 1295 */     _h_ += (this.originalmodelid == null ? 0 : this.originalmodelid.hashCode());
/* 1296 */     _h_ += this.protecterids.hashCode();
/* 1297 */     _h_ += this.changemodelids.hashCode();
/* 1298 */     _h_ += this.targetstatusbuffs.hashCode();
/* 1299 */     _h_ += this.handleonroundstart.hashCode();
/* 1300 */     _h_ += this.handleonroundend.hashCode();
/* 1301 */     _h_ += this.handleondamage.hashCode();
/* 1302 */     _h_ += this.handleonbedamage.hashCode();
/* 1303 */     _h_ += this.handleonbekilled.hashCode();
/* 1304 */     _h_ += this.handleonkillother.hashCode();
/* 1305 */     _h_ += this.handleonrebirth.hashCode();
/* 1306 */     _h_ += this.handleonbeforeattack.hashCode();
/* 1307 */     _h_ += this.handleonafterattack.hashCode();
/* 1308 */     _h_ += this.handleonskillcost.hashCode();
/* 1309 */     _h_ += this.handleonaddbuff.hashCode();
/* 1310 */     _h_ += this.handleonsealed.hashCode();
/* 1311 */     _h_ += this.handleoncounter.hashCode();
/* 1312 */     _h_ += this.handleonprotect.hashCode();
/* 1313 */     _h_ += this.handleontaunt.hashCode();
/* 1314 */     _h_ += this.handleonrebound.hashCode();
/* 1315 */     _h_ += this.handleonenterfight.hashCode();
/* 1316 */     _h_ += this.handleonfighterdead.hashCode();
/* 1317 */     _h_ += this.handleonbeforeuseskill.hashCode();
/* 1318 */     _h_ += this.handleonaftuseskill.hashCode();
/* 1319 */     _h_ += this.handleonbeforeheal.hashCode();
/* 1320 */     _h_ += this.handleontargetnumhandle.hashCode();
/* 1321 */     _h_ += this.handleonbeforepoisonhandle.hashCode();
/* 1322 */     _h_ += this.handleonpetenterfighthandle.hashCode();
/* 1323 */     _h_ += this.handleonaddangerhandle.hashCode();
/* 1324 */     _h_ += this.handleondrughandle.hashCode();
/* 1325 */     _h_ += this.handleonlosehphandle.hashCode();
/* 1326 */     _h_ += this.handleonaftsummonhandle.hashCode();
/* 1327 */     _h_ += this.fightermounts.hashCode();
/* 1328 */     _h_ += this.nextroundaddbuffids.hashCode();
/* 1329 */     _h_ += this.handleonskillcausingdeath.hashCode();
/* 1330 */     _h_ += this.handleonchildenterfighthandle.hashCode();
/* 1331 */     _h_ += this.skillresult.hashCode();
/* 1332 */     _h_ += this.deadrounds.hashCode();
/* 1333 */     _h_ += this.changemodelcard.hashCode();
/* 1334 */     _h_ += this.healthatroundstart.hashCode();
/* 1335 */     _h_ += this.handleonbeforeseal.hashCode();
/* 1336 */     _h_ += this.fightstates.hashCode();
/* 1337 */     _h_ += this.defaultfightstate.hashCode();
/* 1338 */     _h_ += this.effecttargets.hashCode();
/* 1339 */     _h_ += this.outfightinfo.hashCode();
/* 1340 */     _h_ += this.handleonescape.hashCode();
/* 1341 */     _h_ += this.handleonotherbekilledafter.hashCode();
/* 1342 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1348 */     _xdb_verify_unsafe_();
/* 1349 */     StringBuilder _sb_ = new StringBuilder();
/* 1350 */     _sb_.append("(");
/* 1351 */     _sb_.append(this.type);
/* 1352 */     _sb_.append(",");
/* 1353 */     _sb_.append(this.fighterid);
/* 1354 */     _sb_.append(",");
/* 1355 */     _sb_.append(this.pos);
/* 1356 */     _sb_.append(",");
/* 1357 */     _sb_.append(this.hp);
/* 1358 */     _sb_.append(",");
/* 1359 */     _sb_.append(this.mp);
/* 1360 */     _sb_.append(",");
/* 1361 */     _sb_.append(this.anger);
/* 1362 */     _sb_.append(",");
/* 1363 */     _sb_.append(this.attrs);
/* 1364 */     _sb_.append(",");
/* 1365 */     _sb_.append(this.ex_attrs);
/* 1366 */     _sb_.append(",");
/* 1367 */     _sb_.append(this.ai);
/* 1368 */     _sb_.append(",");
/* 1369 */     _sb_.append(this.extra);
/* 1370 */     _sb_.append(",");
/* 1371 */     _sb_.append(this.skills);
/* 1372 */     _sb_.append(",");
/* 1373 */     _sb_.append(this.skilldatas);
/* 1374 */     _sb_.append(",");
/* 1375 */     _sb_.append(this.state);
/* 1376 */     _sb_.append(",");
/* 1377 */     _sb_.append(this.buff_states);
/* 1378 */     _sb_.append(",");
/* 1379 */     _sb_.append(this.buffs);
/* 1380 */     _sb_.append(",");
/* 1381 */     _sb_.append(this.originalmodelid);
/* 1382 */     _sb_.append(",");
/* 1383 */     _sb_.append(this.protecterids);
/* 1384 */     _sb_.append(",");
/* 1385 */     _sb_.append(this.changemodelids);
/* 1386 */     _sb_.append(",");
/* 1387 */     _sb_.append(this.targetstatusbuffs);
/* 1388 */     _sb_.append(",");
/* 1389 */     _sb_.append(this.handleonroundstart);
/* 1390 */     _sb_.append(",");
/* 1391 */     _sb_.append(this.handleonroundend);
/* 1392 */     _sb_.append(",");
/* 1393 */     _sb_.append(this.handleondamage);
/* 1394 */     _sb_.append(",");
/* 1395 */     _sb_.append(this.handleonbedamage);
/* 1396 */     _sb_.append(",");
/* 1397 */     _sb_.append(this.handleonbekilled);
/* 1398 */     _sb_.append(",");
/* 1399 */     _sb_.append(this.handleonkillother);
/* 1400 */     _sb_.append(",");
/* 1401 */     _sb_.append(this.handleonrebirth);
/* 1402 */     _sb_.append(",");
/* 1403 */     _sb_.append(this.handleonbeforeattack);
/* 1404 */     _sb_.append(",");
/* 1405 */     _sb_.append(this.handleonafterattack);
/* 1406 */     _sb_.append(",");
/* 1407 */     _sb_.append(this.handleonskillcost);
/* 1408 */     _sb_.append(",");
/* 1409 */     _sb_.append(this.handleonaddbuff);
/* 1410 */     _sb_.append(",");
/* 1411 */     _sb_.append(this.handleonsealed);
/* 1412 */     _sb_.append(",");
/* 1413 */     _sb_.append(this.handleoncounter);
/* 1414 */     _sb_.append(",");
/* 1415 */     _sb_.append(this.handleonprotect);
/* 1416 */     _sb_.append(",");
/* 1417 */     _sb_.append(this.handleontaunt);
/* 1418 */     _sb_.append(",");
/* 1419 */     _sb_.append(this.handleonrebound);
/* 1420 */     _sb_.append(",");
/* 1421 */     _sb_.append(this.handleonenterfight);
/* 1422 */     _sb_.append(",");
/* 1423 */     _sb_.append(this.handleonfighterdead);
/* 1424 */     _sb_.append(",");
/* 1425 */     _sb_.append(this.handleonbeforeuseskill);
/* 1426 */     _sb_.append(",");
/* 1427 */     _sb_.append(this.handleonaftuseskill);
/* 1428 */     _sb_.append(",");
/* 1429 */     _sb_.append(this.handleonbeforeheal);
/* 1430 */     _sb_.append(",");
/* 1431 */     _sb_.append(this.handleontargetnumhandle);
/* 1432 */     _sb_.append(",");
/* 1433 */     _sb_.append(this.handleonbeforepoisonhandle);
/* 1434 */     _sb_.append(",");
/* 1435 */     _sb_.append(this.handleonpetenterfighthandle);
/* 1436 */     _sb_.append(",");
/* 1437 */     _sb_.append(this.handleonaddangerhandle);
/* 1438 */     _sb_.append(",");
/* 1439 */     _sb_.append(this.handleondrughandle);
/* 1440 */     _sb_.append(",");
/* 1441 */     _sb_.append(this.handleonlosehphandle);
/* 1442 */     _sb_.append(",");
/* 1443 */     _sb_.append(this.handleonaftsummonhandle);
/* 1444 */     _sb_.append(",");
/* 1445 */     _sb_.append(this.fightermounts);
/* 1446 */     _sb_.append(",");
/* 1447 */     _sb_.append(this.nextroundaddbuffids);
/* 1448 */     _sb_.append(",");
/* 1449 */     _sb_.append(this.handleonskillcausingdeath);
/* 1450 */     _sb_.append(",");
/* 1451 */     _sb_.append(this.handleonchildenterfighthandle);
/* 1452 */     _sb_.append(",");
/* 1453 */     _sb_.append(this.skillresult);
/* 1454 */     _sb_.append(",");
/* 1455 */     _sb_.append(this.deadrounds);
/* 1456 */     _sb_.append(",");
/* 1457 */     _sb_.append(this.changemodelcard);
/* 1458 */     _sb_.append(",");
/* 1459 */     _sb_.append(this.healthatroundstart);
/* 1460 */     _sb_.append(",");
/* 1461 */     _sb_.append(this.handleonbeforeseal);
/* 1462 */     _sb_.append(",");
/* 1463 */     _sb_.append(this.fightstates);
/* 1464 */     _sb_.append(",");
/* 1465 */     _sb_.append(this.defaultfightstate);
/* 1466 */     _sb_.append(",");
/* 1467 */     _sb_.append(this.effecttargets);
/* 1468 */     _sb_.append(",");
/* 1469 */     _sb_.append(this.outfightinfo);
/* 1470 */     _sb_.append(",");
/* 1471 */     _sb_.append(this.handleonescape);
/* 1472 */     _sb_.append(",");
/* 1473 */     _sb_.append(this.handleonotherbekilledafter);
/* 1474 */     _sb_.append(")");
/* 1475 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/* 1481 */     ListenableBean lb = new ListenableBean();
/* 1482 */     lb.add(new ListenableChanged().setVarName("type"));
/* 1483 */     lb.add(new ListenableChanged().setVarName("fighterid"));
/* 1484 */     lb.add(new ListenableChanged().setVarName("pos"));
/* 1485 */     lb.add(new ListenableChanged().setVarName("hp"));
/* 1486 */     lb.add(new ListenableChanged().setVarName("mp"));
/* 1487 */     lb.add(new ListenableChanged().setVarName("anger"));
/* 1488 */     lb.add(new ListenableMap().setVarName("attrs"));
/* 1489 */     lb.add(new ListenableMap().setVarName("ex_attrs"));
/* 1490 */     lb.add(new ListenableChanged().setVarName("ai"));
/* 1491 */     lb.add(new ListenableMap().setVarName("extra"));
/* 1492 */     lb.add(new ListenableMap().setVarName("skills"));
/* 1493 */     lb.add(new ListenableMap().setVarName("skilldatas"));
/* 1494 */     lb.add(new ListenableChanged().setVarName("state"));
/* 1495 */     lb.add(new ListenableMap().setVarName("buff_states"));
/* 1496 */     lb.add(new ListenableMap().setVarName("buffs"));
/* 1497 */     lb.add(new ListenableChanged().setVarName("originalmodelid"));
/* 1498 */     lb.add(new ListenableChanged().setVarName("protecterids"));
/* 1499 */     lb.add(new ListenableChanged().setVarName("changemodelids"));
/* 1500 */     lb.add(new ListenableMap().setVarName("targetstatusbuffs"));
/* 1501 */     lb.add(new ListenableSet().setVarName("handleonroundstart"));
/* 1502 */     lb.add(new ListenableSet().setVarName("handleonroundend"));
/* 1503 */     lb.add(new ListenableSet().setVarName("handleondamage"));
/* 1504 */     lb.add(new ListenableSet().setVarName("handleonbedamage"));
/* 1505 */     lb.add(new ListenableSet().setVarName("handleonbekilled"));
/* 1506 */     lb.add(new ListenableSet().setVarName("handleonkillother"));
/* 1507 */     lb.add(new ListenableSet().setVarName("handleonrebirth"));
/* 1508 */     lb.add(new ListenableSet().setVarName("handleonbeforeattack"));
/* 1509 */     lb.add(new ListenableSet().setVarName("handleonafterattack"));
/* 1510 */     lb.add(new ListenableSet().setVarName("handleonskillcost"));
/* 1511 */     lb.add(new ListenableSet().setVarName("handleonaddbuff"));
/* 1512 */     lb.add(new ListenableSet().setVarName("handleonsealed"));
/* 1513 */     lb.add(new ListenableSet().setVarName("handleoncounter"));
/* 1514 */     lb.add(new ListenableSet().setVarName("handleonprotect"));
/* 1515 */     lb.add(new ListenableSet().setVarName("handleontaunt"));
/* 1516 */     lb.add(new ListenableSet().setVarName("handleonrebound"));
/* 1517 */     lb.add(new ListenableSet().setVarName("handleonenterfight"));
/* 1518 */     lb.add(new ListenableSet().setVarName("handleonfighterdead"));
/* 1519 */     lb.add(new ListenableSet().setVarName("handleonbeforeuseskill"));
/* 1520 */     lb.add(new ListenableSet().setVarName("handleonaftuseskill"));
/* 1521 */     lb.add(new ListenableSet().setVarName("handleonbeforeheal"));
/* 1522 */     lb.add(new ListenableSet().setVarName("handleontargetnumhandle"));
/* 1523 */     lb.add(new ListenableSet().setVarName("handleonbeforepoisonhandle"));
/* 1524 */     lb.add(new ListenableSet().setVarName("handleonpetenterfighthandle"));
/* 1525 */     lb.add(new ListenableSet().setVarName("handleonaddangerhandle"));
/* 1526 */     lb.add(new ListenableSet().setVarName("handleondrughandle"));
/* 1527 */     lb.add(new ListenableSet().setVarName("handleonlosehphandle"));
/* 1528 */     lb.add(new ListenableSet().setVarName("handleonaftsummonhandle"));
/* 1529 */     lb.add(new ListenableChanged().setVarName("fightermounts"));
/* 1530 */     lb.add(new ListenableChanged().setVarName("nextroundaddbuffids"));
/* 1531 */     lb.add(new ListenableSet().setVarName("handleonskillcausingdeath"));
/* 1532 */     lb.add(new ListenableSet().setVarName("handleonchildenterfighthandle"));
/* 1533 */     lb.add(new ListenableChanged().setVarName("skillresult"));
/* 1534 */     lb.add(new ListenableChanged().setVarName("deadrounds"));
/* 1535 */     lb.add(new ListenableChanged().setVarName("changemodelcard"));
/* 1536 */     lb.add(new ListenableMap().setVarName("healthatroundstart"));
/* 1537 */     lb.add(new ListenableSet().setVarName("handleonbeforeseal"));
/* 1538 */     lb.add(new ListenableMap().setVarName("fightstates"));
/* 1539 */     lb.add(new ListenableChanged().setVarName("defaultfightstate"));
/* 1540 */     lb.add(new ListenableMap().setVarName("effecttargets"));
/* 1541 */     lb.add(new ListenableChanged().setVarName("outfightinfo"));
/* 1542 */     lb.add(new ListenableSet().setVarName("handleonescape"));
/* 1543 */     lb.add(new ListenableSet().setVarName("handleonotherbekilledafter"));
/* 1544 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Fighter {
/*      */     private Const() {}
/*      */     
/*      */     Fighter nThis() {
/* 1551 */       return Fighter.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1557 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Fighter copy()
/*      */     {
/* 1563 */       return Fighter.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Fighter toData()
/*      */     {
/* 1569 */       return Fighter.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Fighter toBean()
/*      */     {
/* 1574 */       return Fighter.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Fighter toDataIf()
/*      */     {
/* 1580 */       return Fighter.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Fighter toBeanIf()
/*      */     {
/* 1585 */       return Fighter.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getType()
/*      */     {
/* 1592 */       Fighter.this._xdb_verify_unsafe_();
/* 1593 */       return Fighter.this.type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFighterid()
/*      */     {
/* 1600 */       Fighter.this._xdb_verify_unsafe_();
/* 1601 */       return Fighter.this.fighterid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPos()
/*      */     {
/* 1608 */       Fighter.this._xdb_verify_unsafe_();
/* 1609 */       return Fighter.this.pos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHp()
/*      */     {
/* 1616 */       Fighter.this._xdb_verify_unsafe_();
/* 1617 */       return Fighter.this.hp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMp()
/*      */     {
/* 1624 */       Fighter.this._xdb_verify_unsafe_();
/* 1625 */       return Fighter.this.mp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getAnger()
/*      */     {
/* 1632 */       Fighter.this._xdb_verify_unsafe_();
/* 1633 */       return Fighter.this.anger;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAttrs()
/*      */     {
/* 1640 */       Fighter.this._xdb_verify_unsafe_();
/* 1641 */       return Consts.constMap(Fighter.this.attrs);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAttrsAsData()
/*      */     {
/* 1648 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 1650 */       Fighter _o_ = Fighter.this;
/* 1651 */       Map<Integer, Integer> attrs = new HashMap();
/* 1652 */       for (Map.Entry<Integer, Integer> _e_ : _o_.attrs.entrySet())
/* 1653 */         attrs.put(_e_.getKey(), _e_.getValue());
/* 1654 */       return attrs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getEx_attrs()
/*      */     {
/* 1661 */       Fighter.this._xdb_verify_unsafe_();
/* 1662 */       return Consts.constMap(Fighter.this.ex_attrs);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getEx_attrsAsData()
/*      */     {
/* 1669 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 1671 */       Fighter _o_ = Fighter.this;
/* 1672 */       Map<Integer, Integer> ex_attrs = new HashMap();
/* 1673 */       for (Map.Entry<Integer, Integer> _e_ : _o_.ex_attrs.entrySet())
/* 1674 */         ex_attrs.put(_e_.getKey(), _e_.getValue());
/* 1675 */       return ex_attrs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public AI getAi()
/*      */     {
/* 1682 */       Fighter.this._xdb_verify_unsafe_();
/* 1683 */       return Fighter.this.ai;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtra()
/*      */     {
/* 1690 */       Fighter.this._xdb_verify_unsafe_();
/* 1691 */       return Consts.constMap(Fighter.this.extra);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtraAsData()
/*      */     {
/* 1698 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 1700 */       Fighter _o_ = Fighter.this;
/* 1701 */       Map<Integer, Integer> extra = new HashMap();
/* 1702 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/* 1703 */         extra.put(_e_.getKey(), _e_.getValue());
/* 1704 */       return extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkills()
/*      */     {
/* 1711 */       Fighter.this._xdb_verify_unsafe_();
/* 1712 */       return Consts.constMap(Fighter.this.skills);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillsAsData()
/*      */     {
/* 1719 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 1721 */       Fighter _o_ = Fighter.this;
/* 1722 */       Map<Integer, Integer> skills = new HashMap();
/* 1723 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skills.entrySet())
/* 1724 */         skills.put(_e_.getKey(), _e_.getValue());
/* 1725 */       return skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, SkillData> getSkilldatas()
/*      */     {
/* 1732 */       Fighter.this._xdb_verify_unsafe_();
/* 1733 */       return Consts.constMap(Fighter.this.skilldatas);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, SkillData> getSkilldatasAsData()
/*      */     {
/* 1740 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 1742 */       Fighter _o_ = Fighter.this;
/* 1743 */       Map<Integer, SkillData> skilldatas = new HashMap();
/* 1744 */       for (Map.Entry<Integer, SkillData> _e_ : _o_.skilldatas.entrySet())
/* 1745 */         skilldatas.put(_e_.getKey(), new SkillData.Data((SkillData)_e_.getValue()));
/* 1746 */       return skilldatas;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1753 */       Fighter.this._xdb_verify_unsafe_();
/* 1754 */       return Fighter.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBuff_states()
/*      */     {
/* 1761 */       Fighter.this._xdb_verify_unsafe_();
/* 1762 */       return Consts.constMap(Fighter.this.buff_states);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBuff_statesAsData()
/*      */     {
/* 1769 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 1771 */       Fighter _o_ = Fighter.this;
/* 1772 */       Map<Integer, Integer> buff_states = new HashMap();
/* 1773 */       for (Map.Entry<Integer, Integer> _e_ : _o_.buff_states.entrySet())
/* 1774 */         buff_states.put(_e_.getKey(), _e_.getValue());
/* 1775 */       return buff_states;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, FighterBuffs> getBuffs()
/*      */     {
/* 1782 */       Fighter.this._xdb_verify_unsafe_();
/* 1783 */       return Consts.constMap(Fighter.this.buffs);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public MapModelInfo getOriginalmodelid()
/*      */     {
/* 1790 */       Fighter.this._xdb_verify_unsafe_();
/* 1791 */       return Fighter.this.originalmodelid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getProtecterids()
/*      */     {
/* 1798 */       Fighter.this._xdb_verify_unsafe_();
/* 1799 */       return Consts.constList(Fighter.this.protecterids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getProtecteridsAsData()
/*      */     {
/* 1805 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 1807 */       Fighter _o_ = Fighter.this;
/* 1808 */       List<Integer> protecterids = new ArrayList();
/* 1809 */       protecterids.addAll(_o_.protecterids);
/* 1810 */       return protecterids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getChangemodelids()
/*      */     {
/* 1817 */       Fighter.this._xdb_verify_unsafe_();
/* 1818 */       return Consts.constList(Fighter.this.changemodelids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getChangemodelidsAsData()
/*      */     {
/* 1824 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 1826 */       Fighter _o_ = Fighter.this;
/* 1827 */       List<Integer> changemodelids = new ArrayList();
/* 1828 */       changemodelids.addAll(_o_.changemodelids);
/* 1829 */       return changemodelids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Targets> getTargetstatusbuffs()
/*      */     {
/* 1836 */       Fighter.this._xdb_verify_unsafe_();
/* 1837 */       return Consts.constMap(Fighter.this.targetstatusbuffs);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Targets> getTargetstatusbuffsAsData()
/*      */     {
/* 1844 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 1846 */       Fighter _o_ = Fighter.this;
/* 1847 */       Map<Integer, Targets> targetstatusbuffs = new HashMap();
/* 1848 */       for (Map.Entry<Integer, Targets> _e_ : _o_.targetstatusbuffs.entrySet())
/* 1849 */         targetstatusbuffs.put(_e_.getKey(), new Targets.Data((Targets)_e_.getValue()));
/* 1850 */       return targetstatusbuffs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<RoundStartHandle> getHandleonroundstart()
/*      */     {
/* 1857 */       Fighter.this._xdb_verify_unsafe_();
/* 1858 */       return Consts.constSet(Fighter.this.handleonroundstart);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<RoundEndHandle> getHandleonroundend()
/*      */     {
/* 1865 */       Fighter.this._xdb_verify_unsafe_();
/* 1866 */       return Consts.constSet(Fighter.this.handleonroundend);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<DamageHandle> getHandleondamage()
/*      */     {
/* 1873 */       Fighter.this._xdb_verify_unsafe_();
/* 1874 */       return Consts.constSet(Fighter.this.handleondamage);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeDamageHandle> getHandleonbedamage()
/*      */     {
/* 1881 */       Fighter.this._xdb_verify_unsafe_();
/* 1882 */       return Consts.constSet(Fighter.this.handleonbedamage);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeKilledHandle> getHandleonbekilled()
/*      */     {
/* 1889 */       Fighter.this._xdb_verify_unsafe_();
/* 1890 */       return Consts.constSet(Fighter.this.handleonbekilled);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<KillOtherHandle> getHandleonkillother()
/*      */     {
/* 1897 */       Fighter.this._xdb_verify_unsafe_();
/* 1898 */       return Consts.constSet(Fighter.this.handleonkillother);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<RebirthHandle> getHandleonrebirth()
/*      */     {
/* 1905 */       Fighter.this._xdb_verify_unsafe_();
/* 1906 */       return Consts.constSet(Fighter.this.handleonrebirth);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeforeAttackHandle> getHandleonbeforeattack()
/*      */     {
/* 1913 */       Fighter.this._xdb_verify_unsafe_();
/* 1914 */       return Consts.constSet(Fighter.this.handleonbeforeattack);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<AfterAttackHandle> getHandleonafterattack()
/*      */     {
/* 1921 */       Fighter.this._xdb_verify_unsafe_();
/* 1922 */       return Consts.constSet(Fighter.this.handleonafterattack);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<SkillCostHandle> getHandleonskillcost()
/*      */     {
/* 1929 */       Fighter.this._xdb_verify_unsafe_();
/* 1930 */       return Consts.constSet(Fighter.this.handleonskillcost);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<AddBuffHandle> getHandleonaddbuff()
/*      */     {
/* 1937 */       Fighter.this._xdb_verify_unsafe_();
/* 1938 */       return Consts.constSet(Fighter.this.handleonaddbuff);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<SealedHandle> getHandleonsealed()
/*      */     {
/* 1945 */       Fighter.this._xdb_verify_unsafe_();
/* 1946 */       return Consts.constSet(Fighter.this.handleonsealed);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<CounterHandle> getHandleoncounter()
/*      */     {
/* 1953 */       Fighter.this._xdb_verify_unsafe_();
/* 1954 */       return Consts.constSet(Fighter.this.handleoncounter);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<ProtectHandle> getHandleonprotect()
/*      */     {
/* 1961 */       Fighter.this._xdb_verify_unsafe_();
/* 1962 */       return Consts.constSet(Fighter.this.handleonprotect);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<TauntHandle> getHandleontaunt()
/*      */     {
/* 1969 */       Fighter.this._xdb_verify_unsafe_();
/* 1970 */       return Consts.constSet(Fighter.this.handleontaunt);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<ReboundHandle> getHandleonrebound()
/*      */     {
/* 1977 */       Fighter.this._xdb_verify_unsafe_();
/* 1978 */       return Consts.constSet(Fighter.this.handleonrebound);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<EnterFightHandle> getHandleonenterfight()
/*      */     {
/* 1985 */       Fighter.this._xdb_verify_unsafe_();
/* 1986 */       return Consts.constSet(Fighter.this.handleonenterfight);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<FighterDeadHandle> getHandleonfighterdead()
/*      */     {
/* 1993 */       Fighter.this._xdb_verify_unsafe_();
/* 1994 */       return Consts.constSet(Fighter.this.handleonfighterdead);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeforeUseSkilHandle> getHandleonbeforeuseskill()
/*      */     {
/* 2001 */       Fighter.this._xdb_verify_unsafe_();
/* 2002 */       return Consts.constSet(Fighter.this.handleonbeforeuseskill);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<AftUseSkilHandle> getHandleonaftuseskill()
/*      */     {
/* 2009 */       Fighter.this._xdb_verify_unsafe_();
/* 2010 */       return Consts.constSet(Fighter.this.handleonaftuseskill);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeforeHealHandle> getHandleonbeforeheal()
/*      */     {
/* 2017 */       Fighter.this._xdb_verify_unsafe_();
/* 2018 */       return Consts.constSet(Fighter.this.handleonbeforeheal);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<TargetNumHandle> getHandleontargetnumhandle()
/*      */     {
/* 2025 */       Fighter.this._xdb_verify_unsafe_();
/* 2026 */       return Consts.constSet(Fighter.this.handleontargetnumhandle);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeforePoisonHandle> getHandleonbeforepoisonhandle()
/*      */     {
/* 2033 */       Fighter.this._xdb_verify_unsafe_();
/* 2034 */       return Consts.constSet(Fighter.this.handleonbeforepoisonhandle);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<PetEnterFightHandle> getHandleonpetenterfighthandle()
/*      */     {
/* 2041 */       Fighter.this._xdb_verify_unsafe_();
/* 2042 */       return Consts.constSet(Fighter.this.handleonpetenterfighthandle);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<AddAngerHandle> getHandleonaddangerhandle()
/*      */     {
/* 2049 */       Fighter.this._xdb_verify_unsafe_();
/* 2050 */       return Consts.constSet(Fighter.this.handleonaddangerhandle);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<DrugHandle> getHandleondrughandle()
/*      */     {
/* 2057 */       Fighter.this._xdb_verify_unsafe_();
/* 2058 */       return Consts.constSet(Fighter.this.handleondrughandle);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<LoseHpHandle> getHandleonlosehphandle()
/*      */     {
/* 2065 */       Fighter.this._xdb_verify_unsafe_();
/* 2066 */       return Consts.constSet(Fighter.this.handleonlosehphandle);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<AfterSummonHandle> getHandleonaftsummonhandle()
/*      */     {
/* 2073 */       Fighter.this._xdb_verify_unsafe_();
/* 2074 */       return Consts.constSet(Fighter.this.handleonaftsummonhandle);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FighterMounts getFightermounts()
/*      */     {
/* 2081 */       Fighter.this._xdb_verify_unsafe_();
/* 2082 */       return (xbean.FighterMounts)Consts.toConst(Fighter.this.fightermounts);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getNextroundaddbuffids()
/*      */     {
/* 2089 */       Fighter.this._xdb_verify_unsafe_();
/* 2090 */       return Consts.constList(Fighter.this.nextroundaddbuffids);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<SkillCausingDeathHandle> getHandleonskillcausingdeath()
/*      */     {
/* 2097 */       Fighter.this._xdb_verify_unsafe_();
/* 2098 */       return Consts.constSet(Fighter.this.handleonskillcausingdeath);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<ChildEnterFightHandle> getHandleonchildenterfighthandle()
/*      */     {
/* 2105 */       Fighter.this._xdb_verify_unsafe_();
/* 2106 */       return Consts.constSet(Fighter.this.handleonchildenterfighthandle);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.SkillResult getSkillresult()
/*      */     {
/* 2113 */       Fighter.this._xdb_verify_unsafe_();
/* 2114 */       return (xbean.SkillResult)Consts.toConst(Fighter.this.skillresult);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getDeadrounds()
/*      */     {
/* 2121 */       Fighter.this._xdb_verify_unsafe_();
/* 2122 */       return Consts.constList(Fighter.this.deadrounds);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getDeadroundsAsData()
/*      */     {
/* 2128 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 2130 */       Fighter _o_ = Fighter.this;
/* 2131 */       List<Integer> deadrounds = new ArrayList();
/* 2132 */       deadrounds.addAll(_o_.deadrounds);
/* 2133 */       return deadrounds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FighterModelCard getChangemodelcard()
/*      */     {
/* 2140 */       Fighter.this._xdb_verify_unsafe_();
/* 2141 */       return (xbean.FighterModelCard)Consts.toConst(Fighter.this.changemodelcard);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, FighterHealthInfo> getHealthatroundstart()
/*      */     {
/* 2148 */       Fighter.this._xdb_verify_unsafe_();
/* 2149 */       return Consts.constMap(Fighter.this.healthatroundstart);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, FighterHealthInfo> getHealthatroundstartAsData()
/*      */     {
/* 2156 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 2158 */       Fighter _o_ = Fighter.this;
/* 2159 */       Map<Integer, FighterHealthInfo> healthatroundstart = new HashMap();
/* 2160 */       for (Map.Entry<Integer, FighterHealthInfo> _e_ : _o_.healthatroundstart.entrySet())
/* 2161 */         healthatroundstart.put(_e_.getKey(), new FighterHealthInfo.Data((FighterHealthInfo)_e_.getValue()));
/* 2162 */       return healthatroundstart;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeforeSealHandle> getHandleonbeforeseal()
/*      */     {
/* 2169 */       Fighter.this._xdb_verify_unsafe_();
/* 2170 */       return Consts.constSet(Fighter.this.handleonbeforeseal);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FightState> getFightstates()
/*      */     {
/* 2177 */       Fighter.this._xdb_verify_unsafe_();
/* 2178 */       return Consts.constMap(Fighter.this.fightstates);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FightState> getFightstatesAsData()
/*      */     {
/* 2185 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 2187 */       Fighter _o_ = Fighter.this;
/* 2188 */       Map<Integer, xbean.FightState> fightstates = new HashMap();
/* 2189 */       for (Map.Entry<Integer, xbean.FightState> _e_ : _o_.fightstates.entrySet())
/* 2190 */         fightstates.put(_e_.getKey(), new FightState.Data((xbean.FightState)_e_.getValue()));
/* 2191 */       return fightstates;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FightState getDefaultfightstate()
/*      */     {
/* 2198 */       Fighter.this._xdb_verify_unsafe_();
/* 2199 */       return (xbean.FightState)Consts.toConst(Fighter.this.defaultfightstate);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Targets> getEffecttargets()
/*      */     {
/* 2206 */       Fighter.this._xdb_verify_unsafe_();
/* 2207 */       return Consts.constMap(Fighter.this.effecttargets);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Targets> getEffecttargetsAsData()
/*      */     {
/* 2214 */       Fighter.this._xdb_verify_unsafe_();
/*      */       
/* 2216 */       Fighter _o_ = Fighter.this;
/* 2217 */       Map<Integer, Targets> effecttargets = new HashMap();
/* 2218 */       for (Map.Entry<Integer, Targets> _e_ : _o_.effecttargets.entrySet())
/* 2219 */         effecttargets.put(_e_.getKey(), new Targets.Data((Targets)_e_.getValue()));
/* 2220 */       return effecttargets;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FighterOutFightInfo getOutfightinfo()
/*      */     {
/* 2227 */       Fighter.this._xdb_verify_unsafe_();
/* 2228 */       return (xbean.FighterOutFightInfo)Consts.toConst(Fighter.this.outfightinfo);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<EscapeHandle> getHandleonescape()
/*      */     {
/* 2235 */       Fighter.this._xdb_verify_unsafe_();
/* 2236 */       return Consts.constSet(Fighter.this.handleonescape);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<OtherBeKilledAfterHandle> getHandleonotherbekilledafter()
/*      */     {
/* 2243 */       Fighter.this._xdb_verify_unsafe_();
/* 2244 */       return Consts.constSet(Fighter.this.handleonotherbekilledafter);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setType(int _v_)
/*      */     {
/* 2251 */       Fighter.this._xdb_verify_unsafe_();
/* 2252 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFighterid(int _v_)
/*      */     {
/* 2259 */       Fighter.this._xdb_verify_unsafe_();
/* 2260 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPos(int _v_)
/*      */     {
/* 2267 */       Fighter.this._xdb_verify_unsafe_();
/* 2268 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHp(int _v_)
/*      */     {
/* 2275 */       Fighter.this._xdb_verify_unsafe_();
/* 2276 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMp(int _v_)
/*      */     {
/* 2283 */       Fighter.this._xdb_verify_unsafe_();
/* 2284 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnger(float _v_)
/*      */     {
/* 2291 */       Fighter.this._xdb_verify_unsafe_();
/* 2292 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAi(AI _v_)
/*      */     {
/* 2299 */       Fighter.this._xdb_verify_unsafe_();
/* 2300 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 2307 */       Fighter.this._xdb_verify_unsafe_();
/* 2308 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOriginalmodelid(MapModelInfo _v_)
/*      */     {
/* 2315 */       Fighter.this._xdb_verify_unsafe_();
/* 2316 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 2322 */       Fighter.this._xdb_verify_unsafe_();
/* 2323 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 2329 */       Fighter.this._xdb_verify_unsafe_();
/* 2330 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 2336 */       return Fighter.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2342 */       return Fighter.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2348 */       Fighter.this._xdb_verify_unsafe_();
/* 2349 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 2355 */       return Fighter.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2361 */       return Fighter.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2367 */       Fighter.this._xdb_verify_unsafe_();
/* 2368 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 2374 */       return Fighter.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2380 */       return Fighter.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 2386 */       return Fighter.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 2392 */       return Fighter.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 2398 */       return Fighter.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 2404 */       return Fighter.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2410 */       return Fighter.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Fighter
/*      */   {
/*      */     private int type;
/*      */     
/*      */     private int fighterid;
/*      */     
/*      */     private int pos;
/*      */     
/*      */     private int hp;
/*      */     
/*      */     private int mp;
/*      */     
/*      */     private float anger;
/*      */     
/*      */     private HashMap<Integer, Integer> attrs;
/*      */     
/*      */     private HashMap<Integer, Integer> ex_attrs;
/*      */     
/*      */     private AI ai;
/*      */     
/*      */     private HashMap<Integer, Integer> extra;
/*      */     
/*      */     private HashMap<Integer, Integer> skills;
/*      */     
/*      */     private HashMap<Integer, SkillData> skilldatas;
/*      */     
/*      */     private int state;
/*      */     
/*      */     private HashMap<Integer, Integer> buff_states;
/*      */     
/*      */     private HashMap<Integer, FighterBuffs> buffs;
/*      */     
/*      */     private MapModelInfo originalmodelid;
/*      */     
/*      */     private ArrayList<Integer> protecterids;
/*      */     
/*      */     private ArrayList<Integer> changemodelids;
/*      */     
/*      */     private HashMap<Integer, Targets> targetstatusbuffs;
/*      */     
/*      */     private HashSet<RoundStartHandle> handleonroundstart;
/*      */     
/*      */     private HashSet<RoundEndHandle> handleonroundend;
/*      */     
/*      */     private HashSet<DamageHandle> handleondamage;
/*      */     
/*      */     private HashSet<BeDamageHandle> handleonbedamage;
/*      */     
/*      */     private HashSet<BeKilledHandle> handleonbekilled;
/*      */     
/*      */     private HashSet<KillOtherHandle> handleonkillother;
/*      */     
/*      */     private HashSet<RebirthHandle> handleonrebirth;
/*      */     
/*      */     private HashSet<BeforeAttackHandle> handleonbeforeattack;
/*      */     
/*      */     private HashSet<AfterAttackHandle> handleonafterattack;
/*      */     
/*      */     private HashSet<SkillCostHandle> handleonskillcost;
/*      */     
/*      */     private HashSet<AddBuffHandle> handleonaddbuff;
/*      */     
/*      */     private HashSet<SealedHandle> handleonsealed;
/*      */     
/*      */     private HashSet<CounterHandle> handleoncounter;
/*      */     
/*      */     private HashSet<ProtectHandle> handleonprotect;
/*      */     
/*      */     private HashSet<TauntHandle> handleontaunt;
/*      */     
/*      */     private HashSet<ReboundHandle> handleonrebound;
/*      */     
/*      */     private HashSet<EnterFightHandle> handleonenterfight;
/*      */     
/*      */     private HashSet<FighterDeadHandle> handleonfighterdead;
/*      */     
/*      */     private HashSet<BeforeUseSkilHandle> handleonbeforeuseskill;
/*      */     
/*      */     private HashSet<AftUseSkilHandle> handleonaftuseskill;
/*      */     
/*      */     private HashSet<BeforeHealHandle> handleonbeforeheal;
/*      */     
/*      */     private HashSet<TargetNumHandle> handleontargetnumhandle;
/*      */     
/*      */     private HashSet<BeforePoisonHandle> handleonbeforepoisonhandle;
/*      */     
/*      */     private HashSet<PetEnterFightHandle> handleonpetenterfighthandle;
/*      */     
/*      */     private HashSet<AddAngerHandle> handleonaddangerhandle;
/*      */     
/*      */     private HashSet<DrugHandle> handleondrughandle;
/*      */     
/*      */     private HashSet<LoseHpHandle> handleonlosehphandle;
/*      */     
/*      */     private HashSet<AfterSummonHandle> handleonaftsummonhandle;
/*      */     
/*      */     private xbean.FighterMounts fightermounts;
/*      */     
/*      */     private LinkedList<Integer> nextroundaddbuffids;
/*      */     
/*      */     private HashSet<SkillCausingDeathHandle> handleonskillcausingdeath;
/*      */     
/*      */     private HashSet<ChildEnterFightHandle> handleonchildenterfighthandle;
/*      */     
/*      */     private xbean.SkillResult skillresult;
/*      */     
/*      */     private ArrayList<Integer> deadrounds;
/*      */     
/*      */     private xbean.FighterModelCard changemodelcard;
/*      */     
/*      */     private HashMap<Integer, FighterHealthInfo> healthatroundstart;
/*      */     
/*      */     private HashSet<BeforeSealHandle> handleonbeforeseal;
/*      */     
/*      */     private HashMap<Integer, xbean.FightState> fightstates;
/*      */     
/*      */     private xbean.FightState defaultfightstate;
/*      */     
/*      */     private HashMap<Integer, Targets> effecttargets;
/*      */     
/*      */     private xbean.FighterOutFightInfo outfightinfo;
/*      */     
/*      */     private HashSet<EscapeHandle> handleonescape;
/*      */     
/*      */     private HashSet<OtherBeKilledAfterHandle> handleonotherbekilledafter;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 2544 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 2549 */       this.hp = 0;
/* 2550 */       this.mp = 0;
/* 2551 */       this.anger = 0.0F;
/* 2552 */       this.attrs = new HashMap();
/* 2553 */       this.ex_attrs = new HashMap();
/* 2554 */       this.ai = null;
/* 2555 */       this.extra = new HashMap();
/* 2556 */       this.skills = new HashMap();
/* 2557 */       this.skilldatas = new HashMap();
/* 2558 */       this.state = 0;
/* 2559 */       this.buff_states = new HashMap();
/* 2560 */       this.buffs = new HashMap();
/* 2561 */       this.originalmodelid = null;
/* 2562 */       this.protecterids = new ArrayList();
/* 2563 */       this.changemodelids = new ArrayList();
/* 2564 */       this.targetstatusbuffs = new HashMap();
/* 2565 */       this.handleonroundstart = new HashSet();
/* 2566 */       this.handleonroundend = new HashSet();
/* 2567 */       this.handleondamage = new HashSet();
/* 2568 */       this.handleonbedamage = new HashSet();
/* 2569 */       this.handleonbekilled = new HashSet();
/* 2570 */       this.handleonkillother = new HashSet();
/* 2571 */       this.handleonrebirth = new HashSet();
/* 2572 */       this.handleonbeforeattack = new HashSet();
/* 2573 */       this.handleonafterattack = new HashSet();
/* 2574 */       this.handleonskillcost = new HashSet();
/* 2575 */       this.handleonaddbuff = new HashSet();
/* 2576 */       this.handleonsealed = new HashSet();
/* 2577 */       this.handleoncounter = new HashSet();
/* 2578 */       this.handleonprotect = new HashSet();
/* 2579 */       this.handleontaunt = new HashSet();
/* 2580 */       this.handleonrebound = new HashSet();
/* 2581 */       this.handleonenterfight = new HashSet();
/* 2582 */       this.handleonfighterdead = new HashSet();
/* 2583 */       this.handleonbeforeuseskill = new HashSet();
/* 2584 */       this.handleonaftuseskill = new HashSet();
/* 2585 */       this.handleonbeforeheal = new HashSet();
/* 2586 */       this.handleontargetnumhandle = new HashSet();
/* 2587 */       this.handleonbeforepoisonhandle = new HashSet();
/* 2588 */       this.handleonpetenterfighthandle = new HashSet();
/* 2589 */       this.handleonaddangerhandle = new HashSet();
/* 2590 */       this.handleondrughandle = new HashSet();
/* 2591 */       this.handleonlosehphandle = new HashSet();
/* 2592 */       this.handleonaftsummonhandle = new HashSet();
/* 2593 */       this.fightermounts = new FighterMounts.Data();
/* 2594 */       this.nextroundaddbuffids = new LinkedList();
/* 2595 */       this.handleonskillcausingdeath = new HashSet();
/* 2596 */       this.handleonchildenterfighthandle = new HashSet();
/* 2597 */       this.skillresult = new SkillResult.Data();
/* 2598 */       this.deadrounds = new ArrayList();
/* 2599 */       this.changemodelcard = new FighterModelCard.Data();
/* 2600 */       this.healthatroundstart = new HashMap();
/* 2601 */       this.handleonbeforeseal = new HashSet();
/* 2602 */       this.fightstates = new HashMap();
/* 2603 */       this.defaultfightstate = new FightState.Data();
/* 2604 */       this.effecttargets = new HashMap();
/* 2605 */       this.outfightinfo = new FighterOutFightInfo.Data();
/* 2606 */       this.handleonescape = new HashSet();
/* 2607 */       this.handleonotherbekilledafter = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.Fighter _o1_)
/*      */     {
/* 2612 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2618 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2624 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 2630 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2636 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2642 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Fighter copy()
/*      */     {
/* 2648 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Fighter toData()
/*      */     {
/* 2654 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Fighter toBean()
/*      */     {
/* 2659 */       return new Fighter(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Fighter toDataIf()
/*      */     {
/* 2665 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Fighter toBeanIf()
/*      */     {
/* 2670 */       return new Fighter(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2676 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 2680 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 2684 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 2688 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 2692 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 2696 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 2700 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getType()
/*      */     {
/* 2707 */       return this.type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFighterid()
/*      */     {
/* 2714 */       return this.fighterid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPos()
/*      */     {
/* 2721 */       return this.pos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHp()
/*      */     {
/* 2728 */       return this.hp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMp()
/*      */     {
/* 2735 */       return this.mp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getAnger()
/*      */     {
/* 2742 */       return this.anger;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAttrs()
/*      */     {
/* 2749 */       return this.attrs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAttrsAsData()
/*      */     {
/* 2756 */       return this.attrs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getEx_attrs()
/*      */     {
/* 2763 */       return this.ex_attrs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getEx_attrsAsData()
/*      */     {
/* 2770 */       return this.ex_attrs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public AI getAi()
/*      */     {
/* 2777 */       return this.ai;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtra()
/*      */     {
/* 2784 */       return this.extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtraAsData()
/*      */     {
/* 2791 */       return this.extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkills()
/*      */     {
/* 2798 */       return this.skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillsAsData()
/*      */     {
/* 2805 */       return this.skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, SkillData> getSkilldatas()
/*      */     {
/* 2812 */       return this.skilldatas;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, SkillData> getSkilldatasAsData()
/*      */     {
/* 2819 */       return this.skilldatas;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 2826 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBuff_states()
/*      */     {
/* 2833 */       return this.buff_states;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBuff_statesAsData()
/*      */     {
/* 2840 */       return this.buff_states;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, FighterBuffs> getBuffs()
/*      */     {
/* 2847 */       return this.buffs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public MapModelInfo getOriginalmodelid()
/*      */     {
/* 2854 */       return this.originalmodelid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getProtecterids()
/*      */     {
/* 2861 */       return this.protecterids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getProtecteridsAsData()
/*      */     {
/* 2868 */       return this.protecterids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getChangemodelids()
/*      */     {
/* 2875 */       return this.changemodelids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getChangemodelidsAsData()
/*      */     {
/* 2882 */       return this.changemodelids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Targets> getTargetstatusbuffs()
/*      */     {
/* 2889 */       return this.targetstatusbuffs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Targets> getTargetstatusbuffsAsData()
/*      */     {
/* 2896 */       return this.targetstatusbuffs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<RoundStartHandle> getHandleonroundstart()
/*      */     {
/* 2903 */       return this.handleonroundstart;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<RoundEndHandle> getHandleonroundend()
/*      */     {
/* 2910 */       return this.handleonroundend;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<DamageHandle> getHandleondamage()
/*      */     {
/* 2917 */       return this.handleondamage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeDamageHandle> getHandleonbedamage()
/*      */     {
/* 2924 */       return this.handleonbedamage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeKilledHandle> getHandleonbekilled()
/*      */     {
/* 2931 */       return this.handleonbekilled;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<KillOtherHandle> getHandleonkillother()
/*      */     {
/* 2938 */       return this.handleonkillother;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<RebirthHandle> getHandleonrebirth()
/*      */     {
/* 2945 */       return this.handleonrebirth;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeforeAttackHandle> getHandleonbeforeattack()
/*      */     {
/* 2952 */       return this.handleonbeforeattack;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<AfterAttackHandle> getHandleonafterattack()
/*      */     {
/* 2959 */       return this.handleonafterattack;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<SkillCostHandle> getHandleonskillcost()
/*      */     {
/* 2966 */       return this.handleonskillcost;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<AddBuffHandle> getHandleonaddbuff()
/*      */     {
/* 2973 */       return this.handleonaddbuff;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<SealedHandle> getHandleonsealed()
/*      */     {
/* 2980 */       return this.handleonsealed;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<CounterHandle> getHandleoncounter()
/*      */     {
/* 2987 */       return this.handleoncounter;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<ProtectHandle> getHandleonprotect()
/*      */     {
/* 2994 */       return this.handleonprotect;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<TauntHandle> getHandleontaunt()
/*      */     {
/* 3001 */       return this.handleontaunt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<ReboundHandle> getHandleonrebound()
/*      */     {
/* 3008 */       return this.handleonrebound;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<EnterFightHandle> getHandleonenterfight()
/*      */     {
/* 3015 */       return this.handleonenterfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<FighterDeadHandle> getHandleonfighterdead()
/*      */     {
/* 3022 */       return this.handleonfighterdead;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeforeUseSkilHandle> getHandleonbeforeuseskill()
/*      */     {
/* 3029 */       return this.handleonbeforeuseskill;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<AftUseSkilHandle> getHandleonaftuseskill()
/*      */     {
/* 3036 */       return this.handleonaftuseskill;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeforeHealHandle> getHandleonbeforeheal()
/*      */     {
/* 3043 */       return this.handleonbeforeheal;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<TargetNumHandle> getHandleontargetnumhandle()
/*      */     {
/* 3050 */       return this.handleontargetnumhandle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeforePoisonHandle> getHandleonbeforepoisonhandle()
/*      */     {
/* 3057 */       return this.handleonbeforepoisonhandle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<PetEnterFightHandle> getHandleonpetenterfighthandle()
/*      */     {
/* 3064 */       return this.handleonpetenterfighthandle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<AddAngerHandle> getHandleonaddangerhandle()
/*      */     {
/* 3071 */       return this.handleonaddangerhandle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<DrugHandle> getHandleondrughandle()
/*      */     {
/* 3078 */       return this.handleondrughandle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<LoseHpHandle> getHandleonlosehphandle()
/*      */     {
/* 3085 */       return this.handleonlosehphandle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<AfterSummonHandle> getHandleonaftsummonhandle()
/*      */     {
/* 3092 */       return this.handleonaftsummonhandle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FighterMounts getFightermounts()
/*      */     {
/* 3099 */       return this.fightermounts;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getNextroundaddbuffids()
/*      */     {
/* 3106 */       return this.nextroundaddbuffids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<SkillCausingDeathHandle> getHandleonskillcausingdeath()
/*      */     {
/* 3113 */       return this.handleonskillcausingdeath;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<ChildEnterFightHandle> getHandleonchildenterfighthandle()
/*      */     {
/* 3120 */       return this.handleonchildenterfighthandle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.SkillResult getSkillresult()
/*      */     {
/* 3127 */       return this.skillresult;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getDeadrounds()
/*      */     {
/* 3134 */       return this.deadrounds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getDeadroundsAsData()
/*      */     {
/* 3141 */       return this.deadrounds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FighterModelCard getChangemodelcard()
/*      */     {
/* 3148 */       return this.changemodelcard;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, FighterHealthInfo> getHealthatroundstart()
/*      */     {
/* 3155 */       return this.healthatroundstart;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, FighterHealthInfo> getHealthatroundstartAsData()
/*      */     {
/* 3162 */       return this.healthatroundstart;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<BeforeSealHandle> getHandleonbeforeseal()
/*      */     {
/* 3169 */       return this.handleonbeforeseal;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FightState> getFightstates()
/*      */     {
/* 3176 */       return this.fightstates;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FightState> getFightstatesAsData()
/*      */     {
/* 3183 */       return this.fightstates;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FightState getDefaultfightstate()
/*      */     {
/* 3190 */       return this.defaultfightstate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Targets> getEffecttargets()
/*      */     {
/* 3197 */       return this.effecttargets;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Targets> getEffecttargetsAsData()
/*      */     {
/* 3204 */       return this.effecttargets;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FighterOutFightInfo getOutfightinfo()
/*      */     {
/* 3211 */       return this.outfightinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<EscapeHandle> getHandleonescape()
/*      */     {
/* 3218 */       return this.handleonescape;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<OtherBeKilledAfterHandle> getHandleonotherbekilledafter()
/*      */     {
/* 3225 */       return this.handleonotherbekilledafter;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setType(int _v_)
/*      */     {
/* 3232 */       this.type = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFighterid(int _v_)
/*      */     {
/* 3239 */       this.fighterid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPos(int _v_)
/*      */     {
/* 3246 */       this.pos = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHp(int _v_)
/*      */     {
/* 3253 */       this.hp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMp(int _v_)
/*      */     {
/* 3260 */       this.mp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnger(float _v_)
/*      */     {
/* 3267 */       this.anger = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAi(AI _v_)
/*      */     {
/* 3274 */       this.ai = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 3281 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOriginalmodelid(MapModelInfo _v_)
/*      */     {
/* 3288 */       this.originalmodelid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 3294 */       if (!(_o1_ instanceof Data)) return false;
/* 3295 */       Data _o_ = (Data)_o1_;
/* 3296 */       if (this.type != _o_.type) return false;
/* 3297 */       if (this.fighterid != _o_.fighterid) return false;
/* 3298 */       if (this.pos != _o_.pos) return false;
/* 3299 */       if (this.hp != _o_.hp) return false;
/* 3300 */       if (this.mp != _o_.mp) return false;
/* 3301 */       if (this.anger != _o_.anger) return false;
/* 3302 */       if (!this.attrs.equals(_o_.attrs)) return false;
/* 3303 */       if (!this.ex_attrs.equals(_o_.ex_attrs)) return false;
/* 3304 */       if (((null == this.ai) && (null != _o_.ai)) || ((null != this.ai) && (null == _o_.ai)) || ((null != this.ai) && (null != _o_.ai) && (!this.ai.equals(_o_.ai)))) return false;
/* 3305 */       if (!this.extra.equals(_o_.extra)) return false;
/* 3306 */       if (!this.skills.equals(_o_.skills)) return false;
/* 3307 */       if (!this.skilldatas.equals(_o_.skilldatas)) return false;
/* 3308 */       if (this.state != _o_.state) return false;
/* 3309 */       if (!this.buff_states.equals(_o_.buff_states)) return false;
/* 3310 */       if (!this.buffs.equals(_o_.buffs)) return false;
/* 3311 */       if (((null == this.originalmodelid) && (null != _o_.originalmodelid)) || ((null != this.originalmodelid) && (null == _o_.originalmodelid)) || ((null != this.originalmodelid) && (null != _o_.originalmodelid) && (!this.originalmodelid.equals(_o_.originalmodelid)))) return false;
/* 3312 */       if (!this.protecterids.equals(_o_.protecterids)) return false;
/* 3313 */       if (!this.changemodelids.equals(_o_.changemodelids)) return false;
/* 3314 */       if (!this.targetstatusbuffs.equals(_o_.targetstatusbuffs)) return false;
/* 3315 */       if (!this.handleonroundstart.equals(_o_.handleonroundstart)) return false;
/* 3316 */       if (!this.handleonroundend.equals(_o_.handleonroundend)) return false;
/* 3317 */       if (!this.handleondamage.equals(_o_.handleondamage)) return false;
/* 3318 */       if (!this.handleonbedamage.equals(_o_.handleonbedamage)) return false;
/* 3319 */       if (!this.handleonbekilled.equals(_o_.handleonbekilled)) return false;
/* 3320 */       if (!this.handleonkillother.equals(_o_.handleonkillother)) return false;
/* 3321 */       if (!this.handleonrebirth.equals(_o_.handleonrebirth)) return false;
/* 3322 */       if (!this.handleonbeforeattack.equals(_o_.handleonbeforeattack)) return false;
/* 3323 */       if (!this.handleonafterattack.equals(_o_.handleonafterattack)) return false;
/* 3324 */       if (!this.handleonskillcost.equals(_o_.handleonskillcost)) return false;
/* 3325 */       if (!this.handleonaddbuff.equals(_o_.handleonaddbuff)) return false;
/* 3326 */       if (!this.handleonsealed.equals(_o_.handleonsealed)) return false;
/* 3327 */       if (!this.handleoncounter.equals(_o_.handleoncounter)) return false;
/* 3328 */       if (!this.handleonprotect.equals(_o_.handleonprotect)) return false;
/* 3329 */       if (!this.handleontaunt.equals(_o_.handleontaunt)) return false;
/* 3330 */       if (!this.handleonrebound.equals(_o_.handleonrebound)) return false;
/* 3331 */       if (!this.handleonenterfight.equals(_o_.handleonenterfight)) return false;
/* 3332 */       if (!this.handleonfighterdead.equals(_o_.handleonfighterdead)) return false;
/* 3333 */       if (!this.handleonbeforeuseskill.equals(_o_.handleonbeforeuseskill)) return false;
/* 3334 */       if (!this.handleonaftuseskill.equals(_o_.handleonaftuseskill)) return false;
/* 3335 */       if (!this.handleonbeforeheal.equals(_o_.handleonbeforeheal)) return false;
/* 3336 */       if (!this.handleontargetnumhandle.equals(_o_.handleontargetnumhandle)) return false;
/* 3337 */       if (!this.handleonbeforepoisonhandle.equals(_o_.handleonbeforepoisonhandle)) return false;
/* 3338 */       if (!this.handleonpetenterfighthandle.equals(_o_.handleonpetenterfighthandle)) return false;
/* 3339 */       if (!this.handleonaddangerhandle.equals(_o_.handleonaddangerhandle)) return false;
/* 3340 */       if (!this.handleondrughandle.equals(_o_.handleondrughandle)) return false;
/* 3341 */       if (!this.handleonlosehphandle.equals(_o_.handleonlosehphandle)) return false;
/* 3342 */       if (!this.handleonaftsummonhandle.equals(_o_.handleonaftsummonhandle)) return false;
/* 3343 */       if (!this.fightermounts.equals(_o_.fightermounts)) return false;
/* 3344 */       if (!this.nextroundaddbuffids.equals(_o_.nextroundaddbuffids)) return false;
/* 3345 */       if (!this.handleonskillcausingdeath.equals(_o_.handleonskillcausingdeath)) return false;
/* 3346 */       if (!this.handleonchildenterfighthandle.equals(_o_.handleonchildenterfighthandle)) return false;
/* 3347 */       if (!this.skillresult.equals(_o_.skillresult)) return false;
/* 3348 */       if (!this.deadrounds.equals(_o_.deadrounds)) return false;
/* 3349 */       if (!this.changemodelcard.equals(_o_.changemodelcard)) return false;
/* 3350 */       if (!this.healthatroundstart.equals(_o_.healthatroundstart)) return false;
/* 3351 */       if (!this.handleonbeforeseal.equals(_o_.handleonbeforeseal)) return false;
/* 3352 */       if (!this.fightstates.equals(_o_.fightstates)) return false;
/* 3353 */       if (!this.defaultfightstate.equals(_o_.defaultfightstate)) return false;
/* 3354 */       if (!this.effecttargets.equals(_o_.effecttargets)) return false;
/* 3355 */       if (!this.outfightinfo.equals(_o_.outfightinfo)) return false;
/* 3356 */       if (!this.handleonescape.equals(_o_.handleonescape)) return false;
/* 3357 */       if (!this.handleonotherbekilledafter.equals(_o_.handleonotherbekilledafter)) return false;
/* 3358 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 3364 */       int _h_ = 0;
/* 3365 */       _h_ += this.type;
/* 3366 */       _h_ += this.fighterid;
/* 3367 */       _h_ += this.pos;
/* 3368 */       _h_ += this.hp;
/* 3369 */       _h_ += this.mp;
/* 3370 */       _h_ = (int)(_h_ + this.anger);
/* 3371 */       _h_ += this.attrs.hashCode();
/* 3372 */       _h_ += this.ex_attrs.hashCode();
/* 3373 */       _h_ += (this.ai == null ? 0 : this.ai.hashCode());
/* 3374 */       _h_ += this.extra.hashCode();
/* 3375 */       _h_ += this.skills.hashCode();
/* 3376 */       _h_ += this.skilldatas.hashCode();
/* 3377 */       _h_ += this.state;
/* 3378 */       _h_ += this.buff_states.hashCode();
/* 3379 */       _h_ += this.buffs.hashCode();
/* 3380 */       _h_ += (this.originalmodelid == null ? 0 : this.originalmodelid.hashCode());
/* 3381 */       _h_ += this.protecterids.hashCode();
/* 3382 */       _h_ += this.changemodelids.hashCode();
/* 3383 */       _h_ += this.targetstatusbuffs.hashCode();
/* 3384 */       _h_ += this.handleonroundstart.hashCode();
/* 3385 */       _h_ += this.handleonroundend.hashCode();
/* 3386 */       _h_ += this.handleondamage.hashCode();
/* 3387 */       _h_ += this.handleonbedamage.hashCode();
/* 3388 */       _h_ += this.handleonbekilled.hashCode();
/* 3389 */       _h_ += this.handleonkillother.hashCode();
/* 3390 */       _h_ += this.handleonrebirth.hashCode();
/* 3391 */       _h_ += this.handleonbeforeattack.hashCode();
/* 3392 */       _h_ += this.handleonafterattack.hashCode();
/* 3393 */       _h_ += this.handleonskillcost.hashCode();
/* 3394 */       _h_ += this.handleonaddbuff.hashCode();
/* 3395 */       _h_ += this.handleonsealed.hashCode();
/* 3396 */       _h_ += this.handleoncounter.hashCode();
/* 3397 */       _h_ += this.handleonprotect.hashCode();
/* 3398 */       _h_ += this.handleontaunt.hashCode();
/* 3399 */       _h_ += this.handleonrebound.hashCode();
/* 3400 */       _h_ += this.handleonenterfight.hashCode();
/* 3401 */       _h_ += this.handleonfighterdead.hashCode();
/* 3402 */       _h_ += this.handleonbeforeuseskill.hashCode();
/* 3403 */       _h_ += this.handleonaftuseskill.hashCode();
/* 3404 */       _h_ += this.handleonbeforeheal.hashCode();
/* 3405 */       _h_ += this.handleontargetnumhandle.hashCode();
/* 3406 */       _h_ += this.handleonbeforepoisonhandle.hashCode();
/* 3407 */       _h_ += this.handleonpetenterfighthandle.hashCode();
/* 3408 */       _h_ += this.handleonaddangerhandle.hashCode();
/* 3409 */       _h_ += this.handleondrughandle.hashCode();
/* 3410 */       _h_ += this.handleonlosehphandle.hashCode();
/* 3411 */       _h_ += this.handleonaftsummonhandle.hashCode();
/* 3412 */       _h_ += this.fightermounts.hashCode();
/* 3413 */       _h_ += this.nextroundaddbuffids.hashCode();
/* 3414 */       _h_ += this.handleonskillcausingdeath.hashCode();
/* 3415 */       _h_ += this.handleonchildenterfighthandle.hashCode();
/* 3416 */       _h_ += this.skillresult.hashCode();
/* 3417 */       _h_ += this.deadrounds.hashCode();
/* 3418 */       _h_ += this.changemodelcard.hashCode();
/* 3419 */       _h_ += this.healthatroundstart.hashCode();
/* 3420 */       _h_ += this.handleonbeforeseal.hashCode();
/* 3421 */       _h_ += this.fightstates.hashCode();
/* 3422 */       _h_ += this.defaultfightstate.hashCode();
/* 3423 */       _h_ += this.effecttargets.hashCode();
/* 3424 */       _h_ += this.outfightinfo.hashCode();
/* 3425 */       _h_ += this.handleonescape.hashCode();
/* 3426 */       _h_ += this.handleonotherbekilledafter.hashCode();
/* 3427 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 3433 */       StringBuilder _sb_ = new StringBuilder();
/* 3434 */       _sb_.append("(");
/* 3435 */       _sb_.append(this.type);
/* 3436 */       _sb_.append(",");
/* 3437 */       _sb_.append(this.fighterid);
/* 3438 */       _sb_.append(",");
/* 3439 */       _sb_.append(this.pos);
/* 3440 */       _sb_.append(",");
/* 3441 */       _sb_.append(this.hp);
/* 3442 */       _sb_.append(",");
/* 3443 */       _sb_.append(this.mp);
/* 3444 */       _sb_.append(",");
/* 3445 */       _sb_.append(this.anger);
/* 3446 */       _sb_.append(",");
/* 3447 */       _sb_.append(this.attrs);
/* 3448 */       _sb_.append(",");
/* 3449 */       _sb_.append(this.ex_attrs);
/* 3450 */       _sb_.append(",");
/* 3451 */       _sb_.append(this.ai);
/* 3452 */       _sb_.append(",");
/* 3453 */       _sb_.append(this.extra);
/* 3454 */       _sb_.append(",");
/* 3455 */       _sb_.append(this.skills);
/* 3456 */       _sb_.append(",");
/* 3457 */       _sb_.append(this.skilldatas);
/* 3458 */       _sb_.append(",");
/* 3459 */       _sb_.append(this.state);
/* 3460 */       _sb_.append(",");
/* 3461 */       _sb_.append(this.buff_states);
/* 3462 */       _sb_.append(",");
/* 3463 */       _sb_.append(this.buffs);
/* 3464 */       _sb_.append(",");
/* 3465 */       _sb_.append(this.originalmodelid);
/* 3466 */       _sb_.append(",");
/* 3467 */       _sb_.append(this.protecterids);
/* 3468 */       _sb_.append(",");
/* 3469 */       _sb_.append(this.changemodelids);
/* 3470 */       _sb_.append(",");
/* 3471 */       _sb_.append(this.targetstatusbuffs);
/* 3472 */       _sb_.append(",");
/* 3473 */       _sb_.append(this.handleonroundstart);
/* 3474 */       _sb_.append(",");
/* 3475 */       _sb_.append(this.handleonroundend);
/* 3476 */       _sb_.append(",");
/* 3477 */       _sb_.append(this.handleondamage);
/* 3478 */       _sb_.append(",");
/* 3479 */       _sb_.append(this.handleonbedamage);
/* 3480 */       _sb_.append(",");
/* 3481 */       _sb_.append(this.handleonbekilled);
/* 3482 */       _sb_.append(",");
/* 3483 */       _sb_.append(this.handleonkillother);
/* 3484 */       _sb_.append(",");
/* 3485 */       _sb_.append(this.handleonrebirth);
/* 3486 */       _sb_.append(",");
/* 3487 */       _sb_.append(this.handleonbeforeattack);
/* 3488 */       _sb_.append(",");
/* 3489 */       _sb_.append(this.handleonafterattack);
/* 3490 */       _sb_.append(",");
/* 3491 */       _sb_.append(this.handleonskillcost);
/* 3492 */       _sb_.append(",");
/* 3493 */       _sb_.append(this.handleonaddbuff);
/* 3494 */       _sb_.append(",");
/* 3495 */       _sb_.append(this.handleonsealed);
/* 3496 */       _sb_.append(",");
/* 3497 */       _sb_.append(this.handleoncounter);
/* 3498 */       _sb_.append(",");
/* 3499 */       _sb_.append(this.handleonprotect);
/* 3500 */       _sb_.append(",");
/* 3501 */       _sb_.append(this.handleontaunt);
/* 3502 */       _sb_.append(",");
/* 3503 */       _sb_.append(this.handleonrebound);
/* 3504 */       _sb_.append(",");
/* 3505 */       _sb_.append(this.handleonenterfight);
/* 3506 */       _sb_.append(",");
/* 3507 */       _sb_.append(this.handleonfighterdead);
/* 3508 */       _sb_.append(",");
/* 3509 */       _sb_.append(this.handleonbeforeuseskill);
/* 3510 */       _sb_.append(",");
/* 3511 */       _sb_.append(this.handleonaftuseskill);
/* 3512 */       _sb_.append(",");
/* 3513 */       _sb_.append(this.handleonbeforeheal);
/* 3514 */       _sb_.append(",");
/* 3515 */       _sb_.append(this.handleontargetnumhandle);
/* 3516 */       _sb_.append(",");
/* 3517 */       _sb_.append(this.handleonbeforepoisonhandle);
/* 3518 */       _sb_.append(",");
/* 3519 */       _sb_.append(this.handleonpetenterfighthandle);
/* 3520 */       _sb_.append(",");
/* 3521 */       _sb_.append(this.handleonaddangerhandle);
/* 3522 */       _sb_.append(",");
/* 3523 */       _sb_.append(this.handleondrughandle);
/* 3524 */       _sb_.append(",");
/* 3525 */       _sb_.append(this.handleonlosehphandle);
/* 3526 */       _sb_.append(",");
/* 3527 */       _sb_.append(this.handleonaftsummonhandle);
/* 3528 */       _sb_.append(",");
/* 3529 */       _sb_.append(this.fightermounts);
/* 3530 */       _sb_.append(",");
/* 3531 */       _sb_.append(this.nextroundaddbuffids);
/* 3532 */       _sb_.append(",");
/* 3533 */       _sb_.append(this.handleonskillcausingdeath);
/* 3534 */       _sb_.append(",");
/* 3535 */       _sb_.append(this.handleonchildenterfighthandle);
/* 3536 */       _sb_.append(",");
/* 3537 */       _sb_.append(this.skillresult);
/* 3538 */       _sb_.append(",");
/* 3539 */       _sb_.append(this.deadrounds);
/* 3540 */       _sb_.append(",");
/* 3541 */       _sb_.append(this.changemodelcard);
/* 3542 */       _sb_.append(",");
/* 3543 */       _sb_.append(this.healthatroundstart);
/* 3544 */       _sb_.append(",");
/* 3545 */       _sb_.append(this.handleonbeforeseal);
/* 3546 */       _sb_.append(",");
/* 3547 */       _sb_.append(this.fightstates);
/* 3548 */       _sb_.append(",");
/* 3549 */       _sb_.append(this.defaultfightstate);
/* 3550 */       _sb_.append(",");
/* 3551 */       _sb_.append(this.effecttargets);
/* 3552 */       _sb_.append(",");
/* 3553 */       _sb_.append(this.outfightinfo);
/* 3554 */       _sb_.append(",");
/* 3555 */       _sb_.append(this.handleonescape);
/* 3556 */       _sb_.append(",");
/* 3557 */       _sb_.append(this.handleonotherbekilledafter);
/* 3558 */       _sb_.append(")");
/* 3559 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Fighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
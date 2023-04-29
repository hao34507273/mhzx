/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.fight.main.FightContext;
/*      */ import mzm.gsp.fight.main.FightParam;
/*      */ import mzm.gsp.fight.main.FightRecorder;
/*      */ import mzm.gsp.fight.main.FightTimer;
/*      */ import mzm.gsp.fight.main.SkillResultHandle;
/*      */ import mzm.gsp.fight.main.UpdateTimer;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xbean.FightCmd;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableSet;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class Fight extends XBean implements xbean.Fight
/*      */ {
/*      */   private FightContext context;
/*      */   private int type;
/*      */   private int cfgtype;
/*      */   private int fightreason;
/*      */   private int round;
/*      */   private long starttime;
/*      */   private int nextid;
/*      */   private xbean.FightTeam active;
/*      */   private xbean.FightTeam passive;
/*      */   private SetX<Long> curroundendroles;
/*      */   private boolean iscurroundend;
/*      */   private int flow;
/*      */   private ArrayList<FightCmd> cmds;
/*      */   private HashMap<Integer, Integer> extra;
/*      */   private LinkedHashMap<Long, Integer> observers;
/*      */   private FightTimer timer;
/*      */   private UpdateTimer updatetimer;
/*      */   private long nexttimermillsec;
/*      */   private int actiontotalcount;
/*      */   private int actionroundmaxcount;
/*      */   private int actioncountcurround;
/*      */   private FightParam fightparams;
/*      */   private FightRecorder fight_recorder;
/*      */   private SetX<SkillResultHandle> skillresulthandles;
/*      */   private boolean genresultatonce;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   66 */     this.context = null;
/*   67 */     this.type = 0;
/*   68 */     this.cfgtype = 0;
/*   69 */     this.fightreason = 0;
/*   70 */     this.round = 0;
/*   71 */     this.starttime = 0L;
/*   72 */     this.nextid = 0;
/*   73 */     this.active._reset_unsafe_();
/*   74 */     this.passive._reset_unsafe_();
/*   75 */     this.curroundendroles.clear();
/*   76 */     this.iscurroundend = false;
/*   77 */     this.flow = 0;
/*   78 */     this.cmds.clear();
/*   79 */     this.extra.clear();
/*   80 */     this.observers = null;
/*   81 */     this.timer = null;
/*   82 */     this.updatetimer = null;
/*   83 */     this.nexttimermillsec = 0L;
/*   84 */     this.actiontotalcount = 0;
/*   85 */     this.actionroundmaxcount = 0;
/*   86 */     this.actioncountcurround = 0;
/*   87 */     this.fightparams = null;
/*   88 */     this.fight_recorder = null;
/*   89 */     this.skillresulthandles.clear();
/*   90 */     this.genresultatonce = false;
/*      */   }
/*      */   
/*      */   Fight(int __, XBean _xp_, String _vn_)
/*      */   {
/*   95 */     super(_xp_, _vn_);
/*   96 */     this.context = null;
/*   97 */     this.round = 0;
/*   98 */     this.starttime = 0L;
/*   99 */     this.nextid = 0;
/*  100 */     this.active = new FightTeam(0, this, "active");
/*  101 */     this.passive = new FightTeam(0, this, "passive");
/*  102 */     this.curroundendroles = new SetX();
/*  103 */     this.flow = 0;
/*  104 */     this.cmds = new ArrayList();
/*  105 */     this.extra = new HashMap();
/*  106 */     this.observers = null;
/*  107 */     this.timer = null;
/*  108 */     this.updatetimer = null;
/*  109 */     this.fightparams = null;
/*  110 */     this.fight_recorder = null;
/*  111 */     this.skillresulthandles = new SetX();
/*  112 */     this.genresultatonce = false;
/*      */   }
/*      */   
/*      */   public Fight()
/*      */   {
/*  117 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Fight(Fight _o_)
/*      */   {
/*  122 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Fight(xbean.Fight _o1_, XBean _xp_, String _vn_)
/*      */   {
/*  127 */     super(_xp_, _vn_);
/*  128 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  134 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  140 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  146 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  152 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  158 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Fight copy()
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*  165 */     return new Fight(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Fight toData()
/*      */   {
/*  171 */     _xdb_verify_unsafe_();
/*  172 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Fight toBean()
/*      */   {
/*  177 */     _xdb_verify_unsafe_();
/*  178 */     return new Fight(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Fight toDataIf()
/*      */   {
/*  184 */     _xdb_verify_unsafe_();
/*  185 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Fight toBeanIf()
/*      */   {
/*  190 */     _xdb_verify_unsafe_();
/*  191 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  197 */     _xdb_verify_unsafe_();
/*  198 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public FightContext getContext()
/*      */   {
/*  205 */     _xdb_verify_unsafe_();
/*  206 */     return this.context;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getType()
/*      */   {
/*  213 */     _xdb_verify_unsafe_();
/*  214 */     return this.type;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCfgtype()
/*      */   {
/*  221 */     _xdb_verify_unsafe_();
/*  222 */     return this.cfgtype;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFightreason()
/*      */   {
/*  229 */     _xdb_verify_unsafe_();
/*  230 */     return this.fightreason;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRound()
/*      */   {
/*  237 */     _xdb_verify_unsafe_();
/*  238 */     return this.round;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStarttime()
/*      */   {
/*  245 */     _xdb_verify_unsafe_();
/*  246 */     return this.starttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNextid()
/*      */   {
/*  253 */     _xdb_verify_unsafe_();
/*  254 */     return this.nextid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.FightTeam getActive()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return this.active;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.FightTeam getPassive()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return this.passive;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getCurroundendroles()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return Logs.logSet(new LogKey(this, "curroundendroles"), this.curroundendroles);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getCurroundendrolesAsData()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*      */     
/*  286 */     Fight _o_ = this;
/*  287 */     Set<Long> curroundendroles = new SetX();
/*  288 */     curroundendroles.addAll(_o_.curroundendroles);
/*  289 */     return curroundendroles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIscurroundend()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return this.iscurroundend;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFlow()
/*      */   {
/*  304 */     _xdb_verify_unsafe_();
/*  305 */     return this.flow;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<FightCmd> getCmds()
/*      */   {
/*  312 */     _xdb_verify_unsafe_();
/*  313 */     return Logs.logList(new LogKey(this, "cmds"), this.cmds);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<FightCmd> getCmdsAsData()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*      */     
/*  321 */     Fight _o_ = this;
/*  322 */     List<FightCmd> cmds = new ArrayList();
/*  323 */     for (FightCmd _v_ : _o_.cmds)
/*  324 */       cmds.add(new FightCmd.Data(_v_));
/*  325 */     return cmds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getExtra()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return Logs.logMap(new LogKey(this, "extra"), this.extra);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getExtraAsData()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*      */     
/*  342 */     Fight _o_ = this;
/*  343 */     Map<Integer, Integer> extra = new HashMap();
/*  344 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/*  345 */       extra.put(_e_.getKey(), _e_.getValue());
/*  346 */     return extra;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public LinkedHashMap<Long, Integer> getObservers()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*  354 */     return this.observers;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public FightTimer getTimer()
/*      */   {
/*  361 */     _xdb_verify_unsafe_();
/*  362 */     return this.timer;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public UpdateTimer getUpdatetimer()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return this.updatetimer;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getNexttimermillsec()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return this.nexttimermillsec;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActiontotalcount()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     return this.actiontotalcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActionroundmaxcount()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     return this.actionroundmaxcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActioncountcurround()
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     return this.actioncountcurround;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public FightParam getFightparams()
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     return this.fightparams;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public FightRecorder getFight_recorder()
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     return this.fight_recorder;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<SkillResultHandle> getSkillresulthandles()
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*  426 */     return Logs.logSet(new LogKey(this, "skillresulthandles"), this.skillresulthandles);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getGenresultatonce()
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     return this.genresultatonce;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setContext(FightContext _v_)
/*      */   {
/*  441 */     _xdb_verify_unsafe_();
/*  442 */     Logs.logIf(new LogKey(this, "context")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  446 */         new LogObject(this, Fight.this.context)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  450 */             Fight.this.context = ((FightContext)this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  454 */     });
/*  455 */     this.context = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setType(int _v_)
/*      */   {
/*  462 */     _xdb_verify_unsafe_();
/*  463 */     Logs.logIf(new LogKey(this, "type")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  467 */         new LogInt(this, Fight.this.type)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  471 */             Fight.this.type = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  475 */     });
/*  476 */     this.type = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCfgtype(int _v_)
/*      */   {
/*  483 */     _xdb_verify_unsafe_();
/*  484 */     Logs.logIf(new LogKey(this, "cfgtype")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  488 */         new LogInt(this, Fight.this.cfgtype)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  492 */             Fight.this.cfgtype = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  496 */     });
/*  497 */     this.cfgtype = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFightreason(int _v_)
/*      */   {
/*  504 */     _xdb_verify_unsafe_();
/*  505 */     Logs.logIf(new LogKey(this, "fightreason")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  509 */         new LogInt(this, Fight.this.fightreason)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  513 */             Fight.this.fightreason = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  517 */     });
/*  518 */     this.fightreason = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRound(int _v_)
/*      */   {
/*  525 */     _xdb_verify_unsafe_();
/*  526 */     Logs.logIf(new LogKey(this, "round")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  530 */         new LogInt(this, Fight.this.round)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  534 */             Fight.this.round = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  538 */     });
/*  539 */     this.round = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStarttime(long _v_)
/*      */   {
/*  546 */     _xdb_verify_unsafe_();
/*  547 */     Logs.logIf(new LogKey(this, "starttime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  551 */         new LogLong(this, Fight.this.starttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  555 */             Fight.this.starttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  559 */     });
/*  560 */     this.starttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNextid(int _v_)
/*      */   {
/*  567 */     _xdb_verify_unsafe_();
/*  568 */     Logs.logIf(new LogKey(this, "nextid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  572 */         new LogInt(this, Fight.this.nextid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  576 */             Fight.this.nextid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  580 */     });
/*  581 */     this.nextid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIscurroundend(boolean _v_)
/*      */   {
/*  588 */     _xdb_verify_unsafe_();
/*  589 */     Logs.logIf(new LogKey(this, "iscurroundend")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  593 */         new LogObject(this, Boolean.valueOf(Fight.this.iscurroundend))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  597 */             Fight.this.iscurroundend = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  601 */     });
/*  602 */     this.iscurroundend = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFlow(int _v_)
/*      */   {
/*  609 */     _xdb_verify_unsafe_();
/*  610 */     Logs.logIf(new LogKey(this, "flow")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  614 */         new LogInt(this, Fight.this.flow)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  618 */             Fight.this.flow = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  622 */     });
/*  623 */     this.flow = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setObservers(LinkedHashMap<Long, Integer> _v_)
/*      */   {
/*  630 */     _xdb_verify_unsafe_();
/*  631 */     Logs.logIf(new LogKey(this, "observers")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  635 */         new LogObject(this, Fight.this.observers)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  639 */             Fight.this.observers = ((LinkedHashMap)this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  643 */     });
/*  644 */     this.observers = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTimer(FightTimer _v_)
/*      */   {
/*  651 */     _xdb_verify_unsafe_();
/*  652 */     Logs.logIf(new LogKey(this, "timer")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  656 */         new LogObject(this, Fight.this.timer)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  660 */             Fight.this.timer = ((FightTimer)this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  664 */     });
/*  665 */     this.timer = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUpdatetimer(UpdateTimer _v_)
/*      */   {
/*  672 */     _xdb_verify_unsafe_();
/*  673 */     Logs.logIf(new LogKey(this, "updatetimer")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  677 */         new LogObject(this, Fight.this.updatetimer)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  681 */             Fight.this.updatetimer = ((UpdateTimer)this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  685 */     });
/*  686 */     this.updatetimer = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNexttimermillsec(long _v_)
/*      */   {
/*  693 */     _xdb_verify_unsafe_();
/*  694 */     Logs.logIf(new LogKey(this, "nexttimermillsec")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  698 */         new LogLong(this, Fight.this.nexttimermillsec)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  702 */             Fight.this.nexttimermillsec = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  706 */     });
/*  707 */     this.nexttimermillsec = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActiontotalcount(int _v_)
/*      */   {
/*  714 */     _xdb_verify_unsafe_();
/*  715 */     Logs.logIf(new LogKey(this, "actiontotalcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  719 */         new LogInt(this, Fight.this.actiontotalcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  723 */             Fight.this.actiontotalcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  727 */     });
/*  728 */     this.actiontotalcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActionroundmaxcount(int _v_)
/*      */   {
/*  735 */     _xdb_verify_unsafe_();
/*  736 */     Logs.logIf(new LogKey(this, "actionroundmaxcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  740 */         new LogInt(this, Fight.this.actionroundmaxcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  744 */             Fight.this.actionroundmaxcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  748 */     });
/*  749 */     this.actionroundmaxcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActioncountcurround(int _v_)
/*      */   {
/*  756 */     _xdb_verify_unsafe_();
/*  757 */     Logs.logIf(new LogKey(this, "actioncountcurround")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  761 */         new LogInt(this, Fight.this.actioncountcurround)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  765 */             Fight.this.actioncountcurround = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  769 */     });
/*  770 */     this.actioncountcurround = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFightparams(FightParam _v_)
/*      */   {
/*  777 */     _xdb_verify_unsafe_();
/*  778 */     Logs.logIf(new LogKey(this, "fightparams")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  782 */         new LogObject(this, Fight.this.fightparams)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  786 */             Fight.this.fightparams = ((FightParam)this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  790 */     });
/*  791 */     this.fightparams = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFight_recorder(FightRecorder _v_)
/*      */   {
/*  798 */     _xdb_verify_unsafe_();
/*  799 */     Logs.logIf(new LogKey(this, "fight_recorder")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  803 */         new LogObject(this, Fight.this.fight_recorder)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  807 */             Fight.this.fight_recorder = ((FightRecorder)this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  811 */     });
/*  812 */     this.fight_recorder = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGenresultatonce(boolean _v_)
/*      */   {
/*  819 */     _xdb_verify_unsafe_();
/*  820 */     Logs.logIf(new LogKey(this, "genresultatonce")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  824 */         new LogObject(this, Boolean.valueOf(Fight.this.genresultatonce))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  828 */             Fight.this.genresultatonce = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  832 */     });
/*  833 */     this.genresultatonce = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  839 */     _xdb_verify_unsafe_();
/*  840 */     Fight _o_ = null;
/*  841 */     if ((_o1_ instanceof Fight)) { _o_ = (Fight)_o1_;
/*  842 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  843 */       return false;
/*  844 */     if (((null == this.context) && (null != _o_.context)) || ((null != this.context) && (null == _o_.context)) || ((null != this.context) && (null != _o_.context) && (!this.context.equals(_o_.context)))) return false;
/*  845 */     if (this.type != _o_.type) return false;
/*  846 */     if (this.cfgtype != _o_.cfgtype) return false;
/*  847 */     if (this.fightreason != _o_.fightreason) return false;
/*  848 */     if (this.round != _o_.round) return false;
/*  849 */     if (this.starttime != _o_.starttime) return false;
/*  850 */     if (this.nextid != _o_.nextid) return false;
/*  851 */     if (!this.active.equals(_o_.active)) return false;
/*  852 */     if (!this.passive.equals(_o_.passive)) return false;
/*  853 */     if (!this.curroundendroles.equals(_o_.curroundendroles)) return false;
/*  854 */     if (this.iscurroundend != _o_.iscurroundend) return false;
/*  855 */     if (this.flow != _o_.flow) return false;
/*  856 */     if (!this.cmds.equals(_o_.cmds)) return false;
/*  857 */     if (!this.extra.equals(_o_.extra)) return false;
/*  858 */     if (((null == this.observers) && (null != _o_.observers)) || ((null != this.observers) && (null == _o_.observers)) || ((null != this.observers) && (null != _o_.observers) && (!this.observers.equals(_o_.observers)))) return false;
/*  859 */     if (((null == this.timer) && (null != _o_.timer)) || ((null != this.timer) && (null == _o_.timer)) || ((null != this.timer) && (null != _o_.timer) && (!this.timer.equals(_o_.timer)))) return false;
/*  860 */     if (((null == this.updatetimer) && (null != _o_.updatetimer)) || ((null != this.updatetimer) && (null == _o_.updatetimer)) || ((null != this.updatetimer) && (null != _o_.updatetimer) && (!this.updatetimer.equals(_o_.updatetimer)))) return false;
/*  861 */     if (this.nexttimermillsec != _o_.nexttimermillsec) return false;
/*  862 */     if (this.actiontotalcount != _o_.actiontotalcount) return false;
/*  863 */     if (this.actionroundmaxcount != _o_.actionroundmaxcount) return false;
/*  864 */     if (this.actioncountcurround != _o_.actioncountcurround) return false;
/*  865 */     if (((null == this.fightparams) && (null != _o_.fightparams)) || ((null != this.fightparams) && (null == _o_.fightparams)) || ((null != this.fightparams) && (null != _o_.fightparams) && (!this.fightparams.equals(_o_.fightparams)))) return false;
/*  866 */     if (((null == this.fight_recorder) && (null != _o_.fight_recorder)) || ((null != this.fight_recorder) && (null == _o_.fight_recorder)) || ((null != this.fight_recorder) && (null != _o_.fight_recorder) && (!this.fight_recorder.equals(_o_.fight_recorder)))) return false;
/*  867 */     if (!this.skillresulthandles.equals(_o_.skillresulthandles)) return false;
/*  868 */     if (this.genresultatonce != _o_.genresultatonce) return false;
/*  869 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  875 */     _xdb_verify_unsafe_();
/*  876 */     int _h_ = 0;
/*  877 */     _h_ += (this.context == null ? 0 : this.context.hashCode());
/*  878 */     _h_ += this.type;
/*  879 */     _h_ += this.cfgtype;
/*  880 */     _h_ += this.fightreason;
/*  881 */     _h_ += this.round;
/*  882 */     _h_ = (int)(_h_ + this.starttime);
/*  883 */     _h_ += this.nextid;
/*  884 */     _h_ += this.active.hashCode();
/*  885 */     _h_ += this.passive.hashCode();
/*  886 */     _h_ += this.curroundendroles.hashCode();
/*  887 */     _h_ += (this.iscurroundend ? 1231 : 1237);
/*  888 */     _h_ += this.flow;
/*  889 */     _h_ += this.cmds.hashCode();
/*  890 */     _h_ += this.extra.hashCode();
/*  891 */     _h_ += (this.observers == null ? 0 : this.observers.hashCode());
/*  892 */     _h_ += (this.timer == null ? 0 : this.timer.hashCode());
/*  893 */     _h_ += (this.updatetimer == null ? 0 : this.updatetimer.hashCode());
/*  894 */     _h_ = (int)(_h_ + this.nexttimermillsec);
/*  895 */     _h_ += this.actiontotalcount;
/*  896 */     _h_ += this.actionroundmaxcount;
/*  897 */     _h_ += this.actioncountcurround;
/*  898 */     _h_ += (this.fightparams == null ? 0 : this.fightparams.hashCode());
/*  899 */     _h_ += (this.fight_recorder == null ? 0 : this.fight_recorder.hashCode());
/*  900 */     _h_ += this.skillresulthandles.hashCode();
/*  901 */     _h_ += (this.genresultatonce ? 1231 : 1237);
/*  902 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  908 */     _xdb_verify_unsafe_();
/*  909 */     StringBuilder _sb_ = new StringBuilder();
/*  910 */     _sb_.append("(");
/*  911 */     _sb_.append(this.context);
/*  912 */     _sb_.append(",");
/*  913 */     _sb_.append(this.type);
/*  914 */     _sb_.append(",");
/*  915 */     _sb_.append(this.cfgtype);
/*  916 */     _sb_.append(",");
/*  917 */     _sb_.append(this.fightreason);
/*  918 */     _sb_.append(",");
/*  919 */     _sb_.append(this.round);
/*  920 */     _sb_.append(",");
/*  921 */     _sb_.append(this.starttime);
/*  922 */     _sb_.append(",");
/*  923 */     _sb_.append(this.nextid);
/*  924 */     _sb_.append(",");
/*  925 */     _sb_.append(this.active);
/*  926 */     _sb_.append(",");
/*  927 */     _sb_.append(this.passive);
/*  928 */     _sb_.append(",");
/*  929 */     _sb_.append(this.curroundendroles);
/*  930 */     _sb_.append(",");
/*  931 */     _sb_.append(this.iscurroundend);
/*  932 */     _sb_.append(",");
/*  933 */     _sb_.append(this.flow);
/*  934 */     _sb_.append(",");
/*  935 */     _sb_.append(this.cmds);
/*  936 */     _sb_.append(",");
/*  937 */     _sb_.append(this.extra);
/*  938 */     _sb_.append(",");
/*  939 */     _sb_.append(this.observers);
/*  940 */     _sb_.append(",");
/*  941 */     _sb_.append(this.timer);
/*  942 */     _sb_.append(",");
/*  943 */     _sb_.append(this.updatetimer);
/*  944 */     _sb_.append(",");
/*  945 */     _sb_.append(this.nexttimermillsec);
/*  946 */     _sb_.append(",");
/*  947 */     _sb_.append(this.actiontotalcount);
/*  948 */     _sb_.append(",");
/*  949 */     _sb_.append(this.actionroundmaxcount);
/*  950 */     _sb_.append(",");
/*  951 */     _sb_.append(this.actioncountcurround);
/*  952 */     _sb_.append(",");
/*  953 */     _sb_.append(this.fightparams);
/*  954 */     _sb_.append(",");
/*  955 */     _sb_.append(this.fight_recorder);
/*  956 */     _sb_.append(",");
/*  957 */     _sb_.append(this.skillresulthandles);
/*  958 */     _sb_.append(",");
/*  959 */     _sb_.append(this.genresultatonce);
/*  960 */     _sb_.append(")");
/*  961 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  967 */     ListenableBean lb = new ListenableBean();
/*  968 */     lb.add(new ListenableChanged().setVarName("context"));
/*  969 */     lb.add(new ListenableChanged().setVarName("type"));
/*  970 */     lb.add(new ListenableChanged().setVarName("cfgtype"));
/*  971 */     lb.add(new ListenableChanged().setVarName("fightreason"));
/*  972 */     lb.add(new ListenableChanged().setVarName("round"));
/*  973 */     lb.add(new ListenableChanged().setVarName("starttime"));
/*  974 */     lb.add(new ListenableChanged().setVarName("nextid"));
/*  975 */     lb.add(new ListenableChanged().setVarName("active"));
/*  976 */     lb.add(new ListenableChanged().setVarName("passive"));
/*  977 */     lb.add(new ListenableSet().setVarName("curroundendroles"));
/*  978 */     lb.add(new ListenableChanged().setVarName("iscurroundend"));
/*  979 */     lb.add(new ListenableChanged().setVarName("flow"));
/*  980 */     lb.add(new ListenableChanged().setVarName("cmds"));
/*  981 */     lb.add(new xdb.logs.ListenableMap().setVarName("extra"));
/*  982 */     lb.add(new ListenableChanged().setVarName("observers"));
/*  983 */     lb.add(new ListenableChanged().setVarName("timer"));
/*  984 */     lb.add(new ListenableChanged().setVarName("updatetimer"));
/*  985 */     lb.add(new ListenableChanged().setVarName("nexttimermillsec"));
/*  986 */     lb.add(new ListenableChanged().setVarName("actiontotalcount"));
/*  987 */     lb.add(new ListenableChanged().setVarName("actionroundmaxcount"));
/*  988 */     lb.add(new ListenableChanged().setVarName("actioncountcurround"));
/*  989 */     lb.add(new ListenableChanged().setVarName("fightparams"));
/*  990 */     lb.add(new ListenableChanged().setVarName("fight_recorder"));
/*  991 */     lb.add(new ListenableSet().setVarName("skillresulthandles"));
/*  992 */     lb.add(new ListenableChanged().setVarName("genresultatonce"));
/*  993 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Fight {
/*      */     private Const() {}
/*      */     
/*      */     Fight nThis() {
/* 1000 */       return Fight.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1006 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Fight copy()
/*      */     {
/* 1012 */       return Fight.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Fight toData()
/*      */     {
/* 1018 */       return Fight.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Fight toBean()
/*      */     {
/* 1023 */       return Fight.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Fight toDataIf()
/*      */     {
/* 1029 */       return Fight.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Fight toBeanIf()
/*      */     {
/* 1034 */       return Fight.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public FightContext getContext()
/*      */     {
/* 1041 */       Fight.this._xdb_verify_unsafe_();
/* 1042 */       return Fight.this.context;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getType()
/*      */     {
/* 1049 */       Fight.this._xdb_verify_unsafe_();
/* 1050 */       return Fight.this.type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCfgtype()
/*      */     {
/* 1057 */       Fight.this._xdb_verify_unsafe_();
/* 1058 */       return Fight.this.cfgtype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFightreason()
/*      */     {
/* 1065 */       Fight.this._xdb_verify_unsafe_();
/* 1066 */       return Fight.this.fightreason;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRound()
/*      */     {
/* 1073 */       Fight.this._xdb_verify_unsafe_();
/* 1074 */       return Fight.this.round;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/* 1081 */       Fight.this._xdb_verify_unsafe_();
/* 1082 */       return Fight.this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNextid()
/*      */     {
/* 1089 */       Fight.this._xdb_verify_unsafe_();
/* 1090 */       return Fight.this.nextid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FightTeam getActive()
/*      */     {
/* 1097 */       Fight.this._xdb_verify_unsafe_();
/* 1098 */       return (xbean.FightTeam)Consts.toConst(Fight.this.active);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FightTeam getPassive()
/*      */     {
/* 1105 */       Fight.this._xdb_verify_unsafe_();
/* 1106 */       return (xbean.FightTeam)Consts.toConst(Fight.this.passive);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCurroundendroles()
/*      */     {
/* 1113 */       Fight.this._xdb_verify_unsafe_();
/* 1114 */       return Consts.constSet(Fight.this.curroundendroles);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getCurroundendrolesAsData()
/*      */     {
/* 1120 */       Fight.this._xdb_verify_unsafe_();
/*      */       
/* 1122 */       Fight _o_ = Fight.this;
/* 1123 */       Set<Long> curroundendroles = new SetX();
/* 1124 */       curroundendroles.addAll(_o_.curroundendroles);
/* 1125 */       return curroundendroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIscurroundend()
/*      */     {
/* 1132 */       Fight.this._xdb_verify_unsafe_();
/* 1133 */       return Fight.this.iscurroundend;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFlow()
/*      */     {
/* 1140 */       Fight.this._xdb_verify_unsafe_();
/* 1141 */       return Fight.this.flow;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<FightCmd> getCmds()
/*      */     {
/* 1148 */       Fight.this._xdb_verify_unsafe_();
/* 1149 */       return Consts.constList(Fight.this.cmds);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<FightCmd> getCmdsAsData()
/*      */     {
/* 1155 */       Fight.this._xdb_verify_unsafe_();
/*      */       
/* 1157 */       Fight _o_ = Fight.this;
/* 1158 */       List<FightCmd> cmds = new ArrayList();
/* 1159 */       for (FightCmd _v_ : _o_.cmds)
/* 1160 */         cmds.add(new FightCmd.Data(_v_));
/* 1161 */       return cmds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtra()
/*      */     {
/* 1168 */       Fight.this._xdb_verify_unsafe_();
/* 1169 */       return Consts.constMap(Fight.this.extra);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtraAsData()
/*      */     {
/* 1176 */       Fight.this._xdb_verify_unsafe_();
/*      */       
/* 1178 */       Fight _o_ = Fight.this;
/* 1179 */       Map<Integer, Integer> extra = new HashMap();
/* 1180 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/* 1181 */         extra.put(_e_.getKey(), _e_.getValue());
/* 1182 */       return extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public LinkedHashMap<Long, Integer> getObservers()
/*      */     {
/* 1189 */       Fight.this._xdb_verify_unsafe_();
/* 1190 */       return Fight.this.observers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public FightTimer getTimer()
/*      */     {
/* 1197 */       Fight.this._xdb_verify_unsafe_();
/* 1198 */       return Fight.this.timer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public UpdateTimer getUpdatetimer()
/*      */     {
/* 1205 */       Fight.this._xdb_verify_unsafe_();
/* 1206 */       return Fight.this.updatetimer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNexttimermillsec()
/*      */     {
/* 1213 */       Fight.this._xdb_verify_unsafe_();
/* 1214 */       return Fight.this.nexttimermillsec;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActiontotalcount()
/*      */     {
/* 1221 */       Fight.this._xdb_verify_unsafe_();
/* 1222 */       return Fight.this.actiontotalcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActionroundmaxcount()
/*      */     {
/* 1229 */       Fight.this._xdb_verify_unsafe_();
/* 1230 */       return Fight.this.actionroundmaxcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActioncountcurround()
/*      */     {
/* 1237 */       Fight.this._xdb_verify_unsafe_();
/* 1238 */       return Fight.this.actioncountcurround;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public FightParam getFightparams()
/*      */     {
/* 1245 */       Fight.this._xdb_verify_unsafe_();
/* 1246 */       return Fight.this.fightparams;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public FightRecorder getFight_recorder()
/*      */     {
/* 1253 */       Fight.this._xdb_verify_unsafe_();
/* 1254 */       return Fight.this.fight_recorder;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<SkillResultHandle> getSkillresulthandles()
/*      */     {
/* 1261 */       Fight.this._xdb_verify_unsafe_();
/* 1262 */       return Consts.constSet(Fight.this.skillresulthandles);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getGenresultatonce()
/*      */     {
/* 1269 */       Fight.this._xdb_verify_unsafe_();
/* 1270 */       return Fight.this.genresultatonce;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setContext(FightContext _v_)
/*      */     {
/* 1277 */       Fight.this._xdb_verify_unsafe_();
/* 1278 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setType(int _v_)
/*      */     {
/* 1285 */       Fight.this._xdb_verify_unsafe_();
/* 1286 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCfgtype(int _v_)
/*      */     {
/* 1293 */       Fight.this._xdb_verify_unsafe_();
/* 1294 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFightreason(int _v_)
/*      */     {
/* 1301 */       Fight.this._xdb_verify_unsafe_();
/* 1302 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound(int _v_)
/*      */     {
/* 1309 */       Fight.this._xdb_verify_unsafe_();
/* 1310 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/* 1317 */       Fight.this._xdb_verify_unsafe_();
/* 1318 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNextid(int _v_)
/*      */     {
/* 1325 */       Fight.this._xdb_verify_unsafe_();
/* 1326 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIscurroundend(boolean _v_)
/*      */     {
/* 1333 */       Fight.this._xdb_verify_unsafe_();
/* 1334 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFlow(int _v_)
/*      */     {
/* 1341 */       Fight.this._xdb_verify_unsafe_();
/* 1342 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setObservers(LinkedHashMap<Long, Integer> _v_)
/*      */     {
/* 1349 */       Fight.this._xdb_verify_unsafe_();
/* 1350 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimer(FightTimer _v_)
/*      */     {
/* 1357 */       Fight.this._xdb_verify_unsafe_();
/* 1358 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdatetimer(UpdateTimer _v_)
/*      */     {
/* 1365 */       Fight.this._xdb_verify_unsafe_();
/* 1366 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNexttimermillsec(long _v_)
/*      */     {
/* 1373 */       Fight.this._xdb_verify_unsafe_();
/* 1374 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActiontotalcount(int _v_)
/*      */     {
/* 1381 */       Fight.this._xdb_verify_unsafe_();
/* 1382 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActionroundmaxcount(int _v_)
/*      */     {
/* 1389 */       Fight.this._xdb_verify_unsafe_();
/* 1390 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActioncountcurround(int _v_)
/*      */     {
/* 1397 */       Fight.this._xdb_verify_unsafe_();
/* 1398 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFightparams(FightParam _v_)
/*      */     {
/* 1405 */       Fight.this._xdb_verify_unsafe_();
/* 1406 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFight_recorder(FightRecorder _v_)
/*      */     {
/* 1413 */       Fight.this._xdb_verify_unsafe_();
/* 1414 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGenresultatonce(boolean _v_)
/*      */     {
/* 1421 */       Fight.this._xdb_verify_unsafe_();
/* 1422 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1428 */       Fight.this._xdb_verify_unsafe_();
/* 1429 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1435 */       Fight.this._xdb_verify_unsafe_();
/* 1436 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1442 */       return Fight.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1448 */       return Fight.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1454 */       Fight.this._xdb_verify_unsafe_();
/* 1455 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1461 */       return Fight.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1467 */       return Fight.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1473 */       Fight.this._xdb_verify_unsafe_();
/* 1474 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1480 */       return Fight.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1486 */       return Fight.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1492 */       return Fight.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1498 */       return Fight.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1504 */       return Fight.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1510 */       return Fight.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1516 */       return Fight.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Fight
/*      */   {
/*      */     private FightContext context;
/*      */     
/*      */     private int type;
/*      */     
/*      */     private int cfgtype;
/*      */     
/*      */     private int fightreason;
/*      */     
/*      */     private int round;
/*      */     
/*      */     private long starttime;
/*      */     
/*      */     private int nextid;
/*      */     
/*      */     private xbean.FightTeam active;
/*      */     
/*      */     private xbean.FightTeam passive;
/*      */     
/*      */     private HashSet<Long> curroundendroles;
/*      */     
/*      */     private boolean iscurroundend;
/*      */     
/*      */     private int flow;
/*      */     
/*      */     private ArrayList<FightCmd> cmds;
/*      */     
/*      */     private HashMap<Integer, Integer> extra;
/*      */     
/*      */     private LinkedHashMap<Long, Integer> observers;
/*      */     
/*      */     private FightTimer timer;
/*      */     
/*      */     private UpdateTimer updatetimer;
/*      */     
/*      */     private long nexttimermillsec;
/*      */     
/*      */     private int actiontotalcount;
/*      */     
/*      */     private int actionroundmaxcount;
/*      */     
/*      */     private int actioncountcurround;
/*      */     
/*      */     private FightParam fightparams;
/*      */     
/*      */     private FightRecorder fight_recorder;
/*      */     
/*      */     private HashSet<SkillResultHandle> skillresulthandles;
/*      */     
/*      */     private boolean genresultatonce;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1576 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1581 */       this.context = null;
/* 1582 */       this.round = 0;
/* 1583 */       this.starttime = 0L;
/* 1584 */       this.nextid = 0;
/* 1585 */       this.active = new FightTeam.Data();
/* 1586 */       this.passive = new FightTeam.Data();
/* 1587 */       this.curroundendroles = new HashSet();
/* 1588 */       this.flow = 0;
/* 1589 */       this.cmds = new ArrayList();
/* 1590 */       this.extra = new HashMap();
/* 1591 */       this.observers = null;
/* 1592 */       this.timer = null;
/* 1593 */       this.updatetimer = null;
/* 1594 */       this.fightparams = null;
/* 1595 */       this.fight_recorder = null;
/* 1596 */       this.skillresulthandles = new HashSet();
/* 1597 */       this.genresultatonce = false;
/*      */     }
/*      */     
/*      */     Data(xbean.Fight _o1_)
/*      */     {
/* 1602 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1608 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1614 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1620 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1626 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1632 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Fight copy()
/*      */     {
/* 1638 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Fight toData()
/*      */     {
/* 1644 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Fight toBean()
/*      */     {
/* 1649 */       return new Fight(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Fight toDataIf()
/*      */     {
/* 1655 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Fight toBeanIf()
/*      */     {
/* 1660 */       return new Fight(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1666 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1670 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1674 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1678 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1682 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1686 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1690 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public FightContext getContext()
/*      */     {
/* 1697 */       return this.context;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getType()
/*      */     {
/* 1704 */       return this.type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCfgtype()
/*      */     {
/* 1711 */       return this.cfgtype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFightreason()
/*      */     {
/* 1718 */       return this.fightreason;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRound()
/*      */     {
/* 1725 */       return this.round;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/* 1732 */       return this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNextid()
/*      */     {
/* 1739 */       return this.nextid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FightTeam getActive()
/*      */     {
/* 1746 */       return this.active;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FightTeam getPassive()
/*      */     {
/* 1753 */       return this.passive;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCurroundendroles()
/*      */     {
/* 1760 */       return this.curroundendroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCurroundendrolesAsData()
/*      */     {
/* 1767 */       return this.curroundendroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIscurroundend()
/*      */     {
/* 1774 */       return this.iscurroundend;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFlow()
/*      */     {
/* 1781 */       return this.flow;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<FightCmd> getCmds()
/*      */     {
/* 1788 */       return this.cmds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<FightCmd> getCmdsAsData()
/*      */     {
/* 1795 */       return this.cmds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtra()
/*      */     {
/* 1802 */       return this.extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtraAsData()
/*      */     {
/* 1809 */       return this.extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public LinkedHashMap<Long, Integer> getObservers()
/*      */     {
/* 1816 */       return this.observers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public FightTimer getTimer()
/*      */     {
/* 1823 */       return this.timer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public UpdateTimer getUpdatetimer()
/*      */     {
/* 1830 */       return this.updatetimer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNexttimermillsec()
/*      */     {
/* 1837 */       return this.nexttimermillsec;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActiontotalcount()
/*      */     {
/* 1844 */       return this.actiontotalcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActionroundmaxcount()
/*      */     {
/* 1851 */       return this.actionroundmaxcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActioncountcurround()
/*      */     {
/* 1858 */       return this.actioncountcurround;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public FightParam getFightparams()
/*      */     {
/* 1865 */       return this.fightparams;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public FightRecorder getFight_recorder()
/*      */     {
/* 1872 */       return this.fight_recorder;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<SkillResultHandle> getSkillresulthandles()
/*      */     {
/* 1879 */       return this.skillresulthandles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getGenresultatonce()
/*      */     {
/* 1886 */       return this.genresultatonce;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setContext(FightContext _v_)
/*      */     {
/* 1893 */       this.context = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setType(int _v_)
/*      */     {
/* 1900 */       this.type = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCfgtype(int _v_)
/*      */     {
/* 1907 */       this.cfgtype = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFightreason(int _v_)
/*      */     {
/* 1914 */       this.fightreason = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound(int _v_)
/*      */     {
/* 1921 */       this.round = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/* 1928 */       this.starttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNextid(int _v_)
/*      */     {
/* 1935 */       this.nextid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIscurroundend(boolean _v_)
/*      */     {
/* 1942 */       this.iscurroundend = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFlow(int _v_)
/*      */     {
/* 1949 */       this.flow = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setObservers(LinkedHashMap<Long, Integer> _v_)
/*      */     {
/* 1956 */       this.observers = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimer(FightTimer _v_)
/*      */     {
/* 1963 */       this.timer = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdatetimer(UpdateTimer _v_)
/*      */     {
/* 1970 */       this.updatetimer = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNexttimermillsec(long _v_)
/*      */     {
/* 1977 */       this.nexttimermillsec = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActiontotalcount(int _v_)
/*      */     {
/* 1984 */       this.actiontotalcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActionroundmaxcount(int _v_)
/*      */     {
/* 1991 */       this.actionroundmaxcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActioncountcurround(int _v_)
/*      */     {
/* 1998 */       this.actioncountcurround = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFightparams(FightParam _v_)
/*      */     {
/* 2005 */       this.fightparams = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFight_recorder(FightRecorder _v_)
/*      */     {
/* 2012 */       this.fight_recorder = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGenresultatonce(boolean _v_)
/*      */     {
/* 2019 */       this.genresultatonce = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 2025 */       if (!(_o1_ instanceof Data)) return false;
/* 2026 */       Data _o_ = (Data)_o1_;
/* 2027 */       if (((null == this.context) && (null != _o_.context)) || ((null != this.context) && (null == _o_.context)) || ((null != this.context) && (null != _o_.context) && (!this.context.equals(_o_.context)))) return false;
/* 2028 */       if (this.type != _o_.type) return false;
/* 2029 */       if (this.cfgtype != _o_.cfgtype) return false;
/* 2030 */       if (this.fightreason != _o_.fightreason) return false;
/* 2031 */       if (this.round != _o_.round) return false;
/* 2032 */       if (this.starttime != _o_.starttime) return false;
/* 2033 */       if (this.nextid != _o_.nextid) return false;
/* 2034 */       if (!this.active.equals(_o_.active)) return false;
/* 2035 */       if (!this.passive.equals(_o_.passive)) return false;
/* 2036 */       if (!this.curroundendroles.equals(_o_.curroundendroles)) return false;
/* 2037 */       if (this.iscurroundend != _o_.iscurroundend) return false;
/* 2038 */       if (this.flow != _o_.flow) return false;
/* 2039 */       if (!this.cmds.equals(_o_.cmds)) return false;
/* 2040 */       if (!this.extra.equals(_o_.extra)) return false;
/* 2041 */       if (((null == this.observers) && (null != _o_.observers)) || ((null != this.observers) && (null == _o_.observers)) || ((null != this.observers) && (null != _o_.observers) && (!this.observers.equals(_o_.observers)))) return false;
/* 2042 */       if (((null == this.timer) && (null != _o_.timer)) || ((null != this.timer) && (null == _o_.timer)) || ((null != this.timer) && (null != _o_.timer) && (!this.timer.equals(_o_.timer)))) return false;
/* 2043 */       if (((null == this.updatetimer) && (null != _o_.updatetimer)) || ((null != this.updatetimer) && (null == _o_.updatetimer)) || ((null != this.updatetimer) && (null != _o_.updatetimer) && (!this.updatetimer.equals(_o_.updatetimer)))) return false;
/* 2044 */       if (this.nexttimermillsec != _o_.nexttimermillsec) return false;
/* 2045 */       if (this.actiontotalcount != _o_.actiontotalcount) return false;
/* 2046 */       if (this.actionroundmaxcount != _o_.actionroundmaxcount) return false;
/* 2047 */       if (this.actioncountcurround != _o_.actioncountcurround) return false;
/* 2048 */       if (((null == this.fightparams) && (null != _o_.fightparams)) || ((null != this.fightparams) && (null == _o_.fightparams)) || ((null != this.fightparams) && (null != _o_.fightparams) && (!this.fightparams.equals(_o_.fightparams)))) return false;
/* 2049 */       if (((null == this.fight_recorder) && (null != _o_.fight_recorder)) || ((null != this.fight_recorder) && (null == _o_.fight_recorder)) || ((null != this.fight_recorder) && (null != _o_.fight_recorder) && (!this.fight_recorder.equals(_o_.fight_recorder)))) return false;
/* 2050 */       if (!this.skillresulthandles.equals(_o_.skillresulthandles)) return false;
/* 2051 */       if (this.genresultatonce != _o_.genresultatonce) return false;
/* 2052 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 2058 */       int _h_ = 0;
/* 2059 */       _h_ += (this.context == null ? 0 : this.context.hashCode());
/* 2060 */       _h_ += this.type;
/* 2061 */       _h_ += this.cfgtype;
/* 2062 */       _h_ += this.fightreason;
/* 2063 */       _h_ += this.round;
/* 2064 */       _h_ = (int)(_h_ + this.starttime);
/* 2065 */       _h_ += this.nextid;
/* 2066 */       _h_ += this.active.hashCode();
/* 2067 */       _h_ += this.passive.hashCode();
/* 2068 */       _h_ += this.curroundendroles.hashCode();
/* 2069 */       _h_ += (this.iscurroundend ? 1231 : 1237);
/* 2070 */       _h_ += this.flow;
/* 2071 */       _h_ += this.cmds.hashCode();
/* 2072 */       _h_ += this.extra.hashCode();
/* 2073 */       _h_ += (this.observers == null ? 0 : this.observers.hashCode());
/* 2074 */       _h_ += (this.timer == null ? 0 : this.timer.hashCode());
/* 2075 */       _h_ += (this.updatetimer == null ? 0 : this.updatetimer.hashCode());
/* 2076 */       _h_ = (int)(_h_ + this.nexttimermillsec);
/* 2077 */       _h_ += this.actiontotalcount;
/* 2078 */       _h_ += this.actionroundmaxcount;
/* 2079 */       _h_ += this.actioncountcurround;
/* 2080 */       _h_ += (this.fightparams == null ? 0 : this.fightparams.hashCode());
/* 2081 */       _h_ += (this.fight_recorder == null ? 0 : this.fight_recorder.hashCode());
/* 2082 */       _h_ += this.skillresulthandles.hashCode();
/* 2083 */       _h_ += (this.genresultatonce ? 1231 : 1237);
/* 2084 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2090 */       StringBuilder _sb_ = new StringBuilder();
/* 2091 */       _sb_.append("(");
/* 2092 */       _sb_.append(this.context);
/* 2093 */       _sb_.append(",");
/* 2094 */       _sb_.append(this.type);
/* 2095 */       _sb_.append(",");
/* 2096 */       _sb_.append(this.cfgtype);
/* 2097 */       _sb_.append(",");
/* 2098 */       _sb_.append(this.fightreason);
/* 2099 */       _sb_.append(",");
/* 2100 */       _sb_.append(this.round);
/* 2101 */       _sb_.append(",");
/* 2102 */       _sb_.append(this.starttime);
/* 2103 */       _sb_.append(",");
/* 2104 */       _sb_.append(this.nextid);
/* 2105 */       _sb_.append(",");
/* 2106 */       _sb_.append(this.active);
/* 2107 */       _sb_.append(",");
/* 2108 */       _sb_.append(this.passive);
/* 2109 */       _sb_.append(",");
/* 2110 */       _sb_.append(this.curroundendroles);
/* 2111 */       _sb_.append(",");
/* 2112 */       _sb_.append(this.iscurroundend);
/* 2113 */       _sb_.append(",");
/* 2114 */       _sb_.append(this.flow);
/* 2115 */       _sb_.append(",");
/* 2116 */       _sb_.append(this.cmds);
/* 2117 */       _sb_.append(",");
/* 2118 */       _sb_.append(this.extra);
/* 2119 */       _sb_.append(",");
/* 2120 */       _sb_.append(this.observers);
/* 2121 */       _sb_.append(",");
/* 2122 */       _sb_.append(this.timer);
/* 2123 */       _sb_.append(",");
/* 2124 */       _sb_.append(this.updatetimer);
/* 2125 */       _sb_.append(",");
/* 2126 */       _sb_.append(this.nexttimermillsec);
/* 2127 */       _sb_.append(",");
/* 2128 */       _sb_.append(this.actiontotalcount);
/* 2129 */       _sb_.append(",");
/* 2130 */       _sb_.append(this.actionroundmaxcount);
/* 2131 */       _sb_.append(",");
/* 2132 */       _sb_.append(this.actioncountcurround);
/* 2133 */       _sb_.append(",");
/* 2134 */       _sb_.append(this.fightparams);
/* 2135 */       _sb_.append(",");
/* 2136 */       _sb_.append(this.fight_recorder);
/* 2137 */       _sb_.append(",");
/* 2138 */       _sb_.append(this.skillresulthandles);
/* 2139 */       _sb_.append(",");
/* 2140 */       _sb_.append(this.genresultatonce);
/* 2141 */       _sb_.append(")");
/* 2142 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Fight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
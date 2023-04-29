/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.fight.main.FightInfo.AITeamVariable;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xbean.FightGroup;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class FightTeam extends XBean implements xbean.FightTeam
/*     */ {
/*     */   private HashMap<Integer, FightGroup> groups;
/*     */   private HashMap<Integer, Integer> extra;
/*     */   private xdb.util.SetX<mzm.gsp.effect.fighter.Interface.TeamEffect> teameffects;
/*     */   private FightInfo.AITeamVariable aiteamvariable;
/*     */   private int assistfellownum;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.groups.clear();
/*  27 */     this.extra.clear();
/*  28 */     this.teameffects.clear();
/*  29 */     this.aiteamvariable = null;
/*  30 */     this.assistfellownum = 0;
/*     */   }
/*     */   
/*     */   FightTeam(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*  36 */     this.groups = new HashMap();
/*  37 */     this.extra = new HashMap();
/*  38 */     this.teameffects = new xdb.util.SetX();
/*  39 */     this.aiteamvariable = null;
/*     */   }
/*     */   
/*     */   public FightTeam()
/*     */   {
/*  44 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FightTeam(FightTeam _o_)
/*     */   {
/*  49 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FightTeam(xbean.FightTeam _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  54 */     super(_xp_, _vn_);
/*  55 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  61 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  67 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  73 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  79 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  85 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightTeam copy()
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     return new FightTeam(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightTeam toData()
/*     */   {
/*  98 */     _xdb_verify_unsafe_();
/*  99 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightTeam toBean()
/*     */   {
/* 104 */     _xdb_verify_unsafe_();
/* 105 */     return new FightTeam(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightTeam toDataIf()
/*     */   {
/* 111 */     _xdb_verify_unsafe_();
/* 112 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightTeam toBeanIf()
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/* 118 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 124 */     _xdb_verify_unsafe_();
/* 125 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, FightGroup> getGroups()
/*     */   {
/* 132 */     _xdb_verify_unsafe_();
/* 133 */     return xdb.Logs.logMap(new LogKey(this, "groups"), this.groups);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getExtra()
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/* 141 */     return xdb.Logs.logMap(new LogKey(this, "extra"), this.extra);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getExtraAsData()
/*     */   {
/* 148 */     _xdb_verify_unsafe_();
/*     */     
/* 150 */     FightTeam _o_ = this;
/* 151 */     Map<Integer, Integer> extra = new HashMap();
/* 152 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/* 153 */       extra.put(_e_.getKey(), _e_.getValue());
/* 154 */     return extra;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Set<mzm.gsp.effect.fighter.Interface.TeamEffect> getTeameffects()
/*     */   {
/* 161 */     _xdb_verify_unsafe_();
/* 162 */     return xdb.Logs.logSet(new LogKey(this, "teameffects"), this.teameffects);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public FightInfo.AITeamVariable getAiteamvariable()
/*     */   {
/* 169 */     _xdb_verify_unsafe_();
/* 170 */     return this.aiteamvariable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAssistfellownum()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return this.assistfellownum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAiteamvariable(FightInfo.AITeamVariable _v_)
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     xdb.Logs.logIf(new LogKey(this, "aiteamvariable")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 190 */         new xdb.logs.LogObject(this, FightTeam.this.aiteamvariable)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 194 */             FightTeam.this.aiteamvariable = ((FightInfo.AITeamVariable)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 198 */     });
/* 199 */     this.aiteamvariable = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAssistfellownum(int _v_)
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     xdb.Logs.logIf(new LogKey(this, "assistfellownum")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 211 */         new xdb.logs.LogInt(this, FightTeam.this.assistfellownum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 215 */             FightTeam.this.assistfellownum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 219 */     });
/* 220 */     this.assistfellownum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     FightTeam _o_ = null;
/* 228 */     if ((_o1_ instanceof FightTeam)) { _o_ = (FightTeam)_o1_;
/* 229 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 230 */       return false;
/* 231 */     if (!this.groups.equals(_o_.groups)) return false;
/* 232 */     if (!this.extra.equals(_o_.extra)) return false;
/* 233 */     if (!this.teameffects.equals(_o_.teameffects)) return false;
/* 234 */     if (((null == this.aiteamvariable) && (null != _o_.aiteamvariable)) || ((null != this.aiteamvariable) && (null == _o_.aiteamvariable)) || ((null != this.aiteamvariable) && (null != _o_.aiteamvariable) && (!this.aiteamvariable.equals(_o_.aiteamvariable)))) return false;
/* 235 */     if (this.assistfellownum != _o_.assistfellownum) return false;
/* 236 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     int _h_ = 0;
/* 244 */     _h_ += this.groups.hashCode();
/* 245 */     _h_ += this.extra.hashCode();
/* 246 */     _h_ += this.teameffects.hashCode();
/* 247 */     _h_ += (this.aiteamvariable == null ? 0 : this.aiteamvariable.hashCode());
/* 248 */     _h_ += this.assistfellownum;
/* 249 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     StringBuilder _sb_ = new StringBuilder();
/* 257 */     _sb_.append("(");
/* 258 */     _sb_.append(this.groups);
/* 259 */     _sb_.append(",");
/* 260 */     _sb_.append(this.extra);
/* 261 */     _sb_.append(",");
/* 262 */     _sb_.append(this.teameffects);
/* 263 */     _sb_.append(",");
/* 264 */     _sb_.append(this.aiteamvariable);
/* 265 */     _sb_.append(",");
/* 266 */     _sb_.append(this.assistfellownum);
/* 267 */     _sb_.append(")");
/* 268 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 274 */     ListenableBean lb = new ListenableBean();
/* 275 */     lb.add(new xdb.logs.ListenableMap().setVarName("groups"));
/* 276 */     lb.add(new xdb.logs.ListenableMap().setVarName("extra"));
/* 277 */     lb.add(new xdb.logs.ListenableSet().setVarName("teameffects"));
/* 278 */     lb.add(new xdb.logs.ListenableChanged().setVarName("aiteamvariable"));
/* 279 */     lb.add(new xdb.logs.ListenableChanged().setVarName("assistfellownum"));
/* 280 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FightTeam {
/*     */     private Const() {}
/*     */     
/*     */     FightTeam nThis() {
/* 287 */       return FightTeam.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 293 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightTeam copy()
/*     */     {
/* 299 */       return FightTeam.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightTeam toData()
/*     */     {
/* 305 */       return FightTeam.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FightTeam toBean()
/*     */     {
/* 310 */       return FightTeam.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightTeam toDataIf()
/*     */     {
/* 316 */       return FightTeam.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FightTeam toBeanIf()
/*     */     {
/* 321 */       return FightTeam.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, FightGroup> getGroups()
/*     */     {
/* 328 */       FightTeam.this._xdb_verify_unsafe_();
/* 329 */       return xdb.Consts.constMap(FightTeam.this.groups);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getExtra()
/*     */     {
/* 336 */       FightTeam.this._xdb_verify_unsafe_();
/* 337 */       return xdb.Consts.constMap(FightTeam.this.extra);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getExtraAsData()
/*     */     {
/* 344 */       FightTeam.this._xdb_verify_unsafe_();
/*     */       
/* 346 */       FightTeam _o_ = FightTeam.this;
/* 347 */       Map<Integer, Integer> extra = new HashMap();
/* 348 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/* 349 */         extra.put(_e_.getKey(), _e_.getValue());
/* 350 */       return extra;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<mzm.gsp.effect.fighter.Interface.TeamEffect> getTeameffects()
/*     */     {
/* 357 */       FightTeam.this._xdb_verify_unsafe_();
/* 358 */       return xdb.Consts.constSet(FightTeam.this.teameffects);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public FightInfo.AITeamVariable getAiteamvariable()
/*     */     {
/* 365 */       FightTeam.this._xdb_verify_unsafe_();
/* 366 */       return FightTeam.this.aiteamvariable;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAssistfellownum()
/*     */     {
/* 373 */       FightTeam.this._xdb_verify_unsafe_();
/* 374 */       return FightTeam.this.assistfellownum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAiteamvariable(FightInfo.AITeamVariable _v_)
/*     */     {
/* 381 */       FightTeam.this._xdb_verify_unsafe_();
/* 382 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAssistfellownum(int _v_)
/*     */     {
/* 389 */       FightTeam.this._xdb_verify_unsafe_();
/* 390 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 396 */       FightTeam.this._xdb_verify_unsafe_();
/* 397 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 403 */       FightTeam.this._xdb_verify_unsafe_();
/* 404 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 410 */       return FightTeam.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 416 */       return FightTeam.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 422 */       FightTeam.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 429 */       return FightTeam.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 435 */       return FightTeam.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 441 */       FightTeam.this._xdb_verify_unsafe_();
/* 442 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 448 */       return FightTeam.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 454 */       return FightTeam.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 460 */       return FightTeam.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 466 */       return FightTeam.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 472 */       return FightTeam.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 478 */       return FightTeam.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 484 */       return FightTeam.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FightTeam
/*     */   {
/*     */     private HashMap<Integer, FightGroup> groups;
/*     */     
/*     */     private HashMap<Integer, Integer> extra;
/*     */     
/*     */     private java.util.HashSet<mzm.gsp.effect.fighter.Interface.TeamEffect> teameffects;
/*     */     
/*     */     private FightInfo.AITeamVariable aiteamvariable;
/*     */     
/*     */     private int assistfellownum;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 504 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 509 */       this.groups = new HashMap();
/* 510 */       this.extra = new HashMap();
/* 511 */       this.teameffects = new java.util.HashSet();
/* 512 */       this.aiteamvariable = null;
/*     */     }
/*     */     
/*     */     Data(xbean.FightTeam _o1_)
/*     */     {
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 523 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 529 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 535 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightTeam copy()
/*     */     {
/* 553 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightTeam toData()
/*     */     {
/* 559 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FightTeam toBean()
/*     */     {
/* 564 */       return new FightTeam(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightTeam toDataIf()
/*     */     {
/* 570 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FightTeam toBeanIf()
/*     */     {
/* 575 */       return new FightTeam(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 581 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 585 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 589 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 593 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 597 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 601 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 605 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, FightGroup> getGroups()
/*     */     {
/* 612 */       return this.groups;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getExtra()
/*     */     {
/* 619 */       return this.extra;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getExtraAsData()
/*     */     {
/* 626 */       return this.extra;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<mzm.gsp.effect.fighter.Interface.TeamEffect> getTeameffects()
/*     */     {
/* 633 */       return this.teameffects;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public FightInfo.AITeamVariable getAiteamvariable()
/*     */     {
/* 640 */       return this.aiteamvariable;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAssistfellownum()
/*     */     {
/* 647 */       return this.assistfellownum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAiteamvariable(FightInfo.AITeamVariable _v_)
/*     */     {
/* 654 */       this.aiteamvariable = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAssistfellownum(int _v_)
/*     */     {
/* 661 */       this.assistfellownum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 667 */       if (!(_o1_ instanceof Data)) return false;
/* 668 */       Data _o_ = (Data)_o1_;
/* 669 */       if (!this.groups.equals(_o_.groups)) return false;
/* 670 */       if (!this.extra.equals(_o_.extra)) return false;
/* 671 */       if (!this.teameffects.equals(_o_.teameffects)) return false;
/* 672 */       if (((null == this.aiteamvariable) && (null != _o_.aiteamvariable)) || ((null != this.aiteamvariable) && (null == _o_.aiteamvariable)) || ((null != this.aiteamvariable) && (null != _o_.aiteamvariable) && (!this.aiteamvariable.equals(_o_.aiteamvariable)))) return false;
/* 673 */       if (this.assistfellownum != _o_.assistfellownum) return false;
/* 674 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 680 */       int _h_ = 0;
/* 681 */       _h_ += this.groups.hashCode();
/* 682 */       _h_ += this.extra.hashCode();
/* 683 */       _h_ += this.teameffects.hashCode();
/* 684 */       _h_ += (this.aiteamvariable == null ? 0 : this.aiteamvariable.hashCode());
/* 685 */       _h_ += this.assistfellownum;
/* 686 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 692 */       StringBuilder _sb_ = new StringBuilder();
/* 693 */       _sb_.append("(");
/* 694 */       _sb_.append(this.groups);
/* 695 */       _sb_.append(",");
/* 696 */       _sb_.append(this.extra);
/* 697 */       _sb_.append(",");
/* 698 */       _sb_.append(this.teameffects);
/* 699 */       _sb_.append(",");
/* 700 */       _sb_.append(this.aiteamvariable);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.assistfellownum);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FightTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
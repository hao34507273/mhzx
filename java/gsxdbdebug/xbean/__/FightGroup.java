/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.fight.main.GroupAI;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class FightGroup extends XBean implements xbean.FightGroup
/*     */ {
/*     */   private int type;
/*     */   private HashMap<Integer, xbean.Fighter> members;
/*     */   private HashMap<Integer, Integer> extra;
/*     */   private xdb.util.SetX<mzm.gsp.fight.main.Fighter> leavefighters;
/*     */   private GroupAI groupai;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.type = 0;
/*  27 */     this.members.clear();
/*  28 */     this.extra.clear();
/*  29 */     this.leavefighters.clear();
/*  30 */     this.groupai = null;
/*     */   }
/*     */   
/*     */   FightGroup(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*  36 */     this.members = new HashMap();
/*  37 */     this.extra = new HashMap();
/*  38 */     this.leavefighters = new xdb.util.SetX();
/*  39 */     this.groupai = null;
/*     */   }
/*     */   
/*     */   public FightGroup()
/*     */   {
/*  44 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FightGroup(FightGroup _o_)
/*     */   {
/*  49 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FightGroup(xbean.FightGroup _o1_, XBean _xp_, String _vn_)
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
/*     */   public xbean.FightGroup copy()
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     return new FightGroup(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightGroup toData()
/*     */   {
/*  98 */     _xdb_verify_unsafe_();
/*  99 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightGroup toBean()
/*     */   {
/* 104 */     _xdb_verify_unsafe_();
/* 105 */     return new FightGroup(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightGroup toDataIf()
/*     */   {
/* 111 */     _xdb_verify_unsafe_();
/* 112 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightGroup toBeanIf()
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/* 118 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 124 */     _xdb_verify_unsafe_();
/* 125 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/* 132 */     _xdb_verify_unsafe_();
/* 133 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.Fighter> getMembers()
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/* 141 */     return xdb.Logs.logMap(new LogKey(this, "members"), this.members);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getExtra()
/*     */   {
/* 148 */     _xdb_verify_unsafe_();
/* 149 */     return xdb.Logs.logMap(new LogKey(this, "extra"), this.extra);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getExtraAsData()
/*     */   {
/* 156 */     _xdb_verify_unsafe_();
/*     */     
/* 158 */     FightGroup _o_ = this;
/* 159 */     Map<Integer, Integer> extra = new HashMap();
/* 160 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/* 161 */       extra.put(_e_.getKey(), _e_.getValue());
/* 162 */     return extra;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Set<mzm.gsp.fight.main.Fighter> getLeavefighters()
/*     */   {
/* 169 */     _xdb_verify_unsafe_();
/* 170 */     return xdb.Logs.logSet(new LogKey(this, "leavefighters"), this.leavefighters);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public GroupAI getGroupai()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return this.groupai;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setType(int _v_)
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     xdb.Logs.logIf(new LogKey(this, "type")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 190 */         new xdb.logs.LogInt(this, FightGroup.this.type)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 194 */             FightGroup.this.type = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 198 */     });
/* 199 */     this.type = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGroupai(GroupAI _v_)
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     xdb.Logs.logIf(new LogKey(this, "groupai")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 211 */         new xdb.logs.LogObject(this, FightGroup.this.groupai)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 215 */             FightGroup.this.groupai = ((GroupAI)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 219 */     });
/* 220 */     this.groupai = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     FightGroup _o_ = null;
/* 228 */     if ((_o1_ instanceof FightGroup)) { _o_ = (FightGroup)_o1_;
/* 229 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 230 */       return false;
/* 231 */     if (this.type != _o_.type) return false;
/* 232 */     if (!this.members.equals(_o_.members)) return false;
/* 233 */     if (!this.extra.equals(_o_.extra)) return false;
/* 234 */     if (!this.leavefighters.equals(_o_.leavefighters)) return false;
/* 235 */     if (((null == this.groupai) && (null != _o_.groupai)) || ((null != this.groupai) && (null == _o_.groupai)) || ((null != this.groupai) && (null != _o_.groupai) && (!this.groupai.equals(_o_.groupai)))) return false;
/* 236 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     int _h_ = 0;
/* 244 */     _h_ += this.type;
/* 245 */     _h_ += this.members.hashCode();
/* 246 */     _h_ += this.extra.hashCode();
/* 247 */     _h_ += this.leavefighters.hashCode();
/* 248 */     _h_ += (this.groupai == null ? 0 : this.groupai.hashCode());
/* 249 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     StringBuilder _sb_ = new StringBuilder();
/* 257 */     _sb_.append("(");
/* 258 */     _sb_.append(this.type);
/* 259 */     _sb_.append(",");
/* 260 */     _sb_.append(this.members);
/* 261 */     _sb_.append(",");
/* 262 */     _sb_.append(this.extra);
/* 263 */     _sb_.append(",");
/* 264 */     _sb_.append(this.leavefighters);
/* 265 */     _sb_.append(",");
/* 266 */     _sb_.append(this.groupai);
/* 267 */     _sb_.append(")");
/* 268 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 274 */     ListenableBean lb = new ListenableBean();
/* 275 */     lb.add(new xdb.logs.ListenableChanged().setVarName("type"));
/* 276 */     lb.add(new xdb.logs.ListenableMap().setVarName("members"));
/* 277 */     lb.add(new xdb.logs.ListenableMap().setVarName("extra"));
/* 278 */     lb.add(new xdb.logs.ListenableSet().setVarName("leavefighters"));
/* 279 */     lb.add(new xdb.logs.ListenableChanged().setVarName("groupai"));
/* 280 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FightGroup {
/*     */     private Const() {}
/*     */     
/*     */     FightGroup nThis() {
/* 287 */       return FightGroup.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 293 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightGroup copy()
/*     */     {
/* 299 */       return FightGroup.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightGroup toData()
/*     */     {
/* 305 */       return FightGroup.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FightGroup toBean()
/*     */     {
/* 310 */       return FightGroup.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightGroup toDataIf()
/*     */     {
/* 316 */       return FightGroup.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FightGroup toBeanIf()
/*     */     {
/* 321 */       return FightGroup.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getType()
/*     */     {
/* 328 */       FightGroup.this._xdb_verify_unsafe_();
/* 329 */       return FightGroup.this.type;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Fighter> getMembers()
/*     */     {
/* 336 */       FightGroup.this._xdb_verify_unsafe_();
/* 337 */       return xdb.Consts.constMap(FightGroup.this.members);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getExtra()
/*     */     {
/* 344 */       FightGroup.this._xdb_verify_unsafe_();
/* 345 */       return xdb.Consts.constMap(FightGroup.this.extra);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getExtraAsData()
/*     */     {
/* 352 */       FightGroup.this._xdb_verify_unsafe_();
/*     */       
/* 354 */       FightGroup _o_ = FightGroup.this;
/* 355 */       Map<Integer, Integer> extra = new HashMap();
/* 356 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/* 357 */         extra.put(_e_.getKey(), _e_.getValue());
/* 358 */       return extra;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<mzm.gsp.fight.main.Fighter> getLeavefighters()
/*     */     {
/* 365 */       FightGroup.this._xdb_verify_unsafe_();
/* 366 */       return xdb.Consts.constSet(FightGroup.this.leavefighters);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public GroupAI getGroupai()
/*     */     {
/* 373 */       FightGroup.this._xdb_verify_unsafe_();
/* 374 */       return FightGroup.this.groupai;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setType(int _v_)
/*     */     {
/* 381 */       FightGroup.this._xdb_verify_unsafe_();
/* 382 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGroupai(GroupAI _v_)
/*     */     {
/* 389 */       FightGroup.this._xdb_verify_unsafe_();
/* 390 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 396 */       FightGroup.this._xdb_verify_unsafe_();
/* 397 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 403 */       FightGroup.this._xdb_verify_unsafe_();
/* 404 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 410 */       return FightGroup.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 416 */       return FightGroup.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 422 */       FightGroup.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 429 */       return FightGroup.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 435 */       return FightGroup.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 441 */       FightGroup.this._xdb_verify_unsafe_();
/* 442 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 448 */       return FightGroup.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 454 */       return FightGroup.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 460 */       return FightGroup.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 466 */       return FightGroup.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 472 */       return FightGroup.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 478 */       return FightGroup.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 484 */       return FightGroup.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FightGroup
/*     */   {
/*     */     private int type;
/*     */     
/*     */     private HashMap<Integer, xbean.Fighter> members;
/*     */     
/*     */     private HashMap<Integer, Integer> extra;
/*     */     
/*     */     private java.util.HashSet<mzm.gsp.fight.main.Fighter> leavefighters;
/*     */     
/*     */     private GroupAI groupai;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 504 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 509 */       this.members = new HashMap();
/* 510 */       this.extra = new HashMap();
/* 511 */       this.leavefighters = new java.util.HashSet();
/* 512 */       this.groupai = null;
/*     */     }
/*     */     
/*     */     Data(xbean.FightGroup _o1_)
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
/*     */     public xbean.FightGroup copy()
/*     */     {
/* 553 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightGroup toData()
/*     */     {
/* 559 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FightGroup toBean()
/*     */     {
/* 564 */       return new FightGroup(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightGroup toDataIf()
/*     */     {
/* 570 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FightGroup toBeanIf()
/*     */     {
/* 575 */       return new FightGroup(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 581 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
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
/*     */     public Bean toConst() {
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
/*     */     public int getType()
/*     */     {
/* 612 */       return this.type;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Fighter> getMembers()
/*     */     {
/* 619 */       return this.members;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getExtra()
/*     */     {
/* 626 */       return this.extra;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getExtraAsData()
/*     */     {
/* 633 */       return this.extra;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<mzm.gsp.fight.main.Fighter> getLeavefighters()
/*     */     {
/* 640 */       return this.leavefighters;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public GroupAI getGroupai()
/*     */     {
/* 647 */       return this.groupai;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setType(int _v_)
/*     */     {
/* 654 */       this.type = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGroupai(GroupAI _v_)
/*     */     {
/* 661 */       this.groupai = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 667 */       if (!(_o1_ instanceof Data)) return false;
/* 668 */       Data _o_ = (Data)_o1_;
/* 669 */       if (this.type != _o_.type) return false;
/* 670 */       if (!this.members.equals(_o_.members)) return false;
/* 671 */       if (!this.extra.equals(_o_.extra)) return false;
/* 672 */       if (!this.leavefighters.equals(_o_.leavefighters)) return false;
/* 673 */       if (((null == this.groupai) && (null != _o_.groupai)) || ((null != this.groupai) && (null == _o_.groupai)) || ((null != this.groupai) && (null != _o_.groupai) && (!this.groupai.equals(_o_.groupai)))) return false;
/* 674 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 680 */       int _h_ = 0;
/* 681 */       _h_ += this.type;
/* 682 */       _h_ += this.members.hashCode();
/* 683 */       _h_ += this.extra.hashCode();
/* 684 */       _h_ += this.leavefighters.hashCode();
/* 685 */       _h_ += (this.groupai == null ? 0 : this.groupai.hashCode());
/* 686 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 692 */       StringBuilder _sb_ = new StringBuilder();
/* 693 */       _sb_.append("(");
/* 694 */       _sb_.append(this.type);
/* 695 */       _sb_.append(",");
/* 696 */       _sb_.append(this.members);
/* 697 */       _sb_.append(",");
/* 698 */       _sb_.append(this.extra);
/* 699 */       _sb_.append(",");
/* 700 */       _sb_.append(this.leavefighters);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.groupai);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FightGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
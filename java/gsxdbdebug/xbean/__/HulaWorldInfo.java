/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class HulaWorldInfo extends XBean implements xbean.HulaWorldInfo
/*     */ {
/*     */   private LinkedList<xbean.HulaMonsterInfo> monsters;
/*     */   private SetX<Long> roleids;
/*     */   private int maxseq;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.monsters.clear();
/*  23 */     this.roleids.clear();
/*  24 */     this.maxseq = 0;
/*     */   }
/*     */   
/*     */   HulaWorldInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.monsters = new LinkedList();
/*  31 */     this.roleids = new SetX();
/*     */   }
/*     */   
/*     */   public HulaWorldInfo()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public HulaWorldInfo(HulaWorldInfo _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   HulaWorldInfo(xbean.HulaWorldInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof HulaWorldInfo)) { assign((HulaWorldInfo)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(HulaWorldInfo _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.monsters = new LinkedList();
/*  57 */     for (xbean.HulaMonsterInfo _v_ : _o_.monsters)
/*  58 */       this.monsters.add(new HulaMonsterInfo(_v_, this, "monsters"));
/*  59 */     this.roleids = new SetX();
/*  60 */     this.roleids.addAll(_o_.roleids);
/*  61 */     this.maxseq = _o_.maxseq;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.monsters = new LinkedList();
/*  67 */     for (xbean.HulaMonsterInfo _v_ : _o_.monsters)
/*  68 */       this.monsters.add(new HulaMonsterInfo(_v_, this, "monsters"));
/*  69 */     this.roleids = new SetX();
/*  70 */     this.roleids.addAll(_o_.roleids);
/*  71 */     this.maxseq = _o_.maxseq;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.compact_uint32(this.monsters.size());
/*  79 */     for (xbean.HulaMonsterInfo _v_ : this.monsters)
/*     */     {
/*  81 */       _v_.marshal(_os_);
/*     */     }
/*  83 */     _os_.compact_uint32(this.roleids.size());
/*  84 */     for (Long _v_ : this.roleids)
/*     */     {
/*  86 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  88 */     _os_.marshal(this.maxseq);
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  98 */       xbean.HulaMonsterInfo _v_ = new HulaMonsterInfo(0, this, "monsters");
/*  99 */       _v_.unmarshal(_os_);
/* 100 */       this.monsters.add(_v_);
/*     */     }
/* 102 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 104 */       long _v_ = 0L;
/* 105 */       _v_ = _os_.unmarshal_long();
/* 106 */       this.roleids.add(Long.valueOf(_v_));
/*     */     }
/* 108 */     this.maxseq = _os_.unmarshal_int();
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 115 */     _xdb_verify_unsafe_();
/* 116 */     int _size_ = 0;
/* 117 */     for (xbean.HulaMonsterInfo _v_ : this.monsters)
/*     */     {
/* 119 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 121 */     for (Long _v_ : this.roleids)
/*     */     {
/* 123 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */     }
/* 125 */     _size_ += CodedOutputStream.computeInt32Size(3, this.maxseq);
/* 126 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 132 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 135 */       for (xbean.HulaMonsterInfo _v_ : this.monsters)
/*     */       {
/* 137 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 139 */       for (Long _v_ : this.roleids)
/*     */       {
/* 141 */         _output_.writeInt64(2, _v_.longValue());
/*     */       }
/* 143 */       _output_.writeInt32(3, this.maxseq);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 147 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 149 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 155 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 158 */       boolean done = false;
/* 159 */       while (!done)
/*     */       {
/* 161 */         int tag = _input_.readTag();
/* 162 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 166 */           done = true;
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 171 */           xbean.HulaMonsterInfo _v_ = new HulaMonsterInfo(0, this, "monsters");
/* 172 */           _input_.readMessage(_v_);
/* 173 */           this.monsters.add(_v_);
/* 174 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 178 */           long _v_ = 0L;
/* 179 */           _v_ = _input_.readInt64();
/* 180 */           this.roleids.add(Long.valueOf(_v_));
/* 181 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 185 */           this.maxseq = _input_.readInt32();
/* 186 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 190 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 192 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 201 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 205 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 207 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HulaWorldInfo copy()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new HulaWorldInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HulaWorldInfo toData()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HulaWorldInfo toBean()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new HulaWorldInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HulaWorldInfo toDataIf()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HulaWorldInfo toBeanIf()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.HulaMonsterInfo> getMonsters()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return xdb.Logs.logList(new xdb.LogKey(this, "monsters"), this.monsters);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.HulaMonsterInfo> getMonstersAsData()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/*     */     
/* 263 */     HulaWorldInfo _o_ = this;
/* 264 */     List<xbean.HulaMonsterInfo> monsters = new LinkedList();
/* 265 */     for (xbean.HulaMonsterInfo _v_ : _o_.monsters)
/* 266 */       monsters.add(new HulaMonsterInfo.Data(_v_));
/* 267 */     return monsters;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getRoleids()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     return xdb.Logs.logSet(new xdb.LogKey(this, "roleids"), this.roleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getRoleidsAsData()
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/*     */     
/* 283 */     HulaWorldInfo _o_ = this;
/* 284 */     Set<Long> roleids = new SetX();
/* 285 */     roleids.addAll(_o_.roleids);
/* 286 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMaxseq()
/*     */   {
/* 293 */     _xdb_verify_unsafe_();
/* 294 */     return this.maxseq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMaxseq(int _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new xdb.LogKey(this, "maxseq")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 306 */         new xdb.logs.LogInt(this, HulaWorldInfo.this.maxseq)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             HulaWorldInfo.this.maxseq = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.maxseq = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     HulaWorldInfo _o_ = null;
/* 323 */     if ((_o1_ instanceof HulaWorldInfo)) { _o_ = (HulaWorldInfo)_o1_;
/* 324 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 325 */       return false;
/* 326 */     if (!this.monsters.equals(_o_.monsters)) return false;
/* 327 */     if (!this.roleids.equals(_o_.roleids)) return false;
/* 328 */     if (this.maxseq != _o_.maxseq) return false;
/* 329 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 335 */     _xdb_verify_unsafe_();
/* 336 */     int _h_ = 0;
/* 337 */     _h_ += this.monsters.hashCode();
/* 338 */     _h_ += this.roleids.hashCode();
/* 339 */     _h_ += this.maxseq;
/* 340 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 346 */     _xdb_verify_unsafe_();
/* 347 */     StringBuilder _sb_ = new StringBuilder();
/* 348 */     _sb_.append("(");
/* 349 */     _sb_.append(this.monsters);
/* 350 */     _sb_.append(",");
/* 351 */     _sb_.append(this.roleids);
/* 352 */     _sb_.append(",");
/* 353 */     _sb_.append(this.maxseq);
/* 354 */     _sb_.append(")");
/* 355 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 361 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 362 */     lb.add(new xdb.logs.ListenableChanged().setVarName("monsters"));
/* 363 */     lb.add(new xdb.logs.ListenableSet().setVarName("roleids"));
/* 364 */     lb.add(new xdb.logs.ListenableChanged().setVarName("maxseq"));
/* 365 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.HulaWorldInfo {
/*     */     private Const() {}
/*     */     
/*     */     HulaWorldInfo nThis() {
/* 372 */       return HulaWorldInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 378 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HulaWorldInfo copy()
/*     */     {
/* 384 */       return HulaWorldInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HulaWorldInfo toData()
/*     */     {
/* 390 */       return HulaWorldInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.HulaWorldInfo toBean()
/*     */     {
/* 395 */       return HulaWorldInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HulaWorldInfo toDataIf()
/*     */     {
/* 401 */       return HulaWorldInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.HulaWorldInfo toBeanIf()
/*     */     {
/* 406 */       return HulaWorldInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.HulaMonsterInfo> getMonsters()
/*     */     {
/* 413 */       HulaWorldInfo.this._xdb_verify_unsafe_();
/* 414 */       return xdb.Consts.constList(HulaWorldInfo.this.monsters);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.HulaMonsterInfo> getMonstersAsData()
/*     */     {
/* 420 */       HulaWorldInfo.this._xdb_verify_unsafe_();
/*     */       
/* 422 */       HulaWorldInfo _o_ = HulaWorldInfo.this;
/* 423 */       List<xbean.HulaMonsterInfo> monsters = new LinkedList();
/* 424 */       for (xbean.HulaMonsterInfo _v_ : _o_.monsters)
/* 425 */         monsters.add(new HulaMonsterInfo.Data(_v_));
/* 426 */       return monsters;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRoleids()
/*     */     {
/* 433 */       HulaWorldInfo.this._xdb_verify_unsafe_();
/* 434 */       return xdb.Consts.constSet(HulaWorldInfo.this.roleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getRoleidsAsData()
/*     */     {
/* 440 */       HulaWorldInfo.this._xdb_verify_unsafe_();
/*     */       
/* 442 */       HulaWorldInfo _o_ = HulaWorldInfo.this;
/* 443 */       Set<Long> roleids = new SetX();
/* 444 */       roleids.addAll(_o_.roleids);
/* 445 */       return roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMaxseq()
/*     */     {
/* 452 */       HulaWorldInfo.this._xdb_verify_unsafe_();
/* 453 */       return HulaWorldInfo.this.maxseq;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMaxseq(int _v_)
/*     */     {
/* 460 */       HulaWorldInfo.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 467 */       HulaWorldInfo.this._xdb_verify_unsafe_();
/* 468 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 474 */       HulaWorldInfo.this._xdb_verify_unsafe_();
/* 475 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 481 */       return HulaWorldInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 487 */       return HulaWorldInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 493 */       HulaWorldInfo.this._xdb_verify_unsafe_();
/* 494 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 500 */       return HulaWorldInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 506 */       return HulaWorldInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 512 */       HulaWorldInfo.this._xdb_verify_unsafe_();
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 519 */       return HulaWorldInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 525 */       return HulaWorldInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 531 */       return HulaWorldInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 537 */       return HulaWorldInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 543 */       return HulaWorldInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 549 */       return HulaWorldInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 555 */       return HulaWorldInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.HulaWorldInfo
/*     */   {
/*     */     private LinkedList<xbean.HulaMonsterInfo> monsters;
/*     */     
/*     */     private HashSet<Long> roleids;
/*     */     
/*     */     private int maxseq;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 571 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 576 */       this.monsters = new LinkedList();
/* 577 */       this.roleids = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.HulaWorldInfo _o1_)
/*     */     {
/* 582 */       if ((_o1_ instanceof HulaWorldInfo)) { assign((HulaWorldInfo)_o1_);
/* 583 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 584 */       } else if ((_o1_ instanceof HulaWorldInfo.Const)) assign(((HulaWorldInfo.Const)_o1_).nThis()); else {
/* 585 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(HulaWorldInfo _o_) {
/* 590 */       this.monsters = new LinkedList();
/* 591 */       for (xbean.HulaMonsterInfo _v_ : _o_.monsters)
/* 592 */         this.monsters.add(new HulaMonsterInfo.Data(_v_));
/* 593 */       this.roleids = new HashSet();
/* 594 */       this.roleids.addAll(_o_.roleids);
/* 595 */       this.maxseq = _o_.maxseq;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 600 */       this.monsters = new LinkedList();
/* 601 */       for (xbean.HulaMonsterInfo _v_ : _o_.monsters)
/* 602 */         this.monsters.add(new HulaMonsterInfo.Data(_v_));
/* 603 */       this.roleids = new HashSet();
/* 604 */       this.roleids.addAll(_o_.roleids);
/* 605 */       this.maxseq = _o_.maxseq;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 611 */       _os_.compact_uint32(this.monsters.size());
/* 612 */       for (xbean.HulaMonsterInfo _v_ : this.monsters)
/*     */       {
/* 614 */         _v_.marshal(_os_);
/*     */       }
/* 616 */       _os_.compact_uint32(this.roleids.size());
/* 617 */       for (Long _v_ : this.roleids)
/*     */       {
/* 619 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 621 */       _os_.marshal(this.maxseq);
/* 622 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 628 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 630 */         xbean.HulaMonsterInfo _v_ = xbean.Pod.newHulaMonsterInfoData();
/* 631 */         _v_.unmarshal(_os_);
/* 632 */         this.monsters.add(_v_);
/*     */       }
/* 634 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 636 */         long _v_ = 0L;
/* 637 */         _v_ = _os_.unmarshal_long();
/* 638 */         this.roleids.add(Long.valueOf(_v_));
/*     */       }
/* 640 */       this.maxseq = _os_.unmarshal_int();
/* 641 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 647 */       int _size_ = 0;
/* 648 */       for (xbean.HulaMonsterInfo _v_ : this.monsters)
/*     */       {
/* 650 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 652 */       for (Long _v_ : this.roleids)
/*     */       {
/* 654 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */       }
/* 656 */       _size_ += CodedOutputStream.computeInt32Size(3, this.maxseq);
/* 657 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 665 */         for (xbean.HulaMonsterInfo _v_ : this.monsters)
/*     */         {
/* 667 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 669 */         for (Long _v_ : this.roleids)
/*     */         {
/* 671 */           _output_.writeInt64(2, _v_.longValue());
/*     */         }
/* 673 */         _output_.writeInt32(3, this.maxseq);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 677 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 679 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 687 */         boolean done = false;
/* 688 */         while (!done)
/*     */         {
/* 690 */           int tag = _input_.readTag();
/* 691 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 695 */             done = true;
/* 696 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 700 */             xbean.HulaMonsterInfo _v_ = xbean.Pod.newHulaMonsterInfoData();
/* 701 */             _input_.readMessage(_v_);
/* 702 */             this.monsters.add(_v_);
/* 703 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 707 */             long _v_ = 0L;
/* 708 */             _v_ = _input_.readInt64();
/* 709 */             this.roleids.add(Long.valueOf(_v_));
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.maxseq = _input_.readInt32();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 719 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 721 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 730 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 734 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 736 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HulaWorldInfo copy()
/*     */     {
/* 742 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HulaWorldInfo toData()
/*     */     {
/* 748 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.HulaWorldInfo toBean()
/*     */     {
/* 753 */       return new HulaWorldInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HulaWorldInfo toDataIf()
/*     */     {
/* 759 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.HulaWorldInfo toBeanIf()
/*     */     {
/* 764 */       return new HulaWorldInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 770 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 774 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 778 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 782 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 786 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 790 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 794 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.HulaMonsterInfo> getMonsters()
/*     */     {
/* 801 */       return this.monsters;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.HulaMonsterInfo> getMonstersAsData()
/*     */     {
/* 808 */       return this.monsters;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRoleids()
/*     */     {
/* 815 */       return this.roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRoleidsAsData()
/*     */     {
/* 822 */       return this.roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMaxseq()
/*     */     {
/* 829 */       return this.maxseq;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMaxseq(int _v_)
/*     */     {
/* 836 */       this.maxseq = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 842 */       if (!(_o1_ instanceof Data)) return false;
/* 843 */       Data _o_ = (Data)_o1_;
/* 844 */       if (!this.monsters.equals(_o_.monsters)) return false;
/* 845 */       if (!this.roleids.equals(_o_.roleids)) return false;
/* 846 */       if (this.maxseq != _o_.maxseq) return false;
/* 847 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 853 */       int _h_ = 0;
/* 854 */       _h_ += this.monsters.hashCode();
/* 855 */       _h_ += this.roleids.hashCode();
/* 856 */       _h_ += this.maxseq;
/* 857 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 863 */       StringBuilder _sb_ = new StringBuilder();
/* 864 */       _sb_.append("(");
/* 865 */       _sb_.append(this.monsters);
/* 866 */       _sb_.append(",");
/* 867 */       _sb_.append(this.roleids);
/* 868 */       _sb_.append(",");
/* 869 */       _sb_.append(this.maxseq);
/* 870 */       _sb_.append(")");
/* 871 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\HulaWorldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
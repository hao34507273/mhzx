/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class RoleGiveFlowerRank extends XBean implements xbean.RoleGiveFlowerRank
/*     */ {
/*     */   private LinkedList<xbean.RoleGiveFlowerBean> rankdatas;
/*     */   private int version;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.rankdatas.clear();
/*  21 */     this.version = 0;
/*     */   }
/*     */   
/*     */   RoleGiveFlowerRank(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.rankdatas = new LinkedList();
/*  28 */     this.version = 0;
/*     */   }
/*     */   
/*     */   public RoleGiveFlowerRank()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleGiveFlowerRank(RoleGiveFlowerRank _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleGiveFlowerRank(xbean.RoleGiveFlowerRank _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof RoleGiveFlowerRank)) { assign((RoleGiveFlowerRank)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleGiveFlowerRank _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.rankdatas = new LinkedList();
/*  54 */     for (xbean.RoleGiveFlowerBean _v_ : _o_.rankdatas)
/*  55 */       this.rankdatas.add(new RoleGiveFlowerBean(_v_, this, "rankdatas"));
/*  56 */     this.version = _o_.version;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.rankdatas = new LinkedList();
/*  62 */     for (xbean.RoleGiveFlowerBean _v_ : _o_.rankdatas)
/*  63 */       this.rankdatas.add(new RoleGiveFlowerBean(_v_, this, "rankdatas"));
/*  64 */     this.version = _o_.version;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.compact_uint32(this.rankdatas.size());
/*  72 */     for (xbean.RoleGiveFlowerBean _v_ : this.rankdatas)
/*     */     {
/*  74 */       _v_.marshal(_os_);
/*     */     }
/*  76 */     _os_.marshal(this.version);
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  86 */       xbean.RoleGiveFlowerBean _v_ = new RoleGiveFlowerBean(0, this, "rankdatas");
/*  87 */       _v_.unmarshal(_os_);
/*  88 */       this.rankdatas.add(_v_);
/*     */     }
/*  90 */     this.version = _os_.unmarshal_int();
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     int _size_ = 0;
/*  99 */     for (xbean.RoleGiveFlowerBean _v_ : this.rankdatas)
/*     */     {
/* 101 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 103 */     _size_ += CodedOutputStream.computeInt32Size(2, this.version);
/* 104 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 113 */       for (xbean.RoleGiveFlowerBean _v_ : this.rankdatas)
/*     */       {
/* 115 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 117 */       _output_.writeInt32(2, this.version);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 121 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 123 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 129 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 132 */       boolean done = false;
/* 133 */       while (!done)
/*     */       {
/* 135 */         int tag = _input_.readTag();
/* 136 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 140 */           done = true;
/* 141 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 145 */           xbean.RoleGiveFlowerBean _v_ = new RoleGiveFlowerBean(0, this, "rankdatas");
/* 146 */           _input_.readMessage(_v_);
/* 147 */           this.rankdatas.add(_v_);
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 152 */           this.version = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 157 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 159 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 168 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 172 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 174 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleGiveFlowerRank copy()
/*     */   {
/* 180 */     _xdb_verify_unsafe_();
/* 181 */     return new RoleGiveFlowerRank(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleGiveFlowerRank toData()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleGiveFlowerRank toBean()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new RoleGiveFlowerRank(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleGiveFlowerRank toDataIf()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleGiveFlowerRank toBeanIf()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.RoleGiveFlowerBean> getRankdatas()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return xdb.Logs.logList(new LogKey(this, "rankdatas"), this.rankdatas);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.RoleGiveFlowerBean> getRankdatasAsData()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/*     */     
/* 230 */     RoleGiveFlowerRank _o_ = this;
/* 231 */     List<xbean.RoleGiveFlowerBean> rankdatas = new LinkedList();
/* 232 */     for (xbean.RoleGiveFlowerBean _v_ : _o_.rankdatas)
/* 233 */       rankdatas.add(new RoleGiveFlowerBean.Data(_v_));
/* 234 */     return rankdatas;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getVersion()
/*     */   {
/* 241 */     _xdb_verify_unsafe_();
/* 242 */     return this.version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setVersion(int _v_)
/*     */   {
/* 249 */     _xdb_verify_unsafe_();
/* 250 */     xdb.Logs.logIf(new LogKey(this, "version")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 254 */         new xdb.logs.LogInt(this, RoleGiveFlowerRank.this.version)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 258 */             RoleGiveFlowerRank.this.version = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 262 */     });
/* 263 */     this.version = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     RoleGiveFlowerRank _o_ = null;
/* 271 */     if ((_o1_ instanceof RoleGiveFlowerRank)) { _o_ = (RoleGiveFlowerRank)_o1_;
/* 272 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 273 */       return false;
/* 274 */     if (!this.rankdatas.equals(_o_.rankdatas)) return false;
/* 275 */     if (this.version != _o_.version) return false;
/* 276 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/* 283 */     int _h_ = 0;
/* 284 */     _h_ += this.rankdatas.hashCode();
/* 285 */     _h_ += this.version;
/* 286 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/* 293 */     StringBuilder _sb_ = new StringBuilder();
/* 294 */     _sb_.append("(");
/* 295 */     _sb_.append(this.rankdatas);
/* 296 */     _sb_.append(",");
/* 297 */     _sb_.append(this.version);
/* 298 */     _sb_.append(")");
/* 299 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 305 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 306 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rankdatas"));
/* 307 */     lb.add(new xdb.logs.ListenableChanged().setVarName("version"));
/* 308 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleGiveFlowerRank {
/*     */     private Const() {}
/*     */     
/*     */     RoleGiveFlowerRank nThis() {
/* 315 */       return RoleGiveFlowerRank.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 321 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGiveFlowerRank copy()
/*     */     {
/* 327 */       return RoleGiveFlowerRank.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGiveFlowerRank toData()
/*     */     {
/* 333 */       return RoleGiveFlowerRank.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleGiveFlowerRank toBean()
/*     */     {
/* 338 */       return RoleGiveFlowerRank.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGiveFlowerRank toDataIf()
/*     */     {
/* 344 */       return RoleGiveFlowerRank.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleGiveFlowerRank toBeanIf()
/*     */     {
/* 349 */       return RoleGiveFlowerRank.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.RoleGiveFlowerBean> getRankdatas()
/*     */     {
/* 356 */       RoleGiveFlowerRank.this._xdb_verify_unsafe_();
/* 357 */       return xdb.Consts.constList(RoleGiveFlowerRank.this.rankdatas);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.RoleGiveFlowerBean> getRankdatasAsData()
/*     */     {
/* 363 */       RoleGiveFlowerRank.this._xdb_verify_unsafe_();
/*     */       
/* 365 */       RoleGiveFlowerRank _o_ = RoleGiveFlowerRank.this;
/* 366 */       List<xbean.RoleGiveFlowerBean> rankdatas = new LinkedList();
/* 367 */       for (xbean.RoleGiveFlowerBean _v_ : _o_.rankdatas)
/* 368 */         rankdatas.add(new RoleGiveFlowerBean.Data(_v_));
/* 369 */       return rankdatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getVersion()
/*     */     {
/* 376 */       RoleGiveFlowerRank.this._xdb_verify_unsafe_();
/* 377 */       return RoleGiveFlowerRank.this.version;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setVersion(int _v_)
/*     */     {
/* 384 */       RoleGiveFlowerRank.this._xdb_verify_unsafe_();
/* 385 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 391 */       RoleGiveFlowerRank.this._xdb_verify_unsafe_();
/* 392 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 398 */       RoleGiveFlowerRank.this._xdb_verify_unsafe_();
/* 399 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 405 */       return RoleGiveFlowerRank.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 411 */       return RoleGiveFlowerRank.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 417 */       RoleGiveFlowerRank.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 424 */       return RoleGiveFlowerRank.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 430 */       return RoleGiveFlowerRank.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 436 */       RoleGiveFlowerRank.this._xdb_verify_unsafe_();
/* 437 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 443 */       return RoleGiveFlowerRank.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 449 */       return RoleGiveFlowerRank.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 455 */       return RoleGiveFlowerRank.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 461 */       return RoleGiveFlowerRank.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 467 */       return RoleGiveFlowerRank.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 473 */       return RoleGiveFlowerRank.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 479 */       return RoleGiveFlowerRank.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleGiveFlowerRank
/*     */   {
/*     */     private LinkedList<xbean.RoleGiveFlowerBean> rankdatas;
/*     */     
/*     */     private int version;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 493 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 498 */       this.rankdatas = new LinkedList();
/* 499 */       this.version = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.RoleGiveFlowerRank _o1_)
/*     */     {
/* 504 */       if ((_o1_ instanceof RoleGiveFlowerRank)) { assign((RoleGiveFlowerRank)_o1_);
/* 505 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 506 */       } else if ((_o1_ instanceof RoleGiveFlowerRank.Const)) assign(((RoleGiveFlowerRank.Const)_o1_).nThis()); else {
/* 507 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleGiveFlowerRank _o_) {
/* 512 */       this.rankdatas = new LinkedList();
/* 513 */       for (xbean.RoleGiveFlowerBean _v_ : _o_.rankdatas)
/* 514 */         this.rankdatas.add(new RoleGiveFlowerBean.Data(_v_));
/* 515 */       this.version = _o_.version;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 520 */       this.rankdatas = new LinkedList();
/* 521 */       for (xbean.RoleGiveFlowerBean _v_ : _o_.rankdatas)
/* 522 */         this.rankdatas.add(new RoleGiveFlowerBean.Data(_v_));
/* 523 */       this.version = _o_.version;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 529 */       _os_.compact_uint32(this.rankdatas.size());
/* 530 */       for (xbean.RoleGiveFlowerBean _v_ : this.rankdatas)
/*     */       {
/* 532 */         _v_.marshal(_os_);
/*     */       }
/* 534 */       _os_.marshal(this.version);
/* 535 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 541 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 543 */         xbean.RoleGiveFlowerBean _v_ = xbean.Pod.newRoleGiveFlowerBeanData();
/* 544 */         _v_.unmarshal(_os_);
/* 545 */         this.rankdatas.add(_v_);
/*     */       }
/* 547 */       this.version = _os_.unmarshal_int();
/* 548 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 554 */       int _size_ = 0;
/* 555 */       for (xbean.RoleGiveFlowerBean _v_ : this.rankdatas)
/*     */       {
/* 557 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 559 */       _size_ += CodedOutputStream.computeInt32Size(2, this.version);
/* 560 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 568 */         for (xbean.RoleGiveFlowerBean _v_ : this.rankdatas)
/*     */         {
/* 570 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 572 */         _output_.writeInt32(2, this.version);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 576 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 578 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 586 */         boolean done = false;
/* 587 */         while (!done)
/*     */         {
/* 589 */           int tag = _input_.readTag();
/* 590 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 594 */             done = true;
/* 595 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 599 */             xbean.RoleGiveFlowerBean _v_ = xbean.Pod.newRoleGiveFlowerBeanData();
/* 600 */             _input_.readMessage(_v_);
/* 601 */             this.rankdatas.add(_v_);
/* 602 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 606 */             this.version = _input_.readInt32();
/* 607 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 611 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 613 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 622 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 626 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 628 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGiveFlowerRank copy()
/*     */     {
/* 634 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGiveFlowerRank toData()
/*     */     {
/* 640 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleGiveFlowerRank toBean()
/*     */     {
/* 645 */       return new RoleGiveFlowerRank(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGiveFlowerRank toDataIf()
/*     */     {
/* 651 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleGiveFlowerRank toBeanIf()
/*     */     {
/* 656 */       return new RoleGiveFlowerRank(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 662 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 666 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 670 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 674 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 678 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 682 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 686 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.RoleGiveFlowerBean> getRankdatas()
/*     */     {
/* 693 */       return this.rankdatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.RoleGiveFlowerBean> getRankdatasAsData()
/*     */     {
/* 700 */       return this.rankdatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getVersion()
/*     */     {
/* 707 */       return this.version;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setVersion(int _v_)
/*     */     {
/* 714 */       this.version = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 720 */       if (!(_o1_ instanceof Data)) return false;
/* 721 */       Data _o_ = (Data)_o1_;
/* 722 */       if (!this.rankdatas.equals(_o_.rankdatas)) return false;
/* 723 */       if (this.version != _o_.version) return false;
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 730 */       int _h_ = 0;
/* 731 */       _h_ += this.rankdatas.hashCode();
/* 732 */       _h_ += this.version;
/* 733 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 739 */       StringBuilder _sb_ = new StringBuilder();
/* 740 */       _sb_.append("(");
/* 741 */       _sb_.append(this.rankdatas);
/* 742 */       _sb_.append(",");
/* 743 */       _sb_.append(this.version);
/* 744 */       _sb_.append(")");
/* 745 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleGiveFlowerRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
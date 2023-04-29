/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class RoleShangHuiItem extends XBean implements xbean.RoleShangHuiItem
/*     */ {
/*     */   private long shanghuiitemid;
/*     */   private int buynum;
/*     */   private int sellnum;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.shanghuiitemid = 0L;
/*  23 */     this.buynum = 0;
/*  24 */     this.sellnum = 0;
/*     */   }
/*     */   
/*     */   RoleShangHuiItem(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public RoleShangHuiItem()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleShangHuiItem(RoleShangHuiItem _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleShangHuiItem(xbean.RoleShangHuiItem _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof RoleShangHuiItem)) { assign((RoleShangHuiItem)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleShangHuiItem _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.shanghuiitemid = _o_.shanghuiitemid;
/*  55 */     this.buynum = _o_.buynum;
/*  56 */     this.sellnum = _o_.sellnum;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.shanghuiitemid = _o_.shanghuiitemid;
/*  62 */     this.buynum = _o_.buynum;
/*  63 */     this.sellnum = _o_.sellnum;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.shanghuiitemid);
/*  71 */     _os_.marshal(this.buynum);
/*  72 */     _os_.marshal(this.sellnum);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.shanghuiitemid = _os_.unmarshal_long();
/*  81 */     this.buynum = _os_.unmarshal_int();
/*  82 */     this.sellnum = _os_.unmarshal_int();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt64Size(1, this.shanghuiitemid);
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(2, this.buynum);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(3, this.sellnum);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt64(1, this.shanghuiitemid);
/* 104 */       _output_.writeInt32(2, this.buynum);
/* 105 */       _output_.writeInt32(3, this.sellnum);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           this.shanghuiitemid = _input_.readInt64();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.buynum = _input_.readInt32();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.sellnum = _input_.readInt32();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 148 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 150 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 159 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 165 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleShangHuiItem copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new RoleShangHuiItem(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleShangHuiItem toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleShangHuiItem toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new RoleShangHuiItem(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleShangHuiItem toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleShangHuiItem toBeanIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getShanghuiitemid()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.shanghuiitemid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getBuynum()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.buynum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSellnum()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.sellnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setShanghuiitemid(long _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "shanghuiitemid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogLong(this, RoleShangHuiItem.this.shanghuiitemid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             RoleShangHuiItem.this.shanghuiitemid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.shanghuiitemid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBuynum(int _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "buynum")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogInt(this, RoleShangHuiItem.this.buynum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             RoleShangHuiItem.this.buynum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.buynum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSellnum(int _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "sellnum")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogInt(this, RoleShangHuiItem.this.sellnum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             RoleShangHuiItem.this.sellnum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.sellnum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     RoleShangHuiItem _o_ = null;
/* 300 */     if ((_o1_ instanceof RoleShangHuiItem)) { _o_ = (RoleShangHuiItem)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.shanghuiitemid != _o_.shanghuiitemid) return false;
/* 304 */     if (this.buynum != _o_.buynum) return false;
/* 305 */     if (this.sellnum != _o_.sellnum) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ = (int)(_h_ + this.shanghuiitemid);
/* 315 */     _h_ += this.buynum;
/* 316 */     _h_ += this.sellnum;
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.shanghuiitemid);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.buynum);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.sellnum);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("shanghuiitemid"));
/* 340 */     lb.add(new ListenableChanged().setVarName("buynum"));
/* 341 */     lb.add(new ListenableChanged().setVarName("sellnum"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleShangHuiItem {
/*     */     private Const() {}
/*     */     
/*     */     RoleShangHuiItem nThis() {
/* 349 */       return RoleShangHuiItem.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleShangHuiItem copy()
/*     */     {
/* 361 */       return RoleShangHuiItem.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleShangHuiItem toData()
/*     */     {
/* 367 */       return RoleShangHuiItem.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleShangHuiItem toBean()
/*     */     {
/* 372 */       return RoleShangHuiItem.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleShangHuiItem toDataIf()
/*     */     {
/* 378 */       return RoleShangHuiItem.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleShangHuiItem toBeanIf()
/*     */     {
/* 383 */       return RoleShangHuiItem.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getShanghuiitemid()
/*     */     {
/* 390 */       RoleShangHuiItem.this._xdb_verify_unsafe_();
/* 391 */       return RoleShangHuiItem.this.shanghuiitemid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBuynum()
/*     */     {
/* 398 */       RoleShangHuiItem.this._xdb_verify_unsafe_();
/* 399 */       return RoleShangHuiItem.this.buynum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSellnum()
/*     */     {
/* 406 */       RoleShangHuiItem.this._xdb_verify_unsafe_();
/* 407 */       return RoleShangHuiItem.this.sellnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setShanghuiitemid(long _v_)
/*     */     {
/* 414 */       RoleShangHuiItem.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBuynum(int _v_)
/*     */     {
/* 422 */       RoleShangHuiItem.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSellnum(int _v_)
/*     */     {
/* 430 */       RoleShangHuiItem.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       RoleShangHuiItem.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       RoleShangHuiItem.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return RoleShangHuiItem.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return RoleShangHuiItem.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       RoleShangHuiItem.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return RoleShangHuiItem.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return RoleShangHuiItem.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       RoleShangHuiItem.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return RoleShangHuiItem.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return RoleShangHuiItem.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return RoleShangHuiItem.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return RoleShangHuiItem.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return RoleShangHuiItem.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return RoleShangHuiItem.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return RoleShangHuiItem.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleShangHuiItem
/*     */   {
/*     */     private long shanghuiitemid;
/*     */     
/*     */     private int buynum;
/*     */     
/*     */     private int sellnum;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.RoleShangHuiItem _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof RoleShangHuiItem)) { assign((RoleShangHuiItem)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof RoleShangHuiItem.Const)) assign(((RoleShangHuiItem.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleShangHuiItem _o_) {
/* 558 */       this.shanghuiitemid = _o_.shanghuiitemid;
/* 559 */       this.buynum = _o_.buynum;
/* 560 */       this.sellnum = _o_.sellnum;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.shanghuiitemid = _o_.shanghuiitemid;
/* 566 */       this.buynum = _o_.buynum;
/* 567 */       this.sellnum = _o_.sellnum;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.shanghuiitemid);
/* 574 */       _os_.marshal(this.buynum);
/* 575 */       _os_.marshal(this.sellnum);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.shanghuiitemid = _os_.unmarshal_long();
/* 583 */       this.buynum = _os_.unmarshal_int();
/* 584 */       this.sellnum = _os_.unmarshal_int();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt64Size(1, this.shanghuiitemid);
/* 593 */       _size_ += CodedOutputStream.computeInt32Size(2, this.buynum);
/* 594 */       _size_ += CodedOutputStream.computeInt32Size(3, this.sellnum);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt64(1, this.shanghuiitemid);
/* 604 */         _output_.writeInt32(2, this.buynum);
/* 605 */         _output_.writeInt32(3, this.sellnum);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.shanghuiitemid = _input_.readInt64();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.buynum = _input_.readInt32();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.sellnum = _input_.readInt32();
/* 643 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 647 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 649 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 658 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 662 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 664 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleShangHuiItem copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleShangHuiItem toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleShangHuiItem toBean()
/*     */     {
/* 681 */       return new RoleShangHuiItem(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleShangHuiItem toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleShangHuiItem toBeanIf()
/*     */     {
/* 692 */       return new RoleShangHuiItem(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 698 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 718 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getShanghuiitemid()
/*     */     {
/* 729 */       return this.shanghuiitemid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBuynum()
/*     */     {
/* 736 */       return this.buynum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSellnum()
/*     */     {
/* 743 */       return this.sellnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setShanghuiitemid(long _v_)
/*     */     {
/* 750 */       this.shanghuiitemid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBuynum(int _v_)
/*     */     {
/* 757 */       this.buynum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSellnum(int _v_)
/*     */     {
/* 764 */       this.sellnum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.shanghuiitemid != _o_.shanghuiitemid) return false;
/* 773 */       if (this.buynum != _o_.buynum) return false;
/* 774 */       if (this.sellnum != _o_.sellnum) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ = (int)(_h_ + this.shanghuiitemid);
/* 783 */       _h_ += this.buynum;
/* 784 */       _h_ += this.sellnum;
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.shanghuiitemid);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.buynum);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.sellnum);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleShangHuiItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class ItemSale extends XBean implements xbean.ItemSale
/*     */ {
/*     */   private long totalsellnum;
/*     */   private long totalsellmoney;
/*     */   private int recommendprice;
/*     */   private int totalgridnum;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.totalsellnum = 0L;
/*  25 */     this.totalsellmoney = 0L;
/*  26 */     this.recommendprice = 0;
/*  27 */     this.totalgridnum = 0;
/*     */   }
/*     */   
/*     */   ItemSale(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public ItemSale()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ItemSale(ItemSale _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ItemSale(xbean.ItemSale _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof ItemSale)) { assign((ItemSale)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ItemSale _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.totalsellnum = _o_.totalsellnum;
/*  58 */     this.totalsellmoney = _o_.totalsellmoney;
/*  59 */     this.recommendprice = _o_.recommendprice;
/*  60 */     this.totalgridnum = _o_.totalgridnum;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.totalsellnum = _o_.totalsellnum;
/*  66 */     this.totalsellmoney = _o_.totalsellmoney;
/*  67 */     this.recommendprice = _o_.recommendprice;
/*  68 */     this.totalgridnum = _o_.totalgridnum;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.totalsellnum);
/*  76 */     _os_.marshal(this.totalsellmoney);
/*  77 */     _os_.marshal(this.recommendprice);
/*  78 */     _os_.marshal(this.totalgridnum);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.totalsellnum = _os_.unmarshal_long();
/*  87 */     this.totalsellmoney = _os_.unmarshal_long();
/*  88 */     this.recommendprice = _os_.unmarshal_int();
/*  89 */     this.totalgridnum = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt64Size(1, this.totalsellnum);
/*  99 */     _size_ += CodedOutputStream.computeInt64Size(2, this.totalsellmoney);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(3, this.recommendprice);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(4, this.totalgridnum);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt64(1, this.totalsellnum);
/* 112 */       _output_.writeInt64(2, this.totalsellmoney);
/* 113 */       _output_.writeInt32(3, this.recommendprice);
/* 114 */       _output_.writeInt32(4, this.totalgridnum);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 118 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 120 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       boolean done = false;
/* 130 */       while (!done)
/*     */       {
/* 132 */         int tag = _input_.readTag();
/* 133 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 137 */           done = true;
/* 138 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 142 */           this.totalsellnum = _input_.readInt64();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.totalsellmoney = _input_.readInt64();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.recommendprice = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.totalgridnum = _input_.readInt32();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 162 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 164 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 173 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 177 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 179 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ItemSale copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new ItemSale(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ItemSale toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ItemSale toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new ItemSale(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ItemSale toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ItemSale toBeanIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTotalsellnum()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.totalsellnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTotalsellmoney()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.totalsellmoney;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRecommendprice()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.recommendprice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTotalgridnum()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.totalgridnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalsellnum(long _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "totalsellnum")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 263 */         new xdb.logs.LogLong(this, ItemSale.this.totalsellnum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             ItemSale.this.totalsellnum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.totalsellnum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalsellmoney(long _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "totalsellmoney")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 284 */         new xdb.logs.LogLong(this, ItemSale.this.totalsellmoney)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             ItemSale.this.totalsellmoney = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.totalsellmoney = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRecommendprice(int _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "recommendprice")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 305 */         new xdb.logs.LogInt(this, ItemSale.this.recommendprice)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             ItemSale.this.recommendprice = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.recommendprice = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalgridnum(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "totalgridnum")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 326 */         new xdb.logs.LogInt(this, ItemSale.this.totalgridnum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             ItemSale.this.totalgridnum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.totalgridnum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     ItemSale _o_ = null;
/* 343 */     if ((_o1_ instanceof ItemSale)) { _o_ = (ItemSale)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.totalsellnum != _o_.totalsellnum) return false;
/* 347 */     if (this.totalsellmoney != _o_.totalsellmoney) return false;
/* 348 */     if (this.recommendprice != _o_.recommendprice) return false;
/* 349 */     if (this.totalgridnum != _o_.totalgridnum) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ = (int)(_h_ + this.totalsellnum);
/* 359 */     _h_ = (int)(_h_ + this.totalsellmoney);
/* 360 */     _h_ += this.recommendprice;
/* 361 */     _h_ += this.totalgridnum;
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.totalsellnum);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.totalsellmoney);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.recommendprice);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.totalgridnum);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("totalsellnum"));
/* 387 */     lb.add(new ListenableChanged().setVarName("totalsellmoney"));
/* 388 */     lb.add(new ListenableChanged().setVarName("recommendprice"));
/* 389 */     lb.add(new ListenableChanged().setVarName("totalgridnum"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ItemSale {
/*     */     private Const() {}
/*     */     
/*     */     ItemSale nThis() {
/* 397 */       return ItemSale.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ItemSale copy()
/*     */     {
/* 409 */       return ItemSale.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ItemSale toData()
/*     */     {
/* 415 */       return ItemSale.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ItemSale toBean()
/*     */     {
/* 420 */       return ItemSale.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ItemSale toDataIf()
/*     */     {
/* 426 */       return ItemSale.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ItemSale toBeanIf()
/*     */     {
/* 431 */       return ItemSale.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTotalsellnum()
/*     */     {
/* 438 */       ItemSale.this._xdb_verify_unsafe_();
/* 439 */       return ItemSale.this.totalsellnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTotalsellmoney()
/*     */     {
/* 446 */       ItemSale.this._xdb_verify_unsafe_();
/* 447 */       return ItemSale.this.totalsellmoney;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRecommendprice()
/*     */     {
/* 454 */       ItemSale.this._xdb_verify_unsafe_();
/* 455 */       return ItemSale.this.recommendprice;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotalgridnum()
/*     */     {
/* 462 */       ItemSale.this._xdb_verify_unsafe_();
/* 463 */       return ItemSale.this.totalgridnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalsellnum(long _v_)
/*     */     {
/* 470 */       ItemSale.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalsellmoney(long _v_)
/*     */     {
/* 478 */       ItemSale.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRecommendprice(int _v_)
/*     */     {
/* 486 */       ItemSale.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalgridnum(int _v_)
/*     */     {
/* 494 */       ItemSale.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       ItemSale.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       ItemSale.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return ItemSale.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return ItemSale.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       ItemSale.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return ItemSale.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return ItemSale.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       ItemSale.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return ItemSale.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return ItemSale.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return ItemSale.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return ItemSale.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return ItemSale.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return ItemSale.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return ItemSale.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ItemSale
/*     */   {
/*     */     private long totalsellnum;
/*     */     
/*     */     private long totalsellmoney;
/*     */     
/*     */     private int recommendprice;
/*     */     
/*     */     private int totalgridnum;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 607 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.ItemSale _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof ItemSale)) { assign((ItemSale)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof ItemSale.Const)) assign(((ItemSale.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ItemSale _o_) {
/* 624 */       this.totalsellnum = _o_.totalsellnum;
/* 625 */       this.totalsellmoney = _o_.totalsellmoney;
/* 626 */       this.recommendprice = _o_.recommendprice;
/* 627 */       this.totalgridnum = _o_.totalgridnum;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.totalsellnum = _o_.totalsellnum;
/* 633 */       this.totalsellmoney = _o_.totalsellmoney;
/* 634 */       this.recommendprice = _o_.recommendprice;
/* 635 */       this.totalgridnum = _o_.totalgridnum;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.totalsellnum);
/* 642 */       _os_.marshal(this.totalsellmoney);
/* 643 */       _os_.marshal(this.recommendprice);
/* 644 */       _os_.marshal(this.totalgridnum);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.totalsellnum = _os_.unmarshal_long();
/* 652 */       this.totalsellmoney = _os_.unmarshal_long();
/* 653 */       this.recommendprice = _os_.unmarshal_int();
/* 654 */       this.totalgridnum = _os_.unmarshal_int();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt64Size(1, this.totalsellnum);
/* 663 */       _size_ += CodedOutputStream.computeInt64Size(2, this.totalsellmoney);
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(3, this.recommendprice);
/* 665 */       _size_ += CodedOutputStream.computeInt32Size(4, this.totalgridnum);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt64(1, this.totalsellnum);
/* 675 */         _output_.writeInt64(2, this.totalsellmoney);
/* 676 */         _output_.writeInt32(3, this.recommendprice);
/* 677 */         _output_.writeInt32(4, this.totalgridnum);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 681 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 683 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 691 */         boolean done = false;
/* 692 */         while (!done)
/*     */         {
/* 694 */           int tag = _input_.readTag();
/* 695 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 699 */             done = true;
/* 700 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 704 */             this.totalsellnum = _input_.readInt64();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.totalsellmoney = _input_.readInt64();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.recommendprice = _input_.readInt32();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.totalgridnum = _input_.readInt32();
/* 720 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 724 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 726 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 735 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 739 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 741 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ItemSale copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ItemSale toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ItemSale toBean()
/*     */     {
/* 758 */       return new ItemSale(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ItemSale toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ItemSale toBeanIf()
/*     */     {
/* 769 */       return new ItemSale(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 775 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 795 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 799 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTotalsellnum()
/*     */     {
/* 806 */       return this.totalsellnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTotalsellmoney()
/*     */     {
/* 813 */       return this.totalsellmoney;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRecommendprice()
/*     */     {
/* 820 */       return this.recommendprice;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotalgridnum()
/*     */     {
/* 827 */       return this.totalgridnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalsellnum(long _v_)
/*     */     {
/* 834 */       this.totalsellnum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalsellmoney(long _v_)
/*     */     {
/* 841 */       this.totalsellmoney = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRecommendprice(int _v_)
/*     */     {
/* 848 */       this.recommendprice = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalgridnum(int _v_)
/*     */     {
/* 855 */       this.totalgridnum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.totalsellnum != _o_.totalsellnum) return false;
/* 864 */       if (this.totalsellmoney != _o_.totalsellmoney) return false;
/* 865 */       if (this.recommendprice != _o_.recommendprice) return false;
/* 866 */       if (this.totalgridnum != _o_.totalgridnum) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ = (int)(_h_ + this.totalsellnum);
/* 875 */       _h_ = (int)(_h_ + this.totalsellmoney);
/* 876 */       _h_ += this.recommendprice;
/* 877 */       _h_ += this.totalgridnum;
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.totalsellnum);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.totalsellmoney);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.recommendprice);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.totalgridnum);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ItemSale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
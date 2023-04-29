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
/*     */ public final class DisplayItem extends XBean implements xbean.DisplayItem
/*     */ {
/*     */   private int itemid;
/*     */   private int price;
/*     */   private long channelidornum;
/*     */   private long shoppingid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.itemid = 0;
/*  25 */     this.price = 0;
/*  26 */     this.channelidornum = 0L;
/*  27 */     this.shoppingid = 0L;
/*     */   }
/*     */   
/*     */   DisplayItem(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public DisplayItem()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public DisplayItem(DisplayItem _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   DisplayItem(xbean.DisplayItem _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof DisplayItem)) { assign((DisplayItem)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(DisplayItem _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.itemid = _o_.itemid;
/*  58 */     this.price = _o_.price;
/*  59 */     this.channelidornum = _o_.channelidornum;
/*  60 */     this.shoppingid = _o_.shoppingid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.itemid = _o_.itemid;
/*  66 */     this.price = _o_.price;
/*  67 */     this.channelidornum = _o_.channelidornum;
/*  68 */     this.shoppingid = _o_.shoppingid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.itemid);
/*  76 */     _os_.marshal(this.price);
/*  77 */     _os_.marshal(this.channelidornum);
/*  78 */     _os_.marshal(this.shoppingid);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.itemid = _os_.unmarshal_int();
/*  87 */     this.price = _os_.unmarshal_int();
/*  88 */     this.channelidornum = _os_.unmarshal_long();
/*  89 */     this.shoppingid = _os_.unmarshal_long();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt32Size(1, this.itemid);
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(2, this.price);
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(3, this.channelidornum);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(4, this.shoppingid);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt32(1, this.itemid);
/* 112 */       _output_.writeInt32(2, this.price);
/* 113 */       _output_.writeInt64(3, this.channelidornum);
/* 114 */       _output_.writeInt64(4, this.shoppingid);
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
/* 142 */           this.itemid = _input_.readInt32();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.price = _input_.readInt32();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.channelidornum = _input_.readInt64();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.shoppingid = _input_.readInt64();
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
/*     */   public xbean.DisplayItem copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new DisplayItem(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DisplayItem toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DisplayItem toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new DisplayItem(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DisplayItem toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DisplayItem toBeanIf()
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
/*     */   public int getItemid()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.itemid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPrice()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getChannelidornum()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.channelidornum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getShoppingid()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.shoppingid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setItemid(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "itemid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 263 */         new xdb.logs.LogInt(this, DisplayItem.this.itemid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             DisplayItem.this.itemid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.itemid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPrice(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "price")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 284 */         new xdb.logs.LogInt(this, DisplayItem.this.price)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             DisplayItem.this.price = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.price = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setChannelidornum(long _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "channelidornum")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 305 */         new xdb.logs.LogLong(this, DisplayItem.this.channelidornum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             DisplayItem.this.channelidornum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.channelidornum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setShoppingid(long _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "shoppingid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 326 */         new xdb.logs.LogLong(this, DisplayItem.this.shoppingid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             DisplayItem.this.shoppingid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.shoppingid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     DisplayItem _o_ = null;
/* 343 */     if ((_o1_ instanceof DisplayItem)) { _o_ = (DisplayItem)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.itemid != _o_.itemid) return false;
/* 347 */     if (this.price != _o_.price) return false;
/* 348 */     if (this.channelidornum != _o_.channelidornum) return false;
/* 349 */     if (this.shoppingid != _o_.shoppingid) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ += this.itemid;
/* 359 */     _h_ += this.price;
/* 360 */     _h_ = (int)(_h_ + this.channelidornum);
/* 361 */     _h_ = (int)(_h_ + this.shoppingid);
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.itemid);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.price);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.channelidornum);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.shoppingid);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("itemid"));
/* 387 */     lb.add(new ListenableChanged().setVarName("price"));
/* 388 */     lb.add(new ListenableChanged().setVarName("channelidornum"));
/* 389 */     lb.add(new ListenableChanged().setVarName("shoppingid"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.DisplayItem {
/*     */     private Const() {}
/*     */     
/*     */     DisplayItem nThis() {
/* 397 */       return DisplayItem.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DisplayItem copy()
/*     */     {
/* 409 */       return DisplayItem.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DisplayItem toData()
/*     */     {
/* 415 */       return DisplayItem.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.DisplayItem toBean()
/*     */     {
/* 420 */       return DisplayItem.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DisplayItem toDataIf()
/*     */     {
/* 426 */       return DisplayItem.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.DisplayItem toBeanIf()
/*     */     {
/* 431 */       return DisplayItem.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getItemid()
/*     */     {
/* 438 */       DisplayItem.this._xdb_verify_unsafe_();
/* 439 */       return DisplayItem.this.itemid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPrice()
/*     */     {
/* 446 */       DisplayItem.this._xdb_verify_unsafe_();
/* 447 */       return DisplayItem.this.price;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getChannelidornum()
/*     */     {
/* 454 */       DisplayItem.this._xdb_verify_unsafe_();
/* 455 */       return DisplayItem.this.channelidornum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getShoppingid()
/*     */     {
/* 462 */       DisplayItem.this._xdb_verify_unsafe_();
/* 463 */       return DisplayItem.this.shoppingid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setItemid(int _v_)
/*     */     {
/* 470 */       DisplayItem.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPrice(int _v_)
/*     */     {
/* 478 */       DisplayItem.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChannelidornum(long _v_)
/*     */     {
/* 486 */       DisplayItem.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setShoppingid(long _v_)
/*     */     {
/* 494 */       DisplayItem.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       DisplayItem.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       DisplayItem.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return DisplayItem.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return DisplayItem.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       DisplayItem.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return DisplayItem.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return DisplayItem.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       DisplayItem.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return DisplayItem.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return DisplayItem.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return DisplayItem.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return DisplayItem.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return DisplayItem.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return DisplayItem.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return DisplayItem.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.DisplayItem
/*     */   {
/*     */     private int itemid;
/*     */     
/*     */     private int price;
/*     */     
/*     */     private long channelidornum;
/*     */     
/*     */     private long shoppingid;
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
/*     */     Data(xbean.DisplayItem _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof DisplayItem)) { assign((DisplayItem)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof DisplayItem.Const)) assign(((DisplayItem.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(DisplayItem _o_) {
/* 624 */       this.itemid = _o_.itemid;
/* 625 */       this.price = _o_.price;
/* 626 */       this.channelidornum = _o_.channelidornum;
/* 627 */       this.shoppingid = _o_.shoppingid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.itemid = _o_.itemid;
/* 633 */       this.price = _o_.price;
/* 634 */       this.channelidornum = _o_.channelidornum;
/* 635 */       this.shoppingid = _o_.shoppingid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.itemid);
/* 642 */       _os_.marshal(this.price);
/* 643 */       _os_.marshal(this.channelidornum);
/* 644 */       _os_.marshal(this.shoppingid);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.itemid = _os_.unmarshal_int();
/* 652 */       this.price = _os_.unmarshal_int();
/* 653 */       this.channelidornum = _os_.unmarshal_long();
/* 654 */       this.shoppingid = _os_.unmarshal_long();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt32Size(1, this.itemid);
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.price);
/* 664 */       _size_ += CodedOutputStream.computeInt64Size(3, this.channelidornum);
/* 665 */       _size_ += CodedOutputStream.computeInt64Size(4, this.shoppingid);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt32(1, this.itemid);
/* 675 */         _output_.writeInt32(2, this.price);
/* 676 */         _output_.writeInt64(3, this.channelidornum);
/* 677 */         _output_.writeInt64(4, this.shoppingid);
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
/* 704 */             this.itemid = _input_.readInt32();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.price = _input_.readInt32();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.channelidornum = _input_.readInt64();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.shoppingid = _input_.readInt64();
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
/*     */     public xbean.DisplayItem copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DisplayItem toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.DisplayItem toBean()
/*     */     {
/* 758 */       return new DisplayItem(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DisplayItem toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.DisplayItem toBeanIf()
/*     */     {
/* 769 */       return new DisplayItem(this, null, null);
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
/*     */     public int getItemid()
/*     */     {
/* 806 */       return this.itemid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPrice()
/*     */     {
/* 813 */       return this.price;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getChannelidornum()
/*     */     {
/* 820 */       return this.channelidornum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getShoppingid()
/*     */     {
/* 827 */       return this.shoppingid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setItemid(int _v_)
/*     */     {
/* 834 */       this.itemid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPrice(int _v_)
/*     */     {
/* 841 */       this.price = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChannelidornum(long _v_)
/*     */     {
/* 848 */       this.channelidornum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setShoppingid(long _v_)
/*     */     {
/* 855 */       this.shoppingid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.itemid != _o_.itemid) return false;
/* 864 */       if (this.price != _o_.price) return false;
/* 865 */       if (this.channelidornum != _o_.channelidornum) return false;
/* 866 */       if (this.shoppingid != _o_.shoppingid) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ += this.itemid;
/* 875 */       _h_ += this.price;
/* 876 */       _h_ = (int)(_h_ + this.channelidornum);
/* 877 */       _h_ = (int)(_h_ + this.shoppingid);
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.itemid);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.price);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.channelidornum);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.shoppingid);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DisplayItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
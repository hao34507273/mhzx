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
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class FurnitureInfo extends XBean implements xbean.FurnitureInfo
/*     */ {
/*     */   private int x;
/*     */   private int y;
/*     */   private int direction;
/*     */   private int furnitureid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.x = 0;
/*  25 */     this.y = 0;
/*  26 */     this.direction = 0;
/*  27 */     this.furnitureid = 0;
/*     */   }
/*     */   
/*     */   FurnitureInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public FurnitureInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FurnitureInfo(FurnitureInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FurnitureInfo(xbean.FurnitureInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof FurnitureInfo)) { assign((FurnitureInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FurnitureInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.x = _o_.x;
/*  58 */     this.y = _o_.y;
/*  59 */     this.direction = _o_.direction;
/*  60 */     this.furnitureid = _o_.furnitureid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.x = _o_.x;
/*  66 */     this.y = _o_.y;
/*  67 */     this.direction = _o_.direction;
/*  68 */     this.furnitureid = _o_.furnitureid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.x);
/*  76 */     _os_.marshal(this.y);
/*  77 */     _os_.marshal(this.direction);
/*  78 */     _os_.marshal(this.furnitureid);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.x = _os_.unmarshal_int();
/*  87 */     this.y = _os_.unmarshal_int();
/*  88 */     this.direction = _os_.unmarshal_int();
/*  89 */     this.furnitureid = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt32Size(1, this.x);
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(2, this.y);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(3, this.direction);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(4, this.furnitureid);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt32(1, this.x);
/* 112 */       _output_.writeInt32(2, this.y);
/* 113 */       _output_.writeInt32(3, this.direction);
/* 114 */       _output_.writeInt32(4, this.furnitureid);
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
/* 142 */           this.x = _input_.readInt32();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.y = _input_.readInt32();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.direction = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.furnitureid = _input_.readInt32();
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
/*     */   public xbean.FurnitureInfo copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new FurnitureInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FurnitureInfo toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FurnitureInfo toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new FurnitureInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FurnitureInfo toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FurnitureInfo toBeanIf()
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
/*     */   public int getX()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.x;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getY()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.y;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getDirection()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.direction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getFurnitureid()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.furnitureid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setX(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "x")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new LogInt(this, FurnitureInfo.this.x)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             FurnitureInfo.this.x = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.x = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setY(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "y")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new LogInt(this, FurnitureInfo.this.y)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             FurnitureInfo.this.y = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.y = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDirection(int _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "direction")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 305 */         new LogInt(this, FurnitureInfo.this.direction)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             FurnitureInfo.this.direction = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.direction = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFurnitureid(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "furnitureid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new LogInt(this, FurnitureInfo.this.furnitureid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             FurnitureInfo.this.furnitureid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.furnitureid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     FurnitureInfo _o_ = null;
/* 343 */     if ((_o1_ instanceof FurnitureInfo)) { _o_ = (FurnitureInfo)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.x != _o_.x) return false;
/* 347 */     if (this.y != _o_.y) return false;
/* 348 */     if (this.direction != _o_.direction) return false;
/* 349 */     if (this.furnitureid != _o_.furnitureid) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ += this.x;
/* 359 */     _h_ += this.y;
/* 360 */     _h_ += this.direction;
/* 361 */     _h_ += this.furnitureid;
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.x);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.y);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.direction);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.furnitureid);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("x"));
/* 387 */     lb.add(new ListenableChanged().setVarName("y"));
/* 388 */     lb.add(new ListenableChanged().setVarName("direction"));
/* 389 */     lb.add(new ListenableChanged().setVarName("furnitureid"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FurnitureInfo {
/*     */     private Const() {}
/*     */     
/*     */     FurnitureInfo nThis() {
/* 397 */       return FurnitureInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FurnitureInfo copy()
/*     */     {
/* 409 */       return FurnitureInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FurnitureInfo toData()
/*     */     {
/* 415 */       return FurnitureInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FurnitureInfo toBean()
/*     */     {
/* 420 */       return FurnitureInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FurnitureInfo toDataIf()
/*     */     {
/* 426 */       return FurnitureInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FurnitureInfo toBeanIf()
/*     */     {
/* 431 */       return FurnitureInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getX()
/*     */     {
/* 438 */       FurnitureInfo.this._xdb_verify_unsafe_();
/* 439 */       return FurnitureInfo.this.x;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getY()
/*     */     {
/* 446 */       FurnitureInfo.this._xdb_verify_unsafe_();
/* 447 */       return FurnitureInfo.this.y;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDirection()
/*     */     {
/* 454 */       FurnitureInfo.this._xdb_verify_unsafe_();
/* 455 */       return FurnitureInfo.this.direction;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFurnitureid()
/*     */     {
/* 462 */       FurnitureInfo.this._xdb_verify_unsafe_();
/* 463 */       return FurnitureInfo.this.furnitureid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setX(int _v_)
/*     */     {
/* 470 */       FurnitureInfo.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setY(int _v_)
/*     */     {
/* 478 */       FurnitureInfo.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDirection(int _v_)
/*     */     {
/* 486 */       FurnitureInfo.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFurnitureid(int _v_)
/*     */     {
/* 494 */       FurnitureInfo.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       FurnitureInfo.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       FurnitureInfo.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return FurnitureInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return FurnitureInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       FurnitureInfo.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return FurnitureInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return FurnitureInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       FurnitureInfo.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return FurnitureInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return FurnitureInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return FurnitureInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return FurnitureInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return FurnitureInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return FurnitureInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return FurnitureInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FurnitureInfo
/*     */   {
/*     */     private int x;
/*     */     
/*     */     private int y;
/*     */     
/*     */     private int direction;
/*     */     
/*     */     private int furnitureid;
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
/*     */     Data(xbean.FurnitureInfo _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof FurnitureInfo)) { assign((FurnitureInfo)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof FurnitureInfo.Const)) assign(((FurnitureInfo.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FurnitureInfo _o_) {
/* 624 */       this.x = _o_.x;
/* 625 */       this.y = _o_.y;
/* 626 */       this.direction = _o_.direction;
/* 627 */       this.furnitureid = _o_.furnitureid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.x = _o_.x;
/* 633 */       this.y = _o_.y;
/* 634 */       this.direction = _o_.direction;
/* 635 */       this.furnitureid = _o_.furnitureid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.x);
/* 642 */       _os_.marshal(this.y);
/* 643 */       _os_.marshal(this.direction);
/* 644 */       _os_.marshal(this.furnitureid);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.x = _os_.unmarshal_int();
/* 652 */       this.y = _os_.unmarshal_int();
/* 653 */       this.direction = _os_.unmarshal_int();
/* 654 */       this.furnitureid = _os_.unmarshal_int();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt32Size(1, this.x);
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.y);
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(3, this.direction);
/* 665 */       _size_ += CodedOutputStream.computeInt32Size(4, this.furnitureid);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt32(1, this.x);
/* 675 */         _output_.writeInt32(2, this.y);
/* 676 */         _output_.writeInt32(3, this.direction);
/* 677 */         _output_.writeInt32(4, this.furnitureid);
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
/* 704 */             this.x = _input_.readInt32();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.y = _input_.readInt32();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.direction = _input_.readInt32();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.furnitureid = _input_.readInt32();
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
/*     */     public xbean.FurnitureInfo copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FurnitureInfo toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FurnitureInfo toBean()
/*     */     {
/* 758 */       return new FurnitureInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FurnitureInfo toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FurnitureInfo toBeanIf()
/*     */     {
/* 769 */       return new FurnitureInfo(this, null, null);
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
/*     */     public int getX()
/*     */     {
/* 806 */       return this.x;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getY()
/*     */     {
/* 813 */       return this.y;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDirection()
/*     */     {
/* 820 */       return this.direction;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFurnitureid()
/*     */     {
/* 827 */       return this.furnitureid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setX(int _v_)
/*     */     {
/* 834 */       this.x = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setY(int _v_)
/*     */     {
/* 841 */       this.y = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDirection(int _v_)
/*     */     {
/* 848 */       this.direction = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFurnitureid(int _v_)
/*     */     {
/* 855 */       this.furnitureid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.x != _o_.x) return false;
/* 864 */       if (this.y != _o_.y) return false;
/* 865 */       if (this.direction != _o_.direction) return false;
/* 866 */       if (this.furnitureid != _o_.furnitureid) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ += this.x;
/* 875 */       _h_ += this.y;
/* 876 */       _h_ += this.direction;
/* 877 */       _h_ += this.furnitureid;
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.x);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.y);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.direction);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.furnitureid);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FurnitureInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
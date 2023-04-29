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
/*     */ public final class ClothColor extends XBean implements xbean.ClothColor
/*     */ {
/*     */   private int id;
/*     */   private int hair;
/*     */   private int fashion_dress_cfg_id;
/*     */   private int cloth;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.id = 0;
/*  25 */     this.hair = 0;
/*  26 */     this.fashion_dress_cfg_id = 0;
/*  27 */     this.cloth = 0;
/*     */   }
/*     */   
/*     */   ClothColor(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public ClothColor()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ClothColor(ClothColor _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ClothColor(xbean.ClothColor _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof ClothColor)) { assign((ClothColor)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ClothColor _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.id = _o_.id;
/*  58 */     this.hair = _o_.hair;
/*  59 */     this.fashion_dress_cfg_id = _o_.fashion_dress_cfg_id;
/*  60 */     this.cloth = _o_.cloth;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.id = _o_.id;
/*  66 */     this.hair = _o_.hair;
/*  67 */     this.fashion_dress_cfg_id = _o_.fashion_dress_cfg_id;
/*  68 */     this.cloth = _o_.cloth;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.id);
/*  76 */     _os_.marshal(this.hair);
/*  77 */     _os_.marshal(this.fashion_dress_cfg_id);
/*  78 */     _os_.marshal(this.cloth);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.id = _os_.unmarshal_int();
/*  87 */     this.hair = _os_.unmarshal_int();
/*  88 */     this.fashion_dress_cfg_id = _os_.unmarshal_int();
/*  89 */     this.cloth = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt32Size(1, this.id);
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(2, this.hair);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(3, this.fashion_dress_cfg_id);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(4, this.cloth);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt32(1, this.id);
/* 112 */       _output_.writeInt32(2, this.hair);
/* 113 */       _output_.writeInt32(3, this.fashion_dress_cfg_id);
/* 114 */       _output_.writeInt32(4, this.cloth);
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
/* 142 */           this.id = _input_.readInt32();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.hair = _input_.readInt32();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.fashion_dress_cfg_id = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.cloth = _input_.readInt32();
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
/*     */   public xbean.ClothColor copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new ClothColor(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ClothColor toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ClothColor toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new ClothColor(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ClothColor toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ClothColor toBeanIf()
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
/*     */   public int getId()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getHair()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.hair;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getFashion_dress_cfg_id()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.fashion_dress_cfg_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCloth()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.cloth;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new LogInt(this, ClothColor.this.id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             ClothColor.this.id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHair(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "hair")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new LogInt(this, ClothColor.this.hair)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             ClothColor.this.hair = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.hair = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFashion_dress_cfg_id(int _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "fashion_dress_cfg_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 305 */         new LogInt(this, ClothColor.this.fashion_dress_cfg_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             ClothColor.this.fashion_dress_cfg_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.fashion_dress_cfg_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCloth(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "cloth")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new LogInt(this, ClothColor.this.cloth)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             ClothColor.this.cloth = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.cloth = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     ClothColor _o_ = null;
/* 343 */     if ((_o1_ instanceof ClothColor)) { _o_ = (ClothColor)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.id != _o_.id) return false;
/* 347 */     if (this.hair != _o_.hair) return false;
/* 348 */     if (this.fashion_dress_cfg_id != _o_.fashion_dress_cfg_id) return false;
/* 349 */     if (this.cloth != _o_.cloth) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ += this.id;
/* 359 */     _h_ += this.hair;
/* 360 */     _h_ += this.fashion_dress_cfg_id;
/* 361 */     _h_ += this.cloth;
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.id);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.hair);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.fashion_dress_cfg_id);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.cloth);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("id"));
/* 387 */     lb.add(new ListenableChanged().setVarName("hair"));
/* 388 */     lb.add(new ListenableChanged().setVarName("fashion_dress_cfg_id"));
/* 389 */     lb.add(new ListenableChanged().setVarName("cloth"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ClothColor {
/*     */     private Const() {}
/*     */     
/*     */     ClothColor nThis() {
/* 397 */       return ClothColor.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ClothColor copy()
/*     */     {
/* 409 */       return ClothColor.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ClothColor toData()
/*     */     {
/* 415 */       return ClothColor.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ClothColor toBean()
/*     */     {
/* 420 */       return ClothColor.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ClothColor toDataIf()
/*     */     {
/* 426 */       return ClothColor.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ClothColor toBeanIf()
/*     */     {
/* 431 */       return ClothColor.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getId()
/*     */     {
/* 438 */       ClothColor.this._xdb_verify_unsafe_();
/* 439 */       return ClothColor.this.id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHair()
/*     */     {
/* 446 */       ClothColor.this._xdb_verify_unsafe_();
/* 447 */       return ClothColor.this.hair;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFashion_dress_cfg_id()
/*     */     {
/* 454 */       ClothColor.this._xdb_verify_unsafe_();
/* 455 */       return ClothColor.this.fashion_dress_cfg_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCloth()
/*     */     {
/* 462 */       ClothColor.this._xdb_verify_unsafe_();
/* 463 */       return ClothColor.this.cloth;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setId(int _v_)
/*     */     {
/* 470 */       ClothColor.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHair(int _v_)
/*     */     {
/* 478 */       ClothColor.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFashion_dress_cfg_id(int _v_)
/*     */     {
/* 486 */       ClothColor.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCloth(int _v_)
/*     */     {
/* 494 */       ClothColor.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       ClothColor.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       ClothColor.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return ClothColor.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return ClothColor.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       ClothColor.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return ClothColor.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return ClothColor.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       ClothColor.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return ClothColor.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return ClothColor.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return ClothColor.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return ClothColor.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return ClothColor.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return ClothColor.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return ClothColor.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ClothColor
/*     */   {
/*     */     private int id;
/*     */     
/*     */     private int hair;
/*     */     
/*     */     private int fashion_dress_cfg_id;
/*     */     
/*     */     private int cloth;
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
/*     */     Data(xbean.ClothColor _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof ClothColor)) { assign((ClothColor)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof ClothColor.Const)) assign(((ClothColor.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ClothColor _o_) {
/* 624 */       this.id = _o_.id;
/* 625 */       this.hair = _o_.hair;
/* 626 */       this.fashion_dress_cfg_id = _o_.fashion_dress_cfg_id;
/* 627 */       this.cloth = _o_.cloth;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.id = _o_.id;
/* 633 */       this.hair = _o_.hair;
/* 634 */       this.fashion_dress_cfg_id = _o_.fashion_dress_cfg_id;
/* 635 */       this.cloth = _o_.cloth;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.id);
/* 642 */       _os_.marshal(this.hair);
/* 643 */       _os_.marshal(this.fashion_dress_cfg_id);
/* 644 */       _os_.marshal(this.cloth);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.id = _os_.unmarshal_int();
/* 652 */       this.hair = _os_.unmarshal_int();
/* 653 */       this.fashion_dress_cfg_id = _os_.unmarshal_int();
/* 654 */       this.cloth = _os_.unmarshal_int();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt32Size(1, this.id);
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.hair);
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(3, this.fashion_dress_cfg_id);
/* 665 */       _size_ += CodedOutputStream.computeInt32Size(4, this.cloth);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt32(1, this.id);
/* 675 */         _output_.writeInt32(2, this.hair);
/* 676 */         _output_.writeInt32(3, this.fashion_dress_cfg_id);
/* 677 */         _output_.writeInt32(4, this.cloth);
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
/* 704 */             this.id = _input_.readInt32();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.hair = _input_.readInt32();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.fashion_dress_cfg_id = _input_.readInt32();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.cloth = _input_.readInt32();
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
/*     */     public xbean.ClothColor copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ClothColor toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ClothColor toBean()
/*     */     {
/* 758 */       return new ClothColor(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ClothColor toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ClothColor toBeanIf()
/*     */     {
/* 769 */       return new ClothColor(this, null, null);
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
/*     */     public int getId()
/*     */     {
/* 806 */       return this.id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHair()
/*     */     {
/* 813 */       return this.hair;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFashion_dress_cfg_id()
/*     */     {
/* 820 */       return this.fashion_dress_cfg_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCloth()
/*     */     {
/* 827 */       return this.cloth;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setId(int _v_)
/*     */     {
/* 834 */       this.id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHair(int _v_)
/*     */     {
/* 841 */       this.hair = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFashion_dress_cfg_id(int _v_)
/*     */     {
/* 848 */       this.fashion_dress_cfg_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCloth(int _v_)
/*     */     {
/* 855 */       this.cloth = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.id != _o_.id) return false;
/* 864 */       if (this.hair != _o_.hair) return false;
/* 865 */       if (this.fashion_dress_cfg_id != _o_.fashion_dress_cfg_id) return false;
/* 866 */       if (this.cloth != _o_.cloth) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ += this.id;
/* 875 */       _h_ += this.hair;
/* 876 */       _h_ += this.fashion_dress_cfg_id;
/* 877 */       _h_ += this.cloth;
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.id);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.hair);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.fashion_dress_cfg_id);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.cloth);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ClothColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
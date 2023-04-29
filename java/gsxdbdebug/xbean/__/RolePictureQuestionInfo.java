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
/*     */ public final class RolePictureQuestionInfo extends XBean implements xbean.RolePictureQuestionInfo
/*     */ {
/*     */   private long picinfoid;
/*     */   private int rightnum;
/*     */   private int totalnum;
/*     */   private int usehelpnum;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.picinfoid = 0L;
/*  25 */     this.rightnum = 0;
/*  26 */     this.totalnum = 0;
/*  27 */     this.usehelpnum = 0;
/*     */   }
/*     */   
/*     */   RolePictureQuestionInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public RolePictureQuestionInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RolePictureQuestionInfo(RolePictureQuestionInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RolePictureQuestionInfo(xbean.RolePictureQuestionInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof RolePictureQuestionInfo)) { assign((RolePictureQuestionInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RolePictureQuestionInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.picinfoid = _o_.picinfoid;
/*  58 */     this.rightnum = _o_.rightnum;
/*  59 */     this.totalnum = _o_.totalnum;
/*  60 */     this.usehelpnum = _o_.usehelpnum;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.picinfoid = _o_.picinfoid;
/*  66 */     this.rightnum = _o_.rightnum;
/*  67 */     this.totalnum = _o_.totalnum;
/*  68 */     this.usehelpnum = _o_.usehelpnum;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.picinfoid);
/*  76 */     _os_.marshal(this.rightnum);
/*  77 */     _os_.marshal(this.totalnum);
/*  78 */     _os_.marshal(this.usehelpnum);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.picinfoid = _os_.unmarshal_long();
/*  87 */     this.rightnum = _os_.unmarshal_int();
/*  88 */     this.totalnum = _os_.unmarshal_int();
/*  89 */     this.usehelpnum = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt64Size(1, this.picinfoid);
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(2, this.rightnum);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(3, this.totalnum);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(4, this.usehelpnum);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt64(1, this.picinfoid);
/* 112 */       _output_.writeInt32(2, this.rightnum);
/* 113 */       _output_.writeInt32(3, this.totalnum);
/* 114 */       _output_.writeInt32(4, this.usehelpnum);
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
/* 142 */           this.picinfoid = _input_.readInt64();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.rightnum = _input_.readInt32();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.totalnum = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.usehelpnum = _input_.readInt32();
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
/*     */   public xbean.RolePictureQuestionInfo copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new RolePictureQuestionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RolePictureQuestionInfo toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RolePictureQuestionInfo toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new RolePictureQuestionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RolePictureQuestionInfo toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RolePictureQuestionInfo toBeanIf()
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
/*     */   public long getPicinfoid()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.picinfoid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRightnum()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.rightnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTotalnum()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.totalnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getUsehelpnum()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.usehelpnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPicinfoid(long _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "picinfoid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new xdb.logs.LogLong(this, RolePictureQuestionInfo.this.picinfoid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             RolePictureQuestionInfo.this.picinfoid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.picinfoid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRightnum(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "rightnum")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new LogInt(this, RolePictureQuestionInfo.this.rightnum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             RolePictureQuestionInfo.this.rightnum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.rightnum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalnum(int _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "totalnum")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 305 */         new LogInt(this, RolePictureQuestionInfo.this.totalnum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             RolePictureQuestionInfo.this.totalnum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.totalnum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUsehelpnum(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "usehelpnum")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new LogInt(this, RolePictureQuestionInfo.this.usehelpnum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             RolePictureQuestionInfo.this.usehelpnum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.usehelpnum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     RolePictureQuestionInfo _o_ = null;
/* 343 */     if ((_o1_ instanceof RolePictureQuestionInfo)) { _o_ = (RolePictureQuestionInfo)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.picinfoid != _o_.picinfoid) return false;
/* 347 */     if (this.rightnum != _o_.rightnum) return false;
/* 348 */     if (this.totalnum != _o_.totalnum) return false;
/* 349 */     if (this.usehelpnum != _o_.usehelpnum) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ = (int)(_h_ + this.picinfoid);
/* 359 */     _h_ += this.rightnum;
/* 360 */     _h_ += this.totalnum;
/* 361 */     _h_ += this.usehelpnum;
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.picinfoid);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.rightnum);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.totalnum);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.usehelpnum);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("picinfoid"));
/* 387 */     lb.add(new ListenableChanged().setVarName("rightnum"));
/* 388 */     lb.add(new ListenableChanged().setVarName("totalnum"));
/* 389 */     lb.add(new ListenableChanged().setVarName("usehelpnum"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RolePictureQuestionInfo {
/*     */     private Const() {}
/*     */     
/*     */     RolePictureQuestionInfo nThis() {
/* 397 */       return RolePictureQuestionInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePictureQuestionInfo copy()
/*     */     {
/* 409 */       return RolePictureQuestionInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePictureQuestionInfo toData()
/*     */     {
/* 415 */       return RolePictureQuestionInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RolePictureQuestionInfo toBean()
/*     */     {
/* 420 */       return RolePictureQuestionInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePictureQuestionInfo toDataIf()
/*     */     {
/* 426 */       return RolePictureQuestionInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RolePictureQuestionInfo toBeanIf()
/*     */     {
/* 431 */       return RolePictureQuestionInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPicinfoid()
/*     */     {
/* 438 */       RolePictureQuestionInfo.this._xdb_verify_unsafe_();
/* 439 */       return RolePictureQuestionInfo.this.picinfoid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRightnum()
/*     */     {
/* 446 */       RolePictureQuestionInfo.this._xdb_verify_unsafe_();
/* 447 */       return RolePictureQuestionInfo.this.rightnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotalnum()
/*     */     {
/* 454 */       RolePictureQuestionInfo.this._xdb_verify_unsafe_();
/* 455 */       return RolePictureQuestionInfo.this.totalnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUsehelpnum()
/*     */     {
/* 462 */       RolePictureQuestionInfo.this._xdb_verify_unsafe_();
/* 463 */       return RolePictureQuestionInfo.this.usehelpnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPicinfoid(long _v_)
/*     */     {
/* 470 */       RolePictureQuestionInfo.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRightnum(int _v_)
/*     */     {
/* 478 */       RolePictureQuestionInfo.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalnum(int _v_)
/*     */     {
/* 486 */       RolePictureQuestionInfo.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUsehelpnum(int _v_)
/*     */     {
/* 494 */       RolePictureQuestionInfo.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       RolePictureQuestionInfo.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       RolePictureQuestionInfo.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return RolePictureQuestionInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return RolePictureQuestionInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       RolePictureQuestionInfo.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return RolePictureQuestionInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return RolePictureQuestionInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       RolePictureQuestionInfo.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return RolePictureQuestionInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return RolePictureQuestionInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return RolePictureQuestionInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return RolePictureQuestionInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return RolePictureQuestionInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return RolePictureQuestionInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return RolePictureQuestionInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RolePictureQuestionInfo
/*     */   {
/*     */     private long picinfoid;
/*     */     
/*     */     private int rightnum;
/*     */     
/*     */     private int totalnum;
/*     */     
/*     */     private int usehelpnum;
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
/*     */     Data(xbean.RolePictureQuestionInfo _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof RolePictureQuestionInfo)) { assign((RolePictureQuestionInfo)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof RolePictureQuestionInfo.Const)) assign(((RolePictureQuestionInfo.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RolePictureQuestionInfo _o_) {
/* 624 */       this.picinfoid = _o_.picinfoid;
/* 625 */       this.rightnum = _o_.rightnum;
/* 626 */       this.totalnum = _o_.totalnum;
/* 627 */       this.usehelpnum = _o_.usehelpnum;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.picinfoid = _o_.picinfoid;
/* 633 */       this.rightnum = _o_.rightnum;
/* 634 */       this.totalnum = _o_.totalnum;
/* 635 */       this.usehelpnum = _o_.usehelpnum;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.picinfoid);
/* 642 */       _os_.marshal(this.rightnum);
/* 643 */       _os_.marshal(this.totalnum);
/* 644 */       _os_.marshal(this.usehelpnum);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.picinfoid = _os_.unmarshal_long();
/* 652 */       this.rightnum = _os_.unmarshal_int();
/* 653 */       this.totalnum = _os_.unmarshal_int();
/* 654 */       this.usehelpnum = _os_.unmarshal_int();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt64Size(1, this.picinfoid);
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.rightnum);
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(3, this.totalnum);
/* 665 */       _size_ += CodedOutputStream.computeInt32Size(4, this.usehelpnum);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt64(1, this.picinfoid);
/* 675 */         _output_.writeInt32(2, this.rightnum);
/* 676 */         _output_.writeInt32(3, this.totalnum);
/* 677 */         _output_.writeInt32(4, this.usehelpnum);
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
/* 704 */             this.picinfoid = _input_.readInt64();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.rightnum = _input_.readInt32();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.totalnum = _input_.readInt32();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.usehelpnum = _input_.readInt32();
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
/*     */     public xbean.RolePictureQuestionInfo copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePictureQuestionInfo toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RolePictureQuestionInfo toBean()
/*     */     {
/* 758 */       return new RolePictureQuestionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePictureQuestionInfo toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RolePictureQuestionInfo toBeanIf()
/*     */     {
/* 769 */       return new RolePictureQuestionInfo(this, null, null);
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
/*     */     public long getPicinfoid()
/*     */     {
/* 806 */       return this.picinfoid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRightnum()
/*     */     {
/* 813 */       return this.rightnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotalnum()
/*     */     {
/* 820 */       return this.totalnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUsehelpnum()
/*     */     {
/* 827 */       return this.usehelpnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPicinfoid(long _v_)
/*     */     {
/* 834 */       this.picinfoid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRightnum(int _v_)
/*     */     {
/* 841 */       this.rightnum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalnum(int _v_)
/*     */     {
/* 848 */       this.totalnum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUsehelpnum(int _v_)
/*     */     {
/* 855 */       this.usehelpnum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.picinfoid != _o_.picinfoid) return false;
/* 864 */       if (this.rightnum != _o_.rightnum) return false;
/* 865 */       if (this.totalnum != _o_.totalnum) return false;
/* 866 */       if (this.usehelpnum != _o_.usehelpnum) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ = (int)(_h_ + this.picinfoid);
/* 875 */       _h_ += this.rightnum;
/* 876 */       _h_ += this.totalnum;
/* 877 */       _h_ += this.usehelpnum;
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.picinfoid);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.rightnum);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.totalnum);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.usehelpnum);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RolePictureQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
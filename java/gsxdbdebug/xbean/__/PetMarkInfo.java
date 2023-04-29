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
/*     */ public final class PetMarkInfo extends XBean implements xbean.PetMarkInfo
/*     */ {
/*     */   private int pet_mark_cfg_id;
/*     */   private int level;
/*     */   private int exp;
/*     */   private long pet_id;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.pet_mark_cfg_id = 0;
/*  25 */     this.level = 0;
/*  26 */     this.exp = 0;
/*  27 */     this.pet_id = 0L;
/*     */   }
/*     */   
/*     */   PetMarkInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public PetMarkInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PetMarkInfo(PetMarkInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PetMarkInfo(xbean.PetMarkInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof PetMarkInfo)) { assign((PetMarkInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PetMarkInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.pet_mark_cfg_id = _o_.pet_mark_cfg_id;
/*  58 */     this.level = _o_.level;
/*  59 */     this.exp = _o_.exp;
/*  60 */     this.pet_id = _o_.pet_id;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.pet_mark_cfg_id = _o_.pet_mark_cfg_id;
/*  66 */     this.level = _o_.level;
/*  67 */     this.exp = _o_.exp;
/*  68 */     this.pet_id = _o_.pet_id;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.pet_mark_cfg_id);
/*  76 */     _os_.marshal(this.level);
/*  77 */     _os_.marshal(this.exp);
/*  78 */     _os_.marshal(this.pet_id);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.pet_mark_cfg_id = _os_.unmarshal_int();
/*  87 */     this.level = _os_.unmarshal_int();
/*  88 */     this.exp = _os_.unmarshal_int();
/*  89 */     this.pet_id = _os_.unmarshal_long();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt32Size(1, this.pet_mark_cfg_id);
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(3, this.exp);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(4, this.pet_id);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt32(1, this.pet_mark_cfg_id);
/* 112 */       _output_.writeInt32(2, this.level);
/* 113 */       _output_.writeInt32(3, this.exp);
/* 114 */       _output_.writeInt64(4, this.pet_id);
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
/* 142 */           this.pet_mark_cfg_id = _input_.readInt32();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.level = _input_.readInt32();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.exp = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.pet_id = _input_.readInt64();
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
/*     */   public xbean.PetMarkInfo copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new PetMarkInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetMarkInfo toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetMarkInfo toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new PetMarkInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetMarkInfo toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetMarkInfo toBeanIf()
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
/*     */   public int getPet_mark_cfg_id()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.pet_mark_cfg_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getExp()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.exp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getPet_id()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.pet_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPet_mark_cfg_id(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "pet_mark_cfg_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new LogInt(this, PetMarkInfo.this.pet_mark_cfg_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             PetMarkInfo.this.pet_mark_cfg_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.pet_mark_cfg_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLevel(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "level")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new LogInt(this, PetMarkInfo.this.level)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             PetMarkInfo.this.level = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.level = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExp(int _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "exp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 305 */         new LogInt(this, PetMarkInfo.this.exp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             PetMarkInfo.this.exp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.exp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPet_id(long _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "pet_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new xdb.logs.LogLong(this, PetMarkInfo.this.pet_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             PetMarkInfo.this.pet_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.pet_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     PetMarkInfo _o_ = null;
/* 343 */     if ((_o1_ instanceof PetMarkInfo)) { _o_ = (PetMarkInfo)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.pet_mark_cfg_id != _o_.pet_mark_cfg_id) return false;
/* 347 */     if (this.level != _o_.level) return false;
/* 348 */     if (this.exp != _o_.exp) return false;
/* 349 */     if (this.pet_id != _o_.pet_id) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ += this.pet_mark_cfg_id;
/* 359 */     _h_ += this.level;
/* 360 */     _h_ += this.exp;
/* 361 */     _h_ = (int)(_h_ + this.pet_id);
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.pet_mark_cfg_id);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.level);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.exp);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.pet_id);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("pet_mark_cfg_id"));
/* 387 */     lb.add(new ListenableChanged().setVarName("level"));
/* 388 */     lb.add(new ListenableChanged().setVarName("exp"));
/* 389 */     lb.add(new ListenableChanged().setVarName("pet_id"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PetMarkInfo {
/*     */     private Const() {}
/*     */     
/*     */     PetMarkInfo nThis() {
/* 397 */       return PetMarkInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetMarkInfo copy()
/*     */     {
/* 409 */       return PetMarkInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetMarkInfo toData()
/*     */     {
/* 415 */       return PetMarkInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PetMarkInfo toBean()
/*     */     {
/* 420 */       return PetMarkInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetMarkInfo toDataIf()
/*     */     {
/* 426 */       return PetMarkInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PetMarkInfo toBeanIf()
/*     */     {
/* 431 */       return PetMarkInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPet_mark_cfg_id()
/*     */     {
/* 438 */       PetMarkInfo.this._xdb_verify_unsafe_();
/* 439 */       return PetMarkInfo.this.pet_mark_cfg_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 446 */       PetMarkInfo.this._xdb_verify_unsafe_();
/* 447 */       return PetMarkInfo.this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getExp()
/*     */     {
/* 454 */       PetMarkInfo.this._xdb_verify_unsafe_();
/* 455 */       return PetMarkInfo.this.exp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPet_id()
/*     */     {
/* 462 */       PetMarkInfo.this._xdb_verify_unsafe_();
/* 463 */       return PetMarkInfo.this.pet_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPet_mark_cfg_id(int _v_)
/*     */     {
/* 470 */       PetMarkInfo.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 478 */       PetMarkInfo.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExp(int _v_)
/*     */     {
/* 486 */       PetMarkInfo.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPet_id(long _v_)
/*     */     {
/* 494 */       PetMarkInfo.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       PetMarkInfo.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       PetMarkInfo.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return PetMarkInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return PetMarkInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       PetMarkInfo.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return PetMarkInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return PetMarkInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       PetMarkInfo.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return PetMarkInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return PetMarkInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return PetMarkInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return PetMarkInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return PetMarkInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return PetMarkInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return PetMarkInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PetMarkInfo
/*     */   {
/*     */     private int pet_mark_cfg_id;
/*     */     
/*     */     private int level;
/*     */     
/*     */     private int exp;
/*     */     
/*     */     private long pet_id;
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
/*     */     Data(xbean.PetMarkInfo _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof PetMarkInfo)) { assign((PetMarkInfo)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof PetMarkInfo.Const)) assign(((PetMarkInfo.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PetMarkInfo _o_) {
/* 624 */       this.pet_mark_cfg_id = _o_.pet_mark_cfg_id;
/* 625 */       this.level = _o_.level;
/* 626 */       this.exp = _o_.exp;
/* 627 */       this.pet_id = _o_.pet_id;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.pet_mark_cfg_id = _o_.pet_mark_cfg_id;
/* 633 */       this.level = _o_.level;
/* 634 */       this.exp = _o_.exp;
/* 635 */       this.pet_id = _o_.pet_id;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.pet_mark_cfg_id);
/* 642 */       _os_.marshal(this.level);
/* 643 */       _os_.marshal(this.exp);
/* 644 */       _os_.marshal(this.pet_id);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.pet_mark_cfg_id = _os_.unmarshal_int();
/* 652 */       this.level = _os_.unmarshal_int();
/* 653 */       this.exp = _os_.unmarshal_int();
/* 654 */       this.pet_id = _os_.unmarshal_long();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt32Size(1, this.pet_mark_cfg_id);
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(3, this.exp);
/* 665 */       _size_ += CodedOutputStream.computeInt64Size(4, this.pet_id);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt32(1, this.pet_mark_cfg_id);
/* 675 */         _output_.writeInt32(2, this.level);
/* 676 */         _output_.writeInt32(3, this.exp);
/* 677 */         _output_.writeInt64(4, this.pet_id);
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
/* 704 */             this.pet_mark_cfg_id = _input_.readInt32();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.level = _input_.readInt32();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.exp = _input_.readInt32();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.pet_id = _input_.readInt64();
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
/*     */     public xbean.PetMarkInfo copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetMarkInfo toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PetMarkInfo toBean()
/*     */     {
/* 758 */       return new PetMarkInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetMarkInfo toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PetMarkInfo toBeanIf()
/*     */     {
/* 769 */       return new PetMarkInfo(this, null, null);
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
/*     */     public int getPet_mark_cfg_id()
/*     */     {
/* 806 */       return this.pet_mark_cfg_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 813 */       return this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getExp()
/*     */     {
/* 820 */       return this.exp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPet_id()
/*     */     {
/* 827 */       return this.pet_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPet_mark_cfg_id(int _v_)
/*     */     {
/* 834 */       this.pet_mark_cfg_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 841 */       this.level = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExp(int _v_)
/*     */     {
/* 848 */       this.exp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPet_id(long _v_)
/*     */     {
/* 855 */       this.pet_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.pet_mark_cfg_id != _o_.pet_mark_cfg_id) return false;
/* 864 */       if (this.level != _o_.level) return false;
/* 865 */       if (this.exp != _o_.exp) return false;
/* 866 */       if (this.pet_id != _o_.pet_id) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ += this.pet_mark_cfg_id;
/* 875 */       _h_ += this.level;
/* 876 */       _h_ += this.exp;
/* 877 */       _h_ = (int)(_h_ + this.pet_id);
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.pet_mark_cfg_id);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.level);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.exp);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.pet_id);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PetMarkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*     */ public final class ChangeModelCardInfo extends XBean implements xbean.ChangeModelCardInfo
/*     */ {
/*     */   private int card_cfg_id;
/*     */   private int level;
/*     */   private int exp;
/*     */   private int use_count;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.card_cfg_id = 0;
/*  25 */     this.level = 0;
/*  26 */     this.exp = 0;
/*  27 */     this.use_count = 0;
/*     */   }
/*     */   
/*     */   ChangeModelCardInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public ChangeModelCardInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ChangeModelCardInfo(ChangeModelCardInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ChangeModelCardInfo(xbean.ChangeModelCardInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof ChangeModelCardInfo)) { assign((ChangeModelCardInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ChangeModelCardInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.card_cfg_id = _o_.card_cfg_id;
/*  58 */     this.level = _o_.level;
/*  59 */     this.exp = _o_.exp;
/*  60 */     this.use_count = _o_.use_count;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.card_cfg_id = _o_.card_cfg_id;
/*  66 */     this.level = _o_.level;
/*  67 */     this.exp = _o_.exp;
/*  68 */     this.use_count = _o_.use_count;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.card_cfg_id);
/*  76 */     _os_.marshal(this.level);
/*  77 */     _os_.marshal(this.exp);
/*  78 */     _os_.marshal(this.use_count);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.card_cfg_id = _os_.unmarshal_int();
/*  87 */     this.level = _os_.unmarshal_int();
/*  88 */     this.exp = _os_.unmarshal_int();
/*  89 */     this.use_count = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt32Size(1, this.card_cfg_id);
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(3, this.exp);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(4, this.use_count);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt32(1, this.card_cfg_id);
/* 112 */       _output_.writeInt32(2, this.level);
/* 113 */       _output_.writeInt32(3, this.exp);
/* 114 */       _output_.writeInt32(4, this.use_count);
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
/* 142 */           this.card_cfg_id = _input_.readInt32();
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
/* 157 */           this.use_count = _input_.readInt32();
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
/*     */   public xbean.ChangeModelCardInfo copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new ChangeModelCardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChangeModelCardInfo toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChangeModelCardInfo toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new ChangeModelCardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChangeModelCardInfo toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChangeModelCardInfo toBeanIf()
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
/*     */   public int getCard_cfg_id()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.card_cfg_id;
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
/*     */   public int getUse_count()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.use_count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCard_cfg_id(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "card_cfg_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new LogInt(this, ChangeModelCardInfo.this.card_cfg_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             ChangeModelCardInfo.this.card_cfg_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.card_cfg_id = _v_;
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
/* 284 */         new LogInt(this, ChangeModelCardInfo.this.level)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             ChangeModelCardInfo.this.level = this._xdb_saved;
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
/* 305 */         new LogInt(this, ChangeModelCardInfo.this.exp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             ChangeModelCardInfo.this.exp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.exp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUse_count(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "use_count")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new LogInt(this, ChangeModelCardInfo.this.use_count)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             ChangeModelCardInfo.this.use_count = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.use_count = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     ChangeModelCardInfo _o_ = null;
/* 343 */     if ((_o1_ instanceof ChangeModelCardInfo)) { _o_ = (ChangeModelCardInfo)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.card_cfg_id != _o_.card_cfg_id) return false;
/* 347 */     if (this.level != _o_.level) return false;
/* 348 */     if (this.exp != _o_.exp) return false;
/* 349 */     if (this.use_count != _o_.use_count) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ += this.card_cfg_id;
/* 359 */     _h_ += this.level;
/* 360 */     _h_ += this.exp;
/* 361 */     _h_ += this.use_count;
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.card_cfg_id);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.level);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.exp);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.use_count);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("card_cfg_id"));
/* 387 */     lb.add(new ListenableChanged().setVarName("level"));
/* 388 */     lb.add(new ListenableChanged().setVarName("exp"));
/* 389 */     lb.add(new ListenableChanged().setVarName("use_count"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ChangeModelCardInfo {
/*     */     private Const() {}
/*     */     
/*     */     ChangeModelCardInfo nThis() {
/* 397 */       return ChangeModelCardInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChangeModelCardInfo copy()
/*     */     {
/* 409 */       return ChangeModelCardInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChangeModelCardInfo toData()
/*     */     {
/* 415 */       return ChangeModelCardInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ChangeModelCardInfo toBean()
/*     */     {
/* 420 */       return ChangeModelCardInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChangeModelCardInfo toDataIf()
/*     */     {
/* 426 */       return ChangeModelCardInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ChangeModelCardInfo toBeanIf()
/*     */     {
/* 431 */       return ChangeModelCardInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCard_cfg_id()
/*     */     {
/* 438 */       ChangeModelCardInfo.this._xdb_verify_unsafe_();
/* 439 */       return ChangeModelCardInfo.this.card_cfg_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 446 */       ChangeModelCardInfo.this._xdb_verify_unsafe_();
/* 447 */       return ChangeModelCardInfo.this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getExp()
/*     */     {
/* 454 */       ChangeModelCardInfo.this._xdb_verify_unsafe_();
/* 455 */       return ChangeModelCardInfo.this.exp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUse_count()
/*     */     {
/* 462 */       ChangeModelCardInfo.this._xdb_verify_unsafe_();
/* 463 */       return ChangeModelCardInfo.this.use_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCard_cfg_id(int _v_)
/*     */     {
/* 470 */       ChangeModelCardInfo.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 478 */       ChangeModelCardInfo.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExp(int _v_)
/*     */     {
/* 486 */       ChangeModelCardInfo.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUse_count(int _v_)
/*     */     {
/* 494 */       ChangeModelCardInfo.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       ChangeModelCardInfo.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       ChangeModelCardInfo.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return ChangeModelCardInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return ChangeModelCardInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       ChangeModelCardInfo.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return ChangeModelCardInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return ChangeModelCardInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       ChangeModelCardInfo.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return ChangeModelCardInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return ChangeModelCardInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return ChangeModelCardInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return ChangeModelCardInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return ChangeModelCardInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return ChangeModelCardInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return ChangeModelCardInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ChangeModelCardInfo
/*     */   {
/*     */     private int card_cfg_id;
/*     */     
/*     */     private int level;
/*     */     
/*     */     private int exp;
/*     */     
/*     */     private int use_count;
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
/*     */     Data(xbean.ChangeModelCardInfo _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof ChangeModelCardInfo)) { assign((ChangeModelCardInfo)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof ChangeModelCardInfo.Const)) assign(((ChangeModelCardInfo.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ChangeModelCardInfo _o_) {
/* 624 */       this.card_cfg_id = _o_.card_cfg_id;
/* 625 */       this.level = _o_.level;
/* 626 */       this.exp = _o_.exp;
/* 627 */       this.use_count = _o_.use_count;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.card_cfg_id = _o_.card_cfg_id;
/* 633 */       this.level = _o_.level;
/* 634 */       this.exp = _o_.exp;
/* 635 */       this.use_count = _o_.use_count;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.card_cfg_id);
/* 642 */       _os_.marshal(this.level);
/* 643 */       _os_.marshal(this.exp);
/* 644 */       _os_.marshal(this.use_count);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.card_cfg_id = _os_.unmarshal_int();
/* 652 */       this.level = _os_.unmarshal_int();
/* 653 */       this.exp = _os_.unmarshal_int();
/* 654 */       this.use_count = _os_.unmarshal_int();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt32Size(1, this.card_cfg_id);
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(3, this.exp);
/* 665 */       _size_ += CodedOutputStream.computeInt32Size(4, this.use_count);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt32(1, this.card_cfg_id);
/* 675 */         _output_.writeInt32(2, this.level);
/* 676 */         _output_.writeInt32(3, this.exp);
/* 677 */         _output_.writeInt32(4, this.use_count);
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
/* 704 */             this.card_cfg_id = _input_.readInt32();
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
/* 719 */             this.use_count = _input_.readInt32();
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
/*     */     public xbean.ChangeModelCardInfo copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChangeModelCardInfo toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ChangeModelCardInfo toBean()
/*     */     {
/* 758 */       return new ChangeModelCardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChangeModelCardInfo toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ChangeModelCardInfo toBeanIf()
/*     */     {
/* 769 */       return new ChangeModelCardInfo(this, null, null);
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
/*     */     public int getCard_cfg_id()
/*     */     {
/* 806 */       return this.card_cfg_id;
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
/*     */     public int getUse_count()
/*     */     {
/* 827 */       return this.use_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCard_cfg_id(int _v_)
/*     */     {
/* 834 */       this.card_cfg_id = _v_;
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
/*     */     public void setUse_count(int _v_)
/*     */     {
/* 855 */       this.use_count = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.card_cfg_id != _o_.card_cfg_id) return false;
/* 864 */       if (this.level != _o_.level) return false;
/* 865 */       if (this.exp != _o_.exp) return false;
/* 866 */       if (this.use_count != _o_.use_count) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ += this.card_cfg_id;
/* 875 */       _h_ += this.level;
/* 876 */       _h_ += this.exp;
/* 877 */       _h_ += this.use_count;
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.card_cfg_id);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.level);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.exp);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.use_count);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChangeModelCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
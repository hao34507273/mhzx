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
/*     */ public final class LevelGrowthFundActivityInfo extends XBean implements xbean.LevelGrowthFundActivityInfo
/*     */ {
/*     */   private boolean purchased;
/*     */   private long purchase_num;
/*     */   private int sortid;
/*     */   private boolean is_reset;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.purchased = false;
/*  25 */     this.purchase_num = 0L;
/*  26 */     this.sortid = 0;
/*  27 */     this.is_reset = false;
/*     */   }
/*     */   
/*     */   LevelGrowthFundActivityInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.is_reset = false;
/*     */   }
/*     */   
/*     */   public LevelGrowthFundActivityInfo()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public LevelGrowthFundActivityInfo(LevelGrowthFundActivityInfo _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   LevelGrowthFundActivityInfo(xbean.LevelGrowthFundActivityInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof LevelGrowthFundActivityInfo)) { assign((LevelGrowthFundActivityInfo)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(LevelGrowthFundActivityInfo _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.purchased = _o_.purchased;
/*  59 */     this.purchase_num = _o_.purchase_num;
/*  60 */     this.sortid = _o_.sortid;
/*  61 */     this.is_reset = _o_.is_reset;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.purchased = _o_.purchased;
/*  67 */     this.purchase_num = _o_.purchase_num;
/*  68 */     this.sortid = _o_.sortid;
/*  69 */     this.is_reset = _o_.is_reset;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     _os_.marshal(this.purchased);
/*  77 */     _os_.marshal(this.purchase_num);
/*  78 */     _os_.marshal(this.sortid);
/*  79 */     _os_.marshal(this.is_reset);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.purchased = _os_.unmarshal_boolean();
/*  88 */     this.purchase_num = _os_.unmarshal_long();
/*  89 */     this.sortid = _os_.unmarshal_int();
/*  90 */     this.is_reset = _os_.unmarshal_boolean();
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     int _size_ = 0;
/*  99 */     _size_ += CodedOutputStream.computeBoolSize(1, this.purchased);
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(2, this.purchase_num);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(3, this.sortid);
/* 102 */     _size_ += CodedOutputStream.computeBoolSize(4, this.is_reset);
/* 103 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       _output_.writeBool(1, this.purchased);
/* 113 */       _output_.writeInt64(2, this.purchase_num);
/* 114 */       _output_.writeInt32(3, this.sortid);
/* 115 */       _output_.writeBool(4, this.is_reset);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 119 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 121 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 127 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 130 */       boolean done = false;
/* 131 */       while (!done)
/*     */       {
/* 133 */         int tag = _input_.readTag();
/* 134 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 138 */           done = true;
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 143 */           this.purchased = _input_.readBool();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 148 */           this.purchase_num = _input_.readInt64();
/* 149 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 153 */           this.sortid = _input_.readInt32();
/* 154 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 158 */           this.is_reset = _input_.readBool();
/* 159 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 163 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 165 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 174 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 178 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 180 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LevelGrowthFundActivityInfo copy()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new LevelGrowthFundActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LevelGrowthFundActivityInfo toData()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LevelGrowthFundActivityInfo toBean()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new LevelGrowthFundActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LevelGrowthFundActivityInfo toDataIf()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LevelGrowthFundActivityInfo toBeanIf()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getPurchased()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return this.purchased;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getPurchase_num()
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     return this.purchase_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSortid()
/*     */   {
/* 243 */     _xdb_verify_unsafe_();
/* 244 */     return this.sortid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIs_reset()
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     return this.is_reset;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPurchased(boolean _v_)
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     xdb.Logs.logIf(new LogKey(this, "purchased")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 264 */         new xdb.logs.LogObject(this, Boolean.valueOf(LevelGrowthFundActivityInfo.this.purchased))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 268 */             LevelGrowthFundActivityInfo.this.purchased = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 272 */     });
/* 273 */     this.purchased = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPurchase_num(long _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "purchase_num")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 285 */         new xdb.logs.LogLong(this, LevelGrowthFundActivityInfo.this.purchase_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             LevelGrowthFundActivityInfo.this.purchase_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.purchase_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSortid(int _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new LogKey(this, "sortid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 306 */         new xdb.logs.LogInt(this, LevelGrowthFundActivityInfo.this.sortid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             LevelGrowthFundActivityInfo.this.sortid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.sortid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIs_reset(boolean _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     xdb.Logs.logIf(new LogKey(this, "is_reset")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 327 */         new xdb.logs.LogObject(this, Boolean.valueOf(LevelGrowthFundActivityInfo.this.is_reset))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             LevelGrowthFundActivityInfo.this.is_reset = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.is_reset = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 342 */     _xdb_verify_unsafe_();
/* 343 */     LevelGrowthFundActivityInfo _o_ = null;
/* 344 */     if ((_o1_ instanceof LevelGrowthFundActivityInfo)) { _o_ = (LevelGrowthFundActivityInfo)_o1_;
/* 345 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 346 */       return false;
/* 347 */     if (this.purchased != _o_.purchased) return false;
/* 348 */     if (this.purchase_num != _o_.purchase_num) return false;
/* 349 */     if (this.sortid != _o_.sortid) return false;
/* 350 */     if (this.is_reset != _o_.is_reset) return false;
/* 351 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 357 */     _xdb_verify_unsafe_();
/* 358 */     int _h_ = 0;
/* 359 */     _h_ += (this.purchased ? 1231 : 1237);
/* 360 */     _h_ = (int)(_h_ + this.purchase_num);
/* 361 */     _h_ += this.sortid;
/* 362 */     _h_ += (this.is_reset ? 1231 : 1237);
/* 363 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     StringBuilder _sb_ = new StringBuilder();
/* 371 */     _sb_.append("(");
/* 372 */     _sb_.append(this.purchased);
/* 373 */     _sb_.append(",");
/* 374 */     _sb_.append(this.purchase_num);
/* 375 */     _sb_.append(",");
/* 376 */     _sb_.append(this.sortid);
/* 377 */     _sb_.append(",");
/* 378 */     _sb_.append(this.is_reset);
/* 379 */     _sb_.append(")");
/* 380 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 386 */     ListenableBean lb = new ListenableBean();
/* 387 */     lb.add(new ListenableChanged().setVarName("purchased"));
/* 388 */     lb.add(new ListenableChanged().setVarName("purchase_num"));
/* 389 */     lb.add(new ListenableChanged().setVarName("sortid"));
/* 390 */     lb.add(new ListenableChanged().setVarName("is_reset"));
/* 391 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.LevelGrowthFundActivityInfo {
/*     */     private Const() {}
/*     */     
/*     */     LevelGrowthFundActivityInfo nThis() {
/* 398 */       return LevelGrowthFundActivityInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 404 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LevelGrowthFundActivityInfo copy()
/*     */     {
/* 410 */       return LevelGrowthFundActivityInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LevelGrowthFundActivityInfo toData()
/*     */     {
/* 416 */       return LevelGrowthFundActivityInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.LevelGrowthFundActivityInfo toBean()
/*     */     {
/* 421 */       return LevelGrowthFundActivityInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LevelGrowthFundActivityInfo toDataIf()
/*     */     {
/* 427 */       return LevelGrowthFundActivityInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.LevelGrowthFundActivityInfo toBeanIf()
/*     */     {
/* 432 */       return LevelGrowthFundActivityInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getPurchased()
/*     */     {
/* 439 */       LevelGrowthFundActivityInfo.this._xdb_verify_unsafe_();
/* 440 */       return LevelGrowthFundActivityInfo.this.purchased;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPurchase_num()
/*     */     {
/* 447 */       LevelGrowthFundActivityInfo.this._xdb_verify_unsafe_();
/* 448 */       return LevelGrowthFundActivityInfo.this.purchase_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSortid()
/*     */     {
/* 455 */       LevelGrowthFundActivityInfo.this._xdb_verify_unsafe_();
/* 456 */       return LevelGrowthFundActivityInfo.this.sortid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_reset()
/*     */     {
/* 463 */       LevelGrowthFundActivityInfo.this._xdb_verify_unsafe_();
/* 464 */       return LevelGrowthFundActivityInfo.this.is_reset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPurchased(boolean _v_)
/*     */     {
/* 471 */       LevelGrowthFundActivityInfo.this._xdb_verify_unsafe_();
/* 472 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPurchase_num(long _v_)
/*     */     {
/* 479 */       LevelGrowthFundActivityInfo.this._xdb_verify_unsafe_();
/* 480 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSortid(int _v_)
/*     */     {
/* 487 */       LevelGrowthFundActivityInfo.this._xdb_verify_unsafe_();
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_reset(boolean _v_)
/*     */     {
/* 495 */       LevelGrowthFundActivityInfo.this._xdb_verify_unsafe_();
/* 496 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 502 */       LevelGrowthFundActivityInfo.this._xdb_verify_unsafe_();
/* 503 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 509 */       LevelGrowthFundActivityInfo.this._xdb_verify_unsafe_();
/* 510 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 516 */       return LevelGrowthFundActivityInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 522 */       return LevelGrowthFundActivityInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 528 */       LevelGrowthFundActivityInfo.this._xdb_verify_unsafe_();
/* 529 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 535 */       return LevelGrowthFundActivityInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 541 */       return LevelGrowthFundActivityInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 547 */       LevelGrowthFundActivityInfo.this._xdb_verify_unsafe_();
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 554 */       return LevelGrowthFundActivityInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 560 */       return LevelGrowthFundActivityInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 566 */       return LevelGrowthFundActivityInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 572 */       return LevelGrowthFundActivityInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 578 */       return LevelGrowthFundActivityInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 584 */       return LevelGrowthFundActivityInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 590 */       return LevelGrowthFundActivityInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.LevelGrowthFundActivityInfo
/*     */   {
/*     */     private boolean purchased;
/*     */     
/*     */     private long purchase_num;
/*     */     
/*     */     private int sortid;
/*     */     
/*     */     private boolean is_reset;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 608 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 613 */       this.is_reset = false;
/*     */     }
/*     */     
/*     */     Data(xbean.LevelGrowthFundActivityInfo _o1_)
/*     */     {
/* 618 */       if ((_o1_ instanceof LevelGrowthFundActivityInfo)) { assign((LevelGrowthFundActivityInfo)_o1_);
/* 619 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 620 */       } else if ((_o1_ instanceof LevelGrowthFundActivityInfo.Const)) assign(((LevelGrowthFundActivityInfo.Const)_o1_).nThis()); else {
/* 621 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(LevelGrowthFundActivityInfo _o_) {
/* 626 */       this.purchased = _o_.purchased;
/* 627 */       this.purchase_num = _o_.purchase_num;
/* 628 */       this.sortid = _o_.sortid;
/* 629 */       this.is_reset = _o_.is_reset;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 634 */       this.purchased = _o_.purchased;
/* 635 */       this.purchase_num = _o_.purchase_num;
/* 636 */       this.sortid = _o_.sortid;
/* 637 */       this.is_reset = _o_.is_reset;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 643 */       _os_.marshal(this.purchased);
/* 644 */       _os_.marshal(this.purchase_num);
/* 645 */       _os_.marshal(this.sortid);
/* 646 */       _os_.marshal(this.is_reset);
/* 647 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 653 */       this.purchased = _os_.unmarshal_boolean();
/* 654 */       this.purchase_num = _os_.unmarshal_long();
/* 655 */       this.sortid = _os_.unmarshal_int();
/* 656 */       this.is_reset = _os_.unmarshal_boolean();
/* 657 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 663 */       int _size_ = 0;
/* 664 */       _size_ += CodedOutputStream.computeBoolSize(1, this.purchased);
/* 665 */       _size_ += CodedOutputStream.computeInt64Size(2, this.purchase_num);
/* 666 */       _size_ += CodedOutputStream.computeInt32Size(3, this.sortid);
/* 667 */       _size_ += CodedOutputStream.computeBoolSize(4, this.is_reset);
/* 668 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 676 */         _output_.writeBool(1, this.purchased);
/* 677 */         _output_.writeInt64(2, this.purchase_num);
/* 678 */         _output_.writeInt32(3, this.sortid);
/* 679 */         _output_.writeBool(4, this.is_reset);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 683 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 685 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 693 */         boolean done = false;
/* 694 */         while (!done)
/*     */         {
/* 696 */           int tag = _input_.readTag();
/* 697 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 701 */             done = true;
/* 702 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 706 */             this.purchased = _input_.readBool();
/* 707 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 711 */             this.purchase_num = _input_.readInt64();
/* 712 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 716 */             this.sortid = _input_.readInt32();
/* 717 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 721 */             this.is_reset = _input_.readBool();
/* 722 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 726 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 728 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 737 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 741 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 743 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LevelGrowthFundActivityInfo copy()
/*     */     {
/* 749 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LevelGrowthFundActivityInfo toData()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.LevelGrowthFundActivityInfo toBean()
/*     */     {
/* 760 */       return new LevelGrowthFundActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LevelGrowthFundActivityInfo toDataIf()
/*     */     {
/* 766 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.LevelGrowthFundActivityInfo toBeanIf()
/*     */     {
/* 771 */       return new LevelGrowthFundActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 777 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 781 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 785 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 789 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 793 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 797 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 801 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getPurchased()
/*     */     {
/* 808 */       return this.purchased;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPurchase_num()
/*     */     {
/* 815 */       return this.purchase_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSortid()
/*     */     {
/* 822 */       return this.sortid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_reset()
/*     */     {
/* 829 */       return this.is_reset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPurchased(boolean _v_)
/*     */     {
/* 836 */       this.purchased = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPurchase_num(long _v_)
/*     */     {
/* 843 */       this.purchase_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSortid(int _v_)
/*     */     {
/* 850 */       this.sortid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_reset(boolean _v_)
/*     */     {
/* 857 */       this.is_reset = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 863 */       if (!(_o1_ instanceof Data)) return false;
/* 864 */       Data _o_ = (Data)_o1_;
/* 865 */       if (this.purchased != _o_.purchased) return false;
/* 866 */       if (this.purchase_num != _o_.purchase_num) return false;
/* 867 */       if (this.sortid != _o_.sortid) return false;
/* 868 */       if (this.is_reset != _o_.is_reset) return false;
/* 869 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 875 */       int _h_ = 0;
/* 876 */       _h_ += (this.purchased ? 1231 : 1237);
/* 877 */       _h_ = (int)(_h_ + this.purchase_num);
/* 878 */       _h_ += this.sortid;
/* 879 */       _h_ += (this.is_reset ? 1231 : 1237);
/* 880 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 886 */       StringBuilder _sb_ = new StringBuilder();
/* 887 */       _sb_.append("(");
/* 888 */       _sb_.append(this.purchased);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.purchase_num);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.sortid);
/* 893 */       _sb_.append(",");
/* 894 */       _sb_.append(this.is_reset);
/* 895 */       _sb_.append(")");
/* 896 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LevelGrowthFundActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
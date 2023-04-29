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
/*     */ 
/*     */ public final class ActivityFireData extends XBean implements xbean.ActivityFireData
/*     */ {
/*     */   private int hitawardcount;
/*     */   private long updatatime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.hitawardcount = 0;
/*  21 */     this.updatatime = 0L;
/*     */   }
/*     */   
/*     */   ActivityFireData(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public ActivityFireData()
/*     */   {
/*  31 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ActivityFireData(ActivityFireData _o_)
/*     */   {
/*  36 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ActivityFireData(xbean.ActivityFireData _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     if ((_o1_ instanceof ActivityFireData)) { assign((ActivityFireData)_o1_);
/*  43 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  44 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  45 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ActivityFireData _o_) {
/*  50 */     _o_._xdb_verify_unsafe_();
/*  51 */     this.hitawardcount = _o_.hitawardcount;
/*  52 */     this.updatatime = _o_.updatatime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  57 */     this.hitawardcount = _o_.hitawardcount;
/*  58 */     this.updatatime = _o_.updatatime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.marshal(this.hitawardcount);
/*  66 */     _os_.marshal(this.updatatime);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  73 */     _xdb_verify_unsafe_();
/*  74 */     this.hitawardcount = _os_.unmarshal_int();
/*  75 */     this.updatatime = _os_.unmarshal_long();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     int _size_ = 0;
/*  84 */     _size_ += CodedOutputStream.computeInt32Size(1, this.hitawardcount);
/*  85 */     _size_ += CodedOutputStream.computeInt64Size(2, this.updatatime);
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeInt32(1, this.hitawardcount);
/*  96 */       _output_.writeInt64(2, this.updatatime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 100 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 102 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       boolean done = false;
/* 112 */       while (!done)
/*     */       {
/* 114 */         int tag = _input_.readTag();
/* 115 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 119 */           done = true;
/* 120 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 124 */           this.hitawardcount = _input_.readInt32();
/* 125 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 129 */           this.updatatime = _input_.readInt64();
/* 130 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 134 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 136 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 145 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 149 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 151 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ActivityFireData copy()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new ActivityFireData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ActivityFireData toData()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ActivityFireData toBean()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new ActivityFireData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ActivityFireData toDataIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ActivityFireData toBeanIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getHitawardcount()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this.hitawardcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getUpdatatime()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.updatatime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHitawardcount(int _v_)
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     xdb.Logs.logIf(new LogKey(this, "hitawardcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 219 */         new xdb.logs.LogInt(this, ActivityFireData.this.hitawardcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 223 */             ActivityFireData.this.hitawardcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 227 */     });
/* 228 */     this.hitawardcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdatatime(long _v_)
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     xdb.Logs.logIf(new LogKey(this, "updatatime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 240 */         new xdb.logs.LogLong(this, ActivityFireData.this.updatatime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 244 */             ActivityFireData.this.updatatime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 248 */     });
/* 249 */     this.updatatime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     ActivityFireData _o_ = null;
/* 257 */     if ((_o1_ instanceof ActivityFireData)) { _o_ = (ActivityFireData)_o1_;
/* 258 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 259 */       return false;
/* 260 */     if (this.hitawardcount != _o_.hitawardcount) return false;
/* 261 */     if (this.updatatime != _o_.updatatime) return false;
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     int _h_ = 0;
/* 270 */     _h_ += this.hitawardcount;
/* 271 */     _h_ = (int)(_h_ + this.updatatime);
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.hitawardcount);
/* 282 */     _sb_.append(",");
/* 283 */     _sb_.append(this.updatatime);
/* 284 */     _sb_.append(")");
/* 285 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 291 */     ListenableBean lb = new ListenableBean();
/* 292 */     lb.add(new xdb.logs.ListenableChanged().setVarName("hitawardcount"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("updatatime"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ActivityFireData {
/*     */     private Const() {}
/*     */     
/*     */     ActivityFireData nThis() {
/* 301 */       return ActivityFireData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityFireData copy()
/*     */     {
/* 313 */       return ActivityFireData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityFireData toData()
/*     */     {
/* 319 */       return ActivityFireData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ActivityFireData toBean()
/*     */     {
/* 324 */       return ActivityFireData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityFireData toDataIf()
/*     */     {
/* 330 */       return ActivityFireData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ActivityFireData toBeanIf()
/*     */     {
/* 335 */       return ActivityFireData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHitawardcount()
/*     */     {
/* 342 */       ActivityFireData.this._xdb_verify_unsafe_();
/* 343 */       return ActivityFireData.this.hitawardcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getUpdatatime()
/*     */     {
/* 350 */       ActivityFireData.this._xdb_verify_unsafe_();
/* 351 */       return ActivityFireData.this.updatatime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHitawardcount(int _v_)
/*     */     {
/* 358 */       ActivityFireData.this._xdb_verify_unsafe_();
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUpdatatime(long _v_)
/*     */     {
/* 366 */       ActivityFireData.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 373 */       ActivityFireData.this._xdb_verify_unsafe_();
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 380 */       ActivityFireData.this._xdb_verify_unsafe_();
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 387 */       return ActivityFireData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 393 */       return ActivityFireData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 399 */       ActivityFireData.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 406 */       return ActivityFireData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 412 */       return ActivityFireData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 418 */       ActivityFireData.this._xdb_verify_unsafe_();
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 425 */       return ActivityFireData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 431 */       return ActivityFireData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 437 */       return ActivityFireData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 443 */       return ActivityFireData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 449 */       return ActivityFireData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 455 */       return ActivityFireData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 461 */       return ActivityFireData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ActivityFireData
/*     */   {
/*     */     private int hitawardcount;
/*     */     
/*     */     private long updatatime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.ActivityFireData _o1_)
/*     */     {
/* 484 */       if ((_o1_ instanceof ActivityFireData)) { assign((ActivityFireData)_o1_);
/* 485 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 486 */       } else if ((_o1_ instanceof ActivityFireData.Const)) assign(((ActivityFireData.Const)_o1_).nThis()); else {
/* 487 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ActivityFireData _o_) {
/* 492 */       this.hitawardcount = _o_.hitawardcount;
/* 493 */       this.updatatime = _o_.updatatime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 498 */       this.hitawardcount = _o_.hitawardcount;
/* 499 */       this.updatatime = _o_.updatatime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 505 */       _os_.marshal(this.hitawardcount);
/* 506 */       _os_.marshal(this.updatatime);
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 513 */       this.hitawardcount = _os_.unmarshal_int();
/* 514 */       this.updatatime = _os_.unmarshal_long();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeInt32Size(1, this.hitawardcount);
/* 523 */       _size_ += CodedOutputStream.computeInt64Size(2, this.updatatime);
/* 524 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 532 */         _output_.writeInt32(1, this.hitawardcount);
/* 533 */         _output_.writeInt64(2, this.updatatime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 537 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 539 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 547 */         boolean done = false;
/* 548 */         while (!done)
/*     */         {
/* 550 */           int tag = _input_.readTag();
/* 551 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 555 */             done = true;
/* 556 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 560 */             this.hitawardcount = _input_.readInt32();
/* 561 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 565 */             this.updatatime = _input_.readInt64();
/* 566 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 570 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 572 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 581 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 585 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 587 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityFireData copy()
/*     */     {
/* 593 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityFireData toData()
/*     */     {
/* 599 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ActivityFireData toBean()
/*     */     {
/* 604 */       return new ActivityFireData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityFireData toDataIf()
/*     */     {
/* 610 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ActivityFireData toBeanIf()
/*     */     {
/* 615 */       return new ActivityFireData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 621 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 641 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 645 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHitawardcount()
/*     */     {
/* 652 */       return this.hitawardcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getUpdatatime()
/*     */     {
/* 659 */       return this.updatatime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHitawardcount(int _v_)
/*     */     {
/* 666 */       this.hitawardcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUpdatatime(long _v_)
/*     */     {
/* 673 */       this.updatatime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 679 */       if (!(_o1_ instanceof Data)) return false;
/* 680 */       Data _o_ = (Data)_o1_;
/* 681 */       if (this.hitawardcount != _o_.hitawardcount) return false;
/* 682 */       if (this.updatatime != _o_.updatatime) return false;
/* 683 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 689 */       int _h_ = 0;
/* 690 */       _h_ += this.hitawardcount;
/* 691 */       _h_ = (int)(_h_ + this.updatatime);
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.hitawardcount);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.updatatime);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ActivityFireData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
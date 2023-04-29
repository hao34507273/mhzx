/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogObject;
/*     */ 
/*     */ public final class FeiShengInfo extends XBean implements xbean.FeiShengInfo
/*     */ {
/*     */   private boolean is_activity_complete;
/*     */   private boolean have_get_activity_award;
/*     */   private boolean already_play_effect;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.is_activity_complete = false;
/*  23 */     this.have_get_activity_award = false;
/*  24 */     this.already_play_effect = false;
/*     */   }
/*     */   
/*     */   FeiShengInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.is_activity_complete = false;
/*  31 */     this.have_get_activity_award = false;
/*  32 */     this.already_play_effect = false;
/*     */   }
/*     */   
/*     */   public FeiShengInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FeiShengInfo(FeiShengInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FeiShengInfo(xbean.FeiShengInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof FeiShengInfo)) { assign((FeiShengInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FeiShengInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.is_activity_complete = _o_.is_activity_complete;
/*  58 */     this.have_get_activity_award = _o_.have_get_activity_award;
/*  59 */     this.already_play_effect = _o_.already_play_effect;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.is_activity_complete = _o_.is_activity_complete;
/*  65 */     this.have_get_activity_award = _o_.have_get_activity_award;
/*  66 */     this.already_play_effect = _o_.already_play_effect;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.is_activity_complete);
/*  74 */     _os_.marshal(this.have_get_activity_award);
/*  75 */     _os_.marshal(this.already_play_effect);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.is_activity_complete = _os_.unmarshal_boolean();
/*  84 */     this.have_get_activity_award = _os_.unmarshal_boolean();
/*  85 */     this.already_play_effect = _os_.unmarshal_boolean();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     _size_ += CodedOutputStream.computeBoolSize(1, this.is_activity_complete);
/*  95 */     _size_ += CodedOutputStream.computeBoolSize(2, this.have_get_activity_award);
/*  96 */     _size_ += CodedOutputStream.computeBoolSize(3, this.already_play_effect);
/*  97 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 106 */       _output_.writeBool(1, this.is_activity_complete);
/* 107 */       _output_.writeBool(2, this.have_get_activity_award);
/* 108 */       _output_.writeBool(3, this.already_play_effect);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 112 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 114 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       boolean done = false;
/* 124 */       while (!done)
/*     */       {
/* 126 */         int tag = _input_.readTag();
/* 127 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 131 */           done = true;
/* 132 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 136 */           this.is_activity_complete = _input_.readBool();
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 141 */           this.have_get_activity_award = _input_.readBool();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 146 */           this.already_play_effect = _input_.readBool();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 151 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 153 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 162 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 166 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 168 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FeiShengInfo copy()
/*     */   {
/* 174 */     _xdb_verify_unsafe_();
/* 175 */     return new FeiShengInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FeiShengInfo toData()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FeiShengInfo toBean()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new FeiShengInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FeiShengInfo toDataIf()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FeiShengInfo toBeanIf()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIs_activity_complete()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this.is_activity_complete;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getHave_get_activity_award()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return this.have_get_activity_award;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getAlready_play_effect()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this.already_play_effect;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIs_activity_complete(boolean _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     xdb.Logs.logIf(new LogKey(this, "is_activity_complete")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 244 */         new LogObject(this, Boolean.valueOf(FeiShengInfo.this.is_activity_complete))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             FeiShengInfo.this.is_activity_complete = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.is_activity_complete = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHave_get_activity_award(boolean _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "have_get_activity_award")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new LogObject(this, Boolean.valueOf(FeiShengInfo.this.have_get_activity_award))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             FeiShengInfo.this.have_get_activity_award = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.have_get_activity_award = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAlready_play_effect(boolean _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "already_play_effect")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new LogObject(this, Boolean.valueOf(FeiShengInfo.this.already_play_effect))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             FeiShengInfo.this.already_play_effect = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.already_play_effect = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     FeiShengInfo _o_ = null;
/* 303 */     if ((_o1_ instanceof FeiShengInfo)) { _o_ = (FeiShengInfo)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (this.is_activity_complete != _o_.is_activity_complete) return false;
/* 307 */     if (this.have_get_activity_award != _o_.have_get_activity_award) return false;
/* 308 */     if (this.already_play_effect != _o_.already_play_effect) return false;
/* 309 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     int _h_ = 0;
/* 317 */     _h_ += (this.is_activity_complete ? 1231 : 1237);
/* 318 */     _h_ += (this.have_get_activity_award ? 1231 : 1237);
/* 319 */     _h_ += (this.already_play_effect ? 1231 : 1237);
/* 320 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     StringBuilder _sb_ = new StringBuilder();
/* 328 */     _sb_.append("(");
/* 329 */     _sb_.append(this.is_activity_complete);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.have_get_activity_award);
/* 332 */     _sb_.append(",");
/* 333 */     _sb_.append(this.already_play_effect);
/* 334 */     _sb_.append(")");
/* 335 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 341 */     ListenableBean lb = new ListenableBean();
/* 342 */     lb.add(new ListenableChanged().setVarName("is_activity_complete"));
/* 343 */     lb.add(new ListenableChanged().setVarName("have_get_activity_award"));
/* 344 */     lb.add(new ListenableChanged().setVarName("already_play_effect"));
/* 345 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FeiShengInfo {
/*     */     private Const() {}
/*     */     
/*     */     FeiShengInfo nThis() {
/* 352 */       return FeiShengInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeiShengInfo copy()
/*     */     {
/* 364 */       return FeiShengInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeiShengInfo toData()
/*     */     {
/* 370 */       return FeiShengInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FeiShengInfo toBean()
/*     */     {
/* 375 */       return FeiShengInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeiShengInfo toDataIf()
/*     */     {
/* 381 */       return FeiShengInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FeiShengInfo toBeanIf()
/*     */     {
/* 386 */       return FeiShengInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_activity_complete()
/*     */     {
/* 393 */       FeiShengInfo.this._xdb_verify_unsafe_();
/* 394 */       return FeiShengInfo.this.is_activity_complete;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getHave_get_activity_award()
/*     */     {
/* 401 */       FeiShengInfo.this._xdb_verify_unsafe_();
/* 402 */       return FeiShengInfo.this.have_get_activity_award;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getAlready_play_effect()
/*     */     {
/* 409 */       FeiShengInfo.this._xdb_verify_unsafe_();
/* 410 */       return FeiShengInfo.this.already_play_effect;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_activity_complete(boolean _v_)
/*     */     {
/* 417 */       FeiShengInfo.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHave_get_activity_award(boolean _v_)
/*     */     {
/* 425 */       FeiShengInfo.this._xdb_verify_unsafe_();
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAlready_play_effect(boolean _v_)
/*     */     {
/* 433 */       FeiShengInfo.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 440 */       FeiShengInfo.this._xdb_verify_unsafe_();
/* 441 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 447 */       FeiShengInfo.this._xdb_verify_unsafe_();
/* 448 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 454 */       return FeiShengInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 460 */       return FeiShengInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 466 */       FeiShengInfo.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 473 */       return FeiShengInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 479 */       return FeiShengInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 485 */       FeiShengInfo.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 492 */       return FeiShengInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 498 */       return FeiShengInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 504 */       return FeiShengInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 510 */       return FeiShengInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 516 */       return FeiShengInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 522 */       return FeiShengInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 528 */       return FeiShengInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FeiShengInfo
/*     */   {
/*     */     private boolean is_activity_complete;
/*     */     
/*     */     private boolean have_get_activity_award;
/*     */     
/*     */     private boolean already_play_effect;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 549 */       this.is_activity_complete = false;
/* 550 */       this.have_get_activity_award = false;
/* 551 */       this.already_play_effect = false;
/*     */     }
/*     */     
/*     */     Data(xbean.FeiShengInfo _o1_)
/*     */     {
/* 556 */       if ((_o1_ instanceof FeiShengInfo)) { assign((FeiShengInfo)_o1_);
/* 557 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 558 */       } else if ((_o1_ instanceof FeiShengInfo.Const)) assign(((FeiShengInfo.Const)_o1_).nThis()); else {
/* 559 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FeiShengInfo _o_) {
/* 564 */       this.is_activity_complete = _o_.is_activity_complete;
/* 565 */       this.have_get_activity_award = _o_.have_get_activity_award;
/* 566 */       this.already_play_effect = _o_.already_play_effect;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 571 */       this.is_activity_complete = _o_.is_activity_complete;
/* 572 */       this.have_get_activity_award = _o_.have_get_activity_award;
/* 573 */       this.already_play_effect = _o_.already_play_effect;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 579 */       _os_.marshal(this.is_activity_complete);
/* 580 */       _os_.marshal(this.have_get_activity_award);
/* 581 */       _os_.marshal(this.already_play_effect);
/* 582 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 588 */       this.is_activity_complete = _os_.unmarshal_boolean();
/* 589 */       this.have_get_activity_award = _os_.unmarshal_boolean();
/* 590 */       this.already_play_effect = _os_.unmarshal_boolean();
/* 591 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 597 */       int _size_ = 0;
/* 598 */       _size_ += CodedOutputStream.computeBoolSize(1, this.is_activity_complete);
/* 599 */       _size_ += CodedOutputStream.computeBoolSize(2, this.have_get_activity_award);
/* 600 */       _size_ += CodedOutputStream.computeBoolSize(3, this.already_play_effect);
/* 601 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 609 */         _output_.writeBool(1, this.is_activity_complete);
/* 610 */         _output_.writeBool(2, this.have_get_activity_award);
/* 611 */         _output_.writeBool(3, this.already_play_effect);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 615 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 617 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 625 */         boolean done = false;
/* 626 */         while (!done)
/*     */         {
/* 628 */           int tag = _input_.readTag();
/* 629 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 633 */             done = true;
/* 634 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 638 */             this.is_activity_complete = _input_.readBool();
/* 639 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 643 */             this.have_get_activity_award = _input_.readBool();
/* 644 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 648 */             this.already_play_effect = _input_.readBool();
/* 649 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 653 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 655 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 664 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 668 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 670 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeiShengInfo copy()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeiShengInfo toData()
/*     */     {
/* 682 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FeiShengInfo toBean()
/*     */     {
/* 687 */       return new FeiShengInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeiShengInfo toDataIf()
/*     */     {
/* 693 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FeiShengInfo toBeanIf()
/*     */     {
/* 698 */       return new FeiShengInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 720 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 724 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 728 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_activity_complete()
/*     */     {
/* 735 */       return this.is_activity_complete;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getHave_get_activity_award()
/*     */     {
/* 742 */       return this.have_get_activity_award;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getAlready_play_effect()
/*     */     {
/* 749 */       return this.already_play_effect;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_activity_complete(boolean _v_)
/*     */     {
/* 756 */       this.is_activity_complete = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHave_get_activity_award(boolean _v_)
/*     */     {
/* 763 */       this.have_get_activity_award = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAlready_play_effect(boolean _v_)
/*     */     {
/* 770 */       this.already_play_effect = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 776 */       if (!(_o1_ instanceof Data)) return false;
/* 777 */       Data _o_ = (Data)_o1_;
/* 778 */       if (this.is_activity_complete != _o_.is_activity_complete) return false;
/* 779 */       if (this.have_get_activity_award != _o_.have_get_activity_award) return false;
/* 780 */       if (this.already_play_effect != _o_.already_play_effect) return false;
/* 781 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 787 */       int _h_ = 0;
/* 788 */       _h_ += (this.is_activity_complete ? 1231 : 1237);
/* 789 */       _h_ += (this.have_get_activity_award ? 1231 : 1237);
/* 790 */       _h_ += (this.already_play_effect ? 1231 : 1237);
/* 791 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 797 */       StringBuilder _sb_ = new StringBuilder();
/* 798 */       _sb_.append("(");
/* 799 */       _sb_.append(this.is_activity_complete);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.have_get_activity_award);
/* 802 */       _sb_.append(",");
/* 803 */       _sb_.append(this.already_play_effect);
/* 804 */       _sb_.append(")");
/* 805 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FeiShengInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
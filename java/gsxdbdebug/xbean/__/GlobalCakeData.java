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
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class GlobalCakeData extends XBean implements xbean.GlobalCakeData
/*     */ {
/*     */   private int curturn;
/*     */   private int curstage;
/*     */   private boolean isgoing;
/*     */   private long stagestarttime;
/*     */   private boolean recovery;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.curturn = 0;
/*  27 */     this.curstage = 0;
/*  28 */     this.isgoing = false;
/*  29 */     this.stagestarttime = 0L;
/*  30 */     this.recovery = false;
/*     */   }
/*     */   
/*     */   GlobalCakeData(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public GlobalCakeData()
/*     */   {
/*  40 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GlobalCakeData(GlobalCakeData _o_)
/*     */   {
/*  45 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GlobalCakeData(xbean.GlobalCakeData _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  50 */     super(_xp_, _vn_);
/*  51 */     if ((_o1_ instanceof GlobalCakeData)) { assign((GlobalCakeData)_o1_);
/*  52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  54 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GlobalCakeData _o_) {
/*  59 */     _o_._xdb_verify_unsafe_();
/*  60 */     this.curturn = _o_.curturn;
/*  61 */     this.curstage = _o_.curstage;
/*  62 */     this.isgoing = _o_.isgoing;
/*  63 */     this.stagestarttime = _o_.stagestarttime;
/*  64 */     this.recovery = _o_.recovery;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.curturn = _o_.curturn;
/*  70 */     this.curstage = _o_.curstage;
/*  71 */     this.isgoing = _o_.isgoing;
/*  72 */     this.stagestarttime = _o_.stagestarttime;
/*  73 */     this.recovery = _o_.recovery;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.curturn);
/*  81 */     _os_.marshal(this.curstage);
/*  82 */     _os_.marshal(this.isgoing);
/*  83 */     _os_.marshal(this.stagestarttime);
/*  84 */     _os_.marshal(this.recovery);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     this.curturn = _os_.unmarshal_int();
/*  93 */     this.curstage = _os_.unmarshal_int();
/*  94 */     this.isgoing = _os_.unmarshal_boolean();
/*  95 */     this.stagestarttime = _os_.unmarshal_long();
/*  96 */     this.recovery = _os_.unmarshal_boolean();
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     int _size_ = 0;
/* 105 */     _size_ += CodedOutputStream.computeInt32Size(1, this.curturn);
/* 106 */     _size_ += CodedOutputStream.computeInt32Size(2, this.curstage);
/* 107 */     _size_ += CodedOutputStream.computeBoolSize(3, this.isgoing);
/* 108 */     _size_ += CodedOutputStream.computeInt64Size(4, this.stagestarttime);
/* 109 */     _size_ += CodedOutputStream.computeBoolSize(5, this.recovery);
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeInt32(1, this.curturn);
/* 120 */       _output_.writeInt32(2, this.curstage);
/* 121 */       _output_.writeBool(3, this.isgoing);
/* 122 */       _output_.writeInt64(4, this.stagestarttime);
/* 123 */       _output_.writeBool(5, this.recovery);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 127 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 129 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       boolean done = false;
/* 139 */       while (!done)
/*     */       {
/* 141 */         int tag = _input_.readTag();
/* 142 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 146 */           done = true;
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 151 */           this.curturn = _input_.readInt32();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           this.curstage = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 161 */           this.isgoing = _input_.readBool();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 166 */           this.stagestarttime = _input_.readInt64();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 171 */           this.recovery = _input_.readBool();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobalCakeData copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new GlobalCakeData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobalCakeData toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GlobalCakeData toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new GlobalCakeData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobalCakeData toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GlobalCakeData toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCurturn()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.curturn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCurstage()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return this.curstage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIsgoing()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     return this.isgoing;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStagestarttime()
/*     */   {
/* 264 */     _xdb_verify_unsafe_();
/* 265 */     return this.stagestarttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getRecovery()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return this.recovery;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCurturn(int _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     Logs.logIf(new LogKey(this, "curturn")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 285 */         new xdb.logs.LogInt(this, GlobalCakeData.this.curturn)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             GlobalCakeData.this.curturn = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.curturn = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCurstage(int _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     Logs.logIf(new LogKey(this, "curstage")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 306 */         new xdb.logs.LogInt(this, GlobalCakeData.this.curstage)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             GlobalCakeData.this.curstage = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.curstage = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsgoing(boolean _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     Logs.logIf(new LogKey(this, "isgoing")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 327 */         new xdb.logs.LogObject(this, Boolean.valueOf(GlobalCakeData.this.isgoing))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             GlobalCakeData.this.isgoing = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.isgoing = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStagestarttime(long _v_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     Logs.logIf(new LogKey(this, "stagestarttime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 348 */         new xdb.logs.LogLong(this, GlobalCakeData.this.stagestarttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 352 */             GlobalCakeData.this.stagestarttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 356 */     });
/* 357 */     this.stagestarttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRecovery(boolean _v_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     Logs.logIf(new LogKey(this, "recovery")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 369 */         new xdb.logs.LogObject(this, Boolean.valueOf(GlobalCakeData.this.recovery))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 373 */             GlobalCakeData.this.recovery = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 377 */     });
/* 378 */     this.recovery = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 384 */     _xdb_verify_unsafe_();
/* 385 */     GlobalCakeData _o_ = null;
/* 386 */     if ((_o1_ instanceof GlobalCakeData)) { _o_ = (GlobalCakeData)_o1_;
/* 387 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 388 */       return false;
/* 389 */     if (this.curturn != _o_.curturn) return false;
/* 390 */     if (this.curstage != _o_.curstage) return false;
/* 391 */     if (this.isgoing != _o_.isgoing) return false;
/* 392 */     if (this.stagestarttime != _o_.stagestarttime) return false;
/* 393 */     if (this.recovery != _o_.recovery) return false;
/* 394 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 400 */     _xdb_verify_unsafe_();
/* 401 */     int _h_ = 0;
/* 402 */     _h_ += this.curturn;
/* 403 */     _h_ += this.curstage;
/* 404 */     _h_ += (this.isgoing ? 1231 : 1237);
/* 405 */     _h_ = (int)(_h_ + this.stagestarttime);
/* 406 */     _h_ += (this.recovery ? 1231 : 1237);
/* 407 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 413 */     _xdb_verify_unsafe_();
/* 414 */     StringBuilder _sb_ = new StringBuilder();
/* 415 */     _sb_.append("(");
/* 416 */     _sb_.append(this.curturn);
/* 417 */     _sb_.append(",");
/* 418 */     _sb_.append(this.curstage);
/* 419 */     _sb_.append(",");
/* 420 */     _sb_.append(this.isgoing);
/* 421 */     _sb_.append(",");
/* 422 */     _sb_.append(this.stagestarttime);
/* 423 */     _sb_.append(",");
/* 424 */     _sb_.append(this.recovery);
/* 425 */     _sb_.append(")");
/* 426 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 432 */     ListenableBean lb = new ListenableBean();
/* 433 */     lb.add(new ListenableChanged().setVarName("curturn"));
/* 434 */     lb.add(new ListenableChanged().setVarName("curstage"));
/* 435 */     lb.add(new ListenableChanged().setVarName("isgoing"));
/* 436 */     lb.add(new ListenableChanged().setVarName("stagestarttime"));
/* 437 */     lb.add(new ListenableChanged().setVarName("recovery"));
/* 438 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GlobalCakeData {
/*     */     private Const() {}
/*     */     
/*     */     GlobalCakeData nThis() {
/* 445 */       return GlobalCakeData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalCakeData copy()
/*     */     {
/* 457 */       return GlobalCakeData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalCakeData toData()
/*     */     {
/* 463 */       return GlobalCakeData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GlobalCakeData toBean()
/*     */     {
/* 468 */       return GlobalCakeData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalCakeData toDataIf()
/*     */     {
/* 474 */       return GlobalCakeData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GlobalCakeData toBeanIf()
/*     */     {
/* 479 */       return GlobalCakeData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurturn()
/*     */     {
/* 486 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 487 */       return GlobalCakeData.this.curturn;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurstage()
/*     */     {
/* 494 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 495 */       return GlobalCakeData.this.curstage;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsgoing()
/*     */     {
/* 502 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 503 */       return GlobalCakeData.this.isgoing;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStagestarttime()
/*     */     {
/* 510 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 511 */       return GlobalCakeData.this.stagestarttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getRecovery()
/*     */     {
/* 518 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 519 */       return GlobalCakeData.this.recovery;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurturn(int _v_)
/*     */     {
/* 526 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 527 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurstage(int _v_)
/*     */     {
/* 534 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 535 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsgoing(boolean _v_)
/*     */     {
/* 542 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 543 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStagestarttime(long _v_)
/*     */     {
/* 550 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRecovery(boolean _v_)
/*     */     {
/* 558 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 565 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 566 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 572 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 573 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 579 */       return GlobalCakeData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 585 */       return GlobalCakeData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 591 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 598 */       return GlobalCakeData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 604 */       return GlobalCakeData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 610 */       GlobalCakeData.this._xdb_verify_unsafe_();
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 617 */       return GlobalCakeData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       return GlobalCakeData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 629 */       return GlobalCakeData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 635 */       return GlobalCakeData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 641 */       return GlobalCakeData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 647 */       return GlobalCakeData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 653 */       return GlobalCakeData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GlobalCakeData
/*     */   {
/*     */     private int curturn;
/*     */     
/*     */     private int curstage;
/*     */     
/*     */     private boolean isgoing;
/*     */     
/*     */     private long stagestarttime;
/*     */     
/*     */     private boolean recovery;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 673 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.GlobalCakeData _o1_)
/*     */     {
/* 682 */       if ((_o1_ instanceof GlobalCakeData)) { assign((GlobalCakeData)_o1_);
/* 683 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 684 */       } else if ((_o1_ instanceof GlobalCakeData.Const)) assign(((GlobalCakeData.Const)_o1_).nThis()); else {
/* 685 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GlobalCakeData _o_) {
/* 690 */       this.curturn = _o_.curturn;
/* 691 */       this.curstage = _o_.curstage;
/* 692 */       this.isgoing = _o_.isgoing;
/* 693 */       this.stagestarttime = _o_.stagestarttime;
/* 694 */       this.recovery = _o_.recovery;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 699 */       this.curturn = _o_.curturn;
/* 700 */       this.curstage = _o_.curstage;
/* 701 */       this.isgoing = _o_.isgoing;
/* 702 */       this.stagestarttime = _o_.stagestarttime;
/* 703 */       this.recovery = _o_.recovery;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 709 */       _os_.marshal(this.curturn);
/* 710 */       _os_.marshal(this.curstage);
/* 711 */       _os_.marshal(this.isgoing);
/* 712 */       _os_.marshal(this.stagestarttime);
/* 713 */       _os_.marshal(this.recovery);
/* 714 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 720 */       this.curturn = _os_.unmarshal_int();
/* 721 */       this.curstage = _os_.unmarshal_int();
/* 722 */       this.isgoing = _os_.unmarshal_boolean();
/* 723 */       this.stagestarttime = _os_.unmarshal_long();
/* 724 */       this.recovery = _os_.unmarshal_boolean();
/* 725 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 731 */       int _size_ = 0;
/* 732 */       _size_ += CodedOutputStream.computeInt32Size(1, this.curturn);
/* 733 */       _size_ += CodedOutputStream.computeInt32Size(2, this.curstage);
/* 734 */       _size_ += CodedOutputStream.computeBoolSize(3, this.isgoing);
/* 735 */       _size_ += CodedOutputStream.computeInt64Size(4, this.stagestarttime);
/* 736 */       _size_ += CodedOutputStream.computeBoolSize(5, this.recovery);
/* 737 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 745 */         _output_.writeInt32(1, this.curturn);
/* 746 */         _output_.writeInt32(2, this.curstage);
/* 747 */         _output_.writeBool(3, this.isgoing);
/* 748 */         _output_.writeInt64(4, this.stagestarttime);
/* 749 */         _output_.writeBool(5, this.recovery);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 753 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 755 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 763 */         boolean done = false;
/* 764 */         while (!done)
/*     */         {
/* 766 */           int tag = _input_.readTag();
/* 767 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 771 */             done = true;
/* 772 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 776 */             this.curturn = _input_.readInt32();
/* 777 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 781 */             this.curstage = _input_.readInt32();
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 786 */             this.isgoing = _input_.readBool();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 791 */             this.stagestarttime = _input_.readInt64();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 796 */             this.recovery = _input_.readBool();
/* 797 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 801 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 803 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 812 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 816 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 818 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalCakeData copy()
/*     */     {
/* 824 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalCakeData toData()
/*     */     {
/* 830 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GlobalCakeData toBean()
/*     */     {
/* 835 */       return new GlobalCakeData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalCakeData toDataIf()
/*     */     {
/* 841 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GlobalCakeData toBeanIf()
/*     */     {
/* 846 */       return new GlobalCakeData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 852 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 856 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 868 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 872 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 876 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurturn()
/*     */     {
/* 883 */       return this.curturn;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurstage()
/*     */     {
/* 890 */       return this.curstage;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsgoing()
/*     */     {
/* 897 */       return this.isgoing;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStagestarttime()
/*     */     {
/* 904 */       return this.stagestarttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getRecovery()
/*     */     {
/* 911 */       return this.recovery;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurturn(int _v_)
/*     */     {
/* 918 */       this.curturn = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurstage(int _v_)
/*     */     {
/* 925 */       this.curstage = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsgoing(boolean _v_)
/*     */     {
/* 932 */       this.isgoing = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStagestarttime(long _v_)
/*     */     {
/* 939 */       this.stagestarttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRecovery(boolean _v_)
/*     */     {
/* 946 */       this.recovery = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 952 */       if (!(_o1_ instanceof Data)) return false;
/* 953 */       Data _o_ = (Data)_o1_;
/* 954 */       if (this.curturn != _o_.curturn) return false;
/* 955 */       if (this.curstage != _o_.curstage) return false;
/* 956 */       if (this.isgoing != _o_.isgoing) return false;
/* 957 */       if (this.stagestarttime != _o_.stagestarttime) return false;
/* 958 */       if (this.recovery != _o_.recovery) return false;
/* 959 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 965 */       int _h_ = 0;
/* 966 */       _h_ += this.curturn;
/* 967 */       _h_ += this.curstage;
/* 968 */       _h_ += (this.isgoing ? 1231 : 1237);
/* 969 */       _h_ = (int)(_h_ + this.stagestarttime);
/* 970 */       _h_ += (this.recovery ? 1231 : 1237);
/* 971 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 977 */       StringBuilder _sb_ = new StringBuilder();
/* 978 */       _sb_.append("(");
/* 979 */       _sb_.append(this.curturn);
/* 980 */       _sb_.append(",");
/* 981 */       _sb_.append(this.curstage);
/* 982 */       _sb_.append(",");
/* 983 */       _sb_.append(this.isgoing);
/* 984 */       _sb_.append(",");
/* 985 */       _sb_.append(this.stagestarttime);
/* 986 */       _sb_.append(",");
/* 987 */       _sb_.append(this.recovery);
/* 988 */       _sb_.append(")");
/* 989 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GlobalCakeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
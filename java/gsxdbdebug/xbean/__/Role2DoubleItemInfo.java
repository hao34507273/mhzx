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
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class Role2DoubleItemInfo extends XBean implements xbean.Role2DoubleItemInfo
/*     */ {
/*     */   private int today_guarantee_times;
/*     */   private long today_guarantee_refresh_time;
/*     */   private int today_trigger_times;
/*     */   private long today_trigger_refresh_time;
/*     */   private int guarantee_not_trigger_times;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.today_guarantee_times = 0;
/*  27 */     this.today_guarantee_refresh_time = 0L;
/*  28 */     this.today_trigger_times = 0;
/*  29 */     this.today_trigger_refresh_time = 0L;
/*  30 */     this.guarantee_not_trigger_times = 0;
/*     */   }
/*     */   
/*     */   Role2DoubleItemInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public Role2DoubleItemInfo()
/*     */   {
/*  40 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Role2DoubleItemInfo(Role2DoubleItemInfo _o_)
/*     */   {
/*  45 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Role2DoubleItemInfo(xbean.Role2DoubleItemInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  50 */     super(_xp_, _vn_);
/*  51 */     if ((_o1_ instanceof Role2DoubleItemInfo)) { assign((Role2DoubleItemInfo)_o1_);
/*  52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  54 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Role2DoubleItemInfo _o_) {
/*  59 */     _o_._xdb_verify_unsafe_();
/*  60 */     this.today_guarantee_times = _o_.today_guarantee_times;
/*  61 */     this.today_guarantee_refresh_time = _o_.today_guarantee_refresh_time;
/*  62 */     this.today_trigger_times = _o_.today_trigger_times;
/*  63 */     this.today_trigger_refresh_time = _o_.today_trigger_refresh_time;
/*  64 */     this.guarantee_not_trigger_times = _o_.guarantee_not_trigger_times;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.today_guarantee_times = _o_.today_guarantee_times;
/*  70 */     this.today_guarantee_refresh_time = _o_.today_guarantee_refresh_time;
/*  71 */     this.today_trigger_times = _o_.today_trigger_times;
/*  72 */     this.today_trigger_refresh_time = _o_.today_trigger_refresh_time;
/*  73 */     this.guarantee_not_trigger_times = _o_.guarantee_not_trigger_times;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.today_guarantee_times);
/*  81 */     _os_.marshal(this.today_guarantee_refresh_time);
/*  82 */     _os_.marshal(this.today_trigger_times);
/*  83 */     _os_.marshal(this.today_trigger_refresh_time);
/*  84 */     _os_.marshal(this.guarantee_not_trigger_times);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     this.today_guarantee_times = _os_.unmarshal_int();
/*  93 */     this.today_guarantee_refresh_time = _os_.unmarshal_long();
/*  94 */     this.today_trigger_times = _os_.unmarshal_int();
/*  95 */     this.today_trigger_refresh_time = _os_.unmarshal_long();
/*  96 */     this.guarantee_not_trigger_times = _os_.unmarshal_int();
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     int _size_ = 0;
/* 105 */     _size_ += CodedOutputStream.computeInt32Size(1, this.today_guarantee_times);
/* 106 */     _size_ += CodedOutputStream.computeInt64Size(2, this.today_guarantee_refresh_time);
/* 107 */     _size_ += CodedOutputStream.computeInt32Size(3, this.today_trigger_times);
/* 108 */     _size_ += CodedOutputStream.computeInt64Size(4, this.today_trigger_refresh_time);
/* 109 */     _size_ += CodedOutputStream.computeInt32Size(5, this.guarantee_not_trigger_times);
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeInt32(1, this.today_guarantee_times);
/* 120 */       _output_.writeInt64(2, this.today_guarantee_refresh_time);
/* 121 */       _output_.writeInt32(3, this.today_trigger_times);
/* 122 */       _output_.writeInt64(4, this.today_trigger_refresh_time);
/* 123 */       _output_.writeInt32(5, this.guarantee_not_trigger_times);
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
/* 151 */           this.today_guarantee_times = _input_.readInt32();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           this.today_guarantee_refresh_time = _input_.readInt64();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 161 */           this.today_trigger_times = _input_.readInt32();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 166 */           this.today_trigger_refresh_time = _input_.readInt64();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 171 */           this.guarantee_not_trigger_times = _input_.readInt32();
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
/*     */   public xbean.Role2DoubleItemInfo copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new Role2DoubleItemInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2DoubleItemInfo toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2DoubleItemInfo toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new Role2DoubleItemInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2DoubleItemInfo toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2DoubleItemInfo toBeanIf()
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
/*     */   public int getToday_guarantee_times()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.today_guarantee_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getToday_guarantee_refresh_time()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return this.today_guarantee_refresh_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getToday_trigger_times()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     return this.today_trigger_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getToday_trigger_refresh_time()
/*     */   {
/* 264 */     _xdb_verify_unsafe_();
/* 265 */     return this.today_trigger_refresh_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGuarantee_not_trigger_times()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return this.guarantee_not_trigger_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setToday_guarantee_times(int _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "today_guarantee_times")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 285 */         new LogInt(this, Role2DoubleItemInfo.this.today_guarantee_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             Role2DoubleItemInfo.this.today_guarantee_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.today_guarantee_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setToday_guarantee_refresh_time(long _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new LogKey(this, "today_guarantee_refresh_time")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 306 */         new xdb.logs.LogLong(this, Role2DoubleItemInfo.this.today_guarantee_refresh_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             Role2DoubleItemInfo.this.today_guarantee_refresh_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.today_guarantee_refresh_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setToday_trigger_times(int _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     xdb.Logs.logIf(new LogKey(this, "today_trigger_times")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 327 */         new LogInt(this, Role2DoubleItemInfo.this.today_trigger_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             Role2DoubleItemInfo.this.today_trigger_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.today_trigger_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setToday_trigger_refresh_time(long _v_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     xdb.Logs.logIf(new LogKey(this, "today_trigger_refresh_time")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 348 */         new xdb.logs.LogLong(this, Role2DoubleItemInfo.this.today_trigger_refresh_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 352 */             Role2DoubleItemInfo.this.today_trigger_refresh_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 356 */     });
/* 357 */     this.today_trigger_refresh_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGuarantee_not_trigger_times(int _v_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     xdb.Logs.logIf(new LogKey(this, "guarantee_not_trigger_times")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 369 */         new LogInt(this, Role2DoubleItemInfo.this.guarantee_not_trigger_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 373 */             Role2DoubleItemInfo.this.guarantee_not_trigger_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 377 */     });
/* 378 */     this.guarantee_not_trigger_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 384 */     _xdb_verify_unsafe_();
/* 385 */     Role2DoubleItemInfo _o_ = null;
/* 386 */     if ((_o1_ instanceof Role2DoubleItemInfo)) { _o_ = (Role2DoubleItemInfo)_o1_;
/* 387 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 388 */       return false;
/* 389 */     if (this.today_guarantee_times != _o_.today_guarantee_times) return false;
/* 390 */     if (this.today_guarantee_refresh_time != _o_.today_guarantee_refresh_time) return false;
/* 391 */     if (this.today_trigger_times != _o_.today_trigger_times) return false;
/* 392 */     if (this.today_trigger_refresh_time != _o_.today_trigger_refresh_time) return false;
/* 393 */     if (this.guarantee_not_trigger_times != _o_.guarantee_not_trigger_times) return false;
/* 394 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 400 */     _xdb_verify_unsafe_();
/* 401 */     int _h_ = 0;
/* 402 */     _h_ += this.today_guarantee_times;
/* 403 */     _h_ = (int)(_h_ + this.today_guarantee_refresh_time);
/* 404 */     _h_ += this.today_trigger_times;
/* 405 */     _h_ = (int)(_h_ + this.today_trigger_refresh_time);
/* 406 */     _h_ += this.guarantee_not_trigger_times;
/* 407 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 413 */     _xdb_verify_unsafe_();
/* 414 */     StringBuilder _sb_ = new StringBuilder();
/* 415 */     _sb_.append("(");
/* 416 */     _sb_.append(this.today_guarantee_times);
/* 417 */     _sb_.append(",");
/* 418 */     _sb_.append(this.today_guarantee_refresh_time);
/* 419 */     _sb_.append(",");
/* 420 */     _sb_.append(this.today_trigger_times);
/* 421 */     _sb_.append(",");
/* 422 */     _sb_.append(this.today_trigger_refresh_time);
/* 423 */     _sb_.append(",");
/* 424 */     _sb_.append(this.guarantee_not_trigger_times);
/* 425 */     _sb_.append(")");
/* 426 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 432 */     ListenableBean lb = new ListenableBean();
/* 433 */     lb.add(new ListenableChanged().setVarName("today_guarantee_times"));
/* 434 */     lb.add(new ListenableChanged().setVarName("today_guarantee_refresh_time"));
/* 435 */     lb.add(new ListenableChanged().setVarName("today_trigger_times"));
/* 436 */     lb.add(new ListenableChanged().setVarName("today_trigger_refresh_time"));
/* 437 */     lb.add(new ListenableChanged().setVarName("guarantee_not_trigger_times"));
/* 438 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Role2DoubleItemInfo {
/*     */     private Const() {}
/*     */     
/*     */     Role2DoubleItemInfo nThis() {
/* 445 */       return Role2DoubleItemInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2DoubleItemInfo copy()
/*     */     {
/* 457 */       return Role2DoubleItemInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2DoubleItemInfo toData()
/*     */     {
/* 463 */       return Role2DoubleItemInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Role2DoubleItemInfo toBean()
/*     */     {
/* 468 */       return Role2DoubleItemInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2DoubleItemInfo toDataIf()
/*     */     {
/* 474 */       return Role2DoubleItemInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Role2DoubleItemInfo toBeanIf()
/*     */     {
/* 479 */       return Role2DoubleItemInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getToday_guarantee_times()
/*     */     {
/* 486 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 487 */       return Role2DoubleItemInfo.this.today_guarantee_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getToday_guarantee_refresh_time()
/*     */     {
/* 494 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 495 */       return Role2DoubleItemInfo.this.today_guarantee_refresh_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getToday_trigger_times()
/*     */     {
/* 502 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 503 */       return Role2DoubleItemInfo.this.today_trigger_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getToday_trigger_refresh_time()
/*     */     {
/* 510 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 511 */       return Role2DoubleItemInfo.this.today_trigger_refresh_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGuarantee_not_trigger_times()
/*     */     {
/* 518 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 519 */       return Role2DoubleItemInfo.this.guarantee_not_trigger_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToday_guarantee_times(int _v_)
/*     */     {
/* 526 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 527 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToday_guarantee_refresh_time(long _v_)
/*     */     {
/* 534 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 535 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToday_trigger_times(int _v_)
/*     */     {
/* 542 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 543 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToday_trigger_refresh_time(long _v_)
/*     */     {
/* 550 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGuarantee_not_trigger_times(int _v_)
/*     */     {
/* 558 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 565 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 566 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 572 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 573 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 579 */       return Role2DoubleItemInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 585 */       return Role2DoubleItemInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 591 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 598 */       return Role2DoubleItemInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 604 */       return Role2DoubleItemInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 610 */       Role2DoubleItemInfo.this._xdb_verify_unsafe_();
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 617 */       return Role2DoubleItemInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       return Role2DoubleItemInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 629 */       return Role2DoubleItemInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 635 */       return Role2DoubleItemInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 641 */       return Role2DoubleItemInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 647 */       return Role2DoubleItemInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 653 */       return Role2DoubleItemInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Role2DoubleItemInfo
/*     */   {
/*     */     private int today_guarantee_times;
/*     */     
/*     */     private long today_guarantee_refresh_time;
/*     */     
/*     */     private int today_trigger_times;
/*     */     
/*     */     private long today_trigger_refresh_time;
/*     */     
/*     */     private int guarantee_not_trigger_times;
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
/*     */     Data(xbean.Role2DoubleItemInfo _o1_)
/*     */     {
/* 682 */       if ((_o1_ instanceof Role2DoubleItemInfo)) { assign((Role2DoubleItemInfo)_o1_);
/* 683 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 684 */       } else if ((_o1_ instanceof Role2DoubleItemInfo.Const)) assign(((Role2DoubleItemInfo.Const)_o1_).nThis()); else {
/* 685 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Role2DoubleItemInfo _o_) {
/* 690 */       this.today_guarantee_times = _o_.today_guarantee_times;
/* 691 */       this.today_guarantee_refresh_time = _o_.today_guarantee_refresh_time;
/* 692 */       this.today_trigger_times = _o_.today_trigger_times;
/* 693 */       this.today_trigger_refresh_time = _o_.today_trigger_refresh_time;
/* 694 */       this.guarantee_not_trigger_times = _o_.guarantee_not_trigger_times;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 699 */       this.today_guarantee_times = _o_.today_guarantee_times;
/* 700 */       this.today_guarantee_refresh_time = _o_.today_guarantee_refresh_time;
/* 701 */       this.today_trigger_times = _o_.today_trigger_times;
/* 702 */       this.today_trigger_refresh_time = _o_.today_trigger_refresh_time;
/* 703 */       this.guarantee_not_trigger_times = _o_.guarantee_not_trigger_times;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 709 */       _os_.marshal(this.today_guarantee_times);
/* 710 */       _os_.marshal(this.today_guarantee_refresh_time);
/* 711 */       _os_.marshal(this.today_trigger_times);
/* 712 */       _os_.marshal(this.today_trigger_refresh_time);
/* 713 */       _os_.marshal(this.guarantee_not_trigger_times);
/* 714 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 720 */       this.today_guarantee_times = _os_.unmarshal_int();
/* 721 */       this.today_guarantee_refresh_time = _os_.unmarshal_long();
/* 722 */       this.today_trigger_times = _os_.unmarshal_int();
/* 723 */       this.today_trigger_refresh_time = _os_.unmarshal_long();
/* 724 */       this.guarantee_not_trigger_times = _os_.unmarshal_int();
/* 725 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 731 */       int _size_ = 0;
/* 732 */       _size_ += CodedOutputStream.computeInt32Size(1, this.today_guarantee_times);
/* 733 */       _size_ += CodedOutputStream.computeInt64Size(2, this.today_guarantee_refresh_time);
/* 734 */       _size_ += CodedOutputStream.computeInt32Size(3, this.today_trigger_times);
/* 735 */       _size_ += CodedOutputStream.computeInt64Size(4, this.today_trigger_refresh_time);
/* 736 */       _size_ += CodedOutputStream.computeInt32Size(5, this.guarantee_not_trigger_times);
/* 737 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 745 */         _output_.writeInt32(1, this.today_guarantee_times);
/* 746 */         _output_.writeInt64(2, this.today_guarantee_refresh_time);
/* 747 */         _output_.writeInt32(3, this.today_trigger_times);
/* 748 */         _output_.writeInt64(4, this.today_trigger_refresh_time);
/* 749 */         _output_.writeInt32(5, this.guarantee_not_trigger_times);
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
/* 776 */             this.today_guarantee_times = _input_.readInt32();
/* 777 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 781 */             this.today_guarantee_refresh_time = _input_.readInt64();
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 786 */             this.today_trigger_times = _input_.readInt32();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 791 */             this.today_trigger_refresh_time = _input_.readInt64();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 796 */             this.guarantee_not_trigger_times = _input_.readInt32();
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
/*     */     public xbean.Role2DoubleItemInfo copy()
/*     */     {
/* 824 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2DoubleItemInfo toData()
/*     */     {
/* 830 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Role2DoubleItemInfo toBean()
/*     */     {
/* 835 */       return new Role2DoubleItemInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2DoubleItemInfo toDataIf()
/*     */     {
/* 841 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Role2DoubleItemInfo toBeanIf()
/*     */     {
/* 846 */       return new Role2DoubleItemInfo(this, null, null);
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
/*     */     public int getToday_guarantee_times()
/*     */     {
/* 883 */       return this.today_guarantee_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getToday_guarantee_refresh_time()
/*     */     {
/* 890 */       return this.today_guarantee_refresh_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getToday_trigger_times()
/*     */     {
/* 897 */       return this.today_trigger_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getToday_trigger_refresh_time()
/*     */     {
/* 904 */       return this.today_trigger_refresh_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGuarantee_not_trigger_times()
/*     */     {
/* 911 */       return this.guarantee_not_trigger_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToday_guarantee_times(int _v_)
/*     */     {
/* 918 */       this.today_guarantee_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToday_guarantee_refresh_time(long _v_)
/*     */     {
/* 925 */       this.today_guarantee_refresh_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToday_trigger_times(int _v_)
/*     */     {
/* 932 */       this.today_trigger_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToday_trigger_refresh_time(long _v_)
/*     */     {
/* 939 */       this.today_trigger_refresh_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGuarantee_not_trigger_times(int _v_)
/*     */     {
/* 946 */       this.guarantee_not_trigger_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 952 */       if (!(_o1_ instanceof Data)) return false;
/* 953 */       Data _o_ = (Data)_o1_;
/* 954 */       if (this.today_guarantee_times != _o_.today_guarantee_times) return false;
/* 955 */       if (this.today_guarantee_refresh_time != _o_.today_guarantee_refresh_time) return false;
/* 956 */       if (this.today_trigger_times != _o_.today_trigger_times) return false;
/* 957 */       if (this.today_trigger_refresh_time != _o_.today_trigger_refresh_time) return false;
/* 958 */       if (this.guarantee_not_trigger_times != _o_.guarantee_not_trigger_times) return false;
/* 959 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 965 */       int _h_ = 0;
/* 966 */       _h_ += this.today_guarantee_times;
/* 967 */       _h_ = (int)(_h_ + this.today_guarantee_refresh_time);
/* 968 */       _h_ += this.today_trigger_times;
/* 969 */       _h_ = (int)(_h_ + this.today_trigger_refresh_time);
/* 970 */       _h_ += this.guarantee_not_trigger_times;
/* 971 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 977 */       StringBuilder _sb_ = new StringBuilder();
/* 978 */       _sb_.append("(");
/* 979 */       _sb_.append(this.today_guarantee_times);
/* 980 */       _sb_.append(",");
/* 981 */       _sb_.append(this.today_guarantee_refresh_time);
/* 982 */       _sb_.append(",");
/* 983 */       _sb_.append(this.today_trigger_times);
/* 984 */       _sb_.append(",");
/* 985 */       _sb_.append(this.today_trigger_refresh_time);
/* 986 */       _sb_.append(",");
/* 987 */       _sb_.append(this.guarantee_not_trigger_times);
/* 988 */       _sb_.append(")");
/* 989 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2DoubleItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
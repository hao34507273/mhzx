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
/*     */ public final class RMBGiftBagTierInfo extends XBean implements xbean.RMBGiftBagTierInfo
/*     */ {
/*     */   private int product_serviceid;
/*     */   private long base_num;
/*     */   private int award_times;
/*     */   private long award_timestamp;
/*     */   private int award_cfgid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.product_serviceid = 0;
/*  27 */     this.base_num = 0L;
/*  28 */     this.award_times = 0;
/*  29 */     this.award_timestamp = 0L;
/*  30 */     this.award_cfgid = 0;
/*     */   }
/*     */   
/*     */   RMBGiftBagTierInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*  36 */     this.product_serviceid = 0;
/*  37 */     this.base_num = 0L;
/*  38 */     this.award_times = 0;
/*  39 */     this.award_timestamp = 0L;
/*  40 */     this.award_cfgid = 0;
/*     */   }
/*     */   
/*     */   public RMBGiftBagTierInfo()
/*     */   {
/*  45 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RMBGiftBagTierInfo(RMBGiftBagTierInfo _o_)
/*     */   {
/*  50 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RMBGiftBagTierInfo(xbean.RMBGiftBagTierInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  55 */     super(_xp_, _vn_);
/*  56 */     if ((_o1_ instanceof RMBGiftBagTierInfo)) { assign((RMBGiftBagTierInfo)_o1_);
/*  57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  59 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RMBGiftBagTierInfo _o_) {
/*  64 */     _o_._xdb_verify_unsafe_();
/*  65 */     this.product_serviceid = _o_.product_serviceid;
/*  66 */     this.base_num = _o_.base_num;
/*  67 */     this.award_times = _o_.award_times;
/*  68 */     this.award_timestamp = _o_.award_timestamp;
/*  69 */     this.award_cfgid = _o_.award_cfgid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  74 */     this.product_serviceid = _o_.product_serviceid;
/*  75 */     this.base_num = _o_.base_num;
/*  76 */     this.award_times = _o_.award_times;
/*  77 */     this.award_timestamp = _o_.award_timestamp;
/*  78 */     this.award_cfgid = _o_.award_cfgid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     _os_.marshal(this.product_serviceid);
/*  86 */     _os_.marshal(this.base_num);
/*  87 */     _os_.marshal(this.award_times);
/*  88 */     _os_.marshal(this.award_timestamp);
/*  89 */     _os_.marshal(this.award_cfgid);
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     this.product_serviceid = _os_.unmarshal_int();
/*  98 */     this.base_num = _os_.unmarshal_long();
/*  99 */     this.award_times = _os_.unmarshal_int();
/* 100 */     this.award_timestamp = _os_.unmarshal_long();
/* 101 */     this.award_cfgid = _os_.unmarshal_int();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     int _size_ = 0;
/* 110 */     _size_ += CodedOutputStream.computeInt32Size(1, this.product_serviceid);
/* 111 */     _size_ += CodedOutputStream.computeInt64Size(2, this.base_num);
/* 112 */     _size_ += CodedOutputStream.computeInt32Size(3, this.award_times);
/* 113 */     _size_ += CodedOutputStream.computeInt64Size(4, this.award_timestamp);
/* 114 */     _size_ += CodedOutputStream.computeInt32Size(5, this.award_cfgid);
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       _output_.writeInt32(1, this.product_serviceid);
/* 125 */       _output_.writeInt64(2, this.base_num);
/* 126 */       _output_.writeInt32(3, this.award_times);
/* 127 */       _output_.writeInt64(4, this.award_timestamp);
/* 128 */       _output_.writeInt32(5, this.award_cfgid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 132 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 134 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 143 */       boolean done = false;
/* 144 */       while (!done)
/*     */       {
/* 146 */         int tag = _input_.readTag();
/* 147 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 151 */           done = true;
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 156 */           this.product_serviceid = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 161 */           this.base_num = _input_.readInt64();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 166 */           this.award_times = _input_.readInt32();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 171 */           this.award_timestamp = _input_.readInt64();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 176 */           this.award_cfgid = _input_.readInt32();
/* 177 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 181 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 183 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 192 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 196 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 198 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RMBGiftBagTierInfo copy()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new RMBGiftBagTierInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RMBGiftBagTierInfo toData()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RMBGiftBagTierInfo toBean()
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     return new RMBGiftBagTierInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RMBGiftBagTierInfo toDataIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RMBGiftBagTierInfo toBeanIf()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getProduct_serviceid()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return this.product_serviceid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getBase_num()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.base_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAward_times()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.award_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getAward_timestamp()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return this.award_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAward_cfgid()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/* 278 */     return this.award_cfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProduct_serviceid(int _v_)
/*     */   {
/* 285 */     _xdb_verify_unsafe_();
/* 286 */     xdb.Logs.logIf(new LogKey(this, "product_serviceid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 290 */         new LogInt(this, RMBGiftBagTierInfo.this.product_serviceid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 294 */             RMBGiftBagTierInfo.this.product_serviceid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 298 */     });
/* 299 */     this.product_serviceid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBase_num(long _v_)
/*     */   {
/* 306 */     _xdb_verify_unsafe_();
/* 307 */     xdb.Logs.logIf(new LogKey(this, "base_num")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 311 */         new xdb.logs.LogLong(this, RMBGiftBagTierInfo.this.base_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 315 */             RMBGiftBagTierInfo.this.base_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 319 */     });
/* 320 */     this.base_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAward_times(int _v_)
/*     */   {
/* 327 */     _xdb_verify_unsafe_();
/* 328 */     xdb.Logs.logIf(new LogKey(this, "award_times")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 332 */         new LogInt(this, RMBGiftBagTierInfo.this.award_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 336 */             RMBGiftBagTierInfo.this.award_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 340 */     });
/* 341 */     this.award_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAward_timestamp(long _v_)
/*     */   {
/* 348 */     _xdb_verify_unsafe_();
/* 349 */     xdb.Logs.logIf(new LogKey(this, "award_timestamp")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 353 */         new xdb.logs.LogLong(this, RMBGiftBagTierInfo.this.award_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 357 */             RMBGiftBagTierInfo.this.award_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 361 */     });
/* 362 */     this.award_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAward_cfgid(int _v_)
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     xdb.Logs.logIf(new LogKey(this, "award_cfgid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 374 */         new LogInt(this, RMBGiftBagTierInfo.this.award_cfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 378 */             RMBGiftBagTierInfo.this.award_cfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 382 */     });
/* 383 */     this.award_cfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     RMBGiftBagTierInfo _o_ = null;
/* 391 */     if ((_o1_ instanceof RMBGiftBagTierInfo)) { _o_ = (RMBGiftBagTierInfo)_o1_;
/* 392 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 393 */       return false;
/* 394 */     if (this.product_serviceid != _o_.product_serviceid) return false;
/* 395 */     if (this.base_num != _o_.base_num) return false;
/* 396 */     if (this.award_times != _o_.award_times) return false;
/* 397 */     if (this.award_timestamp != _o_.award_timestamp) return false;
/* 398 */     if (this.award_cfgid != _o_.award_cfgid) return false;
/* 399 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 405 */     _xdb_verify_unsafe_();
/* 406 */     int _h_ = 0;
/* 407 */     _h_ += this.product_serviceid;
/* 408 */     _h_ = (int)(_h_ + this.base_num);
/* 409 */     _h_ += this.award_times;
/* 410 */     _h_ = (int)(_h_ + this.award_timestamp);
/* 411 */     _h_ += this.award_cfgid;
/* 412 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 418 */     _xdb_verify_unsafe_();
/* 419 */     StringBuilder _sb_ = new StringBuilder();
/* 420 */     _sb_.append("(");
/* 421 */     _sb_.append(this.product_serviceid);
/* 422 */     _sb_.append(",");
/* 423 */     _sb_.append(this.base_num);
/* 424 */     _sb_.append(",");
/* 425 */     _sb_.append(this.award_times);
/* 426 */     _sb_.append(",");
/* 427 */     _sb_.append(this.award_timestamp);
/* 428 */     _sb_.append(",");
/* 429 */     _sb_.append(this.award_cfgid);
/* 430 */     _sb_.append(")");
/* 431 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 437 */     ListenableBean lb = new ListenableBean();
/* 438 */     lb.add(new ListenableChanged().setVarName("product_serviceid"));
/* 439 */     lb.add(new ListenableChanged().setVarName("base_num"));
/* 440 */     lb.add(new ListenableChanged().setVarName("award_times"));
/* 441 */     lb.add(new ListenableChanged().setVarName("award_timestamp"));
/* 442 */     lb.add(new ListenableChanged().setVarName("award_cfgid"));
/* 443 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RMBGiftBagTierInfo {
/*     */     private Const() {}
/*     */     
/*     */     RMBGiftBagTierInfo nThis() {
/* 450 */       return RMBGiftBagTierInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 456 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RMBGiftBagTierInfo copy()
/*     */     {
/* 462 */       return RMBGiftBagTierInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RMBGiftBagTierInfo toData()
/*     */     {
/* 468 */       return RMBGiftBagTierInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RMBGiftBagTierInfo toBean()
/*     */     {
/* 473 */       return RMBGiftBagTierInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RMBGiftBagTierInfo toDataIf()
/*     */     {
/* 479 */       return RMBGiftBagTierInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RMBGiftBagTierInfo toBeanIf()
/*     */     {
/* 484 */       return RMBGiftBagTierInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getProduct_serviceid()
/*     */     {
/* 491 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 492 */       return RMBGiftBagTierInfo.this.product_serviceid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getBase_num()
/*     */     {
/* 499 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 500 */       return RMBGiftBagTierInfo.this.base_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAward_times()
/*     */     {
/* 507 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 508 */       return RMBGiftBagTierInfo.this.award_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAward_timestamp()
/*     */     {
/* 515 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 516 */       return RMBGiftBagTierInfo.this.award_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAward_cfgid()
/*     */     {
/* 523 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 524 */       return RMBGiftBagTierInfo.this.award_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProduct_serviceid(int _v_)
/*     */     {
/* 531 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBase_num(long _v_)
/*     */     {
/* 539 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_times(int _v_)
/*     */     {
/* 547 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_timestamp(long _v_)
/*     */     {
/* 555 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_cfgid(int _v_)
/*     */     {
/* 563 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 564 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 570 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 571 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 577 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 578 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 584 */       return RMBGiftBagTierInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 590 */       return RMBGiftBagTierInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 596 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 597 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 603 */       return RMBGiftBagTierInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 609 */       return RMBGiftBagTierInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 615 */       RMBGiftBagTierInfo.this._xdb_verify_unsafe_();
/* 616 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 622 */       return RMBGiftBagTierInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 628 */       return RMBGiftBagTierInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 634 */       return RMBGiftBagTierInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 640 */       return RMBGiftBagTierInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 646 */       return RMBGiftBagTierInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 652 */       return RMBGiftBagTierInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 658 */       return RMBGiftBagTierInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RMBGiftBagTierInfo
/*     */   {
/*     */     private int product_serviceid;
/*     */     
/*     */     private long base_num;
/*     */     
/*     */     private int award_times;
/*     */     
/*     */     private long award_timestamp;
/*     */     
/*     */     private int award_cfgid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 678 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 683 */       this.product_serviceid = 0;
/* 684 */       this.base_num = 0L;
/* 685 */       this.award_times = 0;
/* 686 */       this.award_timestamp = 0L;
/* 687 */       this.award_cfgid = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.RMBGiftBagTierInfo _o1_)
/*     */     {
/* 692 */       if ((_o1_ instanceof RMBGiftBagTierInfo)) { assign((RMBGiftBagTierInfo)_o1_);
/* 693 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 694 */       } else if ((_o1_ instanceof RMBGiftBagTierInfo.Const)) assign(((RMBGiftBagTierInfo.Const)_o1_).nThis()); else {
/* 695 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RMBGiftBagTierInfo _o_) {
/* 700 */       this.product_serviceid = _o_.product_serviceid;
/* 701 */       this.base_num = _o_.base_num;
/* 702 */       this.award_times = _o_.award_times;
/* 703 */       this.award_timestamp = _o_.award_timestamp;
/* 704 */       this.award_cfgid = _o_.award_cfgid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 709 */       this.product_serviceid = _o_.product_serviceid;
/* 710 */       this.base_num = _o_.base_num;
/* 711 */       this.award_times = _o_.award_times;
/* 712 */       this.award_timestamp = _o_.award_timestamp;
/* 713 */       this.award_cfgid = _o_.award_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 719 */       _os_.marshal(this.product_serviceid);
/* 720 */       _os_.marshal(this.base_num);
/* 721 */       _os_.marshal(this.award_times);
/* 722 */       _os_.marshal(this.award_timestamp);
/* 723 */       _os_.marshal(this.award_cfgid);
/* 724 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 730 */       this.product_serviceid = _os_.unmarshal_int();
/* 731 */       this.base_num = _os_.unmarshal_long();
/* 732 */       this.award_times = _os_.unmarshal_int();
/* 733 */       this.award_timestamp = _os_.unmarshal_long();
/* 734 */       this.award_cfgid = _os_.unmarshal_int();
/* 735 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 741 */       int _size_ = 0;
/* 742 */       _size_ += CodedOutputStream.computeInt32Size(1, this.product_serviceid);
/* 743 */       _size_ += CodedOutputStream.computeInt64Size(2, this.base_num);
/* 744 */       _size_ += CodedOutputStream.computeInt32Size(3, this.award_times);
/* 745 */       _size_ += CodedOutputStream.computeInt64Size(4, this.award_timestamp);
/* 746 */       _size_ += CodedOutputStream.computeInt32Size(5, this.award_cfgid);
/* 747 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 755 */         _output_.writeInt32(1, this.product_serviceid);
/* 756 */         _output_.writeInt64(2, this.base_num);
/* 757 */         _output_.writeInt32(3, this.award_times);
/* 758 */         _output_.writeInt64(4, this.award_timestamp);
/* 759 */         _output_.writeInt32(5, this.award_cfgid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 763 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 765 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 773 */         boolean done = false;
/* 774 */         while (!done)
/*     */         {
/* 776 */           int tag = _input_.readTag();
/* 777 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 781 */             done = true;
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 786 */             this.product_serviceid = _input_.readInt32();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 791 */             this.base_num = _input_.readInt64();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 796 */             this.award_times = _input_.readInt32();
/* 797 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 801 */             this.award_timestamp = _input_.readInt64();
/* 802 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 806 */             this.award_cfgid = _input_.readInt32();
/* 807 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 811 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 813 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 822 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 826 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 828 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RMBGiftBagTierInfo copy()
/*     */     {
/* 834 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RMBGiftBagTierInfo toData()
/*     */     {
/* 840 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RMBGiftBagTierInfo toBean()
/*     */     {
/* 845 */       return new RMBGiftBagTierInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RMBGiftBagTierInfo toDataIf()
/*     */     {
/* 851 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RMBGiftBagTierInfo toBeanIf()
/*     */     {
/* 856 */       return new RMBGiftBagTierInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 862 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 866 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 870 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 874 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 878 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 882 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 886 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getProduct_serviceid()
/*     */     {
/* 893 */       return this.product_serviceid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getBase_num()
/*     */     {
/* 900 */       return this.base_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAward_times()
/*     */     {
/* 907 */       return this.award_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAward_timestamp()
/*     */     {
/* 914 */       return this.award_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAward_cfgid()
/*     */     {
/* 921 */       return this.award_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProduct_serviceid(int _v_)
/*     */     {
/* 928 */       this.product_serviceid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBase_num(long _v_)
/*     */     {
/* 935 */       this.base_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_times(int _v_)
/*     */     {
/* 942 */       this.award_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_timestamp(long _v_)
/*     */     {
/* 949 */       this.award_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_cfgid(int _v_)
/*     */     {
/* 956 */       this.award_cfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 962 */       if (!(_o1_ instanceof Data)) return false;
/* 963 */       Data _o_ = (Data)_o1_;
/* 964 */       if (this.product_serviceid != _o_.product_serviceid) return false;
/* 965 */       if (this.base_num != _o_.base_num) return false;
/* 966 */       if (this.award_times != _o_.award_times) return false;
/* 967 */       if (this.award_timestamp != _o_.award_timestamp) return false;
/* 968 */       if (this.award_cfgid != _o_.award_cfgid) return false;
/* 969 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 975 */       int _h_ = 0;
/* 976 */       _h_ += this.product_serviceid;
/* 977 */       _h_ = (int)(_h_ + this.base_num);
/* 978 */       _h_ += this.award_times;
/* 979 */       _h_ = (int)(_h_ + this.award_timestamp);
/* 980 */       _h_ += this.award_cfgid;
/* 981 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 987 */       StringBuilder _sb_ = new StringBuilder();
/* 988 */       _sb_.append("(");
/* 989 */       _sb_.append(this.product_serviceid);
/* 990 */       _sb_.append(",");
/* 991 */       _sb_.append(this.base_num);
/* 992 */       _sb_.append(",");
/* 993 */       _sb_.append(this.award_times);
/* 994 */       _sb_.append(",");
/* 995 */       _sb_.append(this.award_timestamp);
/* 996 */       _sb_.append(",");
/* 997 */       _sb_.append(this.award_cfgid);
/* 998 */       _sb_.append(")");
/* 999 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RMBGiftBagTierInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*     */ public final class ZhenyaoCount extends XBean implements xbean.ZhenyaoCount
/*     */ {
/*     */   private long cleantime;
/*     */   private int zhenyaocount;
/*     */   private int reservedexp;
/*     */   private int singlecount;
/*     */   private int doublecount;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.cleantime = 0L;
/*  27 */     this.zhenyaocount = 0;
/*  28 */     this.reservedexp = 0;
/*  29 */     this.singlecount = 0;
/*  30 */     this.doublecount = 0;
/*     */   }
/*     */   
/*     */   ZhenyaoCount(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*  36 */     this.cleantime = 0L;
/*  37 */     this.zhenyaocount = 0;
/*  38 */     this.reservedexp = 0;
/*  39 */     this.singlecount = 0;
/*  40 */     this.doublecount = 0;
/*     */   }
/*     */   
/*     */   public ZhenyaoCount()
/*     */   {
/*  45 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ZhenyaoCount(ZhenyaoCount _o_)
/*     */   {
/*  50 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ZhenyaoCount(xbean.ZhenyaoCount _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  55 */     super(_xp_, _vn_);
/*  56 */     if ((_o1_ instanceof ZhenyaoCount)) { assign((ZhenyaoCount)_o1_);
/*  57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  59 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ZhenyaoCount _o_) {
/*  64 */     _o_._xdb_verify_unsafe_();
/*  65 */     this.cleantime = _o_.cleantime;
/*  66 */     this.zhenyaocount = _o_.zhenyaocount;
/*  67 */     this.reservedexp = _o_.reservedexp;
/*  68 */     this.singlecount = _o_.singlecount;
/*  69 */     this.doublecount = _o_.doublecount;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  74 */     this.cleantime = _o_.cleantime;
/*  75 */     this.zhenyaocount = _o_.zhenyaocount;
/*  76 */     this.reservedexp = _o_.reservedexp;
/*  77 */     this.singlecount = _o_.singlecount;
/*  78 */     this.doublecount = _o_.doublecount;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     _os_.marshal(this.cleantime);
/*  86 */     _os_.marshal(this.zhenyaocount);
/*  87 */     _os_.marshal(this.reservedexp);
/*  88 */     _os_.marshal(this.singlecount);
/*  89 */     _os_.marshal(this.doublecount);
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     this.cleantime = _os_.unmarshal_long();
/*  98 */     this.zhenyaocount = _os_.unmarshal_int();
/*  99 */     this.reservedexp = _os_.unmarshal_int();
/* 100 */     this.singlecount = _os_.unmarshal_int();
/* 101 */     this.doublecount = _os_.unmarshal_int();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     int _size_ = 0;
/* 110 */     _size_ += CodedOutputStream.computeInt64Size(1, this.cleantime);
/* 111 */     _size_ += CodedOutputStream.computeInt32Size(2, this.zhenyaocount);
/* 112 */     _size_ += CodedOutputStream.computeInt32Size(3, this.reservedexp);
/* 113 */     _size_ += CodedOutputStream.computeInt32Size(4, this.singlecount);
/* 114 */     _size_ += CodedOutputStream.computeInt32Size(5, this.doublecount);
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       _output_.writeInt64(1, this.cleantime);
/* 125 */       _output_.writeInt32(2, this.zhenyaocount);
/* 126 */       _output_.writeInt32(3, this.reservedexp);
/* 127 */       _output_.writeInt32(4, this.singlecount);
/* 128 */       _output_.writeInt32(5, this.doublecount);
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
/* 156 */           this.cleantime = _input_.readInt64();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 161 */           this.zhenyaocount = _input_.readInt32();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 166 */           this.reservedexp = _input_.readInt32();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 171 */           this.singlecount = _input_.readInt32();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 176 */           this.doublecount = _input_.readInt32();
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
/*     */   public xbean.ZhenyaoCount copy()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new ZhenyaoCount(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ZhenyaoCount toData()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ZhenyaoCount toBean()
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     return new ZhenyaoCount(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ZhenyaoCount toDataIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ZhenyaoCount toBeanIf()
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
/*     */   public long getCleantime()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return this.cleantime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getZhenyaocount()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.zhenyaocount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getReservedexp()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.reservedexp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSinglecount()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return this.singlecount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getDoublecount()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/* 278 */     return this.doublecount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCleantime(long _v_)
/*     */   {
/* 285 */     _xdb_verify_unsafe_();
/* 286 */     xdb.Logs.logIf(new LogKey(this, "cleantime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 290 */         new xdb.logs.LogLong(this, ZhenyaoCount.this.cleantime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 294 */             ZhenyaoCount.this.cleantime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 298 */     });
/* 299 */     this.cleantime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setZhenyaocount(int _v_)
/*     */   {
/* 306 */     _xdb_verify_unsafe_();
/* 307 */     xdb.Logs.logIf(new LogKey(this, "zhenyaocount")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 311 */         new LogInt(this, ZhenyaoCount.this.zhenyaocount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 315 */             ZhenyaoCount.this.zhenyaocount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 319 */     });
/* 320 */     this.zhenyaocount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReservedexp(int _v_)
/*     */   {
/* 327 */     _xdb_verify_unsafe_();
/* 328 */     xdb.Logs.logIf(new LogKey(this, "reservedexp")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 332 */         new LogInt(this, ZhenyaoCount.this.reservedexp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 336 */             ZhenyaoCount.this.reservedexp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 340 */     });
/* 341 */     this.reservedexp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSinglecount(int _v_)
/*     */   {
/* 348 */     _xdb_verify_unsafe_();
/* 349 */     xdb.Logs.logIf(new LogKey(this, "singlecount")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 353 */         new LogInt(this, ZhenyaoCount.this.singlecount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 357 */             ZhenyaoCount.this.singlecount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 361 */     });
/* 362 */     this.singlecount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDoublecount(int _v_)
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     xdb.Logs.logIf(new LogKey(this, "doublecount")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 374 */         new LogInt(this, ZhenyaoCount.this.doublecount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 378 */             ZhenyaoCount.this.doublecount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 382 */     });
/* 383 */     this.doublecount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     ZhenyaoCount _o_ = null;
/* 391 */     if ((_o1_ instanceof ZhenyaoCount)) { _o_ = (ZhenyaoCount)_o1_;
/* 392 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 393 */       return false;
/* 394 */     if (this.cleantime != _o_.cleantime) return false;
/* 395 */     if (this.zhenyaocount != _o_.zhenyaocount) return false;
/* 396 */     if (this.reservedexp != _o_.reservedexp) return false;
/* 397 */     if (this.singlecount != _o_.singlecount) return false;
/* 398 */     if (this.doublecount != _o_.doublecount) return false;
/* 399 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 405 */     _xdb_verify_unsafe_();
/* 406 */     int _h_ = 0;
/* 407 */     _h_ = (int)(_h_ + this.cleantime);
/* 408 */     _h_ += this.zhenyaocount;
/* 409 */     _h_ += this.reservedexp;
/* 410 */     _h_ += this.singlecount;
/* 411 */     _h_ += this.doublecount;
/* 412 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 418 */     _xdb_verify_unsafe_();
/* 419 */     StringBuilder _sb_ = new StringBuilder();
/* 420 */     _sb_.append("(");
/* 421 */     _sb_.append(this.cleantime);
/* 422 */     _sb_.append(",");
/* 423 */     _sb_.append(this.zhenyaocount);
/* 424 */     _sb_.append(",");
/* 425 */     _sb_.append(this.reservedexp);
/* 426 */     _sb_.append(",");
/* 427 */     _sb_.append(this.singlecount);
/* 428 */     _sb_.append(",");
/* 429 */     _sb_.append(this.doublecount);
/* 430 */     _sb_.append(")");
/* 431 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 437 */     ListenableBean lb = new ListenableBean();
/* 438 */     lb.add(new ListenableChanged().setVarName("cleantime"));
/* 439 */     lb.add(new ListenableChanged().setVarName("zhenyaocount"));
/* 440 */     lb.add(new ListenableChanged().setVarName("reservedexp"));
/* 441 */     lb.add(new ListenableChanged().setVarName("singlecount"));
/* 442 */     lb.add(new ListenableChanged().setVarName("doublecount"));
/* 443 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ZhenyaoCount {
/*     */     private Const() {}
/*     */     
/*     */     ZhenyaoCount nThis() {
/* 450 */       return ZhenyaoCount.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 456 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZhenyaoCount copy()
/*     */     {
/* 462 */       return ZhenyaoCount.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZhenyaoCount toData()
/*     */     {
/* 468 */       return ZhenyaoCount.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ZhenyaoCount toBean()
/*     */     {
/* 473 */       return ZhenyaoCount.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZhenyaoCount toDataIf()
/*     */     {
/* 479 */       return ZhenyaoCount.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ZhenyaoCount toBeanIf()
/*     */     {
/* 484 */       return ZhenyaoCount.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCleantime()
/*     */     {
/* 491 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 492 */       return ZhenyaoCount.this.cleantime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZhenyaocount()
/*     */     {
/* 499 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 500 */       return ZhenyaoCount.this.zhenyaocount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getReservedexp()
/*     */     {
/* 507 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 508 */       return ZhenyaoCount.this.reservedexp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSinglecount()
/*     */     {
/* 515 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 516 */       return ZhenyaoCount.this.singlecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDoublecount()
/*     */     {
/* 523 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 524 */       return ZhenyaoCount.this.doublecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCleantime(long _v_)
/*     */     {
/* 531 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZhenyaocount(int _v_)
/*     */     {
/* 539 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReservedexp(int _v_)
/*     */     {
/* 547 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSinglecount(int _v_)
/*     */     {
/* 555 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDoublecount(int _v_)
/*     */     {
/* 563 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 564 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 570 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 571 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 577 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 578 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 584 */       return ZhenyaoCount.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 590 */       return ZhenyaoCount.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 596 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 597 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 603 */       return ZhenyaoCount.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 609 */       return ZhenyaoCount.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 615 */       ZhenyaoCount.this._xdb_verify_unsafe_();
/* 616 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 622 */       return ZhenyaoCount.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 628 */       return ZhenyaoCount.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 634 */       return ZhenyaoCount.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 640 */       return ZhenyaoCount.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 646 */       return ZhenyaoCount.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 652 */       return ZhenyaoCount.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 658 */       return ZhenyaoCount.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ZhenyaoCount
/*     */   {
/*     */     private long cleantime;
/*     */     
/*     */     private int zhenyaocount;
/*     */     
/*     */     private int reservedexp;
/*     */     
/*     */     private int singlecount;
/*     */     
/*     */     private int doublecount;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 678 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 683 */       this.cleantime = 0L;
/* 684 */       this.zhenyaocount = 0;
/* 685 */       this.reservedexp = 0;
/* 686 */       this.singlecount = 0;
/* 687 */       this.doublecount = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.ZhenyaoCount _o1_)
/*     */     {
/* 692 */       if ((_o1_ instanceof ZhenyaoCount)) { assign((ZhenyaoCount)_o1_);
/* 693 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 694 */       } else if ((_o1_ instanceof ZhenyaoCount.Const)) assign(((ZhenyaoCount.Const)_o1_).nThis()); else {
/* 695 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ZhenyaoCount _o_) {
/* 700 */       this.cleantime = _o_.cleantime;
/* 701 */       this.zhenyaocount = _o_.zhenyaocount;
/* 702 */       this.reservedexp = _o_.reservedexp;
/* 703 */       this.singlecount = _o_.singlecount;
/* 704 */       this.doublecount = _o_.doublecount;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 709 */       this.cleantime = _o_.cleantime;
/* 710 */       this.zhenyaocount = _o_.zhenyaocount;
/* 711 */       this.reservedexp = _o_.reservedexp;
/* 712 */       this.singlecount = _o_.singlecount;
/* 713 */       this.doublecount = _o_.doublecount;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 719 */       _os_.marshal(this.cleantime);
/* 720 */       _os_.marshal(this.zhenyaocount);
/* 721 */       _os_.marshal(this.reservedexp);
/* 722 */       _os_.marshal(this.singlecount);
/* 723 */       _os_.marshal(this.doublecount);
/* 724 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 730 */       this.cleantime = _os_.unmarshal_long();
/* 731 */       this.zhenyaocount = _os_.unmarshal_int();
/* 732 */       this.reservedexp = _os_.unmarshal_int();
/* 733 */       this.singlecount = _os_.unmarshal_int();
/* 734 */       this.doublecount = _os_.unmarshal_int();
/* 735 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 741 */       int _size_ = 0;
/* 742 */       _size_ += CodedOutputStream.computeInt64Size(1, this.cleantime);
/* 743 */       _size_ += CodedOutputStream.computeInt32Size(2, this.zhenyaocount);
/* 744 */       _size_ += CodedOutputStream.computeInt32Size(3, this.reservedexp);
/* 745 */       _size_ += CodedOutputStream.computeInt32Size(4, this.singlecount);
/* 746 */       _size_ += CodedOutputStream.computeInt32Size(5, this.doublecount);
/* 747 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 755 */         _output_.writeInt64(1, this.cleantime);
/* 756 */         _output_.writeInt32(2, this.zhenyaocount);
/* 757 */         _output_.writeInt32(3, this.reservedexp);
/* 758 */         _output_.writeInt32(4, this.singlecount);
/* 759 */         _output_.writeInt32(5, this.doublecount);
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
/* 786 */             this.cleantime = _input_.readInt64();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 791 */             this.zhenyaocount = _input_.readInt32();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 796 */             this.reservedexp = _input_.readInt32();
/* 797 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 801 */             this.singlecount = _input_.readInt32();
/* 802 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 806 */             this.doublecount = _input_.readInt32();
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
/*     */     public xbean.ZhenyaoCount copy()
/*     */     {
/* 834 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZhenyaoCount toData()
/*     */     {
/* 840 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ZhenyaoCount toBean()
/*     */     {
/* 845 */       return new ZhenyaoCount(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZhenyaoCount toDataIf()
/*     */     {
/* 851 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ZhenyaoCount toBeanIf()
/*     */     {
/* 856 */       return new ZhenyaoCount(this, null, null);
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
/*     */     public long getCleantime()
/*     */     {
/* 893 */       return this.cleantime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZhenyaocount()
/*     */     {
/* 900 */       return this.zhenyaocount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getReservedexp()
/*     */     {
/* 907 */       return this.reservedexp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSinglecount()
/*     */     {
/* 914 */       return this.singlecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDoublecount()
/*     */     {
/* 921 */       return this.doublecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCleantime(long _v_)
/*     */     {
/* 928 */       this.cleantime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZhenyaocount(int _v_)
/*     */     {
/* 935 */       this.zhenyaocount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReservedexp(int _v_)
/*     */     {
/* 942 */       this.reservedexp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSinglecount(int _v_)
/*     */     {
/* 949 */       this.singlecount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDoublecount(int _v_)
/*     */     {
/* 956 */       this.doublecount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 962 */       if (!(_o1_ instanceof Data)) return false;
/* 963 */       Data _o_ = (Data)_o1_;
/* 964 */       if (this.cleantime != _o_.cleantime) return false;
/* 965 */       if (this.zhenyaocount != _o_.zhenyaocount) return false;
/* 966 */       if (this.reservedexp != _o_.reservedexp) return false;
/* 967 */       if (this.singlecount != _o_.singlecount) return false;
/* 968 */       if (this.doublecount != _o_.doublecount) return false;
/* 969 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 975 */       int _h_ = 0;
/* 976 */       _h_ = (int)(_h_ + this.cleantime);
/* 977 */       _h_ += this.zhenyaocount;
/* 978 */       _h_ += this.reservedexp;
/* 979 */       _h_ += this.singlecount;
/* 980 */       _h_ += this.doublecount;
/* 981 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 987 */       StringBuilder _sb_ = new StringBuilder();
/* 988 */       _sb_.append("(");
/* 989 */       _sb_.append(this.cleantime);
/* 990 */       _sb_.append(",");
/* 991 */       _sb_.append(this.zhenyaocount);
/* 992 */       _sb_.append(",");
/* 993 */       _sb_.append(this.reservedexp);
/* 994 */       _sb_.append(",");
/* 995 */       _sb_.append(this.singlecount);
/* 996 */       _sb_.append(",");
/* 997 */       _sb_.append(this.doublecount);
/* 998 */       _sb_.append(")");
/* 999 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ZhenyaoCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
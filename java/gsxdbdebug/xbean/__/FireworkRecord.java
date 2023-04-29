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
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class FireworkRecord extends XBean implements xbean.FireworkRecord
/*     */ {
/*     */   private long cleansessionid;
/*     */   private int alreadygetnum;
/*     */   private long fireworkstarttime;
/*     */   private long fireworkcountdowntime;
/*     */   private long findfireworkstarttime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.cleansessionid = 0L;
/*  27 */     this.alreadygetnum = 0;
/*  28 */     this.fireworkstarttime = 0L;
/*  29 */     this.fireworkcountdowntime = 0L;
/*  30 */     this.findfireworkstarttime = 0L;
/*     */   }
/*     */   
/*     */   FireworkRecord(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public FireworkRecord()
/*     */   {
/*  40 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FireworkRecord(FireworkRecord _o_)
/*     */   {
/*  45 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FireworkRecord(xbean.FireworkRecord _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  50 */     super(_xp_, _vn_);
/*  51 */     if ((_o1_ instanceof FireworkRecord)) { assign((FireworkRecord)_o1_);
/*  52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  54 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FireworkRecord _o_) {
/*  59 */     _o_._xdb_verify_unsafe_();
/*  60 */     this.cleansessionid = _o_.cleansessionid;
/*  61 */     this.alreadygetnum = _o_.alreadygetnum;
/*  62 */     this.fireworkstarttime = _o_.fireworkstarttime;
/*  63 */     this.fireworkcountdowntime = _o_.fireworkcountdowntime;
/*  64 */     this.findfireworkstarttime = _o_.findfireworkstarttime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.cleansessionid = _o_.cleansessionid;
/*  70 */     this.alreadygetnum = _o_.alreadygetnum;
/*  71 */     this.fireworkstarttime = _o_.fireworkstarttime;
/*  72 */     this.fireworkcountdowntime = _o_.fireworkcountdowntime;
/*  73 */     this.findfireworkstarttime = _o_.findfireworkstarttime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.cleansessionid);
/*  81 */     _os_.marshal(this.alreadygetnum);
/*  82 */     _os_.marshal(this.fireworkstarttime);
/*  83 */     _os_.marshal(this.fireworkcountdowntime);
/*  84 */     _os_.marshal(this.findfireworkstarttime);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     this.cleansessionid = _os_.unmarshal_long();
/*  93 */     this.alreadygetnum = _os_.unmarshal_int();
/*  94 */     this.fireworkstarttime = _os_.unmarshal_long();
/*  95 */     this.fireworkcountdowntime = _os_.unmarshal_long();
/*  96 */     this.findfireworkstarttime = _os_.unmarshal_long();
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     int _size_ = 0;
/* 105 */     _size_ += CodedOutputStream.computeInt64Size(1, this.cleansessionid);
/* 106 */     _size_ += CodedOutputStream.computeInt32Size(2, this.alreadygetnum);
/* 107 */     _size_ += CodedOutputStream.computeInt64Size(3, this.fireworkstarttime);
/* 108 */     _size_ += CodedOutputStream.computeInt64Size(4, this.fireworkcountdowntime);
/* 109 */     _size_ += CodedOutputStream.computeInt64Size(5, this.findfireworkstarttime);
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeInt64(1, this.cleansessionid);
/* 120 */       _output_.writeInt32(2, this.alreadygetnum);
/* 121 */       _output_.writeInt64(3, this.fireworkstarttime);
/* 122 */       _output_.writeInt64(4, this.fireworkcountdowntime);
/* 123 */       _output_.writeInt64(5, this.findfireworkstarttime);
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
/* 151 */           this.cleansessionid = _input_.readInt64();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           this.alreadygetnum = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 161 */           this.fireworkstarttime = _input_.readInt64();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 166 */           this.fireworkcountdowntime = _input_.readInt64();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 171 */           this.findfireworkstarttime = _input_.readInt64();
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
/*     */   public xbean.FireworkRecord copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new FireworkRecord(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FireworkRecord toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FireworkRecord toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new FireworkRecord(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FireworkRecord toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FireworkRecord toBeanIf()
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
/*     */   public long getCleansessionid()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.cleansessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAlreadygetnum()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return this.alreadygetnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getFireworkstarttime()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     return this.fireworkstarttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getFireworkcountdowntime()
/*     */   {
/* 264 */     _xdb_verify_unsafe_();
/* 265 */     return this.fireworkcountdowntime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getFindfireworkstarttime()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return this.findfireworkstarttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCleansessionid(long _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "cleansessionid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 285 */         new LogLong(this, FireworkRecord.this.cleansessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             FireworkRecord.this.cleansessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.cleansessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAlreadygetnum(int _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new LogKey(this, "alreadygetnum")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 306 */         new xdb.logs.LogInt(this, FireworkRecord.this.alreadygetnum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             FireworkRecord.this.alreadygetnum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.alreadygetnum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFireworkstarttime(long _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     xdb.Logs.logIf(new LogKey(this, "fireworkstarttime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 327 */         new LogLong(this, FireworkRecord.this.fireworkstarttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             FireworkRecord.this.fireworkstarttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.fireworkstarttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFireworkcountdowntime(long _v_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     xdb.Logs.logIf(new LogKey(this, "fireworkcountdowntime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 348 */         new LogLong(this, FireworkRecord.this.fireworkcountdowntime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 352 */             FireworkRecord.this.fireworkcountdowntime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 356 */     });
/* 357 */     this.fireworkcountdowntime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFindfireworkstarttime(long _v_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     xdb.Logs.logIf(new LogKey(this, "findfireworkstarttime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 369 */         new LogLong(this, FireworkRecord.this.findfireworkstarttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 373 */             FireworkRecord.this.findfireworkstarttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 377 */     });
/* 378 */     this.findfireworkstarttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 384 */     _xdb_verify_unsafe_();
/* 385 */     FireworkRecord _o_ = null;
/* 386 */     if ((_o1_ instanceof FireworkRecord)) { _o_ = (FireworkRecord)_o1_;
/* 387 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 388 */       return false;
/* 389 */     if (this.cleansessionid != _o_.cleansessionid) return false;
/* 390 */     if (this.alreadygetnum != _o_.alreadygetnum) return false;
/* 391 */     if (this.fireworkstarttime != _o_.fireworkstarttime) return false;
/* 392 */     if (this.fireworkcountdowntime != _o_.fireworkcountdowntime) return false;
/* 393 */     if (this.findfireworkstarttime != _o_.findfireworkstarttime) return false;
/* 394 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 400 */     _xdb_verify_unsafe_();
/* 401 */     int _h_ = 0;
/* 402 */     _h_ = (int)(_h_ + this.cleansessionid);
/* 403 */     _h_ += this.alreadygetnum;
/* 404 */     _h_ = (int)(_h_ + this.fireworkstarttime);
/* 405 */     _h_ = (int)(_h_ + this.fireworkcountdowntime);
/* 406 */     _h_ = (int)(_h_ + this.findfireworkstarttime);
/* 407 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 413 */     _xdb_verify_unsafe_();
/* 414 */     StringBuilder _sb_ = new StringBuilder();
/* 415 */     _sb_.append("(");
/* 416 */     _sb_.append(this.cleansessionid);
/* 417 */     _sb_.append(",");
/* 418 */     _sb_.append(this.alreadygetnum);
/* 419 */     _sb_.append(",");
/* 420 */     _sb_.append(this.fireworkstarttime);
/* 421 */     _sb_.append(",");
/* 422 */     _sb_.append(this.fireworkcountdowntime);
/* 423 */     _sb_.append(",");
/* 424 */     _sb_.append(this.findfireworkstarttime);
/* 425 */     _sb_.append(")");
/* 426 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 432 */     ListenableBean lb = new ListenableBean();
/* 433 */     lb.add(new ListenableChanged().setVarName("cleansessionid"));
/* 434 */     lb.add(new ListenableChanged().setVarName("alreadygetnum"));
/* 435 */     lb.add(new ListenableChanged().setVarName("fireworkstarttime"));
/* 436 */     lb.add(new ListenableChanged().setVarName("fireworkcountdowntime"));
/* 437 */     lb.add(new ListenableChanged().setVarName("findfireworkstarttime"));
/* 438 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FireworkRecord {
/*     */     private Const() {}
/*     */     
/*     */     FireworkRecord nThis() {
/* 445 */       return FireworkRecord.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FireworkRecord copy()
/*     */     {
/* 457 */       return FireworkRecord.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FireworkRecord toData()
/*     */     {
/* 463 */       return FireworkRecord.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FireworkRecord toBean()
/*     */     {
/* 468 */       return FireworkRecord.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FireworkRecord toDataIf()
/*     */     {
/* 474 */       return FireworkRecord.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FireworkRecord toBeanIf()
/*     */     {
/* 479 */       return FireworkRecord.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCleansessionid()
/*     */     {
/* 486 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 487 */       return FireworkRecord.this.cleansessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAlreadygetnum()
/*     */     {
/* 494 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 495 */       return FireworkRecord.this.alreadygetnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFireworkstarttime()
/*     */     {
/* 502 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 503 */       return FireworkRecord.this.fireworkstarttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFireworkcountdowntime()
/*     */     {
/* 510 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 511 */       return FireworkRecord.this.fireworkcountdowntime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFindfireworkstarttime()
/*     */     {
/* 518 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 519 */       return FireworkRecord.this.findfireworkstarttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCleansessionid(long _v_)
/*     */     {
/* 526 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 527 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAlreadygetnum(int _v_)
/*     */     {
/* 534 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 535 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFireworkstarttime(long _v_)
/*     */     {
/* 542 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 543 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFireworkcountdowntime(long _v_)
/*     */     {
/* 550 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFindfireworkstarttime(long _v_)
/*     */     {
/* 558 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 565 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 566 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 572 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 573 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 579 */       return FireworkRecord.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 585 */       return FireworkRecord.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 591 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 598 */       return FireworkRecord.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 604 */       return FireworkRecord.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 610 */       FireworkRecord.this._xdb_verify_unsafe_();
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 617 */       return FireworkRecord.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       return FireworkRecord.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 629 */       return FireworkRecord.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 635 */       return FireworkRecord.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 641 */       return FireworkRecord.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 647 */       return FireworkRecord.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 653 */       return FireworkRecord.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FireworkRecord
/*     */   {
/*     */     private long cleansessionid;
/*     */     
/*     */     private int alreadygetnum;
/*     */     
/*     */     private long fireworkstarttime;
/*     */     
/*     */     private long fireworkcountdowntime;
/*     */     
/*     */     private long findfireworkstarttime;
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
/*     */     Data(xbean.FireworkRecord _o1_)
/*     */     {
/* 682 */       if ((_o1_ instanceof FireworkRecord)) { assign((FireworkRecord)_o1_);
/* 683 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 684 */       } else if ((_o1_ instanceof FireworkRecord.Const)) assign(((FireworkRecord.Const)_o1_).nThis()); else {
/* 685 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FireworkRecord _o_) {
/* 690 */       this.cleansessionid = _o_.cleansessionid;
/* 691 */       this.alreadygetnum = _o_.alreadygetnum;
/* 692 */       this.fireworkstarttime = _o_.fireworkstarttime;
/* 693 */       this.fireworkcountdowntime = _o_.fireworkcountdowntime;
/* 694 */       this.findfireworkstarttime = _o_.findfireworkstarttime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 699 */       this.cleansessionid = _o_.cleansessionid;
/* 700 */       this.alreadygetnum = _o_.alreadygetnum;
/* 701 */       this.fireworkstarttime = _o_.fireworkstarttime;
/* 702 */       this.fireworkcountdowntime = _o_.fireworkcountdowntime;
/* 703 */       this.findfireworkstarttime = _o_.findfireworkstarttime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 709 */       _os_.marshal(this.cleansessionid);
/* 710 */       _os_.marshal(this.alreadygetnum);
/* 711 */       _os_.marshal(this.fireworkstarttime);
/* 712 */       _os_.marshal(this.fireworkcountdowntime);
/* 713 */       _os_.marshal(this.findfireworkstarttime);
/* 714 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 720 */       this.cleansessionid = _os_.unmarshal_long();
/* 721 */       this.alreadygetnum = _os_.unmarshal_int();
/* 722 */       this.fireworkstarttime = _os_.unmarshal_long();
/* 723 */       this.fireworkcountdowntime = _os_.unmarshal_long();
/* 724 */       this.findfireworkstarttime = _os_.unmarshal_long();
/* 725 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 731 */       int _size_ = 0;
/* 732 */       _size_ += CodedOutputStream.computeInt64Size(1, this.cleansessionid);
/* 733 */       _size_ += CodedOutputStream.computeInt32Size(2, this.alreadygetnum);
/* 734 */       _size_ += CodedOutputStream.computeInt64Size(3, this.fireworkstarttime);
/* 735 */       _size_ += CodedOutputStream.computeInt64Size(4, this.fireworkcountdowntime);
/* 736 */       _size_ += CodedOutputStream.computeInt64Size(5, this.findfireworkstarttime);
/* 737 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 745 */         _output_.writeInt64(1, this.cleansessionid);
/* 746 */         _output_.writeInt32(2, this.alreadygetnum);
/* 747 */         _output_.writeInt64(3, this.fireworkstarttime);
/* 748 */         _output_.writeInt64(4, this.fireworkcountdowntime);
/* 749 */         _output_.writeInt64(5, this.findfireworkstarttime);
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
/* 776 */             this.cleansessionid = _input_.readInt64();
/* 777 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 781 */             this.alreadygetnum = _input_.readInt32();
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 786 */             this.fireworkstarttime = _input_.readInt64();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 791 */             this.fireworkcountdowntime = _input_.readInt64();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 796 */             this.findfireworkstarttime = _input_.readInt64();
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
/*     */     public xbean.FireworkRecord copy()
/*     */     {
/* 824 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FireworkRecord toData()
/*     */     {
/* 830 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FireworkRecord toBean()
/*     */     {
/* 835 */       return new FireworkRecord(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FireworkRecord toDataIf()
/*     */     {
/* 841 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FireworkRecord toBeanIf()
/*     */     {
/* 846 */       return new FireworkRecord(this, null, null);
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
/*     */     public long getCleansessionid()
/*     */     {
/* 883 */       return this.cleansessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAlreadygetnum()
/*     */     {
/* 890 */       return this.alreadygetnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFireworkstarttime()
/*     */     {
/* 897 */       return this.fireworkstarttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFireworkcountdowntime()
/*     */     {
/* 904 */       return this.fireworkcountdowntime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFindfireworkstarttime()
/*     */     {
/* 911 */       return this.findfireworkstarttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCleansessionid(long _v_)
/*     */     {
/* 918 */       this.cleansessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAlreadygetnum(int _v_)
/*     */     {
/* 925 */       this.alreadygetnum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFireworkstarttime(long _v_)
/*     */     {
/* 932 */       this.fireworkstarttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFireworkcountdowntime(long _v_)
/*     */     {
/* 939 */       this.fireworkcountdowntime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFindfireworkstarttime(long _v_)
/*     */     {
/* 946 */       this.findfireworkstarttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 952 */       if (!(_o1_ instanceof Data)) return false;
/* 953 */       Data _o_ = (Data)_o1_;
/* 954 */       if (this.cleansessionid != _o_.cleansessionid) return false;
/* 955 */       if (this.alreadygetnum != _o_.alreadygetnum) return false;
/* 956 */       if (this.fireworkstarttime != _o_.fireworkstarttime) return false;
/* 957 */       if (this.fireworkcountdowntime != _o_.fireworkcountdowntime) return false;
/* 958 */       if (this.findfireworkstarttime != _o_.findfireworkstarttime) return false;
/* 959 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 965 */       int _h_ = 0;
/* 966 */       _h_ = (int)(_h_ + this.cleansessionid);
/* 967 */       _h_ += this.alreadygetnum;
/* 968 */       _h_ = (int)(_h_ + this.fireworkstarttime);
/* 969 */       _h_ = (int)(_h_ + this.fireworkcountdowntime);
/* 970 */       _h_ = (int)(_h_ + this.findfireworkstarttime);
/* 971 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 977 */       StringBuilder _sb_ = new StringBuilder();
/* 978 */       _sb_.append("(");
/* 979 */       _sb_.append(this.cleansessionid);
/* 980 */       _sb_.append(",");
/* 981 */       _sb_.append(this.alreadygetnum);
/* 982 */       _sb_.append(",");
/* 983 */       _sb_.append(this.fireworkstarttime);
/* 984 */       _sb_.append(",");
/* 985 */       _sb_.append(this.fireworkcountdowntime);
/* 986 */       _sb_.append(",");
/* 987 */       _sb_.append(this.findfireworkstarttime);
/* 988 */       _sb_.append(")");
/* 989 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FireworkRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*     */ 
/*     */ public final class GatherMapItemInfo extends XBean implements xbean.GatherMapItemInfo
/*     */ {
/*     */   private long request_gather_timestamp;
/*     */   private long gather_success_timestamp;
/*     */   private int gather_success_times;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.request_gather_timestamp = 0L;
/*  23 */     this.gather_success_timestamp = 0L;
/*  24 */     this.gather_success_times = 0;
/*     */   }
/*     */   
/*     */   GatherMapItemInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public GatherMapItemInfo()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GatherMapItemInfo(GatherMapItemInfo _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GatherMapItemInfo(xbean.GatherMapItemInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof GatherMapItemInfo)) { assign((GatherMapItemInfo)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GatherMapItemInfo _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.request_gather_timestamp = _o_.request_gather_timestamp;
/*  55 */     this.gather_success_timestamp = _o_.gather_success_timestamp;
/*  56 */     this.gather_success_times = _o_.gather_success_times;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.request_gather_timestamp = _o_.request_gather_timestamp;
/*  62 */     this.gather_success_timestamp = _o_.gather_success_timestamp;
/*  63 */     this.gather_success_times = _o_.gather_success_times;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.request_gather_timestamp);
/*  71 */     _os_.marshal(this.gather_success_timestamp);
/*  72 */     _os_.marshal(this.gather_success_times);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.request_gather_timestamp = _os_.unmarshal_long();
/*  81 */     this.gather_success_timestamp = _os_.unmarshal_long();
/*  82 */     this.gather_success_times = _os_.unmarshal_int();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt64Size(1, this.request_gather_timestamp);
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(2, this.gather_success_timestamp);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(3, this.gather_success_times);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt64(1, this.request_gather_timestamp);
/* 104 */       _output_.writeInt64(2, this.gather_success_timestamp);
/* 105 */       _output_.writeInt32(3, this.gather_success_times);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           this.request_gather_timestamp = _input_.readInt64();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.gather_success_timestamp = _input_.readInt64();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.gather_success_times = _input_.readInt32();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 148 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 150 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 159 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 165 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GatherMapItemInfo copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new GatherMapItemInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GatherMapItemInfo toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GatherMapItemInfo toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new GatherMapItemInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GatherMapItemInfo toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GatherMapItemInfo toBeanIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRequest_gather_timestamp()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.request_gather_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getGather_success_timestamp()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.gather_success_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGather_success_times()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.gather_success_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRequest_gather_timestamp(long _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "request_gather_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogLong(this, GatherMapItemInfo.this.request_gather_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             GatherMapItemInfo.this.request_gather_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.request_gather_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGather_success_timestamp(long _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "gather_success_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogLong(this, GatherMapItemInfo.this.gather_success_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             GatherMapItemInfo.this.gather_success_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.gather_success_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGather_success_times(int _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "gather_success_times")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogInt(this, GatherMapItemInfo.this.gather_success_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             GatherMapItemInfo.this.gather_success_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.gather_success_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     GatherMapItemInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof GatherMapItemInfo)) { _o_ = (GatherMapItemInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.request_gather_timestamp != _o_.request_gather_timestamp) return false;
/* 304 */     if (this.gather_success_timestamp != _o_.gather_success_timestamp) return false;
/* 305 */     if (this.gather_success_times != _o_.gather_success_times) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ = (int)(_h_ + this.request_gather_timestamp);
/* 315 */     _h_ = (int)(_h_ + this.gather_success_timestamp);
/* 316 */     _h_ += this.gather_success_times;
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.request_gather_timestamp);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.gather_success_timestamp);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.gather_success_times);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("request_gather_timestamp"));
/* 340 */     lb.add(new ListenableChanged().setVarName("gather_success_timestamp"));
/* 341 */     lb.add(new ListenableChanged().setVarName("gather_success_times"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GatherMapItemInfo {
/*     */     private Const() {}
/*     */     
/*     */     GatherMapItemInfo nThis() {
/* 349 */       return GatherMapItemInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GatherMapItemInfo copy()
/*     */     {
/* 361 */       return GatherMapItemInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GatherMapItemInfo toData()
/*     */     {
/* 367 */       return GatherMapItemInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GatherMapItemInfo toBean()
/*     */     {
/* 372 */       return GatherMapItemInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GatherMapItemInfo toDataIf()
/*     */     {
/* 378 */       return GatherMapItemInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GatherMapItemInfo toBeanIf()
/*     */     {
/* 383 */       return GatherMapItemInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRequest_gather_timestamp()
/*     */     {
/* 390 */       GatherMapItemInfo.this._xdb_verify_unsafe_();
/* 391 */       return GatherMapItemInfo.this.request_gather_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGather_success_timestamp()
/*     */     {
/* 398 */       GatherMapItemInfo.this._xdb_verify_unsafe_();
/* 399 */       return GatherMapItemInfo.this.gather_success_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGather_success_times()
/*     */     {
/* 406 */       GatherMapItemInfo.this._xdb_verify_unsafe_();
/* 407 */       return GatherMapItemInfo.this.gather_success_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRequest_gather_timestamp(long _v_)
/*     */     {
/* 414 */       GatherMapItemInfo.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGather_success_timestamp(long _v_)
/*     */     {
/* 422 */       GatherMapItemInfo.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGather_success_times(int _v_)
/*     */     {
/* 430 */       GatherMapItemInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       GatherMapItemInfo.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       GatherMapItemInfo.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return GatherMapItemInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return GatherMapItemInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       GatherMapItemInfo.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return GatherMapItemInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return GatherMapItemInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       GatherMapItemInfo.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return GatherMapItemInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return GatherMapItemInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return GatherMapItemInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return GatherMapItemInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return GatherMapItemInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return GatherMapItemInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return GatherMapItemInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GatherMapItemInfo
/*     */   {
/*     */     private long request_gather_timestamp;
/*     */     
/*     */     private long gather_success_timestamp;
/*     */     
/*     */     private int gather_success_times;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.GatherMapItemInfo _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof GatherMapItemInfo)) { assign((GatherMapItemInfo)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof GatherMapItemInfo.Const)) assign(((GatherMapItemInfo.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GatherMapItemInfo _o_) {
/* 558 */       this.request_gather_timestamp = _o_.request_gather_timestamp;
/* 559 */       this.gather_success_timestamp = _o_.gather_success_timestamp;
/* 560 */       this.gather_success_times = _o_.gather_success_times;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.request_gather_timestamp = _o_.request_gather_timestamp;
/* 566 */       this.gather_success_timestamp = _o_.gather_success_timestamp;
/* 567 */       this.gather_success_times = _o_.gather_success_times;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.request_gather_timestamp);
/* 574 */       _os_.marshal(this.gather_success_timestamp);
/* 575 */       _os_.marshal(this.gather_success_times);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.request_gather_timestamp = _os_.unmarshal_long();
/* 583 */       this.gather_success_timestamp = _os_.unmarshal_long();
/* 584 */       this.gather_success_times = _os_.unmarshal_int();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt64Size(1, this.request_gather_timestamp);
/* 593 */       _size_ += CodedOutputStream.computeInt64Size(2, this.gather_success_timestamp);
/* 594 */       _size_ += CodedOutputStream.computeInt32Size(3, this.gather_success_times);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt64(1, this.request_gather_timestamp);
/* 604 */         _output_.writeInt64(2, this.gather_success_timestamp);
/* 605 */         _output_.writeInt32(3, this.gather_success_times);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.request_gather_timestamp = _input_.readInt64();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.gather_success_timestamp = _input_.readInt64();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.gather_success_times = _input_.readInt32();
/* 643 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 647 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 649 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 658 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 662 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 664 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GatherMapItemInfo copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GatherMapItemInfo toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GatherMapItemInfo toBean()
/*     */     {
/* 681 */       return new GatherMapItemInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GatherMapItemInfo toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GatherMapItemInfo toBeanIf()
/*     */     {
/* 692 */       return new GatherMapItemInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 698 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 718 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRequest_gather_timestamp()
/*     */     {
/* 729 */       return this.request_gather_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGather_success_timestamp()
/*     */     {
/* 736 */       return this.gather_success_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGather_success_times()
/*     */     {
/* 743 */       return this.gather_success_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRequest_gather_timestamp(long _v_)
/*     */     {
/* 750 */       this.request_gather_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGather_success_timestamp(long _v_)
/*     */     {
/* 757 */       this.gather_success_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGather_success_times(int _v_)
/*     */     {
/* 764 */       this.gather_success_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.request_gather_timestamp != _o_.request_gather_timestamp) return false;
/* 773 */       if (this.gather_success_timestamp != _o_.gather_success_timestamp) return false;
/* 774 */       if (this.gather_success_times != _o_.gather_success_times) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ = (int)(_h_ + this.request_gather_timestamp);
/* 783 */       _h_ = (int)(_h_ + this.gather_success_timestamp);
/* 784 */       _h_ += this.gather_success_times;
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.request_gather_timestamp);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.gather_success_timestamp);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.gather_success_times);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GatherMapItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
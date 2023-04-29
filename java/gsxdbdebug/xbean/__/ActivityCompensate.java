/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.TreeMap;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class ActivityCompensate extends XBean implements xbean.ActivityCompensate
/*     */ {
/*     */   private TreeMap<Long, Integer> start_time2get_times;
/*     */   private long can_join_time;
/*     */   private long latest_start_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.start_time2get_times.clear();
/*  23 */     this.can_join_time = 0L;
/*  24 */     this.latest_start_time = 0L;
/*     */   }
/*     */   
/*     */   ActivityCompensate(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.start_time2get_times = new TreeMap();
/*  31 */     this.can_join_time = 0L;
/*  32 */     this.latest_start_time = 0L;
/*     */   }
/*     */   
/*     */   public ActivityCompensate()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ActivityCompensate(ActivityCompensate _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ActivityCompensate(xbean.ActivityCompensate _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof ActivityCompensate)) { assign((ActivityCompensate)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ActivityCompensate _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.start_time2get_times = new TreeMap();
/*  58 */     for (Map.Entry<Long, Integer> _e_ : _o_.start_time2get_times.entrySet())
/*  59 */       this.start_time2get_times.put(_e_.getKey(), _e_.getValue());
/*  60 */     this.can_join_time = _o_.can_join_time;
/*  61 */     this.latest_start_time = _o_.latest_start_time;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.start_time2get_times = new TreeMap();
/*  67 */     for (Map.Entry<Long, Integer> _e_ : _o_.start_time2get_times.entrySet())
/*  68 */       this.start_time2get_times.put(_e_.getKey(), _e_.getValue());
/*  69 */     this.can_join_time = _o_.can_join_time;
/*  70 */     this.latest_start_time = _o_.latest_start_time;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     _os_.compact_uint32(this.start_time2get_times.size());
/*  78 */     for (Map.Entry<Long, Integer> _e_ : this.start_time2get_times.entrySet())
/*     */     {
/*  80 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  81 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  83 */     _os_.marshal(this.can_join_time);
/*  84 */     _os_.marshal(this.latest_start_time);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  94 */       long _k_ = 0L;
/*  95 */       _k_ = _os_.unmarshal_long();
/*  96 */       int _v_ = 0;
/*  97 */       _v_ = _os_.unmarshal_int();
/*  98 */       this.start_time2get_times.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 100 */     this.can_join_time = _os_.unmarshal_long();
/* 101 */     this.latest_start_time = _os_.unmarshal_long();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     int _size_ = 0;
/* 110 */     for (Map.Entry<Long, Integer> _e_ : this.start_time2get_times.entrySet())
/*     */     {
/* 112 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 113 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 115 */     _size_ += CodedOutputStream.computeInt64Size(2, this.can_join_time);
/* 116 */     _size_ += CodedOutputStream.computeInt64Size(3, this.latest_start_time);
/* 117 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 123 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 126 */       for (Map.Entry<Long, Integer> _e_ : this.start_time2get_times.entrySet())
/*     */       {
/* 128 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 129 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 131 */       _output_.writeInt64(2, this.can_join_time);
/* 132 */       _output_.writeInt64(3, this.latest_start_time);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 136 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 138 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 144 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 147 */       boolean done = false;
/* 148 */       while (!done)
/*     */       {
/* 150 */         int tag = _input_.readTag();
/* 151 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 155 */           done = true;
/* 156 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 160 */           long _k_ = 0L;
/* 161 */           _k_ = _input_.readInt64();
/* 162 */           int readTag = _input_.readTag();
/* 163 */           if (8 != readTag)
/*     */           {
/* 165 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 167 */           int _v_ = 0;
/* 168 */           _v_ = _input_.readInt32();
/* 169 */           this.start_time2get_times.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 170 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 174 */           this.can_join_time = _input_.readInt64();
/* 175 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 179 */           this.latest_start_time = _input_.readInt64();
/* 180 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 184 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 186 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 195 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 199 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 201 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ActivityCompensate copy()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new ActivityCompensate(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ActivityCompensate toData()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ActivityCompensate toBean()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new ActivityCompensate(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ActivityCompensate toDataIf()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ActivityCompensate toBeanIf()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public NavigableMap<Long, Integer> getStart_time2get_times()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return xdb.Logs.logNavigableMap(new LogKey(this, "start_time2get_times"), this.start_time2get_times);
/*     */   }
/*     */   
/*     */ 
/*     */   public NavigableMap<Long, Integer> getStart_time2get_timesAsData()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/*     */     
/* 257 */     ActivityCompensate _o_ = this;
/* 258 */     NavigableMap<Long, Integer> start_time2get_times = new TreeMap();
/* 259 */     for (Map.Entry<Long, Integer> _e_ : _o_.start_time2get_times.entrySet())
/* 260 */       start_time2get_times.put(_e_.getKey(), _e_.getValue());
/* 261 */     return start_time2get_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCan_join_time()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     return this.can_join_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLatest_start_time()
/*     */   {
/* 276 */     _xdb_verify_unsafe_();
/* 277 */     return this.latest_start_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCan_join_time(long _v_)
/*     */   {
/* 284 */     _xdb_verify_unsafe_();
/* 285 */     xdb.Logs.logIf(new LogKey(this, "can_join_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 289 */         new xdb.logs.LogLong(this, ActivityCompensate.this.can_join_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 293 */             ActivityCompensate.this.can_join_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 297 */     });
/* 298 */     this.can_join_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLatest_start_time(long _v_)
/*     */   {
/* 305 */     _xdb_verify_unsafe_();
/* 306 */     xdb.Logs.logIf(new LogKey(this, "latest_start_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 310 */         new xdb.logs.LogLong(this, ActivityCompensate.this.latest_start_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 314 */             ActivityCompensate.this.latest_start_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 318 */     });
/* 319 */     this.latest_start_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 325 */     _xdb_verify_unsafe_();
/* 326 */     ActivityCompensate _o_ = null;
/* 327 */     if ((_o1_ instanceof ActivityCompensate)) { _o_ = (ActivityCompensate)_o1_;
/* 328 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 329 */       return false;
/* 330 */     if (!this.start_time2get_times.equals(_o_.start_time2get_times)) return false;
/* 331 */     if (this.can_join_time != _o_.can_join_time) return false;
/* 332 */     if (this.latest_start_time != _o_.latest_start_time) return false;
/* 333 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 339 */     _xdb_verify_unsafe_();
/* 340 */     int _h_ = 0;
/* 341 */     _h_ += this.start_time2get_times.hashCode();
/* 342 */     _h_ = (int)(_h_ + this.can_join_time);
/* 343 */     _h_ = (int)(_h_ + this.latest_start_time);
/* 344 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 350 */     _xdb_verify_unsafe_();
/* 351 */     StringBuilder _sb_ = new StringBuilder();
/* 352 */     _sb_.append("(");
/* 353 */     _sb_.append(this.start_time2get_times);
/* 354 */     _sb_.append(",");
/* 355 */     _sb_.append(this.can_join_time);
/* 356 */     _sb_.append(",");
/* 357 */     _sb_.append(this.latest_start_time);
/* 358 */     _sb_.append(")");
/* 359 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 365 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 366 */     lb.add(new xdb.logs.ListenableMap().setVarName("start_time2get_times"));
/* 367 */     lb.add(new xdb.logs.ListenableChanged().setVarName("can_join_time"));
/* 368 */     lb.add(new xdb.logs.ListenableChanged().setVarName("latest_start_time"));
/* 369 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ActivityCompensate {
/*     */     private Const() {}
/*     */     
/*     */     ActivityCompensate nThis() {
/* 376 */       return ActivityCompensate.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 382 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityCompensate copy()
/*     */     {
/* 388 */       return ActivityCompensate.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityCompensate toData()
/*     */     {
/* 394 */       return ActivityCompensate.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ActivityCompensate toBean()
/*     */     {
/* 399 */       return ActivityCompensate.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityCompensate toDataIf()
/*     */     {
/* 405 */       return ActivityCompensate.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ActivityCompensate toBeanIf()
/*     */     {
/* 410 */       return ActivityCompensate.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public NavigableMap<Long, Integer> getStart_time2get_times()
/*     */     {
/* 417 */       ActivityCompensate.this._xdb_verify_unsafe_();
/* 418 */       return xdb.Consts.constNavigableMap(ActivityCompensate.this.start_time2get_times);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public NavigableMap<Long, Integer> getStart_time2get_timesAsData()
/*     */     {
/* 425 */       ActivityCompensate.this._xdb_verify_unsafe_();
/*     */       
/* 427 */       ActivityCompensate _o_ = ActivityCompensate.this;
/* 428 */       NavigableMap<Long, Integer> start_time2get_times = new TreeMap();
/* 429 */       for (Map.Entry<Long, Integer> _e_ : _o_.start_time2get_times.entrySet())
/* 430 */         start_time2get_times.put(_e_.getKey(), _e_.getValue());
/* 431 */       return start_time2get_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCan_join_time()
/*     */     {
/* 438 */       ActivityCompensate.this._xdb_verify_unsafe_();
/* 439 */       return ActivityCompensate.this.can_join_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLatest_start_time()
/*     */     {
/* 446 */       ActivityCompensate.this._xdb_verify_unsafe_();
/* 447 */       return ActivityCompensate.this.latest_start_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCan_join_time(long _v_)
/*     */     {
/* 454 */       ActivityCompensate.this._xdb_verify_unsafe_();
/* 455 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLatest_start_time(long _v_)
/*     */     {
/* 462 */       ActivityCompensate.this._xdb_verify_unsafe_();
/* 463 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 469 */       ActivityCompensate.this._xdb_verify_unsafe_();
/* 470 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 476 */       ActivityCompensate.this._xdb_verify_unsafe_();
/* 477 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 483 */       return ActivityCompensate.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 489 */       return ActivityCompensate.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 495 */       ActivityCompensate.this._xdb_verify_unsafe_();
/* 496 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 502 */       return ActivityCompensate.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 508 */       return ActivityCompensate.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 514 */       ActivityCompensate.this._xdb_verify_unsafe_();
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 521 */       return ActivityCompensate.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 527 */       return ActivityCompensate.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 533 */       return ActivityCompensate.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 539 */       return ActivityCompensate.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 545 */       return ActivityCompensate.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 551 */       return ActivityCompensate.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 557 */       return ActivityCompensate.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ActivityCompensate
/*     */   {
/*     */     private TreeMap<Long, Integer> start_time2get_times;
/*     */     
/*     */     private long can_join_time;
/*     */     
/*     */     private long latest_start_time;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 573 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 578 */       this.start_time2get_times = new TreeMap();
/* 579 */       this.can_join_time = 0L;
/* 580 */       this.latest_start_time = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.ActivityCompensate _o1_)
/*     */     {
/* 585 */       if ((_o1_ instanceof ActivityCompensate)) { assign((ActivityCompensate)_o1_);
/* 586 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 587 */       } else if ((_o1_ instanceof ActivityCompensate.Const)) assign(((ActivityCompensate.Const)_o1_).nThis()); else {
/* 588 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ActivityCompensate _o_) {
/* 593 */       this.start_time2get_times = new TreeMap();
/* 594 */       for (Map.Entry<Long, Integer> _e_ : _o_.start_time2get_times.entrySet())
/* 595 */         this.start_time2get_times.put(_e_.getKey(), _e_.getValue());
/* 596 */       this.can_join_time = _o_.can_join_time;
/* 597 */       this.latest_start_time = _o_.latest_start_time;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 602 */       this.start_time2get_times = new TreeMap();
/* 603 */       for (Map.Entry<Long, Integer> _e_ : _o_.start_time2get_times.entrySet())
/* 604 */         this.start_time2get_times.put(_e_.getKey(), _e_.getValue());
/* 605 */       this.can_join_time = _o_.can_join_time;
/* 606 */       this.latest_start_time = _o_.latest_start_time;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 612 */       _os_.compact_uint32(this.start_time2get_times.size());
/* 613 */       for (Map.Entry<Long, Integer> _e_ : this.start_time2get_times.entrySet())
/*     */       {
/* 615 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 616 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 618 */       _os_.marshal(this.can_join_time);
/* 619 */       _os_.marshal(this.latest_start_time);
/* 620 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 626 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 628 */         long _k_ = 0L;
/* 629 */         _k_ = _os_.unmarshal_long();
/* 630 */         int _v_ = 0;
/* 631 */         _v_ = _os_.unmarshal_int();
/* 632 */         this.start_time2get_times.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/* 634 */       this.can_join_time = _os_.unmarshal_long();
/* 635 */       this.latest_start_time = _os_.unmarshal_long();
/* 636 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 642 */       int _size_ = 0;
/* 643 */       for (Map.Entry<Long, Integer> _e_ : this.start_time2get_times.entrySet())
/*     */       {
/* 645 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 646 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 648 */       _size_ += CodedOutputStream.computeInt64Size(2, this.can_join_time);
/* 649 */       _size_ += CodedOutputStream.computeInt64Size(3, this.latest_start_time);
/* 650 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 658 */         for (Map.Entry<Long, Integer> _e_ : this.start_time2get_times.entrySet())
/*     */         {
/* 660 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 661 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 663 */         _output_.writeInt64(2, this.can_join_time);
/* 664 */         _output_.writeInt64(3, this.latest_start_time);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 668 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 670 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 678 */         boolean done = false;
/* 679 */         while (!done)
/*     */         {
/* 681 */           int tag = _input_.readTag();
/* 682 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 686 */             done = true;
/* 687 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 691 */             long _k_ = 0L;
/* 692 */             _k_ = _input_.readInt64();
/* 693 */             int readTag = _input_.readTag();
/* 694 */             if (8 != readTag)
/*     */             {
/* 696 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 698 */             int _v_ = 0;
/* 699 */             _v_ = _input_.readInt32();
/* 700 */             this.start_time2get_times.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 701 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 705 */             this.can_join_time = _input_.readInt64();
/* 706 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 710 */             this.latest_start_time = _input_.readInt64();
/* 711 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 715 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 717 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 726 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 730 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 732 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityCompensate copy()
/*     */     {
/* 738 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityCompensate toData()
/*     */     {
/* 744 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ActivityCompensate toBean()
/*     */     {
/* 749 */       return new ActivityCompensate(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityCompensate toDataIf()
/*     */     {
/* 755 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ActivityCompensate toBeanIf()
/*     */     {
/* 760 */       return new ActivityCompensate(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 766 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 770 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 774 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 778 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 782 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 786 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 790 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public NavigableMap<Long, Integer> getStart_time2get_times()
/*     */     {
/* 797 */       return this.start_time2get_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public NavigableMap<Long, Integer> getStart_time2get_timesAsData()
/*     */     {
/* 804 */       return this.start_time2get_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCan_join_time()
/*     */     {
/* 811 */       return this.can_join_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLatest_start_time()
/*     */     {
/* 818 */       return this.latest_start_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCan_join_time(long _v_)
/*     */     {
/* 825 */       this.can_join_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLatest_start_time(long _v_)
/*     */     {
/* 832 */       this.latest_start_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 838 */       if (!(_o1_ instanceof Data)) return false;
/* 839 */       Data _o_ = (Data)_o1_;
/* 840 */       if (!this.start_time2get_times.equals(_o_.start_time2get_times)) return false;
/* 841 */       if (this.can_join_time != _o_.can_join_time) return false;
/* 842 */       if (this.latest_start_time != _o_.latest_start_time) return false;
/* 843 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 849 */       int _h_ = 0;
/* 850 */       _h_ += this.start_time2get_times.hashCode();
/* 851 */       _h_ = (int)(_h_ + this.can_join_time);
/* 852 */       _h_ = (int)(_h_ + this.latest_start_time);
/* 853 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 859 */       StringBuilder _sb_ = new StringBuilder();
/* 860 */       _sb_.append("(");
/* 861 */       _sb_.append(this.start_time2get_times);
/* 862 */       _sb_.append(",");
/* 863 */       _sb_.append(this.can_join_time);
/* 864 */       _sb_.append(",");
/* 865 */       _sb_.append(this.latest_start_time);
/* 866 */       _sb_.append(")");
/* 867 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ActivityCompensate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
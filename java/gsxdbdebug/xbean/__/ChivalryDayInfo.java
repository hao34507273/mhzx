/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class ChivalryDayInfo extends XBean implements xbean.ChivalryDayInfo
/*     */ {
/*     */   private long lastflushtime;
/*     */   private int chivalrydaysum;
/*     */   private HashMap<Integer, Integer> activitydaysum;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.lastflushtime = 0L;
/*  23 */     this.chivalrydaysum = 0;
/*  24 */     this.activitydaysum.clear();
/*     */   }
/*     */   
/*     */   ChivalryDayInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.activitydaysum = new HashMap();
/*     */   }
/*     */   
/*     */   public ChivalryDayInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ChivalryDayInfo(ChivalryDayInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ChivalryDayInfo(xbean.ChivalryDayInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof ChivalryDayInfo)) { assign((ChivalryDayInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ChivalryDayInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.lastflushtime = _o_.lastflushtime;
/*  56 */     this.chivalrydaysum = _o_.chivalrydaysum;
/*  57 */     this.activitydaysum = new HashMap();
/*  58 */     for (Map.Entry<Integer, Integer> _e_ : _o_.activitydaysum.entrySet()) {
/*  59 */       this.activitydaysum.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  64 */     this.lastflushtime = _o_.lastflushtime;
/*  65 */     this.chivalrydaysum = _o_.chivalrydaysum;
/*  66 */     this.activitydaysum = new HashMap();
/*  67 */     for (Map.Entry<Integer, Integer> _e_ : _o_.activitydaysum.entrySet()) {
/*  68 */       this.activitydaysum.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.lastflushtime);
/*  76 */     _os_.marshal(this.chivalrydaysum);
/*  77 */     _os_.compact_uint32(this.activitydaysum.size());
/*  78 */     for (Map.Entry<Integer, Integer> _e_ : this.activitydaysum.entrySet())
/*     */     {
/*  80 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  81 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     this.lastflushtime = _os_.unmarshal_long();
/*  91 */     this.chivalrydaysum = _os_.unmarshal_int();
/*     */     
/*  93 */     int size = _os_.uncompact_uint32();
/*  94 */     if (size >= 12)
/*     */     {
/*  96 */       this.activitydaysum = new HashMap(size * 2);
/*     */     }
/*  98 */     for (; size > 0; size--)
/*     */     {
/* 100 */       int _k_ = 0;
/* 101 */       _k_ = _os_.unmarshal_int();
/* 102 */       int _v_ = 0;
/* 103 */       _v_ = _os_.unmarshal_int();
/* 104 */       this.activitydaysum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     int _size_ = 0;
/* 115 */     _size_ += CodedOutputStream.computeInt64Size(1, this.lastflushtime);
/* 116 */     _size_ += CodedOutputStream.computeInt32Size(2, this.chivalrydaysum);
/* 117 */     for (Map.Entry<Integer, Integer> _e_ : this.activitydaysum.entrySet())
/*     */     {
/* 119 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 120 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 122 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       _output_.writeInt64(1, this.lastflushtime);
/* 132 */       _output_.writeInt32(2, this.chivalrydaysum);
/* 133 */       for (Map.Entry<Integer, Integer> _e_ : this.activitydaysum.entrySet())
/*     */       {
/* 135 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 136 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 141 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 143 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 149 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 152 */       boolean done = false;
/* 153 */       while (!done)
/*     */       {
/* 155 */         int tag = _input_.readTag();
/* 156 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 160 */           done = true;
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 165 */           this.lastflushtime = _input_.readInt64();
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this.chivalrydaysum = _input_.readInt32();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 175 */           int _k_ = 0;
/* 176 */           _k_ = _input_.readInt32();
/* 177 */           int readTag = _input_.readTag();
/* 178 */           if (24 != readTag)
/*     */           {
/* 180 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 182 */           int _v_ = 0;
/* 183 */           _v_ = _input_.readInt32();
/* 184 */           this.activitydaysum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 185 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 189 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 191 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 200 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 204 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 206 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChivalryDayInfo copy()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new ChivalryDayInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChivalryDayInfo toData()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChivalryDayInfo toBean()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new ChivalryDayInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChivalryDayInfo toDataIf()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChivalryDayInfo toBeanIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLastflushtime()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.lastflushtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getChivalrydaysum()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.chivalrydaysum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getActivitydaysum()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return xdb.Logs.logMap(new LogKey(this, "activitydaysum"), this.activitydaysum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getActivitydaysumAsData()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/*     */     
/* 279 */     ChivalryDayInfo _o_ = this;
/* 280 */     Map<Integer, Integer> activitydaysum = new HashMap();
/* 281 */     for (Map.Entry<Integer, Integer> _e_ : _o_.activitydaysum.entrySet())
/* 282 */       activitydaysum.put(_e_.getKey(), _e_.getValue());
/* 283 */     return activitydaysum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLastflushtime(long _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "lastflushtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogLong(this, ChivalryDayInfo.this.lastflushtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             ChivalryDayInfo.this.lastflushtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.lastflushtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setChivalrydaysum(int _v_)
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     xdb.Logs.logIf(new LogKey(this, "chivalrydaysum")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 316 */         new xdb.logs.LogInt(this, ChivalryDayInfo.this.chivalrydaysum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 320 */             ChivalryDayInfo.this.chivalrydaysum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 324 */     });
/* 325 */     this.chivalrydaysum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     ChivalryDayInfo _o_ = null;
/* 333 */     if ((_o1_ instanceof ChivalryDayInfo)) { _o_ = (ChivalryDayInfo)_o1_;
/* 334 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 335 */       return false;
/* 336 */     if (this.lastflushtime != _o_.lastflushtime) return false;
/* 337 */     if (this.chivalrydaysum != _o_.chivalrydaysum) return false;
/* 338 */     if (!this.activitydaysum.equals(_o_.activitydaysum)) return false;
/* 339 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     int _h_ = 0;
/* 347 */     _h_ = (int)(_h_ + this.lastflushtime);
/* 348 */     _h_ += this.chivalrydaysum;
/* 349 */     _h_ += this.activitydaysum.hashCode();
/* 350 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     StringBuilder _sb_ = new StringBuilder();
/* 358 */     _sb_.append("(");
/* 359 */     _sb_.append(this.lastflushtime);
/* 360 */     _sb_.append(",");
/* 361 */     _sb_.append(this.chivalrydaysum);
/* 362 */     _sb_.append(",");
/* 363 */     _sb_.append(this.activitydaysum);
/* 364 */     _sb_.append(")");
/* 365 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 371 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 372 */     lb.add(new xdb.logs.ListenableChanged().setVarName("lastflushtime"));
/* 373 */     lb.add(new xdb.logs.ListenableChanged().setVarName("chivalrydaysum"));
/* 374 */     lb.add(new xdb.logs.ListenableMap().setVarName("activitydaysum"));
/* 375 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ChivalryDayInfo {
/*     */     private Const() {}
/*     */     
/*     */     ChivalryDayInfo nThis() {
/* 382 */       return ChivalryDayInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 388 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChivalryDayInfo copy()
/*     */     {
/* 394 */       return ChivalryDayInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChivalryDayInfo toData()
/*     */     {
/* 400 */       return ChivalryDayInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ChivalryDayInfo toBean()
/*     */     {
/* 405 */       return ChivalryDayInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChivalryDayInfo toDataIf()
/*     */     {
/* 411 */       return ChivalryDayInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ChivalryDayInfo toBeanIf()
/*     */     {
/* 416 */       return ChivalryDayInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLastflushtime()
/*     */     {
/* 423 */       ChivalryDayInfo.this._xdb_verify_unsafe_();
/* 424 */       return ChivalryDayInfo.this.lastflushtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getChivalrydaysum()
/*     */     {
/* 431 */       ChivalryDayInfo.this._xdb_verify_unsafe_();
/* 432 */       return ChivalryDayInfo.this.chivalrydaysum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getActivitydaysum()
/*     */     {
/* 439 */       ChivalryDayInfo.this._xdb_verify_unsafe_();
/* 440 */       return xdb.Consts.constMap(ChivalryDayInfo.this.activitydaysum);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getActivitydaysumAsData()
/*     */     {
/* 447 */       ChivalryDayInfo.this._xdb_verify_unsafe_();
/*     */       
/* 449 */       ChivalryDayInfo _o_ = ChivalryDayInfo.this;
/* 450 */       Map<Integer, Integer> activitydaysum = new HashMap();
/* 451 */       for (Map.Entry<Integer, Integer> _e_ : _o_.activitydaysum.entrySet())
/* 452 */         activitydaysum.put(_e_.getKey(), _e_.getValue());
/* 453 */       return activitydaysum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastflushtime(long _v_)
/*     */     {
/* 460 */       ChivalryDayInfo.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChivalrydaysum(int _v_)
/*     */     {
/* 468 */       ChivalryDayInfo.this._xdb_verify_unsafe_();
/* 469 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 475 */       ChivalryDayInfo.this._xdb_verify_unsafe_();
/* 476 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 482 */       ChivalryDayInfo.this._xdb_verify_unsafe_();
/* 483 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 489 */       return ChivalryDayInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 495 */       return ChivalryDayInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 501 */       ChivalryDayInfo.this._xdb_verify_unsafe_();
/* 502 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 508 */       return ChivalryDayInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 514 */       return ChivalryDayInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 520 */       ChivalryDayInfo.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 527 */       return ChivalryDayInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 533 */       return ChivalryDayInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 539 */       return ChivalryDayInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 545 */       return ChivalryDayInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 551 */       return ChivalryDayInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 557 */       return ChivalryDayInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 563 */       return ChivalryDayInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ChivalryDayInfo
/*     */   {
/*     */     private long lastflushtime;
/*     */     
/*     */     private int chivalrydaysum;
/*     */     
/*     */     private HashMap<Integer, Integer> activitydaysum;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 579 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 584 */       this.activitydaysum = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.ChivalryDayInfo _o1_)
/*     */     {
/* 589 */       if ((_o1_ instanceof ChivalryDayInfo)) { assign((ChivalryDayInfo)_o1_);
/* 590 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 591 */       } else if ((_o1_ instanceof ChivalryDayInfo.Const)) assign(((ChivalryDayInfo.Const)_o1_).nThis()); else {
/* 592 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ChivalryDayInfo _o_) {
/* 597 */       this.lastflushtime = _o_.lastflushtime;
/* 598 */       this.chivalrydaysum = _o_.chivalrydaysum;
/* 599 */       this.activitydaysum = new HashMap();
/* 600 */       for (Map.Entry<Integer, Integer> _e_ : _o_.activitydaysum.entrySet()) {
/* 601 */         this.activitydaysum.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 606 */       this.lastflushtime = _o_.lastflushtime;
/* 607 */       this.chivalrydaysum = _o_.chivalrydaysum;
/* 608 */       this.activitydaysum = new HashMap();
/* 609 */       for (Map.Entry<Integer, Integer> _e_ : _o_.activitydaysum.entrySet()) {
/* 610 */         this.activitydaysum.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.marshal(this.lastflushtime);
/* 617 */       _os_.marshal(this.chivalrydaysum);
/* 618 */       _os_.compact_uint32(this.activitydaysum.size());
/* 619 */       for (Map.Entry<Integer, Integer> _e_ : this.activitydaysum.entrySet())
/*     */       {
/* 621 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 622 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 624 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 630 */       this.lastflushtime = _os_.unmarshal_long();
/* 631 */       this.chivalrydaysum = _os_.unmarshal_int();
/*     */       
/* 633 */       int size = _os_.uncompact_uint32();
/* 634 */       if (size >= 12)
/*     */       {
/* 636 */         this.activitydaysum = new HashMap(size * 2);
/*     */       }
/* 638 */       for (; size > 0; size--)
/*     */       {
/* 640 */         int _k_ = 0;
/* 641 */         _k_ = _os_.unmarshal_int();
/* 642 */         int _v_ = 0;
/* 643 */         _v_ = _os_.unmarshal_int();
/* 644 */         this.activitydaysum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 647 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 653 */       int _size_ = 0;
/* 654 */       _size_ += CodedOutputStream.computeInt64Size(1, this.lastflushtime);
/* 655 */       _size_ += CodedOutputStream.computeInt32Size(2, this.chivalrydaysum);
/* 656 */       for (Map.Entry<Integer, Integer> _e_ : this.activitydaysum.entrySet())
/*     */       {
/* 658 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 659 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 661 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 669 */         _output_.writeInt64(1, this.lastflushtime);
/* 670 */         _output_.writeInt32(2, this.chivalrydaysum);
/* 671 */         for (Map.Entry<Integer, Integer> _e_ : this.activitydaysum.entrySet())
/*     */         {
/* 673 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 674 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 679 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 681 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 689 */         boolean done = false;
/* 690 */         while (!done)
/*     */         {
/* 692 */           int tag = _input_.readTag();
/* 693 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 697 */             done = true;
/* 698 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 702 */             this.lastflushtime = _input_.readInt64();
/* 703 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 707 */             this.chivalrydaysum = _input_.readInt32();
/* 708 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 712 */             int _k_ = 0;
/* 713 */             _k_ = _input_.readInt32();
/* 714 */             int readTag = _input_.readTag();
/* 715 */             if (24 != readTag)
/*     */             {
/* 717 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 719 */             int _v_ = 0;
/* 720 */             _v_ = _input_.readInt32();
/* 721 */             this.activitydaysum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
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
/*     */     public xbean.ChivalryDayInfo copy()
/*     */     {
/* 749 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChivalryDayInfo toData()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ChivalryDayInfo toBean()
/*     */     {
/* 760 */       return new ChivalryDayInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChivalryDayInfo toDataIf()
/*     */     {
/* 766 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ChivalryDayInfo toBeanIf()
/*     */     {
/* 771 */       return new ChivalryDayInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 777 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
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
/*     */     public xdb.Bean toConst() {
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
/*     */     public long getLastflushtime()
/*     */     {
/* 808 */       return this.lastflushtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getChivalrydaysum()
/*     */     {
/* 815 */       return this.chivalrydaysum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getActivitydaysum()
/*     */     {
/* 822 */       return this.activitydaysum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getActivitydaysumAsData()
/*     */     {
/* 829 */       return this.activitydaysum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastflushtime(long _v_)
/*     */     {
/* 836 */       this.lastflushtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChivalrydaysum(int _v_)
/*     */     {
/* 843 */       this.chivalrydaysum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 849 */       if (!(_o1_ instanceof Data)) return false;
/* 850 */       Data _o_ = (Data)_o1_;
/* 851 */       if (this.lastflushtime != _o_.lastflushtime) return false;
/* 852 */       if (this.chivalrydaysum != _o_.chivalrydaysum) return false;
/* 853 */       if (!this.activitydaysum.equals(_o_.activitydaysum)) return false;
/* 854 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 860 */       int _h_ = 0;
/* 861 */       _h_ = (int)(_h_ + this.lastflushtime);
/* 862 */       _h_ += this.chivalrydaysum;
/* 863 */       _h_ += this.activitydaysum.hashCode();
/* 864 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 870 */       StringBuilder _sb_ = new StringBuilder();
/* 871 */       _sb_.append("(");
/* 872 */       _sb_.append(this.lastflushtime);
/* 873 */       _sb_.append(",");
/* 874 */       _sb_.append(this.chivalrydaysum);
/* 875 */       _sb_.append(",");
/* 876 */       _sb_.append(this.activitydaysum);
/* 877 */       _sb_.append(")");
/* 878 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChivalryDayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
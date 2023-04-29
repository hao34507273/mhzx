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
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class ReportInfo extends XBean implements xbean.ReportInfo
/*     */ {
/*     */   private HashMap<Long, xbean.ReportRecord> report_records;
/*     */   private long report_timestamp;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.report_records.clear();
/*  21 */     this.report_timestamp = 0L;
/*     */   }
/*     */   
/*     */   ReportInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.report_records = new HashMap();
/*     */   }
/*     */   
/*     */   public ReportInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ReportInfo(ReportInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ReportInfo(xbean.ReportInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof ReportInfo)) { assign((ReportInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ReportInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.report_records = new HashMap();
/*  53 */     for (Map.Entry<Long, xbean.ReportRecord> _e_ : _o_.report_records.entrySet())
/*  54 */       this.report_records.put(_e_.getKey(), new ReportRecord((xbean.ReportRecord)_e_.getValue(), this, "report_records"));
/*  55 */     this.report_timestamp = _o_.report_timestamp;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.report_records = new HashMap();
/*  61 */     for (Map.Entry<Long, xbean.ReportRecord> _e_ : _o_.report_records.entrySet())
/*  62 */       this.report_records.put(_e_.getKey(), new ReportRecord((xbean.ReportRecord)_e_.getValue(), this, "report_records"));
/*  63 */     this.report_timestamp = _o_.report_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.compact_uint32(this.report_records.size());
/*  71 */     for (Map.Entry<Long, xbean.ReportRecord> _e_ : this.report_records.entrySet())
/*     */     {
/*  73 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  74 */       ((xbean.ReportRecord)_e_.getValue()).marshal(_os_);
/*     */     }
/*  76 */     _os_.marshal(this.report_timestamp);
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*     */     
/*  85 */     int size = _os_.uncompact_uint32();
/*  86 */     if (size >= 12)
/*     */     {
/*  88 */       this.report_records = new HashMap(size * 2);
/*     */     }
/*  90 */     for (; size > 0; size--)
/*     */     {
/*  92 */       long _k_ = 0L;
/*  93 */       _k_ = _os_.unmarshal_long();
/*  94 */       xbean.ReportRecord _v_ = new ReportRecord(0, this, "report_records");
/*  95 */       _v_.unmarshal(_os_);
/*  96 */       this.report_records.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*  99 */     this.report_timestamp = _os_.unmarshal_long();
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     for (Map.Entry<Long, xbean.ReportRecord> _e_ : this.report_records.entrySet())
/*     */     {
/* 110 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 111 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 113 */     _size_ += CodedOutputStream.computeInt64Size(2, this.report_timestamp);
/* 114 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       for (Map.Entry<Long, xbean.ReportRecord> _e_ : this.report_records.entrySet())
/*     */       {
/* 125 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 126 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 128 */       _output_.writeInt64(2, this.report_timestamp);
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
/* 156 */           long _k_ = 0L;
/* 157 */           _k_ = _input_.readInt64();
/* 158 */           int readTag = _input_.readTag();
/* 159 */           if (10 != readTag)
/*     */           {
/* 161 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 163 */           xbean.ReportRecord _v_ = new ReportRecord(0, this, "report_records");
/* 164 */           _input_.readMessage(_v_);
/* 165 */           this.report_records.put(Long.valueOf(_k_), _v_);
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this.report_timestamp = _input_.readInt64();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 175 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 177 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 186 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 190 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 192 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ReportInfo copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new ReportInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ReportInfo toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ReportInfo toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new ReportInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ReportInfo toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ReportInfo toBeanIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.ReportRecord> getReport_records()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return xdb.Logs.logMap(new xdb.LogKey(this, "report_records"), this.report_records);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.ReportRecord> getReport_recordsAsData()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/*     */     
/* 249 */     ReportInfo _o_ = this;
/* 250 */     Map<Long, xbean.ReportRecord> report_records = new HashMap();
/* 251 */     for (Map.Entry<Long, xbean.ReportRecord> _e_ : _o_.report_records.entrySet())
/* 252 */       report_records.put(_e_.getKey(), new ReportRecord.Data((xbean.ReportRecord)_e_.getValue()));
/* 253 */     return report_records;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getReport_timestamp()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return this.report_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReport_timestamp(long _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "report_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogLong(this, ReportInfo.this.report_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             ReportInfo.this.report_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.report_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     ReportInfo _o_ = null;
/* 290 */     if ((_o1_ instanceof ReportInfo)) { _o_ = (ReportInfo)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (!this.report_records.equals(_o_.report_records)) return false;
/* 294 */     if (this.report_timestamp != _o_.report_timestamp) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ += this.report_records.hashCode();
/* 304 */     _h_ = (int)(_h_ + this.report_timestamp);
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.report_records);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.report_timestamp);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableMap().setVarName("report_records"));
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("report_timestamp"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ReportInfo {
/*     */     private Const() {}
/*     */     
/*     */     ReportInfo nThis() {
/* 334 */       return ReportInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ReportInfo copy()
/*     */     {
/* 346 */       return ReportInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ReportInfo toData()
/*     */     {
/* 352 */       return ReportInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ReportInfo toBean()
/*     */     {
/* 357 */       return ReportInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ReportInfo toDataIf()
/*     */     {
/* 363 */       return ReportInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ReportInfo toBeanIf()
/*     */     {
/* 368 */       return ReportInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.ReportRecord> getReport_records()
/*     */     {
/* 375 */       ReportInfo.this._xdb_verify_unsafe_();
/* 376 */       return xdb.Consts.constMap(ReportInfo.this.report_records);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.ReportRecord> getReport_recordsAsData()
/*     */     {
/* 383 */       ReportInfo.this._xdb_verify_unsafe_();
/*     */       
/* 385 */       ReportInfo _o_ = ReportInfo.this;
/* 386 */       Map<Long, xbean.ReportRecord> report_records = new HashMap();
/* 387 */       for (Map.Entry<Long, xbean.ReportRecord> _e_ : _o_.report_records.entrySet())
/* 388 */         report_records.put(_e_.getKey(), new ReportRecord.Data((xbean.ReportRecord)_e_.getValue()));
/* 389 */       return report_records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getReport_timestamp()
/*     */     {
/* 396 */       ReportInfo.this._xdb_verify_unsafe_();
/* 397 */       return ReportInfo.this.report_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReport_timestamp(long _v_)
/*     */     {
/* 404 */       ReportInfo.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       ReportInfo.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       ReportInfo.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return ReportInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return ReportInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       ReportInfo.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return ReportInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return ReportInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       ReportInfo.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return ReportInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return ReportInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return ReportInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return ReportInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return ReportInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return ReportInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return ReportInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ReportInfo
/*     */   {
/*     */     private HashMap<Long, xbean.ReportRecord> report_records;
/*     */     
/*     */     private long report_timestamp;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.report_records = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.ReportInfo _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof ReportInfo)) { assign((ReportInfo)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof ReportInfo.Const)) assign(((ReportInfo.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ReportInfo _o_) {
/* 531 */       this.report_records = new HashMap();
/* 532 */       for (Map.Entry<Long, xbean.ReportRecord> _e_ : _o_.report_records.entrySet())
/* 533 */         this.report_records.put(_e_.getKey(), new ReportRecord.Data((xbean.ReportRecord)_e_.getValue()));
/* 534 */       this.report_timestamp = _o_.report_timestamp;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 539 */       this.report_records = new HashMap();
/* 540 */       for (Map.Entry<Long, xbean.ReportRecord> _e_ : _o_.report_records.entrySet())
/* 541 */         this.report_records.put(_e_.getKey(), new ReportRecord.Data((xbean.ReportRecord)_e_.getValue()));
/* 542 */       this.report_timestamp = _o_.report_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.compact_uint32(this.report_records.size());
/* 549 */       for (Map.Entry<Long, xbean.ReportRecord> _e_ : this.report_records.entrySet())
/*     */       {
/* 551 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 552 */         ((xbean.ReportRecord)_e_.getValue()).marshal(_os_);
/*     */       }
/* 554 */       _os_.marshal(this.report_timestamp);
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 562 */       int size = _os_.uncompact_uint32();
/* 563 */       if (size >= 12)
/*     */       {
/* 565 */         this.report_records = new HashMap(size * 2);
/*     */       }
/* 567 */       for (; size > 0; size--)
/*     */       {
/* 569 */         long _k_ = 0L;
/* 570 */         _k_ = _os_.unmarshal_long();
/* 571 */         xbean.ReportRecord _v_ = xbean.Pod.newReportRecordData();
/* 572 */         _v_.unmarshal(_os_);
/* 573 */         this.report_records.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 576 */       this.report_timestamp = _os_.unmarshal_long();
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       for (Map.Entry<Long, xbean.ReportRecord> _e_ : this.report_records.entrySet())
/*     */       {
/* 586 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 587 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 589 */       _size_ += CodedOutputStream.computeInt64Size(2, this.report_timestamp);
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         for (Map.Entry<Long, xbean.ReportRecord> _e_ : this.report_records.entrySet())
/*     */         {
/* 600 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 601 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 603 */         _output_.writeInt64(2, this.report_timestamp);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 607 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 609 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 617 */         boolean done = false;
/* 618 */         while (!done)
/*     */         {
/* 620 */           int tag = _input_.readTag();
/* 621 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 625 */             done = true;
/* 626 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 630 */             long _k_ = 0L;
/* 631 */             _k_ = _input_.readInt64();
/* 632 */             int readTag = _input_.readTag();
/* 633 */             if (10 != readTag)
/*     */             {
/* 635 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 637 */             xbean.ReportRecord _v_ = xbean.Pod.newReportRecordData();
/* 638 */             _input_.readMessage(_v_);
/* 639 */             this.report_records.put(Long.valueOf(_k_), _v_);
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 644 */             this.report_timestamp = _input_.readInt64();
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ReportInfo copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ReportInfo toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ReportInfo toBean()
/*     */     {
/* 683 */       return new ReportInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ReportInfo toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ReportInfo toBeanIf()
/*     */     {
/* 694 */       return new ReportInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.ReportRecord> getReport_records()
/*     */     {
/* 731 */       return this.report_records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.ReportRecord> getReport_recordsAsData()
/*     */     {
/* 738 */       return this.report_records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getReport_timestamp()
/*     */     {
/* 745 */       return this.report_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReport_timestamp(long _v_)
/*     */     {
/* 752 */       this.report_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (!this.report_records.equals(_o_.report_records)) return false;
/* 761 */       if (this.report_timestamp != _o_.report_timestamp) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ += this.report_records.hashCode();
/* 770 */       _h_ = (int)(_h_ + this.report_timestamp);
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.report_records);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.report_timestamp);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ReportInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
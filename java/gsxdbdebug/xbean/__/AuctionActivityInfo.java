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
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class AuctionActivityInfo extends XBean implements xbean.AuctionActivityInfo
/*     */ {
/*     */   private xbean.AuctionPeriodInfo lastperiodinfo;
/*     */   private xbean.AuctionPeriodInfo currentperiodinfo;
/*     */   private HashMap<Long, xbean.AuctionMergeInfo> roleid2mergeinfo;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.lastperiodinfo._reset_unsafe_();
/*  23 */     this.currentperiodinfo._reset_unsafe_();
/*  24 */     this.roleid2mergeinfo.clear();
/*     */   }
/*     */   
/*     */   AuctionActivityInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.lastperiodinfo = new AuctionPeriodInfo(0, this, "lastperiodinfo");
/*  31 */     this.currentperiodinfo = new AuctionPeriodInfo(0, this, "currentperiodinfo");
/*  32 */     this.roleid2mergeinfo = new HashMap();
/*     */   }
/*     */   
/*     */   public AuctionActivityInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public AuctionActivityInfo(AuctionActivityInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   AuctionActivityInfo(xbean.AuctionActivityInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof AuctionActivityInfo)) { assign((AuctionActivityInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(AuctionActivityInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.lastperiodinfo = new AuctionPeriodInfo(_o_.lastperiodinfo, this, "lastperiodinfo");
/*  58 */     this.currentperiodinfo = new AuctionPeriodInfo(_o_.currentperiodinfo, this, "currentperiodinfo");
/*  59 */     this.roleid2mergeinfo = new HashMap();
/*  60 */     for (Map.Entry<Long, xbean.AuctionMergeInfo> _e_ : _o_.roleid2mergeinfo.entrySet()) {
/*  61 */       this.roleid2mergeinfo.put(_e_.getKey(), new AuctionMergeInfo((xbean.AuctionMergeInfo)_e_.getValue(), this, "roleid2mergeinfo"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  66 */     this.lastperiodinfo = new AuctionPeriodInfo(_o_.lastperiodinfo, this, "lastperiodinfo");
/*  67 */     this.currentperiodinfo = new AuctionPeriodInfo(_o_.currentperiodinfo, this, "currentperiodinfo");
/*  68 */     this.roleid2mergeinfo = new HashMap();
/*  69 */     for (Map.Entry<Long, xbean.AuctionMergeInfo> _e_ : _o_.roleid2mergeinfo.entrySet()) {
/*  70 */       this.roleid2mergeinfo.put(_e_.getKey(), new AuctionMergeInfo((xbean.AuctionMergeInfo)_e_.getValue(), this, "roleid2mergeinfo"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     this.lastperiodinfo.marshal(_os_);
/*  78 */     this.currentperiodinfo.marshal(_os_);
/*  79 */     _os_.compact_uint32(this.roleid2mergeinfo.size());
/*  80 */     for (Map.Entry<Long, xbean.AuctionMergeInfo> _e_ : this.roleid2mergeinfo.entrySet())
/*     */     {
/*  82 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  83 */       ((xbean.AuctionMergeInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     this.lastperiodinfo.unmarshal(_os_);
/*  93 */     this.currentperiodinfo.unmarshal(_os_);
/*     */     
/*  95 */     int size = _os_.uncompact_uint32();
/*  96 */     if (size >= 12)
/*     */     {
/*  98 */       this.roleid2mergeinfo = new HashMap(size * 2);
/*     */     }
/* 100 */     for (; size > 0; size--)
/*     */     {
/* 102 */       long _k_ = 0L;
/* 103 */       _k_ = _os_.unmarshal_long();
/* 104 */       xbean.AuctionMergeInfo _v_ = new AuctionMergeInfo(0, this, "roleid2mergeinfo");
/* 105 */       _v_.unmarshal(_os_);
/* 106 */       this.roleid2mergeinfo.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 115 */     _xdb_verify_unsafe_();
/* 116 */     int _size_ = 0;
/* 117 */     _size_ += CodedOutputStream.computeMessageSize(1, this.lastperiodinfo);
/* 118 */     _size_ += CodedOutputStream.computeMessageSize(2, this.currentperiodinfo);
/* 119 */     for (Map.Entry<Long, xbean.AuctionMergeInfo> _e_ : this.roleid2mergeinfo.entrySet())
/*     */     {
/* 121 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 122 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */     }
/* 124 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 133 */       _output_.writeMessage(1, this.lastperiodinfo);
/* 134 */       _output_.writeMessage(2, this.currentperiodinfo);
/* 135 */       for (Map.Entry<Long, xbean.AuctionMergeInfo> _e_ : this.roleid2mergeinfo.entrySet())
/*     */       {
/* 137 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 138 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 143 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 145 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 151 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 154 */       boolean done = false;
/* 155 */       while (!done)
/*     */       {
/* 157 */         int tag = _input_.readTag();
/* 158 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 162 */           done = true;
/* 163 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 167 */           _input_.readMessage(this.lastperiodinfo);
/* 168 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 172 */           _input_.readMessage(this.currentperiodinfo);
/* 173 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 177 */           long _k_ = 0L;
/* 178 */           _k_ = _input_.readInt64();
/* 179 */           int readTag = _input_.readTag();
/* 180 */           if (26 != readTag)
/*     */           {
/* 182 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 184 */           xbean.AuctionMergeInfo _v_ = new AuctionMergeInfo(0, this, "roleid2mergeinfo");
/* 185 */           _input_.readMessage(_v_);
/* 186 */           this.roleid2mergeinfo.put(Long.valueOf(_k_), _v_);
/* 187 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 191 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 193 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 202 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 206 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 208 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AuctionActivityInfo copy()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return new AuctionActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AuctionActivityInfo toData()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AuctionActivityInfo toBean()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new AuctionActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AuctionActivityInfo toDataIf()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AuctionActivityInfo toBeanIf()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.AuctionPeriodInfo getLastperiodinfo()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     return this.lastperiodinfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.AuctionPeriodInfo getCurrentperiodinfo()
/*     */   {
/* 263 */     _xdb_verify_unsafe_();
/* 264 */     return this.currentperiodinfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.AuctionMergeInfo> getRoleid2mergeinfo()
/*     */   {
/* 271 */     _xdb_verify_unsafe_();
/* 272 */     return xdb.Logs.logMap(new xdb.LogKey(this, "roleid2mergeinfo"), this.roleid2mergeinfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.AuctionMergeInfo> getRoleid2mergeinfoAsData()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/*     */     
/* 281 */     AuctionActivityInfo _o_ = this;
/* 282 */     Map<Long, xbean.AuctionMergeInfo> roleid2mergeinfo = new HashMap();
/* 283 */     for (Map.Entry<Long, xbean.AuctionMergeInfo> _e_ : _o_.roleid2mergeinfo.entrySet())
/* 284 */       roleid2mergeinfo.put(_e_.getKey(), new AuctionMergeInfo.Data((xbean.AuctionMergeInfo)_e_.getValue()));
/* 285 */     return roleid2mergeinfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     AuctionActivityInfo _o_ = null;
/* 293 */     if ((_o1_ instanceof AuctionActivityInfo)) { _o_ = (AuctionActivityInfo)_o1_;
/* 294 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 295 */       return false;
/* 296 */     if (!this.lastperiodinfo.equals(_o_.lastperiodinfo)) return false;
/* 297 */     if (!this.currentperiodinfo.equals(_o_.currentperiodinfo)) return false;
/* 298 */     if (!this.roleid2mergeinfo.equals(_o_.roleid2mergeinfo)) return false;
/* 299 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 305 */     _xdb_verify_unsafe_();
/* 306 */     int _h_ = 0;
/* 307 */     _h_ += this.lastperiodinfo.hashCode();
/* 308 */     _h_ += this.currentperiodinfo.hashCode();
/* 309 */     _h_ += this.roleid2mergeinfo.hashCode();
/* 310 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 316 */     _xdb_verify_unsafe_();
/* 317 */     StringBuilder _sb_ = new StringBuilder();
/* 318 */     _sb_.append("(");
/* 319 */     _sb_.append(this.lastperiodinfo);
/* 320 */     _sb_.append(",");
/* 321 */     _sb_.append(this.currentperiodinfo);
/* 322 */     _sb_.append(",");
/* 323 */     _sb_.append(this.roleid2mergeinfo);
/* 324 */     _sb_.append(")");
/* 325 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 331 */     ListenableBean lb = new ListenableBean();
/* 332 */     lb.add(new xdb.logs.ListenableChanged().setVarName("lastperiodinfo"));
/* 333 */     lb.add(new xdb.logs.ListenableChanged().setVarName("currentperiodinfo"));
/* 334 */     lb.add(new xdb.logs.ListenableMap().setVarName("roleid2mergeinfo"));
/* 335 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.AuctionActivityInfo {
/*     */     private Const() {}
/*     */     
/*     */     AuctionActivityInfo nThis() {
/* 342 */       return AuctionActivityInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 348 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionActivityInfo copy()
/*     */     {
/* 354 */       return AuctionActivityInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionActivityInfo toData()
/*     */     {
/* 360 */       return AuctionActivityInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.AuctionActivityInfo toBean()
/*     */     {
/* 365 */       return AuctionActivityInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionActivityInfo toDataIf()
/*     */     {
/* 371 */       return AuctionActivityInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.AuctionActivityInfo toBeanIf()
/*     */     {
/* 376 */       return AuctionActivityInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.AuctionPeriodInfo getLastperiodinfo()
/*     */     {
/* 383 */       AuctionActivityInfo.this._xdb_verify_unsafe_();
/* 384 */       return (xbean.AuctionPeriodInfo)xdb.Consts.toConst(AuctionActivityInfo.this.lastperiodinfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.AuctionPeriodInfo getCurrentperiodinfo()
/*     */     {
/* 391 */       AuctionActivityInfo.this._xdb_verify_unsafe_();
/* 392 */       return (xbean.AuctionPeriodInfo)xdb.Consts.toConst(AuctionActivityInfo.this.currentperiodinfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.AuctionMergeInfo> getRoleid2mergeinfo()
/*     */     {
/* 399 */       AuctionActivityInfo.this._xdb_verify_unsafe_();
/* 400 */       return xdb.Consts.constMap(AuctionActivityInfo.this.roleid2mergeinfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.AuctionMergeInfo> getRoleid2mergeinfoAsData()
/*     */     {
/* 407 */       AuctionActivityInfo.this._xdb_verify_unsafe_();
/*     */       
/* 409 */       AuctionActivityInfo _o_ = AuctionActivityInfo.this;
/* 410 */       Map<Long, xbean.AuctionMergeInfo> roleid2mergeinfo = new HashMap();
/* 411 */       for (Map.Entry<Long, xbean.AuctionMergeInfo> _e_ : _o_.roleid2mergeinfo.entrySet())
/* 412 */         roleid2mergeinfo.put(_e_.getKey(), new AuctionMergeInfo.Data((xbean.AuctionMergeInfo)_e_.getValue()));
/* 413 */       return roleid2mergeinfo;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 419 */       AuctionActivityInfo.this._xdb_verify_unsafe_();
/* 420 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 426 */       AuctionActivityInfo.this._xdb_verify_unsafe_();
/* 427 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 433 */       return AuctionActivityInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 439 */       return AuctionActivityInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 445 */       AuctionActivityInfo.this._xdb_verify_unsafe_();
/* 446 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 452 */       return AuctionActivityInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 458 */       return AuctionActivityInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 464 */       AuctionActivityInfo.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 471 */       return AuctionActivityInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 477 */       return AuctionActivityInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 483 */       return AuctionActivityInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 489 */       return AuctionActivityInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 495 */       return AuctionActivityInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 501 */       return AuctionActivityInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 507 */       return AuctionActivityInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.AuctionActivityInfo
/*     */   {
/*     */     private xbean.AuctionPeriodInfo lastperiodinfo;
/*     */     
/*     */     private xbean.AuctionPeriodInfo currentperiodinfo;
/*     */     
/*     */     private HashMap<Long, xbean.AuctionMergeInfo> roleid2mergeinfo;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 523 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 528 */       this.lastperiodinfo = new AuctionPeriodInfo.Data();
/* 529 */       this.currentperiodinfo = new AuctionPeriodInfo.Data();
/* 530 */       this.roleid2mergeinfo = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.AuctionActivityInfo _o1_)
/*     */     {
/* 535 */       if ((_o1_ instanceof AuctionActivityInfo)) { assign((AuctionActivityInfo)_o1_);
/* 536 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 537 */       } else if ((_o1_ instanceof AuctionActivityInfo.Const)) assign(((AuctionActivityInfo.Const)_o1_).nThis()); else {
/* 538 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(AuctionActivityInfo _o_) {
/* 543 */       this.lastperiodinfo = new AuctionPeriodInfo.Data(_o_.lastperiodinfo);
/* 544 */       this.currentperiodinfo = new AuctionPeriodInfo.Data(_o_.currentperiodinfo);
/* 545 */       this.roleid2mergeinfo = new HashMap();
/* 546 */       for (Map.Entry<Long, xbean.AuctionMergeInfo> _e_ : _o_.roleid2mergeinfo.entrySet()) {
/* 547 */         this.roleid2mergeinfo.put(_e_.getKey(), new AuctionMergeInfo.Data((xbean.AuctionMergeInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 552 */       this.lastperiodinfo = new AuctionPeriodInfo.Data(_o_.lastperiodinfo);
/* 553 */       this.currentperiodinfo = new AuctionPeriodInfo.Data(_o_.currentperiodinfo);
/* 554 */       this.roleid2mergeinfo = new HashMap();
/* 555 */       for (Map.Entry<Long, xbean.AuctionMergeInfo> _e_ : _o_.roleid2mergeinfo.entrySet()) {
/* 556 */         this.roleid2mergeinfo.put(_e_.getKey(), new AuctionMergeInfo.Data((xbean.AuctionMergeInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 562 */       this.lastperiodinfo.marshal(_os_);
/* 563 */       this.currentperiodinfo.marshal(_os_);
/* 564 */       _os_.compact_uint32(this.roleid2mergeinfo.size());
/* 565 */       for (Map.Entry<Long, xbean.AuctionMergeInfo> _e_ : this.roleid2mergeinfo.entrySet())
/*     */       {
/* 567 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 568 */         ((xbean.AuctionMergeInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 570 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 576 */       this.lastperiodinfo.unmarshal(_os_);
/* 577 */       this.currentperiodinfo.unmarshal(_os_);
/*     */       
/* 579 */       int size = _os_.uncompact_uint32();
/* 580 */       if (size >= 12)
/*     */       {
/* 582 */         this.roleid2mergeinfo = new HashMap(size * 2);
/*     */       }
/* 584 */       for (; size > 0; size--)
/*     */       {
/* 586 */         long _k_ = 0L;
/* 587 */         _k_ = _os_.unmarshal_long();
/* 588 */         xbean.AuctionMergeInfo _v_ = xbean.Pod.newAuctionMergeInfoData();
/* 589 */         _v_.unmarshal(_os_);
/* 590 */         this.roleid2mergeinfo.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 593 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 599 */       int _size_ = 0;
/* 600 */       _size_ += CodedOutputStream.computeMessageSize(1, this.lastperiodinfo);
/* 601 */       _size_ += CodedOutputStream.computeMessageSize(2, this.currentperiodinfo);
/* 602 */       for (Map.Entry<Long, xbean.AuctionMergeInfo> _e_ : this.roleid2mergeinfo.entrySet())
/*     */       {
/* 604 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 605 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */       }
/* 607 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 615 */         _output_.writeMessage(1, this.lastperiodinfo);
/* 616 */         _output_.writeMessage(2, this.currentperiodinfo);
/* 617 */         for (Map.Entry<Long, xbean.AuctionMergeInfo> _e_ : this.roleid2mergeinfo.entrySet())
/*     */         {
/* 619 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 620 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 625 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 627 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 635 */         boolean done = false;
/* 636 */         while (!done)
/*     */         {
/* 638 */           int tag = _input_.readTag();
/* 639 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 643 */             done = true;
/* 644 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 648 */             _input_.readMessage(this.lastperiodinfo);
/* 649 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 653 */             _input_.readMessage(this.currentperiodinfo);
/* 654 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 658 */             long _k_ = 0L;
/* 659 */             _k_ = _input_.readInt64();
/* 660 */             int readTag = _input_.readTag();
/* 661 */             if (26 != readTag)
/*     */             {
/* 663 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 665 */             xbean.AuctionMergeInfo _v_ = xbean.Pod.newAuctionMergeInfoData();
/* 666 */             _input_.readMessage(_v_);
/* 667 */             this.roleid2mergeinfo.put(Long.valueOf(_k_), _v_);
/* 668 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 672 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 674 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 683 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 687 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 689 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionActivityInfo copy()
/*     */     {
/* 695 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionActivityInfo toData()
/*     */     {
/* 701 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.AuctionActivityInfo toBean()
/*     */     {
/* 706 */       return new AuctionActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionActivityInfo toDataIf()
/*     */     {
/* 712 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.AuctionActivityInfo toBeanIf()
/*     */     {
/* 717 */       return new AuctionActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 723 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 727 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 731 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 735 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 739 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 743 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 747 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.AuctionPeriodInfo getLastperiodinfo()
/*     */     {
/* 754 */       return this.lastperiodinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.AuctionPeriodInfo getCurrentperiodinfo()
/*     */     {
/* 761 */       return this.currentperiodinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.AuctionMergeInfo> getRoleid2mergeinfo()
/*     */     {
/* 768 */       return this.roleid2mergeinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.AuctionMergeInfo> getRoleid2mergeinfoAsData()
/*     */     {
/* 775 */       return this.roleid2mergeinfo;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 781 */       if (!(_o1_ instanceof Data)) return false;
/* 782 */       Data _o_ = (Data)_o1_;
/* 783 */       if (!this.lastperiodinfo.equals(_o_.lastperiodinfo)) return false;
/* 784 */       if (!this.currentperiodinfo.equals(_o_.currentperiodinfo)) return false;
/* 785 */       if (!this.roleid2mergeinfo.equals(_o_.roleid2mergeinfo)) return false;
/* 786 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 792 */       int _h_ = 0;
/* 793 */       _h_ += this.lastperiodinfo.hashCode();
/* 794 */       _h_ += this.currentperiodinfo.hashCode();
/* 795 */       _h_ += this.roleid2mergeinfo.hashCode();
/* 796 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 802 */       StringBuilder _sb_ = new StringBuilder();
/* 803 */       _sb_.append("(");
/* 804 */       _sb_.append(this.lastperiodinfo);
/* 805 */       _sb_.append(",");
/* 806 */       _sb_.append(this.currentperiodinfo);
/* 807 */       _sb_.append(",");
/* 808 */       _sb_.append(this.roleid2mergeinfo);
/* 809 */       _sb_.append(")");
/* 810 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AuctionActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
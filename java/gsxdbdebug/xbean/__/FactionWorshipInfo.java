/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ 
/*     */ public final class FactionWorshipInfo extends xdb.XBean implements xbean.FactionWorshipInfo
/*     */ {
/*     */   private HashMap<Integer, Integer> worshipdata;
/*     */   private ArrayList<xbean.SingleWorshipInfo> worshiprecord;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.worshipdata.clear();
/*  21 */     this.worshiprecord.clear();
/*     */   }
/*     */   
/*     */   FactionWorshipInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.worshipdata = new HashMap();
/*  28 */     this.worshiprecord = new ArrayList();
/*     */   }
/*     */   
/*     */   public FactionWorshipInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FactionWorshipInfo(FactionWorshipInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FactionWorshipInfo(xbean.FactionWorshipInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof FactionWorshipInfo)) { assign((FactionWorshipInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FactionWorshipInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.worshipdata = new HashMap();
/*  54 */     for (Map.Entry<Integer, Integer> _e_ : _o_.worshipdata.entrySet())
/*  55 */       this.worshipdata.put(_e_.getKey(), _e_.getValue());
/*  56 */     this.worshiprecord = new ArrayList();
/*  57 */     for (xbean.SingleWorshipInfo _v_ : _o_.worshiprecord) {
/*  58 */       this.worshiprecord.add(new SingleWorshipInfo(_v_, this, "worshiprecord"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  63 */     this.worshipdata = new HashMap();
/*  64 */     for (Map.Entry<Integer, Integer> _e_ : _o_.worshipdata.entrySet())
/*  65 */       this.worshipdata.put(_e_.getKey(), _e_.getValue());
/*  66 */     this.worshiprecord = new ArrayList();
/*  67 */     for (xbean.SingleWorshipInfo _v_ : _o_.worshiprecord) {
/*  68 */       this.worshiprecord.add(new SingleWorshipInfo(_v_, this, "worshiprecord"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.worshipdata.size());
/*  76 */     for (Map.Entry<Integer, Integer> _e_ : this.worshipdata.entrySet())
/*     */     {
/*  78 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  79 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  81 */     _os_.compact_uint32(this.worshiprecord.size());
/*  82 */     for (xbean.SingleWorshipInfo _v_ : this.worshiprecord)
/*     */     {
/*  84 */       _v_.marshal(_os_);
/*     */     }
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     
/*  94 */     int size = _os_.uncompact_uint32();
/*  95 */     if (size >= 12)
/*     */     {
/*  97 */       this.worshipdata = new HashMap(size * 2);
/*     */     }
/*  99 */     for (; size > 0; size--)
/*     */     {
/* 101 */       int _k_ = 0;
/* 102 */       _k_ = _os_.unmarshal_int();
/* 103 */       int _v_ = 0;
/* 104 */       _v_ = _os_.unmarshal_int();
/* 105 */       this.worshipdata.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 108 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 110 */       xbean.SingleWorshipInfo _v_ = new SingleWorshipInfo(0, this, "worshiprecord");
/* 111 */       _v_.unmarshal(_os_);
/* 112 */       this.worshiprecord.add(_v_);
/*     */     }
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     int _size_ = 0;
/* 122 */     for (Map.Entry<Integer, Integer> _e_ : this.worshipdata.entrySet())
/*     */     {
/* 124 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 125 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 127 */     for (xbean.SingleWorshipInfo _v_ : this.worshiprecord)
/*     */     {
/* 129 */       _size_ += CodedOutputStream.computeMessageSize(2, _v_);
/*     */     }
/* 131 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 140 */       for (Map.Entry<Integer, Integer> _e_ : this.worshipdata.entrySet())
/*     */       {
/* 142 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 143 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 145 */       for (xbean.SingleWorshipInfo _v_ : this.worshiprecord)
/*     */       {
/* 147 */         _output_.writeMessage(2, _v_);
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 152 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 154 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 160 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 163 */       boolean done = false;
/* 164 */       while (!done)
/*     */       {
/* 166 */         int tag = _input_.readTag();
/* 167 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 171 */           done = true;
/* 172 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 176 */           int _k_ = 0;
/* 177 */           _k_ = _input_.readInt32();
/* 178 */           int readTag = _input_.readTag();
/* 179 */           if (8 != readTag)
/*     */           {
/* 181 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 183 */           int _v_ = 0;
/* 184 */           _v_ = _input_.readInt32();
/* 185 */           this.worshipdata.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 186 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 190 */           xbean.SingleWorshipInfo _v_ = new SingleWorshipInfo(0, this, "worshiprecord");
/* 191 */           _input_.readMessage(_v_);
/* 192 */           this.worshiprecord.add(_v_);
/* 193 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 197 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 199 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 208 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 212 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 214 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FactionWorshipInfo copy()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new FactionWorshipInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FactionWorshipInfo toData()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FactionWorshipInfo toBean()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new FactionWorshipInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FactionWorshipInfo toDataIf()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FactionWorshipInfo toBeanIf()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getWorshipdata()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return xdb.Logs.logMap(new xdb.LogKey(this, "worshipdata"), this.worshipdata);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getWorshipdataAsData()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/*     */     
/* 271 */     FactionWorshipInfo _o_ = this;
/* 272 */     Map<Integer, Integer> worshipdata = new HashMap();
/* 273 */     for (Map.Entry<Integer, Integer> _e_ : _o_.worshipdata.entrySet())
/* 274 */       worshipdata.put(_e_.getKey(), _e_.getValue());
/* 275 */     return worshipdata;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.SingleWorshipInfo> getWorshiprecord()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/* 283 */     return xdb.Logs.logList(new xdb.LogKey(this, "worshiprecord"), this.worshiprecord);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.SingleWorshipInfo> getWorshiprecordAsData()
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/*     */     
/* 291 */     FactionWorshipInfo _o_ = this;
/* 292 */     List<xbean.SingleWorshipInfo> worshiprecord = new ArrayList();
/* 293 */     for (xbean.SingleWorshipInfo _v_ : _o_.worshiprecord)
/* 294 */       worshiprecord.add(new SingleWorshipInfo.Data(_v_));
/* 295 */     return worshiprecord;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     FactionWorshipInfo _o_ = null;
/* 303 */     if ((_o1_ instanceof FactionWorshipInfo)) { _o_ = (FactionWorshipInfo)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (!this.worshipdata.equals(_o_.worshipdata)) return false;
/* 307 */     if (!this.worshiprecord.equals(_o_.worshiprecord)) return false;
/* 308 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 314 */     _xdb_verify_unsafe_();
/* 315 */     int _h_ = 0;
/* 316 */     _h_ += this.worshipdata.hashCode();
/* 317 */     _h_ += this.worshiprecord.hashCode();
/* 318 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     StringBuilder _sb_ = new StringBuilder();
/* 326 */     _sb_.append("(");
/* 327 */     _sb_.append(this.worshipdata);
/* 328 */     _sb_.append(",");
/* 329 */     _sb_.append(this.worshiprecord);
/* 330 */     _sb_.append(")");
/* 331 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 337 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 338 */     lb.add(new xdb.logs.ListenableMap().setVarName("worshipdata"));
/* 339 */     lb.add(new xdb.logs.ListenableChanged().setVarName("worshiprecord"));
/* 340 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FactionWorshipInfo {
/*     */     private Const() {}
/*     */     
/*     */     FactionWorshipInfo nThis() {
/* 347 */       return FactionWorshipInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 353 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionWorshipInfo copy()
/*     */     {
/* 359 */       return FactionWorshipInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionWorshipInfo toData()
/*     */     {
/* 365 */       return FactionWorshipInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FactionWorshipInfo toBean()
/*     */     {
/* 370 */       return FactionWorshipInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionWorshipInfo toDataIf()
/*     */     {
/* 376 */       return FactionWorshipInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FactionWorshipInfo toBeanIf()
/*     */     {
/* 381 */       return FactionWorshipInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getWorshipdata()
/*     */     {
/* 388 */       FactionWorshipInfo.this._xdb_verify_unsafe_();
/* 389 */       return xdb.Consts.constMap(FactionWorshipInfo.this.worshipdata);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getWorshipdataAsData()
/*     */     {
/* 396 */       FactionWorshipInfo.this._xdb_verify_unsafe_();
/*     */       
/* 398 */       FactionWorshipInfo _o_ = FactionWorshipInfo.this;
/* 399 */       Map<Integer, Integer> worshipdata = new HashMap();
/* 400 */       for (Map.Entry<Integer, Integer> _e_ : _o_.worshipdata.entrySet())
/* 401 */         worshipdata.put(_e_.getKey(), _e_.getValue());
/* 402 */       return worshipdata;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SingleWorshipInfo> getWorshiprecord()
/*     */     {
/* 409 */       FactionWorshipInfo.this._xdb_verify_unsafe_();
/* 410 */       return xdb.Consts.constList(FactionWorshipInfo.this.worshiprecord);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.SingleWorshipInfo> getWorshiprecordAsData()
/*     */     {
/* 416 */       FactionWorshipInfo.this._xdb_verify_unsafe_();
/*     */       
/* 418 */       FactionWorshipInfo _o_ = FactionWorshipInfo.this;
/* 419 */       List<xbean.SingleWorshipInfo> worshiprecord = new ArrayList();
/* 420 */       for (xbean.SingleWorshipInfo _v_ : _o_.worshiprecord)
/* 421 */         worshiprecord.add(new SingleWorshipInfo.Data(_v_));
/* 422 */       return worshiprecord;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 428 */       FactionWorshipInfo.this._xdb_verify_unsafe_();
/* 429 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 435 */       FactionWorshipInfo.this._xdb_verify_unsafe_();
/* 436 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 442 */       return FactionWorshipInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 448 */       return FactionWorshipInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 454 */       FactionWorshipInfo.this._xdb_verify_unsafe_();
/* 455 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 461 */       return FactionWorshipInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 467 */       return FactionWorshipInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 473 */       FactionWorshipInfo.this._xdb_verify_unsafe_();
/* 474 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 480 */       return FactionWorshipInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 486 */       return FactionWorshipInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 492 */       return FactionWorshipInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 498 */       return FactionWorshipInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 504 */       return FactionWorshipInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 510 */       return FactionWorshipInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 516 */       return FactionWorshipInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FactionWorshipInfo
/*     */   {
/*     */     private HashMap<Integer, Integer> worshipdata;
/*     */     
/*     */     private ArrayList<xbean.SingleWorshipInfo> worshiprecord;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 530 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 535 */       this.worshipdata = new HashMap();
/* 536 */       this.worshiprecord = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.FactionWorshipInfo _o1_)
/*     */     {
/* 541 */       if ((_o1_ instanceof FactionWorshipInfo)) { assign((FactionWorshipInfo)_o1_);
/* 542 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 543 */       } else if ((_o1_ instanceof FactionWorshipInfo.Const)) assign(((FactionWorshipInfo.Const)_o1_).nThis()); else {
/* 544 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FactionWorshipInfo _o_) {
/* 549 */       this.worshipdata = new HashMap();
/* 550 */       for (Map.Entry<Integer, Integer> _e_ : _o_.worshipdata.entrySet())
/* 551 */         this.worshipdata.put(_e_.getKey(), _e_.getValue());
/* 552 */       this.worshiprecord = new ArrayList();
/* 553 */       for (xbean.SingleWorshipInfo _v_ : _o_.worshiprecord) {
/* 554 */         this.worshiprecord.add(new SingleWorshipInfo.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 559 */       this.worshipdata = new HashMap();
/* 560 */       for (Map.Entry<Integer, Integer> _e_ : _o_.worshipdata.entrySet())
/* 561 */         this.worshipdata.put(_e_.getKey(), _e_.getValue());
/* 562 */       this.worshiprecord = new ArrayList();
/* 563 */       for (xbean.SingleWorshipInfo _v_ : _o_.worshiprecord) {
/* 564 */         this.worshiprecord.add(new SingleWorshipInfo.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 570 */       _os_.compact_uint32(this.worshipdata.size());
/* 571 */       for (Map.Entry<Integer, Integer> _e_ : this.worshipdata.entrySet())
/*     */       {
/* 573 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 574 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 576 */       _os_.compact_uint32(this.worshiprecord.size());
/* 577 */       for (xbean.SingleWorshipInfo _v_ : this.worshiprecord)
/*     */       {
/* 579 */         _v_.marshal(_os_);
/*     */       }
/* 581 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 588 */       int size = _os_.uncompact_uint32();
/* 589 */       if (size >= 12)
/*     */       {
/* 591 */         this.worshipdata = new HashMap(size * 2);
/*     */       }
/* 593 */       for (; size > 0; size--)
/*     */       {
/* 595 */         int _k_ = 0;
/* 596 */         _k_ = _os_.unmarshal_int();
/* 597 */         int _v_ = 0;
/* 598 */         _v_ = _os_.unmarshal_int();
/* 599 */         this.worshipdata.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 602 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 604 */         xbean.SingleWorshipInfo _v_ = xbean.Pod.newSingleWorshipInfoData();
/* 605 */         _v_.unmarshal(_os_);
/* 606 */         this.worshiprecord.add(_v_);
/*     */       }
/* 608 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 614 */       int _size_ = 0;
/* 615 */       for (Map.Entry<Integer, Integer> _e_ : this.worshipdata.entrySet())
/*     */       {
/* 617 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 618 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 620 */       for (xbean.SingleWorshipInfo _v_ : this.worshiprecord)
/*     */       {
/* 622 */         _size_ += CodedOutputStream.computeMessageSize(2, _v_);
/*     */       }
/* 624 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 632 */         for (Map.Entry<Integer, Integer> _e_ : this.worshipdata.entrySet())
/*     */         {
/* 634 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 635 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 637 */         for (xbean.SingleWorshipInfo _v_ : this.worshiprecord)
/*     */         {
/* 639 */           _output_.writeMessage(2, _v_);
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 644 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 646 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 654 */         boolean done = false;
/* 655 */         while (!done)
/*     */         {
/* 657 */           int tag = _input_.readTag();
/* 658 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 662 */             done = true;
/* 663 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 667 */             int _k_ = 0;
/* 668 */             _k_ = _input_.readInt32();
/* 669 */             int readTag = _input_.readTag();
/* 670 */             if (8 != readTag)
/*     */             {
/* 672 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 674 */             int _v_ = 0;
/* 675 */             _v_ = _input_.readInt32();
/* 676 */             this.worshipdata.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 677 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 681 */             xbean.SingleWorshipInfo _v_ = xbean.Pod.newSingleWorshipInfoData();
/* 682 */             _input_.readMessage(_v_);
/* 683 */             this.worshiprecord.add(_v_);
/* 684 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 688 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 690 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 699 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 703 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 705 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionWorshipInfo copy()
/*     */     {
/* 711 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionWorshipInfo toData()
/*     */     {
/* 717 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FactionWorshipInfo toBean()
/*     */     {
/* 722 */       return new FactionWorshipInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionWorshipInfo toDataIf()
/*     */     {
/* 728 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FactionWorshipInfo toBeanIf()
/*     */     {
/* 733 */       return new FactionWorshipInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 739 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 743 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 747 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 751 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 755 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 759 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 763 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getWorshipdata()
/*     */     {
/* 770 */       return this.worshipdata;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getWorshipdataAsData()
/*     */     {
/* 777 */       return this.worshipdata;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SingleWorshipInfo> getWorshiprecord()
/*     */     {
/* 784 */       return this.worshiprecord;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SingleWorshipInfo> getWorshiprecordAsData()
/*     */     {
/* 791 */       return this.worshiprecord;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 797 */       if (!(_o1_ instanceof Data)) return false;
/* 798 */       Data _o_ = (Data)_o1_;
/* 799 */       if (!this.worshipdata.equals(_o_.worshipdata)) return false;
/* 800 */       if (!this.worshiprecord.equals(_o_.worshiprecord)) return false;
/* 801 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 807 */       int _h_ = 0;
/* 808 */       _h_ += this.worshipdata.hashCode();
/* 809 */       _h_ += this.worshiprecord.hashCode();
/* 810 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 816 */       StringBuilder _sb_ = new StringBuilder();
/* 817 */       _sb_.append("(");
/* 818 */       _sb_.append(this.worshipdata);
/* 819 */       _sb_.append(",");
/* 820 */       _sb_.append(this.worshiprecord);
/* 821 */       _sb_.append(")");
/* 822 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FactionWorshipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
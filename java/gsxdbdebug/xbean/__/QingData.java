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
/*     */ import ppbio.Message;
/*     */ 
/*     */ public final class QingData extends xdb.XBean implements xbean.QingData
/*     */ {
/*     */   private HashMap<Integer, xbean.Progress> type2progress;
/*     */   private HashMap<Integer, xbean.HelpData> type2helpdata;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.type2progress.clear();
/*  21 */     this.type2helpdata.clear();
/*     */   }
/*     */   
/*     */   QingData(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.type2progress = new HashMap();
/*  28 */     this.type2helpdata = new HashMap();
/*     */   }
/*     */   
/*     */   public QingData()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public QingData(QingData _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   QingData(xbean.QingData _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof QingData)) { assign((QingData)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(QingData _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.type2progress = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.Progress> _e_ : _o_.type2progress.entrySet())
/*  55 */       this.type2progress.put(_e_.getKey(), new Progress((xbean.Progress)_e_.getValue(), this, "type2progress"));
/*  56 */     this.type2helpdata = new HashMap();
/*  57 */     for (Map.Entry<Integer, xbean.HelpData> _e_ : _o_.type2helpdata.entrySet()) {
/*  58 */       this.type2helpdata.put(_e_.getKey(), new HelpData((xbean.HelpData)_e_.getValue(), this, "type2helpdata"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  63 */     this.type2progress = new HashMap();
/*  64 */     for (Map.Entry<Integer, xbean.Progress> _e_ : _o_.type2progress.entrySet())
/*  65 */       this.type2progress.put(_e_.getKey(), new Progress((xbean.Progress)_e_.getValue(), this, "type2progress"));
/*  66 */     this.type2helpdata = new HashMap();
/*  67 */     for (Map.Entry<Integer, xbean.HelpData> _e_ : _o_.type2helpdata.entrySet()) {
/*  68 */       this.type2helpdata.put(_e_.getKey(), new HelpData((xbean.HelpData)_e_.getValue(), this, "type2helpdata"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.type2progress.size());
/*  76 */     for (Map.Entry<Integer, xbean.Progress> _e_ : this.type2progress.entrySet())
/*     */     {
/*  78 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  79 */       ((xbean.Progress)_e_.getValue()).marshal(_os_);
/*     */     }
/*  81 */     _os_.compact_uint32(this.type2helpdata.size());
/*  82 */     for (Map.Entry<Integer, xbean.HelpData> _e_ : this.type2helpdata.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  85 */       ((xbean.HelpData)_e_.getValue()).marshal(_os_);
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*     */     
/*  95 */     int size = _os_.uncompact_uint32();
/*  96 */     if (size >= 12)
/*     */     {
/*  98 */       this.type2progress = new HashMap(size * 2);
/*     */     }
/* 100 */     for (; size > 0; size--)
/*     */     {
/* 102 */       int _k_ = 0;
/* 103 */       _k_ = _os_.unmarshal_int();
/* 104 */       xbean.Progress _v_ = new Progress(0, this, "type2progress");
/* 105 */       _v_.unmarshal(_os_);
/* 106 */       this.type2progress.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*     */ 
/* 110 */     int size = _os_.uncompact_uint32();
/* 111 */     if (size >= 12)
/*     */     {
/* 113 */       this.type2helpdata = new HashMap(size * 2);
/*     */     }
/* 115 */     for (; size > 0; size--)
/*     */     {
/* 117 */       int _k_ = 0;
/* 118 */       _k_ = _os_.unmarshal_int();
/* 119 */       xbean.HelpData _v_ = new HelpData(0, this, "type2helpdata");
/* 120 */       _v_.unmarshal(_os_);
/* 121 */       this.type2helpdata.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 124 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/* 131 */     int _size_ = 0;
/* 132 */     for (Map.Entry<Integer, xbean.Progress> _e_ : this.type2progress.entrySet())
/*     */     {
/* 134 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 135 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*     */     }
/* 137 */     for (Map.Entry<Integer, xbean.HelpData> _e_ : this.type2helpdata.entrySet())
/*     */     {
/* 139 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 140 */       _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*     */     }
/* 142 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 148 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 151 */       for (Map.Entry<Integer, xbean.Progress> _e_ : this.type2progress.entrySet())
/*     */       {
/* 153 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 154 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*     */       }
/* 156 */       for (Map.Entry<Integer, xbean.HelpData> _e_ : this.type2helpdata.entrySet())
/*     */       {
/* 158 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 159 */         _output_.writeMessage(2, (Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 175 */       boolean done = false;
/* 176 */       while (!done)
/*     */       {
/* 178 */         int tag = _input_.readTag();
/* 179 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 183 */           done = true;
/* 184 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 188 */           int _k_ = 0;
/* 189 */           _k_ = _input_.readInt32();
/* 190 */           int readTag = _input_.readTag();
/* 191 */           if (10 != readTag)
/*     */           {
/* 193 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 195 */           xbean.Progress _v_ = new Progress(0, this, "type2progress");
/* 196 */           _input_.readMessage(_v_);
/* 197 */           this.type2progress.put(Integer.valueOf(_k_), _v_);
/* 198 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 202 */           int _k_ = 0;
/* 203 */           _k_ = _input_.readInt32();
/* 204 */           int readTag = _input_.readTag();
/* 205 */           if (18 != readTag)
/*     */           {
/* 207 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 209 */           xbean.HelpData _v_ = new HelpData(0, this, "type2helpdata");
/* 210 */           _input_.readMessage(_v_);
/* 211 */           this.type2helpdata.put(Integer.valueOf(_k_), _v_);
/* 212 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 216 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 218 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 227 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 231 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 233 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.QingData copy()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new QingData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.QingData toData()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.QingData toBean()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new QingData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.QingData toDataIf()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.QingData toBeanIf()
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.Progress> getType2progress()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return xdb.Logs.logMap(new xdb.LogKey(this, "type2progress"), this.type2progress);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.Progress> getType2progressAsData()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/*     */     
/* 290 */     QingData _o_ = this;
/* 291 */     Map<Integer, xbean.Progress> type2progress = new HashMap();
/* 292 */     for (Map.Entry<Integer, xbean.Progress> _e_ : _o_.type2progress.entrySet())
/* 293 */       type2progress.put(_e_.getKey(), new Progress.Data((xbean.Progress)_e_.getValue()));
/* 294 */     return type2progress;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.HelpData> getType2helpdata()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     return xdb.Logs.logMap(new xdb.LogKey(this, "type2helpdata"), this.type2helpdata);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.HelpData> getType2helpdataAsData()
/*     */   {
/* 309 */     _xdb_verify_unsafe_();
/*     */     
/* 311 */     QingData _o_ = this;
/* 312 */     Map<Integer, xbean.HelpData> type2helpdata = new HashMap();
/* 313 */     for (Map.Entry<Integer, xbean.HelpData> _e_ : _o_.type2helpdata.entrySet())
/* 314 */       type2helpdata.put(_e_.getKey(), new HelpData.Data((xbean.HelpData)_e_.getValue()));
/* 315 */     return type2helpdata;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     QingData _o_ = null;
/* 323 */     if ((_o1_ instanceof QingData)) { _o_ = (QingData)_o1_;
/* 324 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 325 */       return false;
/* 326 */     if (!this.type2progress.equals(_o_.type2progress)) return false;
/* 327 */     if (!this.type2helpdata.equals(_o_.type2helpdata)) return false;
/* 328 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 334 */     _xdb_verify_unsafe_();
/* 335 */     int _h_ = 0;
/* 336 */     _h_ += this.type2progress.hashCode();
/* 337 */     _h_ += this.type2helpdata.hashCode();
/* 338 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     StringBuilder _sb_ = new StringBuilder();
/* 346 */     _sb_.append("(");
/* 347 */     _sb_.append(this.type2progress);
/* 348 */     _sb_.append(",");
/* 349 */     _sb_.append(this.type2helpdata);
/* 350 */     _sb_.append(")");
/* 351 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 357 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 358 */     lb.add(new xdb.logs.ListenableMap().setVarName("type2progress"));
/* 359 */     lb.add(new xdb.logs.ListenableMap().setVarName("type2helpdata"));
/* 360 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.QingData {
/*     */     private Const() {}
/*     */     
/*     */     QingData nThis() {
/* 367 */       return QingData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 373 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QingData copy()
/*     */     {
/* 379 */       return QingData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QingData toData()
/*     */     {
/* 385 */       return QingData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.QingData toBean()
/*     */     {
/* 390 */       return QingData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QingData toDataIf()
/*     */     {
/* 396 */       return QingData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.QingData toBeanIf()
/*     */     {
/* 401 */       return QingData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Progress> getType2progress()
/*     */     {
/* 408 */       QingData.this._xdb_verify_unsafe_();
/* 409 */       return xdb.Consts.constMap(QingData.this.type2progress);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Progress> getType2progressAsData()
/*     */     {
/* 416 */       QingData.this._xdb_verify_unsafe_();
/*     */       
/* 418 */       QingData _o_ = QingData.this;
/* 419 */       Map<Integer, xbean.Progress> type2progress = new HashMap();
/* 420 */       for (Map.Entry<Integer, xbean.Progress> _e_ : _o_.type2progress.entrySet())
/* 421 */         type2progress.put(_e_.getKey(), new Progress.Data((xbean.Progress)_e_.getValue()));
/* 422 */       return type2progress;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.HelpData> getType2helpdata()
/*     */     {
/* 429 */       QingData.this._xdb_verify_unsafe_();
/* 430 */       return xdb.Consts.constMap(QingData.this.type2helpdata);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.HelpData> getType2helpdataAsData()
/*     */     {
/* 437 */       QingData.this._xdb_verify_unsafe_();
/*     */       
/* 439 */       QingData _o_ = QingData.this;
/* 440 */       Map<Integer, xbean.HelpData> type2helpdata = new HashMap();
/* 441 */       for (Map.Entry<Integer, xbean.HelpData> _e_ : _o_.type2helpdata.entrySet())
/* 442 */         type2helpdata.put(_e_.getKey(), new HelpData.Data((xbean.HelpData)_e_.getValue()));
/* 443 */       return type2helpdata;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 449 */       QingData.this._xdb_verify_unsafe_();
/* 450 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 456 */       QingData.this._xdb_verify_unsafe_();
/* 457 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 463 */       return QingData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 469 */       return QingData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 475 */       QingData.this._xdb_verify_unsafe_();
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 482 */       return QingData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 488 */       return QingData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 494 */       QingData.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 501 */       return QingData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 507 */       return QingData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 513 */       return QingData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 519 */       return QingData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 525 */       return QingData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 531 */       return QingData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 537 */       return QingData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.QingData
/*     */   {
/*     */     private HashMap<Integer, xbean.Progress> type2progress;
/*     */     
/*     */     private HashMap<Integer, xbean.HelpData> type2helpdata;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 556 */       this.type2progress = new HashMap();
/* 557 */       this.type2helpdata = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.QingData _o1_)
/*     */     {
/* 562 */       if ((_o1_ instanceof QingData)) { assign((QingData)_o1_);
/* 563 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 564 */       } else if ((_o1_ instanceof QingData.Const)) assign(((QingData.Const)_o1_).nThis()); else {
/* 565 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(QingData _o_) {
/* 570 */       this.type2progress = new HashMap();
/* 571 */       for (Map.Entry<Integer, xbean.Progress> _e_ : _o_.type2progress.entrySet())
/* 572 */         this.type2progress.put(_e_.getKey(), new Progress.Data((xbean.Progress)_e_.getValue()));
/* 573 */       this.type2helpdata = new HashMap();
/* 574 */       for (Map.Entry<Integer, xbean.HelpData> _e_ : _o_.type2helpdata.entrySet()) {
/* 575 */         this.type2helpdata.put(_e_.getKey(), new HelpData.Data((xbean.HelpData)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 580 */       this.type2progress = new HashMap();
/* 581 */       for (Map.Entry<Integer, xbean.Progress> _e_ : _o_.type2progress.entrySet())
/* 582 */         this.type2progress.put(_e_.getKey(), new Progress.Data((xbean.Progress)_e_.getValue()));
/* 583 */       this.type2helpdata = new HashMap();
/* 584 */       for (Map.Entry<Integer, xbean.HelpData> _e_ : _o_.type2helpdata.entrySet()) {
/* 585 */         this.type2helpdata.put(_e_.getKey(), new HelpData.Data((xbean.HelpData)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 591 */       _os_.compact_uint32(this.type2progress.size());
/* 592 */       for (Map.Entry<Integer, xbean.Progress> _e_ : this.type2progress.entrySet())
/*     */       {
/* 594 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 595 */         ((xbean.Progress)_e_.getValue()).marshal(_os_);
/*     */       }
/* 597 */       _os_.compact_uint32(this.type2helpdata.size());
/* 598 */       for (Map.Entry<Integer, xbean.HelpData> _e_ : this.type2helpdata.entrySet())
/*     */       {
/* 600 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 601 */         ((xbean.HelpData)_e_.getValue()).marshal(_os_);
/*     */       }
/* 603 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 610 */       int size = _os_.uncompact_uint32();
/* 611 */       if (size >= 12)
/*     */       {
/* 613 */         this.type2progress = new HashMap(size * 2);
/*     */       }
/* 615 */       for (; size > 0; size--)
/*     */       {
/* 617 */         int _k_ = 0;
/* 618 */         _k_ = _os_.unmarshal_int();
/* 619 */         xbean.Progress _v_ = xbean.Pod.newProgressData();
/* 620 */         _v_.unmarshal(_os_);
/* 621 */         this.type2progress.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/*     */ 
/* 625 */       int size = _os_.uncompact_uint32();
/* 626 */       if (size >= 12)
/*     */       {
/* 628 */         this.type2helpdata = new HashMap(size * 2);
/*     */       }
/* 630 */       for (; size > 0; size--)
/*     */       {
/* 632 */         int _k_ = 0;
/* 633 */         _k_ = _os_.unmarshal_int();
/* 634 */         xbean.HelpData _v_ = xbean.Pod.newHelpDataData();
/* 635 */         _v_.unmarshal(_os_);
/* 636 */         this.type2helpdata.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 639 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 645 */       int _size_ = 0;
/* 646 */       for (Map.Entry<Integer, xbean.Progress> _e_ : this.type2progress.entrySet())
/*     */       {
/* 648 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 649 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*     */       }
/* 651 */       for (Map.Entry<Integer, xbean.HelpData> _e_ : this.type2helpdata.entrySet())
/*     */       {
/* 653 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 654 */         _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*     */       }
/* 656 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 664 */         for (Map.Entry<Integer, xbean.Progress> _e_ : this.type2progress.entrySet())
/*     */         {
/* 666 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 667 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*     */         }
/* 669 */         for (Map.Entry<Integer, xbean.HelpData> _e_ : this.type2helpdata.entrySet())
/*     */         {
/* 671 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 672 */           _output_.writeMessage(2, (Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 677 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 679 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 687 */         boolean done = false;
/* 688 */         while (!done)
/*     */         {
/* 690 */           int tag = _input_.readTag();
/* 691 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 695 */             done = true;
/* 696 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 700 */             int _k_ = 0;
/* 701 */             _k_ = _input_.readInt32();
/* 702 */             int readTag = _input_.readTag();
/* 703 */             if (10 != readTag)
/*     */             {
/* 705 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 707 */             xbean.Progress _v_ = xbean.Pod.newProgressData();
/* 708 */             _input_.readMessage(_v_);
/* 709 */             this.type2progress.put(Integer.valueOf(_k_), _v_);
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 714 */             int _k_ = 0;
/* 715 */             _k_ = _input_.readInt32();
/* 716 */             int readTag = _input_.readTag();
/* 717 */             if (18 != readTag)
/*     */             {
/* 719 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 721 */             xbean.HelpData _v_ = xbean.Pod.newHelpDataData();
/* 722 */             _input_.readMessage(_v_);
/* 723 */             this.type2helpdata.put(Integer.valueOf(_k_), _v_);
/* 724 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 728 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 730 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 739 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 743 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 745 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QingData copy()
/*     */     {
/* 751 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QingData toData()
/*     */     {
/* 757 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.QingData toBean()
/*     */     {
/* 762 */       return new QingData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QingData toDataIf()
/*     */     {
/* 768 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.QingData toBeanIf()
/*     */     {
/* 773 */       return new QingData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 799 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 803 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Progress> getType2progress()
/*     */     {
/* 810 */       return this.type2progress;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.Progress> getType2progressAsData()
/*     */     {
/* 817 */       return this.type2progress;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.HelpData> getType2helpdata()
/*     */     {
/* 824 */       return this.type2helpdata;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.HelpData> getType2helpdataAsData()
/*     */     {
/* 831 */       return this.type2helpdata;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 837 */       if (!(_o1_ instanceof Data)) return false;
/* 838 */       Data _o_ = (Data)_o1_;
/* 839 */       if (!this.type2progress.equals(_o_.type2progress)) return false;
/* 840 */       if (!this.type2helpdata.equals(_o_.type2helpdata)) return false;
/* 841 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 847 */       int _h_ = 0;
/* 848 */       _h_ += this.type2progress.hashCode();
/* 849 */       _h_ += this.type2helpdata.hashCode();
/* 850 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 856 */       StringBuilder _sb_ = new StringBuilder();
/* 857 */       _sb_.append("(");
/* 858 */       _sb_.append(this.type2progress);
/* 859 */       _sb_.append(",");
/* 860 */       _sb_.append(this.type2helpdata);
/* 861 */       _sb_.append(")");
/* 862 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\QingData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*     */ public final class XAwardInfo extends xdb.XBean implements xbean.XAwardInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.XAwardContent> type2awardcontent;
/*     */   private HashMap<Integer, xbean.XAwardData> type2awarddata;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.type2awardcontent.clear();
/*  21 */     this.type2awarddata.clear();
/*     */   }
/*     */   
/*     */   XAwardInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.type2awardcontent = new HashMap();
/*  28 */     this.type2awarddata = new HashMap();
/*     */   }
/*     */   
/*     */   public XAwardInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public XAwardInfo(XAwardInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   XAwardInfo(xbean.XAwardInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof XAwardInfo)) { assign((XAwardInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(XAwardInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.type2awardcontent = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.XAwardContent> _e_ : _o_.type2awardcontent.entrySet())
/*  55 */       this.type2awardcontent.put(_e_.getKey(), new XAwardContent((xbean.XAwardContent)_e_.getValue(), this, "type2awardcontent"));
/*  56 */     this.type2awarddata = new HashMap();
/*  57 */     for (Map.Entry<Integer, xbean.XAwardData> _e_ : _o_.type2awarddata.entrySet()) {
/*  58 */       this.type2awarddata.put(_e_.getKey(), new XAwardData((xbean.XAwardData)_e_.getValue(), this, "type2awarddata"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  63 */     this.type2awardcontent = new HashMap();
/*  64 */     for (Map.Entry<Integer, xbean.XAwardContent> _e_ : _o_.type2awardcontent.entrySet())
/*  65 */       this.type2awardcontent.put(_e_.getKey(), new XAwardContent((xbean.XAwardContent)_e_.getValue(), this, "type2awardcontent"));
/*  66 */     this.type2awarddata = new HashMap();
/*  67 */     for (Map.Entry<Integer, xbean.XAwardData> _e_ : _o_.type2awarddata.entrySet()) {
/*  68 */       this.type2awarddata.put(_e_.getKey(), new XAwardData((xbean.XAwardData)_e_.getValue(), this, "type2awarddata"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.type2awardcontent.size());
/*  76 */     for (Map.Entry<Integer, xbean.XAwardContent> _e_ : this.type2awardcontent.entrySet())
/*     */     {
/*  78 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  79 */       ((xbean.XAwardContent)_e_.getValue()).marshal(_os_);
/*     */     }
/*  81 */     _os_.compact_uint32(this.type2awarddata.size());
/*  82 */     for (Map.Entry<Integer, xbean.XAwardData> _e_ : this.type2awarddata.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  85 */       ((xbean.XAwardData)_e_.getValue()).marshal(_os_);
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
/*  98 */       this.type2awardcontent = new HashMap(size * 2);
/*     */     }
/* 100 */     for (; size > 0; size--)
/*     */     {
/* 102 */       int _k_ = 0;
/* 103 */       _k_ = _os_.unmarshal_int();
/* 104 */       xbean.XAwardContent _v_ = new XAwardContent(0, this, "type2awardcontent");
/* 105 */       _v_.unmarshal(_os_);
/* 106 */       this.type2awardcontent.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*     */ 
/* 110 */     int size = _os_.uncompact_uint32();
/* 111 */     if (size >= 12)
/*     */     {
/* 113 */       this.type2awarddata = new HashMap(size * 2);
/*     */     }
/* 115 */     for (; size > 0; size--)
/*     */     {
/* 117 */       int _k_ = 0;
/* 118 */       _k_ = _os_.unmarshal_int();
/* 119 */       xbean.XAwardData _v_ = new XAwardData(0, this, "type2awarddata");
/* 120 */       _v_.unmarshal(_os_);
/* 121 */       this.type2awarddata.put(Integer.valueOf(_k_), _v_);
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
/* 132 */     for (Map.Entry<Integer, xbean.XAwardContent> _e_ : this.type2awardcontent.entrySet())
/*     */     {
/* 134 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 135 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*     */     }
/* 137 */     for (Map.Entry<Integer, xbean.XAwardData> _e_ : this.type2awarddata.entrySet())
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
/* 151 */       for (Map.Entry<Integer, xbean.XAwardContent> _e_ : this.type2awardcontent.entrySet())
/*     */       {
/* 153 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 154 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*     */       }
/* 156 */       for (Map.Entry<Integer, xbean.XAwardData> _e_ : this.type2awarddata.entrySet())
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
/* 195 */           xbean.XAwardContent _v_ = new XAwardContent(0, this, "type2awardcontent");
/* 196 */           _input_.readMessage(_v_);
/* 197 */           this.type2awardcontent.put(Integer.valueOf(_k_), _v_);
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
/* 209 */           xbean.XAwardData _v_ = new XAwardData(0, this, "type2awarddata");
/* 210 */           _input_.readMessage(_v_);
/* 211 */           this.type2awarddata.put(Integer.valueOf(_k_), _v_);
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
/*     */   public xbean.XAwardInfo copy()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new XAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.XAwardInfo toData()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.XAwardInfo toBean()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new XAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.XAwardInfo toDataIf()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.XAwardInfo toBeanIf()
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
/*     */   public Map<Integer, xbean.XAwardContent> getType2awardcontent()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return xdb.Logs.logMap(new xdb.LogKey(this, "type2awardcontent"), this.type2awardcontent);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.XAwardContent> getType2awardcontentAsData()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/*     */     
/* 290 */     XAwardInfo _o_ = this;
/* 291 */     Map<Integer, xbean.XAwardContent> type2awardcontent = new HashMap();
/* 292 */     for (Map.Entry<Integer, xbean.XAwardContent> _e_ : _o_.type2awardcontent.entrySet())
/* 293 */       type2awardcontent.put(_e_.getKey(), new XAwardContent.Data((xbean.XAwardContent)_e_.getValue()));
/* 294 */     return type2awardcontent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.XAwardData> getType2awarddata()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     return xdb.Logs.logMap(new xdb.LogKey(this, "type2awarddata"), this.type2awarddata);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.XAwardData> getType2awarddataAsData()
/*     */   {
/* 309 */     _xdb_verify_unsafe_();
/*     */     
/* 311 */     XAwardInfo _o_ = this;
/* 312 */     Map<Integer, xbean.XAwardData> type2awarddata = new HashMap();
/* 313 */     for (Map.Entry<Integer, xbean.XAwardData> _e_ : _o_.type2awarddata.entrySet())
/* 314 */       type2awarddata.put(_e_.getKey(), new XAwardData.Data((xbean.XAwardData)_e_.getValue()));
/* 315 */     return type2awarddata;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     XAwardInfo _o_ = null;
/* 323 */     if ((_o1_ instanceof XAwardInfo)) { _o_ = (XAwardInfo)_o1_;
/* 324 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 325 */       return false;
/* 326 */     if (!this.type2awardcontent.equals(_o_.type2awardcontent)) return false;
/* 327 */     if (!this.type2awarddata.equals(_o_.type2awarddata)) return false;
/* 328 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 334 */     _xdb_verify_unsafe_();
/* 335 */     int _h_ = 0;
/* 336 */     _h_ += this.type2awardcontent.hashCode();
/* 337 */     _h_ += this.type2awarddata.hashCode();
/* 338 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     StringBuilder _sb_ = new StringBuilder();
/* 346 */     _sb_.append("(");
/* 347 */     _sb_.append(this.type2awardcontent);
/* 348 */     _sb_.append(",");
/* 349 */     _sb_.append(this.type2awarddata);
/* 350 */     _sb_.append(")");
/* 351 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 357 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 358 */     lb.add(new xdb.logs.ListenableMap().setVarName("type2awardcontent"));
/* 359 */     lb.add(new xdb.logs.ListenableMap().setVarName("type2awarddata"));
/* 360 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.XAwardInfo {
/*     */     private Const() {}
/*     */     
/*     */     XAwardInfo nThis() {
/* 367 */       return XAwardInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 373 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XAwardInfo copy()
/*     */     {
/* 379 */       return XAwardInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XAwardInfo toData()
/*     */     {
/* 385 */       return XAwardInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.XAwardInfo toBean()
/*     */     {
/* 390 */       return XAwardInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XAwardInfo toDataIf()
/*     */     {
/* 396 */       return XAwardInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.XAwardInfo toBeanIf()
/*     */     {
/* 401 */       return XAwardInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.XAwardContent> getType2awardcontent()
/*     */     {
/* 408 */       XAwardInfo.this._xdb_verify_unsafe_();
/* 409 */       return xdb.Consts.constMap(XAwardInfo.this.type2awardcontent);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.XAwardContent> getType2awardcontentAsData()
/*     */     {
/* 416 */       XAwardInfo.this._xdb_verify_unsafe_();
/*     */       
/* 418 */       XAwardInfo _o_ = XAwardInfo.this;
/* 419 */       Map<Integer, xbean.XAwardContent> type2awardcontent = new HashMap();
/* 420 */       for (Map.Entry<Integer, xbean.XAwardContent> _e_ : _o_.type2awardcontent.entrySet())
/* 421 */         type2awardcontent.put(_e_.getKey(), new XAwardContent.Data((xbean.XAwardContent)_e_.getValue()));
/* 422 */       return type2awardcontent;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.XAwardData> getType2awarddata()
/*     */     {
/* 429 */       XAwardInfo.this._xdb_verify_unsafe_();
/* 430 */       return xdb.Consts.constMap(XAwardInfo.this.type2awarddata);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.XAwardData> getType2awarddataAsData()
/*     */     {
/* 437 */       XAwardInfo.this._xdb_verify_unsafe_();
/*     */       
/* 439 */       XAwardInfo _o_ = XAwardInfo.this;
/* 440 */       Map<Integer, xbean.XAwardData> type2awarddata = new HashMap();
/* 441 */       for (Map.Entry<Integer, xbean.XAwardData> _e_ : _o_.type2awarddata.entrySet())
/* 442 */         type2awarddata.put(_e_.getKey(), new XAwardData.Data((xbean.XAwardData)_e_.getValue()));
/* 443 */       return type2awarddata;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 449 */       XAwardInfo.this._xdb_verify_unsafe_();
/* 450 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 456 */       XAwardInfo.this._xdb_verify_unsafe_();
/* 457 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 463 */       return XAwardInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 469 */       return XAwardInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 475 */       XAwardInfo.this._xdb_verify_unsafe_();
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 482 */       return XAwardInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 488 */       return XAwardInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 494 */       XAwardInfo.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 501 */       return XAwardInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 507 */       return XAwardInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 513 */       return XAwardInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 519 */       return XAwardInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 525 */       return XAwardInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 531 */       return XAwardInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 537 */       return XAwardInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.XAwardInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.XAwardContent> type2awardcontent;
/*     */     
/*     */     private HashMap<Integer, xbean.XAwardData> type2awarddata;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 556 */       this.type2awardcontent = new HashMap();
/* 557 */       this.type2awarddata = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.XAwardInfo _o1_)
/*     */     {
/* 562 */       if ((_o1_ instanceof XAwardInfo)) { assign((XAwardInfo)_o1_);
/* 563 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 564 */       } else if ((_o1_ instanceof XAwardInfo.Const)) assign(((XAwardInfo.Const)_o1_).nThis()); else {
/* 565 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(XAwardInfo _o_) {
/* 570 */       this.type2awardcontent = new HashMap();
/* 571 */       for (Map.Entry<Integer, xbean.XAwardContent> _e_ : _o_.type2awardcontent.entrySet())
/* 572 */         this.type2awardcontent.put(_e_.getKey(), new XAwardContent.Data((xbean.XAwardContent)_e_.getValue()));
/* 573 */       this.type2awarddata = new HashMap();
/* 574 */       for (Map.Entry<Integer, xbean.XAwardData> _e_ : _o_.type2awarddata.entrySet()) {
/* 575 */         this.type2awarddata.put(_e_.getKey(), new XAwardData.Data((xbean.XAwardData)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 580 */       this.type2awardcontent = new HashMap();
/* 581 */       for (Map.Entry<Integer, xbean.XAwardContent> _e_ : _o_.type2awardcontent.entrySet())
/* 582 */         this.type2awardcontent.put(_e_.getKey(), new XAwardContent.Data((xbean.XAwardContent)_e_.getValue()));
/* 583 */       this.type2awarddata = new HashMap();
/* 584 */       for (Map.Entry<Integer, xbean.XAwardData> _e_ : _o_.type2awarddata.entrySet()) {
/* 585 */         this.type2awarddata.put(_e_.getKey(), new XAwardData.Data((xbean.XAwardData)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 591 */       _os_.compact_uint32(this.type2awardcontent.size());
/* 592 */       for (Map.Entry<Integer, xbean.XAwardContent> _e_ : this.type2awardcontent.entrySet())
/*     */       {
/* 594 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 595 */         ((xbean.XAwardContent)_e_.getValue()).marshal(_os_);
/*     */       }
/* 597 */       _os_.compact_uint32(this.type2awarddata.size());
/* 598 */       for (Map.Entry<Integer, xbean.XAwardData> _e_ : this.type2awarddata.entrySet())
/*     */       {
/* 600 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 601 */         ((xbean.XAwardData)_e_.getValue()).marshal(_os_);
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
/* 613 */         this.type2awardcontent = new HashMap(size * 2);
/*     */       }
/* 615 */       for (; size > 0; size--)
/*     */       {
/* 617 */         int _k_ = 0;
/* 618 */         _k_ = _os_.unmarshal_int();
/* 619 */         xbean.XAwardContent _v_ = xbean.Pod.newXAwardContentData();
/* 620 */         _v_.unmarshal(_os_);
/* 621 */         this.type2awardcontent.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/*     */ 
/* 625 */       int size = _os_.uncompact_uint32();
/* 626 */       if (size >= 12)
/*     */       {
/* 628 */         this.type2awarddata = new HashMap(size * 2);
/*     */       }
/* 630 */       for (; size > 0; size--)
/*     */       {
/* 632 */         int _k_ = 0;
/* 633 */         _k_ = _os_.unmarshal_int();
/* 634 */         xbean.XAwardData _v_ = xbean.Pod.newXAwardDataData();
/* 635 */         _v_.unmarshal(_os_);
/* 636 */         this.type2awarddata.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 639 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 645 */       int _size_ = 0;
/* 646 */       for (Map.Entry<Integer, xbean.XAwardContent> _e_ : this.type2awardcontent.entrySet())
/*     */       {
/* 648 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 649 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*     */       }
/* 651 */       for (Map.Entry<Integer, xbean.XAwardData> _e_ : this.type2awarddata.entrySet())
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
/* 664 */         for (Map.Entry<Integer, xbean.XAwardContent> _e_ : this.type2awardcontent.entrySet())
/*     */         {
/* 666 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 667 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*     */         }
/* 669 */         for (Map.Entry<Integer, xbean.XAwardData> _e_ : this.type2awarddata.entrySet())
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
/* 707 */             xbean.XAwardContent _v_ = xbean.Pod.newXAwardContentData();
/* 708 */             _input_.readMessage(_v_);
/* 709 */             this.type2awardcontent.put(Integer.valueOf(_k_), _v_);
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
/* 721 */             xbean.XAwardData _v_ = xbean.Pod.newXAwardDataData();
/* 722 */             _input_.readMessage(_v_);
/* 723 */             this.type2awarddata.put(Integer.valueOf(_k_), _v_);
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
/*     */     public xbean.XAwardInfo copy()
/*     */     {
/* 751 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XAwardInfo toData()
/*     */     {
/* 757 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.XAwardInfo toBean()
/*     */     {
/* 762 */       return new XAwardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XAwardInfo toDataIf()
/*     */     {
/* 768 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.XAwardInfo toBeanIf()
/*     */     {
/* 773 */       return new XAwardInfo(this, null, null);
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
/*     */     public Map<Integer, xbean.XAwardContent> getType2awardcontent()
/*     */     {
/* 810 */       return this.type2awardcontent;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.XAwardContent> getType2awardcontentAsData()
/*     */     {
/* 817 */       return this.type2awardcontent;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.XAwardData> getType2awarddata()
/*     */     {
/* 824 */       return this.type2awarddata;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.XAwardData> getType2awarddataAsData()
/*     */     {
/* 831 */       return this.type2awarddata;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 837 */       if (!(_o1_ instanceof Data)) return false;
/* 838 */       Data _o_ = (Data)_o1_;
/* 839 */       if (!this.type2awardcontent.equals(_o_.type2awardcontent)) return false;
/* 840 */       if (!this.type2awarddata.equals(_o_.type2awarddata)) return false;
/* 841 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 847 */       int _h_ = 0;
/* 848 */       _h_ += this.type2awardcontent.hashCode();
/* 849 */       _h_ += this.type2awarddata.hashCode();
/* 850 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 856 */       StringBuilder _sb_ = new StringBuilder();
/* 857 */       _sb_.append("(");
/* 858 */       _sb_.append(this.type2awardcontent);
/* 859 */       _sb_.append(",");
/* 860 */       _sb_.append(this.type2awarddata);
/* 861 */       _sb_.append(")");
/* 862 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\XAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
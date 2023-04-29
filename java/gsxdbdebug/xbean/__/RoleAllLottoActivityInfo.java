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
/*     */ public final class RoleAllLottoActivityInfo extends xdb.XBean implements xbean.RoleAllLottoActivityInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.RoleAllLottoWarmUpInfo> warm_up_infos;
/*     */   private HashMap<Integer, xbean.RoleAllLottoTurnInfo> turn_infos;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.warm_up_infos.clear();
/*  21 */     this.turn_infos.clear();
/*     */   }
/*     */   
/*     */   RoleAllLottoActivityInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.warm_up_infos = new HashMap();
/*  28 */     this.turn_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public RoleAllLottoActivityInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleAllLottoActivityInfo(RoleAllLottoActivityInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleAllLottoActivityInfo(xbean.RoleAllLottoActivityInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof RoleAllLottoActivityInfo)) { assign((RoleAllLottoActivityInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleAllLottoActivityInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.warm_up_infos = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.RoleAllLottoWarmUpInfo> _e_ : _o_.warm_up_infos.entrySet())
/*  55 */       this.warm_up_infos.put(_e_.getKey(), new RoleAllLottoWarmUpInfo((xbean.RoleAllLottoWarmUpInfo)_e_.getValue(), this, "warm_up_infos"));
/*  56 */     this.turn_infos = new HashMap();
/*  57 */     for (Map.Entry<Integer, xbean.RoleAllLottoTurnInfo> _e_ : _o_.turn_infos.entrySet()) {
/*  58 */       this.turn_infos.put(_e_.getKey(), new RoleAllLottoTurnInfo((xbean.RoleAllLottoTurnInfo)_e_.getValue(), this, "turn_infos"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  63 */     this.warm_up_infos = new HashMap();
/*  64 */     for (Map.Entry<Integer, xbean.RoleAllLottoWarmUpInfo> _e_ : _o_.warm_up_infos.entrySet())
/*  65 */       this.warm_up_infos.put(_e_.getKey(), new RoleAllLottoWarmUpInfo((xbean.RoleAllLottoWarmUpInfo)_e_.getValue(), this, "warm_up_infos"));
/*  66 */     this.turn_infos = new HashMap();
/*  67 */     for (Map.Entry<Integer, xbean.RoleAllLottoTurnInfo> _e_ : _o_.turn_infos.entrySet()) {
/*  68 */       this.turn_infos.put(_e_.getKey(), new RoleAllLottoTurnInfo((xbean.RoleAllLottoTurnInfo)_e_.getValue(), this, "turn_infos"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.warm_up_infos.size());
/*  76 */     for (Map.Entry<Integer, xbean.RoleAllLottoWarmUpInfo> _e_ : this.warm_up_infos.entrySet())
/*     */     {
/*  78 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  79 */       ((xbean.RoleAllLottoWarmUpInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  81 */     _os_.compact_uint32(this.turn_infos.size());
/*  82 */     for (Map.Entry<Integer, xbean.RoleAllLottoTurnInfo> _e_ : this.turn_infos.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  85 */       ((xbean.RoleAllLottoTurnInfo)_e_.getValue()).marshal(_os_);
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
/*  98 */       this.warm_up_infos = new HashMap(size * 2);
/*     */     }
/* 100 */     for (; size > 0; size--)
/*     */     {
/* 102 */       int _k_ = 0;
/* 103 */       _k_ = _os_.unmarshal_int();
/* 104 */       xbean.RoleAllLottoWarmUpInfo _v_ = new RoleAllLottoWarmUpInfo(0, this, "warm_up_infos");
/* 105 */       _v_.unmarshal(_os_);
/* 106 */       this.warm_up_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*     */ 
/* 110 */     int size = _os_.uncompact_uint32();
/* 111 */     if (size >= 12)
/*     */     {
/* 113 */       this.turn_infos = new HashMap(size * 2);
/*     */     }
/* 115 */     for (; size > 0; size--)
/*     */     {
/* 117 */       int _k_ = 0;
/* 118 */       _k_ = _os_.unmarshal_int();
/* 119 */       xbean.RoleAllLottoTurnInfo _v_ = new RoleAllLottoTurnInfo(0, this, "turn_infos");
/* 120 */       _v_.unmarshal(_os_);
/* 121 */       this.turn_infos.put(Integer.valueOf(_k_), _v_);
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
/* 132 */     for (Map.Entry<Integer, xbean.RoleAllLottoWarmUpInfo> _e_ : this.warm_up_infos.entrySet())
/*     */     {
/* 134 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 135 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*     */     }
/* 137 */     for (Map.Entry<Integer, xbean.RoleAllLottoTurnInfo> _e_ : this.turn_infos.entrySet())
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
/* 151 */       for (Map.Entry<Integer, xbean.RoleAllLottoWarmUpInfo> _e_ : this.warm_up_infos.entrySet())
/*     */       {
/* 153 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 154 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*     */       }
/* 156 */       for (Map.Entry<Integer, xbean.RoleAllLottoTurnInfo> _e_ : this.turn_infos.entrySet())
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
/* 195 */           xbean.RoleAllLottoWarmUpInfo _v_ = new RoleAllLottoWarmUpInfo(0, this, "warm_up_infos");
/* 196 */           _input_.readMessage(_v_);
/* 197 */           this.warm_up_infos.put(Integer.valueOf(_k_), _v_);
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
/* 209 */           xbean.RoleAllLottoTurnInfo _v_ = new RoleAllLottoTurnInfo(0, this, "turn_infos");
/* 210 */           _input_.readMessage(_v_);
/* 211 */           this.turn_infos.put(Integer.valueOf(_k_), _v_);
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
/*     */   public xbean.RoleAllLottoActivityInfo copy()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new RoleAllLottoActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleAllLottoActivityInfo toData()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleAllLottoActivityInfo toBean()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new RoleAllLottoActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleAllLottoActivityInfo toDataIf()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleAllLottoActivityInfo toBeanIf()
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
/*     */   public Map<Integer, xbean.RoleAllLottoWarmUpInfo> getWarm_up_infos()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return xdb.Logs.logMap(new xdb.LogKey(this, "warm_up_infos"), this.warm_up_infos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.RoleAllLottoWarmUpInfo> getWarm_up_infosAsData()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/*     */     
/* 290 */     RoleAllLottoActivityInfo _o_ = this;
/* 291 */     Map<Integer, xbean.RoleAllLottoWarmUpInfo> warm_up_infos = new HashMap();
/* 292 */     for (Map.Entry<Integer, xbean.RoleAllLottoWarmUpInfo> _e_ : _o_.warm_up_infos.entrySet())
/* 293 */       warm_up_infos.put(_e_.getKey(), new RoleAllLottoWarmUpInfo.Data((xbean.RoleAllLottoWarmUpInfo)_e_.getValue()));
/* 294 */     return warm_up_infos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.RoleAllLottoTurnInfo> getTurn_infos()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     return xdb.Logs.logMap(new xdb.LogKey(this, "turn_infos"), this.turn_infos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.RoleAllLottoTurnInfo> getTurn_infosAsData()
/*     */   {
/* 309 */     _xdb_verify_unsafe_();
/*     */     
/* 311 */     RoleAllLottoActivityInfo _o_ = this;
/* 312 */     Map<Integer, xbean.RoleAllLottoTurnInfo> turn_infos = new HashMap();
/* 313 */     for (Map.Entry<Integer, xbean.RoleAllLottoTurnInfo> _e_ : _o_.turn_infos.entrySet())
/* 314 */       turn_infos.put(_e_.getKey(), new RoleAllLottoTurnInfo.Data((xbean.RoleAllLottoTurnInfo)_e_.getValue()));
/* 315 */     return turn_infos;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     RoleAllLottoActivityInfo _o_ = null;
/* 323 */     if ((_o1_ instanceof RoleAllLottoActivityInfo)) { _o_ = (RoleAllLottoActivityInfo)_o1_;
/* 324 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 325 */       return false;
/* 326 */     if (!this.warm_up_infos.equals(_o_.warm_up_infos)) return false;
/* 327 */     if (!this.turn_infos.equals(_o_.turn_infos)) return false;
/* 328 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 334 */     _xdb_verify_unsafe_();
/* 335 */     int _h_ = 0;
/* 336 */     _h_ += this.warm_up_infos.hashCode();
/* 337 */     _h_ += this.turn_infos.hashCode();
/* 338 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     StringBuilder _sb_ = new StringBuilder();
/* 346 */     _sb_.append("(");
/* 347 */     _sb_.append(this.warm_up_infos);
/* 348 */     _sb_.append(",");
/* 349 */     _sb_.append(this.turn_infos);
/* 350 */     _sb_.append(")");
/* 351 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 357 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 358 */     lb.add(new xdb.logs.ListenableMap().setVarName("warm_up_infos"));
/* 359 */     lb.add(new xdb.logs.ListenableMap().setVarName("turn_infos"));
/* 360 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleAllLottoActivityInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleAllLottoActivityInfo nThis() {
/* 367 */       return RoleAllLottoActivityInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 373 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleAllLottoActivityInfo copy()
/*     */     {
/* 379 */       return RoleAllLottoActivityInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleAllLottoActivityInfo toData()
/*     */     {
/* 385 */       return RoleAllLottoActivityInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleAllLottoActivityInfo toBean()
/*     */     {
/* 390 */       return RoleAllLottoActivityInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleAllLottoActivityInfo toDataIf()
/*     */     {
/* 396 */       return RoleAllLottoActivityInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleAllLottoActivityInfo toBeanIf()
/*     */     {
/* 401 */       return RoleAllLottoActivityInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleAllLottoWarmUpInfo> getWarm_up_infos()
/*     */     {
/* 408 */       RoleAllLottoActivityInfo.this._xdb_verify_unsafe_();
/* 409 */       return xdb.Consts.constMap(RoleAllLottoActivityInfo.this.warm_up_infos);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleAllLottoWarmUpInfo> getWarm_up_infosAsData()
/*     */     {
/* 416 */       RoleAllLottoActivityInfo.this._xdb_verify_unsafe_();
/*     */       
/* 418 */       RoleAllLottoActivityInfo _o_ = RoleAllLottoActivityInfo.this;
/* 419 */       Map<Integer, xbean.RoleAllLottoWarmUpInfo> warm_up_infos = new HashMap();
/* 420 */       for (Map.Entry<Integer, xbean.RoleAllLottoWarmUpInfo> _e_ : _o_.warm_up_infos.entrySet())
/* 421 */         warm_up_infos.put(_e_.getKey(), new RoleAllLottoWarmUpInfo.Data((xbean.RoleAllLottoWarmUpInfo)_e_.getValue()));
/* 422 */       return warm_up_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleAllLottoTurnInfo> getTurn_infos()
/*     */     {
/* 429 */       RoleAllLottoActivityInfo.this._xdb_verify_unsafe_();
/* 430 */       return xdb.Consts.constMap(RoleAllLottoActivityInfo.this.turn_infos);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleAllLottoTurnInfo> getTurn_infosAsData()
/*     */     {
/* 437 */       RoleAllLottoActivityInfo.this._xdb_verify_unsafe_();
/*     */       
/* 439 */       RoleAllLottoActivityInfo _o_ = RoleAllLottoActivityInfo.this;
/* 440 */       Map<Integer, xbean.RoleAllLottoTurnInfo> turn_infos = new HashMap();
/* 441 */       for (Map.Entry<Integer, xbean.RoleAllLottoTurnInfo> _e_ : _o_.turn_infos.entrySet())
/* 442 */         turn_infos.put(_e_.getKey(), new RoleAllLottoTurnInfo.Data((xbean.RoleAllLottoTurnInfo)_e_.getValue()));
/* 443 */       return turn_infos;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 449 */       RoleAllLottoActivityInfo.this._xdb_verify_unsafe_();
/* 450 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 456 */       RoleAllLottoActivityInfo.this._xdb_verify_unsafe_();
/* 457 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 463 */       return RoleAllLottoActivityInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 469 */       return RoleAllLottoActivityInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 475 */       RoleAllLottoActivityInfo.this._xdb_verify_unsafe_();
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 482 */       return RoleAllLottoActivityInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 488 */       return RoleAllLottoActivityInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 494 */       RoleAllLottoActivityInfo.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 501 */       return RoleAllLottoActivityInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 507 */       return RoleAllLottoActivityInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 513 */       return RoleAllLottoActivityInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 519 */       return RoleAllLottoActivityInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 525 */       return RoleAllLottoActivityInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 531 */       return RoleAllLottoActivityInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 537 */       return RoleAllLottoActivityInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleAllLottoActivityInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.RoleAllLottoWarmUpInfo> warm_up_infos;
/*     */     
/*     */     private HashMap<Integer, xbean.RoleAllLottoTurnInfo> turn_infos;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 556 */       this.warm_up_infos = new HashMap();
/* 557 */       this.turn_infos = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleAllLottoActivityInfo _o1_)
/*     */     {
/* 562 */       if ((_o1_ instanceof RoleAllLottoActivityInfo)) { assign((RoleAllLottoActivityInfo)_o1_);
/* 563 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 564 */       } else if ((_o1_ instanceof RoleAllLottoActivityInfo.Const)) assign(((RoleAllLottoActivityInfo.Const)_o1_).nThis()); else {
/* 565 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleAllLottoActivityInfo _o_) {
/* 570 */       this.warm_up_infos = new HashMap();
/* 571 */       for (Map.Entry<Integer, xbean.RoleAllLottoWarmUpInfo> _e_ : _o_.warm_up_infos.entrySet())
/* 572 */         this.warm_up_infos.put(_e_.getKey(), new RoleAllLottoWarmUpInfo.Data((xbean.RoleAllLottoWarmUpInfo)_e_.getValue()));
/* 573 */       this.turn_infos = new HashMap();
/* 574 */       for (Map.Entry<Integer, xbean.RoleAllLottoTurnInfo> _e_ : _o_.turn_infos.entrySet()) {
/* 575 */         this.turn_infos.put(_e_.getKey(), new RoleAllLottoTurnInfo.Data((xbean.RoleAllLottoTurnInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 580 */       this.warm_up_infos = new HashMap();
/* 581 */       for (Map.Entry<Integer, xbean.RoleAllLottoWarmUpInfo> _e_ : _o_.warm_up_infos.entrySet())
/* 582 */         this.warm_up_infos.put(_e_.getKey(), new RoleAllLottoWarmUpInfo.Data((xbean.RoleAllLottoWarmUpInfo)_e_.getValue()));
/* 583 */       this.turn_infos = new HashMap();
/* 584 */       for (Map.Entry<Integer, xbean.RoleAllLottoTurnInfo> _e_ : _o_.turn_infos.entrySet()) {
/* 585 */         this.turn_infos.put(_e_.getKey(), new RoleAllLottoTurnInfo.Data((xbean.RoleAllLottoTurnInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 591 */       _os_.compact_uint32(this.warm_up_infos.size());
/* 592 */       for (Map.Entry<Integer, xbean.RoleAllLottoWarmUpInfo> _e_ : this.warm_up_infos.entrySet())
/*     */       {
/* 594 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 595 */         ((xbean.RoleAllLottoWarmUpInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 597 */       _os_.compact_uint32(this.turn_infos.size());
/* 598 */       for (Map.Entry<Integer, xbean.RoleAllLottoTurnInfo> _e_ : this.turn_infos.entrySet())
/*     */       {
/* 600 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 601 */         ((xbean.RoleAllLottoTurnInfo)_e_.getValue()).marshal(_os_);
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
/* 613 */         this.warm_up_infos = new HashMap(size * 2);
/*     */       }
/* 615 */       for (; size > 0; size--)
/*     */       {
/* 617 */         int _k_ = 0;
/* 618 */         _k_ = _os_.unmarshal_int();
/* 619 */         xbean.RoleAllLottoWarmUpInfo _v_ = xbean.Pod.newRoleAllLottoWarmUpInfoData();
/* 620 */         _v_.unmarshal(_os_);
/* 621 */         this.warm_up_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/*     */ 
/* 625 */       int size = _os_.uncompact_uint32();
/* 626 */       if (size >= 12)
/*     */       {
/* 628 */         this.turn_infos = new HashMap(size * 2);
/*     */       }
/* 630 */       for (; size > 0; size--)
/*     */       {
/* 632 */         int _k_ = 0;
/* 633 */         _k_ = _os_.unmarshal_int();
/* 634 */         xbean.RoleAllLottoTurnInfo _v_ = xbean.Pod.newRoleAllLottoTurnInfoData();
/* 635 */         _v_.unmarshal(_os_);
/* 636 */         this.turn_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 639 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 645 */       int _size_ = 0;
/* 646 */       for (Map.Entry<Integer, xbean.RoleAllLottoWarmUpInfo> _e_ : this.warm_up_infos.entrySet())
/*     */       {
/* 648 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 649 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*     */       }
/* 651 */       for (Map.Entry<Integer, xbean.RoleAllLottoTurnInfo> _e_ : this.turn_infos.entrySet())
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
/* 664 */         for (Map.Entry<Integer, xbean.RoleAllLottoWarmUpInfo> _e_ : this.warm_up_infos.entrySet())
/*     */         {
/* 666 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 667 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*     */         }
/* 669 */         for (Map.Entry<Integer, xbean.RoleAllLottoTurnInfo> _e_ : this.turn_infos.entrySet())
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
/* 707 */             xbean.RoleAllLottoWarmUpInfo _v_ = xbean.Pod.newRoleAllLottoWarmUpInfoData();
/* 708 */             _input_.readMessage(_v_);
/* 709 */             this.warm_up_infos.put(Integer.valueOf(_k_), _v_);
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
/* 721 */             xbean.RoleAllLottoTurnInfo _v_ = xbean.Pod.newRoleAllLottoTurnInfoData();
/* 722 */             _input_.readMessage(_v_);
/* 723 */             this.turn_infos.put(Integer.valueOf(_k_), _v_);
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
/*     */     public xbean.RoleAllLottoActivityInfo copy()
/*     */     {
/* 751 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleAllLottoActivityInfo toData()
/*     */     {
/* 757 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleAllLottoActivityInfo toBean()
/*     */     {
/* 762 */       return new RoleAllLottoActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleAllLottoActivityInfo toDataIf()
/*     */     {
/* 768 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleAllLottoActivityInfo toBeanIf()
/*     */     {
/* 773 */       return new RoleAllLottoActivityInfo(this, null, null);
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
/*     */     public Map<Integer, xbean.RoleAllLottoWarmUpInfo> getWarm_up_infos()
/*     */     {
/* 810 */       return this.warm_up_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleAllLottoWarmUpInfo> getWarm_up_infosAsData()
/*     */     {
/* 817 */       return this.warm_up_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleAllLottoTurnInfo> getTurn_infos()
/*     */     {
/* 824 */       return this.turn_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleAllLottoTurnInfo> getTurn_infosAsData()
/*     */     {
/* 831 */       return this.turn_infos;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 837 */       if (!(_o1_ instanceof Data)) return false;
/* 838 */       Data _o_ = (Data)_o1_;
/* 839 */       if (!this.warm_up_infos.equals(_o_.warm_up_infos)) return false;
/* 840 */       if (!this.turn_infos.equals(_o_.turn_infos)) return false;
/* 841 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 847 */       int _h_ = 0;
/* 848 */       _h_ += this.warm_up_infos.hashCode();
/* 849 */       _h_ += this.turn_infos.hashCode();
/* 850 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 856 */       StringBuilder _sb_ = new StringBuilder();
/* 857 */       _sb_.append("(");
/* 858 */       _sb_.append(this.warm_up_infos);
/* 859 */       _sb_.append(",");
/* 860 */       _sb_.append(this.turn_infos);
/* 861 */       _sb_.append(")");
/* 862 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleAllLottoActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
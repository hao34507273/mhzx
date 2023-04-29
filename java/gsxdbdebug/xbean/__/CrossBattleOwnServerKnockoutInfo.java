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
/*     */ public final class CrossBattleOwnServerKnockoutInfo extends xdb.XBean implements xbean.CrossBattleOwnServerKnockoutInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.FightOwnServerStageInfo> fight_stage_info_map;
/*     */   private HashMap<Long, xbean.FightCorpsInfo> fight_corps_info_map;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.fight_stage_info_map.clear();
/*  21 */     this.fight_corps_info_map.clear();
/*     */   }
/*     */   
/*     */   CrossBattleOwnServerKnockoutInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.fight_stage_info_map = new HashMap();
/*  28 */     this.fight_corps_info_map = new HashMap();
/*     */   }
/*     */   
/*     */   public CrossBattleOwnServerKnockoutInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CrossBattleOwnServerKnockoutInfo(CrossBattleOwnServerKnockoutInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CrossBattleOwnServerKnockoutInfo(xbean.CrossBattleOwnServerKnockoutInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof CrossBattleOwnServerKnockoutInfo)) { assign((CrossBattleOwnServerKnockoutInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CrossBattleOwnServerKnockoutInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.fight_stage_info_map = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.FightOwnServerStageInfo> _e_ : _o_.fight_stage_info_map.entrySet())
/*  55 */       this.fight_stage_info_map.put(_e_.getKey(), new FightOwnServerStageInfo((xbean.FightOwnServerStageInfo)_e_.getValue(), this, "fight_stage_info_map"));
/*  56 */     this.fight_corps_info_map = new HashMap();
/*  57 */     for (Map.Entry<Long, xbean.FightCorpsInfo> _e_ : _o_.fight_corps_info_map.entrySet()) {
/*  58 */       this.fight_corps_info_map.put(_e_.getKey(), new FightCorpsInfo((xbean.FightCorpsInfo)_e_.getValue(), this, "fight_corps_info_map"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  63 */     this.fight_stage_info_map = new HashMap();
/*  64 */     for (Map.Entry<Integer, xbean.FightOwnServerStageInfo> _e_ : _o_.fight_stage_info_map.entrySet())
/*  65 */       this.fight_stage_info_map.put(_e_.getKey(), new FightOwnServerStageInfo((xbean.FightOwnServerStageInfo)_e_.getValue(), this, "fight_stage_info_map"));
/*  66 */     this.fight_corps_info_map = new HashMap();
/*  67 */     for (Map.Entry<Long, xbean.FightCorpsInfo> _e_ : _o_.fight_corps_info_map.entrySet()) {
/*  68 */       this.fight_corps_info_map.put(_e_.getKey(), new FightCorpsInfo((xbean.FightCorpsInfo)_e_.getValue(), this, "fight_corps_info_map"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.fight_stage_info_map.size());
/*  76 */     for (Map.Entry<Integer, xbean.FightOwnServerStageInfo> _e_ : this.fight_stage_info_map.entrySet())
/*     */     {
/*  78 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  79 */       ((xbean.FightOwnServerStageInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  81 */     _os_.compact_uint32(this.fight_corps_info_map.size());
/*  82 */     for (Map.Entry<Long, xbean.FightCorpsInfo> _e_ : this.fight_corps_info_map.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  85 */       ((xbean.FightCorpsInfo)_e_.getValue()).marshal(_os_);
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
/*  98 */       this.fight_stage_info_map = new HashMap(size * 2);
/*     */     }
/* 100 */     for (; size > 0; size--)
/*     */     {
/* 102 */       int _k_ = 0;
/* 103 */       _k_ = _os_.unmarshal_int();
/* 104 */       xbean.FightOwnServerStageInfo _v_ = new FightOwnServerStageInfo(0, this, "fight_stage_info_map");
/* 105 */       _v_.unmarshal(_os_);
/* 106 */       this.fight_stage_info_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*     */ 
/* 110 */     int size = _os_.uncompact_uint32();
/* 111 */     if (size >= 12)
/*     */     {
/* 113 */       this.fight_corps_info_map = new HashMap(size * 2);
/*     */     }
/* 115 */     for (; size > 0; size--)
/*     */     {
/* 117 */       long _k_ = 0L;
/* 118 */       _k_ = _os_.unmarshal_long();
/* 119 */       xbean.FightCorpsInfo _v_ = new FightCorpsInfo(0, this, "fight_corps_info_map");
/* 120 */       _v_.unmarshal(_os_);
/* 121 */       this.fight_corps_info_map.put(Long.valueOf(_k_), _v_);
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
/* 132 */     for (Map.Entry<Integer, xbean.FightOwnServerStageInfo> _e_ : this.fight_stage_info_map.entrySet())
/*     */     {
/* 134 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 135 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*     */     }
/* 137 */     for (Map.Entry<Long, xbean.FightCorpsInfo> _e_ : this.fight_corps_info_map.entrySet())
/*     */     {
/* 139 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
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
/* 151 */       for (Map.Entry<Integer, xbean.FightOwnServerStageInfo> _e_ : this.fight_stage_info_map.entrySet())
/*     */       {
/* 153 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 154 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*     */       }
/* 156 */       for (Map.Entry<Long, xbean.FightCorpsInfo> _e_ : this.fight_corps_info_map.entrySet())
/*     */       {
/* 158 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
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
/* 195 */           xbean.FightOwnServerStageInfo _v_ = new FightOwnServerStageInfo(0, this, "fight_stage_info_map");
/* 196 */           _input_.readMessage(_v_);
/* 197 */           this.fight_stage_info_map.put(Integer.valueOf(_k_), _v_);
/* 198 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 202 */           long _k_ = 0L;
/* 203 */           _k_ = _input_.readInt64();
/* 204 */           int readTag = _input_.readTag();
/* 205 */           if (18 != readTag)
/*     */           {
/* 207 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 209 */           xbean.FightCorpsInfo _v_ = new FightCorpsInfo(0, this, "fight_corps_info_map");
/* 210 */           _input_.readMessage(_v_);
/* 211 */           this.fight_corps_info_map.put(Long.valueOf(_k_), _v_);
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
/*     */   public xbean.CrossBattleOwnServerKnockoutInfo copy()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new CrossBattleOwnServerKnockoutInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossBattleOwnServerKnockoutInfo toData()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossBattleOwnServerKnockoutInfo toBean()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new CrossBattleOwnServerKnockoutInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossBattleOwnServerKnockoutInfo toDataIf()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossBattleOwnServerKnockoutInfo toBeanIf()
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
/*     */   public Map<Integer, xbean.FightOwnServerStageInfo> getFight_stage_info_map()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return xdb.Logs.logMap(new xdb.LogKey(this, "fight_stage_info_map"), this.fight_stage_info_map);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.FightOwnServerStageInfo> getFight_stage_info_mapAsData()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/*     */     
/* 290 */     CrossBattleOwnServerKnockoutInfo _o_ = this;
/* 291 */     Map<Integer, xbean.FightOwnServerStageInfo> fight_stage_info_map = new HashMap();
/* 292 */     for (Map.Entry<Integer, xbean.FightOwnServerStageInfo> _e_ : _o_.fight_stage_info_map.entrySet())
/* 293 */       fight_stage_info_map.put(_e_.getKey(), new FightOwnServerStageInfo.Data((xbean.FightOwnServerStageInfo)_e_.getValue()));
/* 294 */     return fight_stage_info_map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.FightCorpsInfo> getFight_corps_info_map()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     return xdb.Logs.logMap(new xdb.LogKey(this, "fight_corps_info_map"), this.fight_corps_info_map);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.FightCorpsInfo> getFight_corps_info_mapAsData()
/*     */   {
/* 309 */     _xdb_verify_unsafe_();
/*     */     
/* 311 */     CrossBattleOwnServerKnockoutInfo _o_ = this;
/* 312 */     Map<Long, xbean.FightCorpsInfo> fight_corps_info_map = new HashMap();
/* 313 */     for (Map.Entry<Long, xbean.FightCorpsInfo> _e_ : _o_.fight_corps_info_map.entrySet())
/* 314 */       fight_corps_info_map.put(_e_.getKey(), new FightCorpsInfo.Data((xbean.FightCorpsInfo)_e_.getValue()));
/* 315 */     return fight_corps_info_map;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     CrossBattleOwnServerKnockoutInfo _o_ = null;
/* 323 */     if ((_o1_ instanceof CrossBattleOwnServerKnockoutInfo)) { _o_ = (CrossBattleOwnServerKnockoutInfo)_o1_;
/* 324 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 325 */       return false;
/* 326 */     if (!this.fight_stage_info_map.equals(_o_.fight_stage_info_map)) return false;
/* 327 */     if (!this.fight_corps_info_map.equals(_o_.fight_corps_info_map)) return false;
/* 328 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 334 */     _xdb_verify_unsafe_();
/* 335 */     int _h_ = 0;
/* 336 */     _h_ += this.fight_stage_info_map.hashCode();
/* 337 */     _h_ += this.fight_corps_info_map.hashCode();
/* 338 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     StringBuilder _sb_ = new StringBuilder();
/* 346 */     _sb_.append("(");
/* 347 */     _sb_.append(this.fight_stage_info_map);
/* 348 */     _sb_.append(",");
/* 349 */     _sb_.append(this.fight_corps_info_map);
/* 350 */     _sb_.append(")");
/* 351 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 357 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 358 */     lb.add(new xdb.logs.ListenableMap().setVarName("fight_stage_info_map"));
/* 359 */     lb.add(new xdb.logs.ListenableMap().setVarName("fight_corps_info_map"));
/* 360 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CrossBattleOwnServerKnockoutInfo {
/*     */     private Const() {}
/*     */     
/*     */     CrossBattleOwnServerKnockoutInfo nThis() {
/* 367 */       return CrossBattleOwnServerKnockoutInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 373 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleOwnServerKnockoutInfo copy()
/*     */     {
/* 379 */       return CrossBattleOwnServerKnockoutInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleOwnServerKnockoutInfo toData()
/*     */     {
/* 385 */       return CrossBattleOwnServerKnockoutInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CrossBattleOwnServerKnockoutInfo toBean()
/*     */     {
/* 390 */       return CrossBattleOwnServerKnockoutInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleOwnServerKnockoutInfo toDataIf()
/*     */     {
/* 396 */       return CrossBattleOwnServerKnockoutInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CrossBattleOwnServerKnockoutInfo toBeanIf()
/*     */     {
/* 401 */       return CrossBattleOwnServerKnockoutInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FightOwnServerStageInfo> getFight_stage_info_map()
/*     */     {
/* 408 */       CrossBattleOwnServerKnockoutInfo.this._xdb_verify_unsafe_();
/* 409 */       return xdb.Consts.constMap(CrossBattleOwnServerKnockoutInfo.this.fight_stage_info_map);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FightOwnServerStageInfo> getFight_stage_info_mapAsData()
/*     */     {
/* 416 */       CrossBattleOwnServerKnockoutInfo.this._xdb_verify_unsafe_();
/*     */       
/* 418 */       CrossBattleOwnServerKnockoutInfo _o_ = CrossBattleOwnServerKnockoutInfo.this;
/* 419 */       Map<Integer, xbean.FightOwnServerStageInfo> fight_stage_info_map = new HashMap();
/* 420 */       for (Map.Entry<Integer, xbean.FightOwnServerStageInfo> _e_ : _o_.fight_stage_info_map.entrySet())
/* 421 */         fight_stage_info_map.put(_e_.getKey(), new FightOwnServerStageInfo.Data((xbean.FightOwnServerStageInfo)_e_.getValue()));
/* 422 */       return fight_stage_info_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.FightCorpsInfo> getFight_corps_info_map()
/*     */     {
/* 429 */       CrossBattleOwnServerKnockoutInfo.this._xdb_verify_unsafe_();
/* 430 */       return xdb.Consts.constMap(CrossBattleOwnServerKnockoutInfo.this.fight_corps_info_map);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.FightCorpsInfo> getFight_corps_info_mapAsData()
/*     */     {
/* 437 */       CrossBattleOwnServerKnockoutInfo.this._xdb_verify_unsafe_();
/*     */       
/* 439 */       CrossBattleOwnServerKnockoutInfo _o_ = CrossBattleOwnServerKnockoutInfo.this;
/* 440 */       Map<Long, xbean.FightCorpsInfo> fight_corps_info_map = new HashMap();
/* 441 */       for (Map.Entry<Long, xbean.FightCorpsInfo> _e_ : _o_.fight_corps_info_map.entrySet())
/* 442 */         fight_corps_info_map.put(_e_.getKey(), new FightCorpsInfo.Data((xbean.FightCorpsInfo)_e_.getValue()));
/* 443 */       return fight_corps_info_map;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 449 */       CrossBattleOwnServerKnockoutInfo.this._xdb_verify_unsafe_();
/* 450 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 456 */       CrossBattleOwnServerKnockoutInfo.this._xdb_verify_unsafe_();
/* 457 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 463 */       return CrossBattleOwnServerKnockoutInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 469 */       return CrossBattleOwnServerKnockoutInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 475 */       CrossBattleOwnServerKnockoutInfo.this._xdb_verify_unsafe_();
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 482 */       return CrossBattleOwnServerKnockoutInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 488 */       return CrossBattleOwnServerKnockoutInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 494 */       CrossBattleOwnServerKnockoutInfo.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 501 */       return CrossBattleOwnServerKnockoutInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 507 */       return CrossBattleOwnServerKnockoutInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 513 */       return CrossBattleOwnServerKnockoutInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 519 */       return CrossBattleOwnServerKnockoutInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 525 */       return CrossBattleOwnServerKnockoutInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 531 */       return CrossBattleOwnServerKnockoutInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 537 */       return CrossBattleOwnServerKnockoutInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CrossBattleOwnServerKnockoutInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.FightOwnServerStageInfo> fight_stage_info_map;
/*     */     
/*     */     private HashMap<Long, xbean.FightCorpsInfo> fight_corps_info_map;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 556 */       this.fight_stage_info_map = new HashMap();
/* 557 */       this.fight_corps_info_map = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.CrossBattleOwnServerKnockoutInfo _o1_)
/*     */     {
/* 562 */       if ((_o1_ instanceof CrossBattleOwnServerKnockoutInfo)) { assign((CrossBattleOwnServerKnockoutInfo)_o1_);
/* 563 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 564 */       } else if ((_o1_ instanceof CrossBattleOwnServerKnockoutInfo.Const)) assign(((CrossBattleOwnServerKnockoutInfo.Const)_o1_).nThis()); else {
/* 565 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CrossBattleOwnServerKnockoutInfo _o_) {
/* 570 */       this.fight_stage_info_map = new HashMap();
/* 571 */       for (Map.Entry<Integer, xbean.FightOwnServerStageInfo> _e_ : _o_.fight_stage_info_map.entrySet())
/* 572 */         this.fight_stage_info_map.put(_e_.getKey(), new FightOwnServerStageInfo.Data((xbean.FightOwnServerStageInfo)_e_.getValue()));
/* 573 */       this.fight_corps_info_map = new HashMap();
/* 574 */       for (Map.Entry<Long, xbean.FightCorpsInfo> _e_ : _o_.fight_corps_info_map.entrySet()) {
/* 575 */         this.fight_corps_info_map.put(_e_.getKey(), new FightCorpsInfo.Data((xbean.FightCorpsInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 580 */       this.fight_stage_info_map = new HashMap();
/* 581 */       for (Map.Entry<Integer, xbean.FightOwnServerStageInfo> _e_ : _o_.fight_stage_info_map.entrySet())
/* 582 */         this.fight_stage_info_map.put(_e_.getKey(), new FightOwnServerStageInfo.Data((xbean.FightOwnServerStageInfo)_e_.getValue()));
/* 583 */       this.fight_corps_info_map = new HashMap();
/* 584 */       for (Map.Entry<Long, xbean.FightCorpsInfo> _e_ : _o_.fight_corps_info_map.entrySet()) {
/* 585 */         this.fight_corps_info_map.put(_e_.getKey(), new FightCorpsInfo.Data((xbean.FightCorpsInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 591 */       _os_.compact_uint32(this.fight_stage_info_map.size());
/* 592 */       for (Map.Entry<Integer, xbean.FightOwnServerStageInfo> _e_ : this.fight_stage_info_map.entrySet())
/*     */       {
/* 594 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 595 */         ((xbean.FightOwnServerStageInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 597 */       _os_.compact_uint32(this.fight_corps_info_map.size());
/* 598 */       for (Map.Entry<Long, xbean.FightCorpsInfo> _e_ : this.fight_corps_info_map.entrySet())
/*     */       {
/* 600 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 601 */         ((xbean.FightCorpsInfo)_e_.getValue()).marshal(_os_);
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
/* 613 */         this.fight_stage_info_map = new HashMap(size * 2);
/*     */       }
/* 615 */       for (; size > 0; size--)
/*     */       {
/* 617 */         int _k_ = 0;
/* 618 */         _k_ = _os_.unmarshal_int();
/* 619 */         xbean.FightOwnServerStageInfo _v_ = xbean.Pod.newFightOwnServerStageInfoData();
/* 620 */         _v_.unmarshal(_os_);
/* 621 */         this.fight_stage_info_map.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/*     */ 
/* 625 */       int size = _os_.uncompact_uint32();
/* 626 */       if (size >= 12)
/*     */       {
/* 628 */         this.fight_corps_info_map = new HashMap(size * 2);
/*     */       }
/* 630 */       for (; size > 0; size--)
/*     */       {
/* 632 */         long _k_ = 0L;
/* 633 */         _k_ = _os_.unmarshal_long();
/* 634 */         xbean.FightCorpsInfo _v_ = xbean.Pod.newFightCorpsInfoData();
/* 635 */         _v_.unmarshal(_os_);
/* 636 */         this.fight_corps_info_map.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 639 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 645 */       int _size_ = 0;
/* 646 */       for (Map.Entry<Integer, xbean.FightOwnServerStageInfo> _e_ : this.fight_stage_info_map.entrySet())
/*     */       {
/* 648 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 649 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*     */       }
/* 651 */       for (Map.Entry<Long, xbean.FightCorpsInfo> _e_ : this.fight_corps_info_map.entrySet())
/*     */       {
/* 653 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
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
/* 664 */         for (Map.Entry<Integer, xbean.FightOwnServerStageInfo> _e_ : this.fight_stage_info_map.entrySet())
/*     */         {
/* 666 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 667 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*     */         }
/* 669 */         for (Map.Entry<Long, xbean.FightCorpsInfo> _e_ : this.fight_corps_info_map.entrySet())
/*     */         {
/* 671 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
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
/* 707 */             xbean.FightOwnServerStageInfo _v_ = xbean.Pod.newFightOwnServerStageInfoData();
/* 708 */             _input_.readMessage(_v_);
/* 709 */             this.fight_stage_info_map.put(Integer.valueOf(_k_), _v_);
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 714 */             long _k_ = 0L;
/* 715 */             _k_ = _input_.readInt64();
/* 716 */             int readTag = _input_.readTag();
/* 717 */             if (18 != readTag)
/*     */             {
/* 719 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 721 */             xbean.FightCorpsInfo _v_ = xbean.Pod.newFightCorpsInfoData();
/* 722 */             _input_.readMessage(_v_);
/* 723 */             this.fight_corps_info_map.put(Long.valueOf(_k_), _v_);
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
/*     */     public xbean.CrossBattleOwnServerKnockoutInfo copy()
/*     */     {
/* 751 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleOwnServerKnockoutInfo toData()
/*     */     {
/* 757 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CrossBattleOwnServerKnockoutInfo toBean()
/*     */     {
/* 762 */       return new CrossBattleOwnServerKnockoutInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleOwnServerKnockoutInfo toDataIf()
/*     */     {
/* 768 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CrossBattleOwnServerKnockoutInfo toBeanIf()
/*     */     {
/* 773 */       return new CrossBattleOwnServerKnockoutInfo(this, null, null);
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
/*     */     public Map<Integer, xbean.FightOwnServerStageInfo> getFight_stage_info_map()
/*     */     {
/* 810 */       return this.fight_stage_info_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FightOwnServerStageInfo> getFight_stage_info_mapAsData()
/*     */     {
/* 817 */       return this.fight_stage_info_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.FightCorpsInfo> getFight_corps_info_map()
/*     */     {
/* 824 */       return this.fight_corps_info_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.FightCorpsInfo> getFight_corps_info_mapAsData()
/*     */     {
/* 831 */       return this.fight_corps_info_map;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 837 */       if (!(_o1_ instanceof Data)) return false;
/* 838 */       Data _o_ = (Data)_o1_;
/* 839 */       if (!this.fight_stage_info_map.equals(_o_.fight_stage_info_map)) return false;
/* 840 */       if (!this.fight_corps_info_map.equals(_o_.fight_corps_info_map)) return false;
/* 841 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 847 */       int _h_ = 0;
/* 848 */       _h_ += this.fight_stage_info_map.hashCode();
/* 849 */       _h_ += this.fight_corps_info_map.hashCode();
/* 850 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 856 */       StringBuilder _sb_ = new StringBuilder();
/* 857 */       _sb_.append("(");
/* 858 */       _sb_.append(this.fight_stage_info_map);
/* 859 */       _sb_.append(",");
/* 860 */       _sb_.append(this.fight_corps_info_map);
/* 861 */       _sb_.append(")");
/* 862 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossBattleOwnServerKnockoutInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
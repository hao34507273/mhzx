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
/*     */ public final class CrossbattlePoint extends XBean implements xbean.CrossbattlePoint
/*     */ {
/*     */   private HashMap<Integer, xbean.CrossbattlePointRaceInfo> point_races;
/*     */   private int time_point_cfgid;
/*     */   private HashMap<Long, Integer> corps_result;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.point_races.clear();
/*  23 */     this.time_point_cfgid = 0;
/*  24 */     this.corps_result.clear();
/*     */   }
/*     */   
/*     */   CrossbattlePoint(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.point_races = new HashMap();
/*  31 */     this.corps_result = new HashMap();
/*     */   }
/*     */   
/*     */   public CrossbattlePoint()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CrossbattlePoint(CrossbattlePoint _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CrossbattlePoint(xbean.CrossbattlePoint _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof CrossbattlePoint)) { assign((CrossbattlePoint)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CrossbattlePoint _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.point_races = new HashMap();
/*  57 */     for (Map.Entry<Integer, xbean.CrossbattlePointRaceInfo> _e_ : _o_.point_races.entrySet())
/*  58 */       this.point_races.put(_e_.getKey(), new CrossbattlePointRaceInfo((xbean.CrossbattlePointRaceInfo)_e_.getValue(), this, "point_races"));
/*  59 */     this.time_point_cfgid = _o_.time_point_cfgid;
/*  60 */     this.corps_result = new HashMap();
/*  61 */     for (Map.Entry<Long, Integer> _e_ : _o_.corps_result.entrySet()) {
/*  62 */       this.corps_result.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  67 */     this.point_races = new HashMap();
/*  68 */     for (Map.Entry<Integer, xbean.CrossbattlePointRaceInfo> _e_ : _o_.point_races.entrySet())
/*  69 */       this.point_races.put(_e_.getKey(), new CrossbattlePointRaceInfo((xbean.CrossbattlePointRaceInfo)_e_.getValue(), this, "point_races"));
/*  70 */     this.time_point_cfgid = _o_.time_point_cfgid;
/*  71 */     this.corps_result = new HashMap();
/*  72 */     for (Map.Entry<Long, Integer> _e_ : _o_.corps_result.entrySet()) {
/*  73 */       this.corps_result.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.compact_uint32(this.point_races.size());
/*  81 */     for (Map.Entry<Integer, xbean.CrossbattlePointRaceInfo> _e_ : this.point_races.entrySet())
/*     */     {
/*  83 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  84 */       ((xbean.CrossbattlePointRaceInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  86 */     _os_.marshal(this.time_point_cfgid);
/*  87 */     _os_.compact_uint32(this.corps_result.size());
/*  88 */     for (Map.Entry<Long, Integer> _e_ : this.corps_result.entrySet())
/*     */     {
/*  90 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  91 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/*     */     
/* 101 */     int size = _os_.uncompact_uint32();
/* 102 */     if (size >= 12)
/*     */     {
/* 104 */       this.point_races = new HashMap(size * 2);
/*     */     }
/* 106 */     for (; size > 0; size--)
/*     */     {
/* 108 */       int _k_ = 0;
/* 109 */       _k_ = _os_.unmarshal_int();
/* 110 */       xbean.CrossbattlePointRaceInfo _v_ = new CrossbattlePointRaceInfo(0, this, "point_races");
/* 111 */       _v_.unmarshal(_os_);
/* 112 */       this.point_races.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 115 */     this.time_point_cfgid = _os_.unmarshal_int();
/*     */     
/* 117 */     int size = _os_.uncompact_uint32();
/* 118 */     if (size >= 12)
/*     */     {
/* 120 */       this.corps_result = new HashMap(size * 2);
/*     */     }
/* 122 */     for (; size > 0; size--)
/*     */     {
/* 124 */       long _k_ = 0L;
/* 125 */       _k_ = _os_.unmarshal_long();
/* 126 */       int _v_ = 0;
/* 127 */       _v_ = _os_.unmarshal_int();
/* 128 */       this.corps_result.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 131 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     int _size_ = 0;
/* 139 */     for (Map.Entry<Integer, xbean.CrossbattlePointRaceInfo> _e_ : this.point_races.entrySet())
/*     */     {
/* 141 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 142 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 144 */     _size_ += CodedOutputStream.computeInt32Size(2, this.time_point_cfgid);
/* 145 */     for (Map.Entry<Long, Integer> _e_ : this.corps_result.entrySet())
/*     */     {
/* 147 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 148 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 150 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 156 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 159 */       for (Map.Entry<Integer, xbean.CrossbattlePointRaceInfo> _e_ : this.point_races.entrySet())
/*     */       {
/* 161 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 162 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 164 */       _output_.writeInt32(2, this.time_point_cfgid);
/* 165 */       for (Map.Entry<Long, Integer> _e_ : this.corps_result.entrySet())
/*     */       {
/* 167 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 168 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 173 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 175 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 184 */       boolean done = false;
/* 185 */       while (!done)
/*     */       {
/* 187 */         int tag = _input_.readTag();
/* 188 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 192 */           done = true;
/* 193 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 197 */           int _k_ = 0;
/* 198 */           _k_ = _input_.readInt32();
/* 199 */           int readTag = _input_.readTag();
/* 200 */           if (10 != readTag)
/*     */           {
/* 202 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 204 */           xbean.CrossbattlePointRaceInfo _v_ = new CrossbattlePointRaceInfo(0, this, "point_races");
/* 205 */           _input_.readMessage(_v_);
/* 206 */           this.point_races.put(Integer.valueOf(_k_), _v_);
/* 207 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 211 */           this.time_point_cfgid = _input_.readInt32();
/* 212 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 216 */           long _k_ = 0L;
/* 217 */           _k_ = _input_.readInt64();
/* 218 */           int readTag = _input_.readTag();
/* 219 */           if (24 != readTag)
/*     */           {
/* 221 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 223 */           int _v_ = 0;
/* 224 */           _v_ = _input_.readInt32();
/* 225 */           this.corps_result.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 226 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 230 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 232 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 241 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 245 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 247 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossbattlePoint copy()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new CrossbattlePoint(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossbattlePoint toData()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossbattlePoint toBean()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return new CrossbattlePoint(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossbattlePoint toDataIf()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossbattlePoint toBeanIf()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 286 */     _xdb_verify_unsafe_();
/* 287 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.CrossbattlePointRaceInfo> getPoint_races()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     return xdb.Logs.logMap(new LogKey(this, "point_races"), this.point_races);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.CrossbattlePointRaceInfo> getPoint_racesAsData()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/*     */     
/* 304 */     CrossbattlePoint _o_ = this;
/* 305 */     Map<Integer, xbean.CrossbattlePointRaceInfo> point_races = new HashMap();
/* 306 */     for (Map.Entry<Integer, xbean.CrossbattlePointRaceInfo> _e_ : _o_.point_races.entrySet())
/* 307 */       point_races.put(_e_.getKey(), new CrossbattlePointRaceInfo.Data((xbean.CrossbattlePointRaceInfo)_e_.getValue()));
/* 308 */     return point_races;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTime_point_cfgid()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     return this.time_point_cfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getCorps_result()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     return xdb.Logs.logMap(new LogKey(this, "corps_result"), this.corps_result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getCorps_resultAsData()
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/*     */     
/* 333 */     CrossbattlePoint _o_ = this;
/* 334 */     Map<Long, Integer> corps_result = new HashMap();
/* 335 */     for (Map.Entry<Long, Integer> _e_ : _o_.corps_result.entrySet())
/* 336 */       corps_result.put(_e_.getKey(), _e_.getValue());
/* 337 */     return corps_result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTime_point_cfgid(int _v_)
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     xdb.Logs.logIf(new LogKey(this, "time_point_cfgid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 349 */         new xdb.logs.LogInt(this, CrossbattlePoint.this.time_point_cfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 353 */             CrossbattlePoint.this.time_point_cfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 357 */     });
/* 358 */     this.time_point_cfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     CrossbattlePoint _o_ = null;
/* 366 */     if ((_o1_ instanceof CrossbattlePoint)) { _o_ = (CrossbattlePoint)_o1_;
/* 367 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 368 */       return false;
/* 369 */     if (!this.point_races.equals(_o_.point_races)) return false;
/* 370 */     if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/* 371 */     if (!this.corps_result.equals(_o_.corps_result)) return false;
/* 372 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 378 */     _xdb_verify_unsafe_();
/* 379 */     int _h_ = 0;
/* 380 */     _h_ += this.point_races.hashCode();
/* 381 */     _h_ += this.time_point_cfgid;
/* 382 */     _h_ += this.corps_result.hashCode();
/* 383 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     StringBuilder _sb_ = new StringBuilder();
/* 391 */     _sb_.append("(");
/* 392 */     _sb_.append(this.point_races);
/* 393 */     _sb_.append(",");
/* 394 */     _sb_.append(this.time_point_cfgid);
/* 395 */     _sb_.append(",");
/* 396 */     _sb_.append(this.corps_result);
/* 397 */     _sb_.append(")");
/* 398 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 404 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 405 */     lb.add(new xdb.logs.ListenableMap().setVarName("point_races"));
/* 406 */     lb.add(new xdb.logs.ListenableChanged().setVarName("time_point_cfgid"));
/* 407 */     lb.add(new xdb.logs.ListenableMap().setVarName("corps_result"));
/* 408 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CrossbattlePoint {
/*     */     private Const() {}
/*     */     
/*     */     CrossbattlePoint nThis() {
/* 415 */       return CrossbattlePoint.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossbattlePoint copy()
/*     */     {
/* 427 */       return CrossbattlePoint.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossbattlePoint toData()
/*     */     {
/* 433 */       return CrossbattlePoint.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CrossbattlePoint toBean()
/*     */     {
/* 438 */       return CrossbattlePoint.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossbattlePoint toDataIf()
/*     */     {
/* 444 */       return CrossbattlePoint.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CrossbattlePoint toBeanIf()
/*     */     {
/* 449 */       return CrossbattlePoint.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.CrossbattlePointRaceInfo> getPoint_races()
/*     */     {
/* 456 */       CrossbattlePoint.this._xdb_verify_unsafe_();
/* 457 */       return xdb.Consts.constMap(CrossbattlePoint.this.point_races);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.CrossbattlePointRaceInfo> getPoint_racesAsData()
/*     */     {
/* 464 */       CrossbattlePoint.this._xdb_verify_unsafe_();
/*     */       
/* 466 */       CrossbattlePoint _o_ = CrossbattlePoint.this;
/* 467 */       Map<Integer, xbean.CrossbattlePointRaceInfo> point_races = new HashMap();
/* 468 */       for (Map.Entry<Integer, xbean.CrossbattlePointRaceInfo> _e_ : _o_.point_races.entrySet())
/* 469 */         point_races.put(_e_.getKey(), new CrossbattlePointRaceInfo.Data((xbean.CrossbattlePointRaceInfo)_e_.getValue()));
/* 470 */       return point_races;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTime_point_cfgid()
/*     */     {
/* 477 */       CrossbattlePoint.this._xdb_verify_unsafe_();
/* 478 */       return CrossbattlePoint.this.time_point_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getCorps_result()
/*     */     {
/* 485 */       CrossbattlePoint.this._xdb_verify_unsafe_();
/* 486 */       return xdb.Consts.constMap(CrossbattlePoint.this.corps_result);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getCorps_resultAsData()
/*     */     {
/* 493 */       CrossbattlePoint.this._xdb_verify_unsafe_();
/*     */       
/* 495 */       CrossbattlePoint _o_ = CrossbattlePoint.this;
/* 496 */       Map<Long, Integer> corps_result = new HashMap();
/* 497 */       for (Map.Entry<Long, Integer> _e_ : _o_.corps_result.entrySet())
/* 498 */         corps_result.put(_e_.getKey(), _e_.getValue());
/* 499 */       return corps_result;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTime_point_cfgid(int _v_)
/*     */     {
/* 506 */       CrossbattlePoint.this._xdb_verify_unsafe_();
/* 507 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 513 */       CrossbattlePoint.this._xdb_verify_unsafe_();
/* 514 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 520 */       CrossbattlePoint.this._xdb_verify_unsafe_();
/* 521 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 527 */       return CrossbattlePoint.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 533 */       return CrossbattlePoint.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 539 */       CrossbattlePoint.this._xdb_verify_unsafe_();
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 546 */       return CrossbattlePoint.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 552 */       return CrossbattlePoint.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 558 */       CrossbattlePoint.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 565 */       return CrossbattlePoint.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 571 */       return CrossbattlePoint.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 577 */       return CrossbattlePoint.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 583 */       return CrossbattlePoint.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 589 */       return CrossbattlePoint.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 595 */       return CrossbattlePoint.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 601 */       return CrossbattlePoint.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CrossbattlePoint
/*     */   {
/*     */     private HashMap<Integer, xbean.CrossbattlePointRaceInfo> point_races;
/*     */     
/*     */     private int time_point_cfgid;
/*     */     
/*     */     private HashMap<Long, Integer> corps_result;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 617 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 622 */       this.point_races = new HashMap();
/* 623 */       this.corps_result = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.CrossbattlePoint _o1_)
/*     */     {
/* 628 */       if ((_o1_ instanceof CrossbattlePoint)) { assign((CrossbattlePoint)_o1_);
/* 629 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 630 */       } else if ((_o1_ instanceof CrossbattlePoint.Const)) assign(((CrossbattlePoint.Const)_o1_).nThis()); else {
/* 631 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CrossbattlePoint _o_) {
/* 636 */       this.point_races = new HashMap();
/* 637 */       for (Map.Entry<Integer, xbean.CrossbattlePointRaceInfo> _e_ : _o_.point_races.entrySet())
/* 638 */         this.point_races.put(_e_.getKey(), new CrossbattlePointRaceInfo.Data((xbean.CrossbattlePointRaceInfo)_e_.getValue()));
/* 639 */       this.time_point_cfgid = _o_.time_point_cfgid;
/* 640 */       this.corps_result = new HashMap();
/* 641 */       for (Map.Entry<Long, Integer> _e_ : _o_.corps_result.entrySet()) {
/* 642 */         this.corps_result.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 647 */       this.point_races = new HashMap();
/* 648 */       for (Map.Entry<Integer, xbean.CrossbattlePointRaceInfo> _e_ : _o_.point_races.entrySet())
/* 649 */         this.point_races.put(_e_.getKey(), new CrossbattlePointRaceInfo.Data((xbean.CrossbattlePointRaceInfo)_e_.getValue()));
/* 650 */       this.time_point_cfgid = _o_.time_point_cfgid;
/* 651 */       this.corps_result = new HashMap();
/* 652 */       for (Map.Entry<Long, Integer> _e_ : _o_.corps_result.entrySet()) {
/* 653 */         this.corps_result.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 659 */       _os_.compact_uint32(this.point_races.size());
/* 660 */       for (Map.Entry<Integer, xbean.CrossbattlePointRaceInfo> _e_ : this.point_races.entrySet())
/*     */       {
/* 662 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 663 */         ((xbean.CrossbattlePointRaceInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 665 */       _os_.marshal(this.time_point_cfgid);
/* 666 */       _os_.compact_uint32(this.corps_result.size());
/* 667 */       for (Map.Entry<Long, Integer> _e_ : this.corps_result.entrySet())
/*     */       {
/* 669 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 670 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 672 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 679 */       int size = _os_.uncompact_uint32();
/* 680 */       if (size >= 12)
/*     */       {
/* 682 */         this.point_races = new HashMap(size * 2);
/*     */       }
/* 684 */       for (; size > 0; size--)
/*     */       {
/* 686 */         int _k_ = 0;
/* 687 */         _k_ = _os_.unmarshal_int();
/* 688 */         xbean.CrossbattlePointRaceInfo _v_ = xbean.Pod.newCrossbattlePointRaceInfoData();
/* 689 */         _v_.unmarshal(_os_);
/* 690 */         this.point_races.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 693 */       this.time_point_cfgid = _os_.unmarshal_int();
/*     */       
/* 695 */       int size = _os_.uncompact_uint32();
/* 696 */       if (size >= 12)
/*     */       {
/* 698 */         this.corps_result = new HashMap(size * 2);
/*     */       }
/* 700 */       for (; size > 0; size--)
/*     */       {
/* 702 */         long _k_ = 0L;
/* 703 */         _k_ = _os_.unmarshal_long();
/* 704 */         int _v_ = 0;
/* 705 */         _v_ = _os_.unmarshal_int();
/* 706 */         this.corps_result.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 709 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 715 */       int _size_ = 0;
/* 716 */       for (Map.Entry<Integer, xbean.CrossbattlePointRaceInfo> _e_ : this.point_races.entrySet())
/*     */       {
/* 718 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 719 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 721 */       _size_ += CodedOutputStream.computeInt32Size(2, this.time_point_cfgid);
/* 722 */       for (Map.Entry<Long, Integer> _e_ : this.corps_result.entrySet())
/*     */       {
/* 724 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 725 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 727 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 735 */         for (Map.Entry<Integer, xbean.CrossbattlePointRaceInfo> _e_ : this.point_races.entrySet())
/*     */         {
/* 737 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 738 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 740 */         _output_.writeInt32(2, this.time_point_cfgid);
/* 741 */         for (Map.Entry<Long, Integer> _e_ : this.corps_result.entrySet())
/*     */         {
/* 743 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 744 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 749 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 751 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 759 */         boolean done = false;
/* 760 */         while (!done)
/*     */         {
/* 762 */           int tag = _input_.readTag();
/* 763 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 767 */             done = true;
/* 768 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 772 */             int _k_ = 0;
/* 773 */             _k_ = _input_.readInt32();
/* 774 */             int readTag = _input_.readTag();
/* 775 */             if (10 != readTag)
/*     */             {
/* 777 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 779 */             xbean.CrossbattlePointRaceInfo _v_ = xbean.Pod.newCrossbattlePointRaceInfoData();
/* 780 */             _input_.readMessage(_v_);
/* 781 */             this.point_races.put(Integer.valueOf(_k_), _v_);
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 786 */             this.time_point_cfgid = _input_.readInt32();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 791 */             long _k_ = 0L;
/* 792 */             _k_ = _input_.readInt64();
/* 793 */             int readTag = _input_.readTag();
/* 794 */             if (24 != readTag)
/*     */             {
/* 796 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 798 */             int _v_ = 0;
/* 799 */             _v_ = _input_.readInt32();
/* 800 */             this.corps_result.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 801 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 805 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 807 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 816 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 820 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 822 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossbattlePoint copy()
/*     */     {
/* 828 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossbattlePoint toData()
/*     */     {
/* 834 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CrossbattlePoint toBean()
/*     */     {
/* 839 */       return new CrossbattlePoint(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossbattlePoint toDataIf()
/*     */     {
/* 845 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CrossbattlePoint toBeanIf()
/*     */     {
/* 850 */       return new CrossbattlePoint(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 856 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 868 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 872 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 876 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 880 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.CrossbattlePointRaceInfo> getPoint_races()
/*     */     {
/* 887 */       return this.point_races;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.CrossbattlePointRaceInfo> getPoint_racesAsData()
/*     */     {
/* 894 */       return this.point_races;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTime_point_cfgid()
/*     */     {
/* 901 */       return this.time_point_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getCorps_result()
/*     */     {
/* 908 */       return this.corps_result;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getCorps_resultAsData()
/*     */     {
/* 915 */       return this.corps_result;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTime_point_cfgid(int _v_)
/*     */     {
/* 922 */       this.time_point_cfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 928 */       if (!(_o1_ instanceof Data)) return false;
/* 929 */       Data _o_ = (Data)_o1_;
/* 930 */       if (!this.point_races.equals(_o_.point_races)) return false;
/* 931 */       if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/* 932 */       if (!this.corps_result.equals(_o_.corps_result)) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ += this.point_races.hashCode();
/* 941 */       _h_ += this.time_point_cfgid;
/* 942 */       _h_ += this.corps_result.hashCode();
/* 943 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 949 */       StringBuilder _sb_ = new StringBuilder();
/* 950 */       _sb_.append("(");
/* 951 */       _sb_.append(this.point_races);
/* 952 */       _sb_.append(",");
/* 953 */       _sb_.append(this.time_point_cfgid);
/* 954 */       _sb_.append(",");
/* 955 */       _sb_.append(this.corps_result);
/* 956 */       _sb_.append(")");
/* 957 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossbattlePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*     */ 
/*     */ public final class Role2NTimesAwardInfo extends xdb.XBean implements xbean.Role2NTimesAwardInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.IdipNTimesAwardInfo> n_times_award_role_map;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.n_times_award_role_map.clear();
/*     */   }
/*     */   
/*     */   Role2NTimesAwardInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.n_times_award_role_map = new HashMap();
/*     */   }
/*     */   
/*     */   public Role2NTimesAwardInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Role2NTimesAwardInfo(Role2NTimesAwardInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Role2NTimesAwardInfo(xbean.Role2NTimesAwardInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof Role2NTimesAwardInfo)) { assign((Role2NTimesAwardInfo)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Role2NTimesAwardInfo _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.n_times_award_role_map = new HashMap();
/*  50 */     for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : _o_.n_times_award_role_map.entrySet()) {
/*  51 */       this.n_times_award_role_map.put(_e_.getKey(), new IdipNTimesAwardInfo((xbean.IdipNTimesAwardInfo)_e_.getValue(), this, "n_times_award_role_map"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  56 */     this.n_times_award_role_map = new HashMap();
/*  57 */     for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : _o_.n_times_award_role_map.entrySet()) {
/*  58 */       this.n_times_award_role_map.put(_e_.getKey(), new IdipNTimesAwardInfo((xbean.IdipNTimesAwardInfo)_e_.getValue(), this, "n_times_award_role_map"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.compact_uint32(this.n_times_award_role_map.size());
/*  66 */     for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : this.n_times_award_role_map.entrySet())
/*     */     {
/*  68 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  69 */       ((xbean.IdipNTimesAwardInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*     */     
/*  79 */     int size = _os_.uncompact_uint32();
/*  80 */     if (size >= 12)
/*     */     {
/*  82 */       this.n_times_award_role_map = new HashMap(size * 2);
/*     */     }
/*  84 */     for (; size > 0; size--)
/*     */     {
/*  86 */       int _k_ = 0;
/*  87 */       _k_ = _os_.unmarshal_int();
/*  88 */       xbean.IdipNTimesAwardInfo _v_ = new IdipNTimesAwardInfo(0, this, "n_times_award_role_map");
/*  89 */       _v_.unmarshal(_os_);
/*  90 */       this.n_times_award_role_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     int _size_ = 0;
/* 101 */     for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : this.n_times_award_role_map.entrySet())
/*     */     {
/* 103 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 104 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 106 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 115 */       for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : this.n_times_award_role_map.entrySet())
/*     */       {
/* 117 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 118 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 123 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 125 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 131 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 134 */       boolean done = false;
/* 135 */       while (!done)
/*     */       {
/* 137 */         int tag = _input_.readTag();
/* 138 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 142 */           done = true;
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 147 */           int _k_ = 0;
/* 148 */           _k_ = _input_.readInt32();
/* 149 */           int readTag = _input_.readTag();
/* 150 */           if (10 != readTag)
/*     */           {
/* 152 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 154 */           xbean.IdipNTimesAwardInfo _v_ = new IdipNTimesAwardInfo(0, this, "n_times_award_role_map");
/* 155 */           _input_.readMessage(_v_);
/* 156 */           this.n_times_award_role_map.put(Integer.valueOf(_k_), _v_);
/* 157 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 161 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 163 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 172 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 176 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 178 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2NTimesAwardInfo copy()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Role2NTimesAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2NTimesAwardInfo toData()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2NTimesAwardInfo toBean()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new Role2NTimesAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2NTimesAwardInfo toDataIf()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2NTimesAwardInfo toBeanIf()
/*     */   {
/* 210 */     _xdb_verify_unsafe_();
/* 211 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.IdipNTimesAwardInfo> getN_times_award_role_map()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return xdb.Logs.logMap(new xdb.LogKey(this, "n_times_award_role_map"), this.n_times_award_role_map);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.IdipNTimesAwardInfo> getN_times_award_role_mapAsData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/*     */     
/* 235 */     Role2NTimesAwardInfo _o_ = this;
/* 236 */     Map<Integer, xbean.IdipNTimesAwardInfo> n_times_award_role_map = new HashMap();
/* 237 */     for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : _o_.n_times_award_role_map.entrySet())
/* 238 */       n_times_award_role_map.put(_e_.getKey(), new IdipNTimesAwardInfo.Data((xbean.IdipNTimesAwardInfo)_e_.getValue()));
/* 239 */     return n_times_award_role_map;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     Role2NTimesAwardInfo _o_ = null;
/* 247 */     if ((_o1_ instanceof Role2NTimesAwardInfo)) { _o_ = (Role2NTimesAwardInfo)_o1_;
/* 248 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 249 */       return false;
/* 250 */     if (!this.n_times_award_role_map.equals(_o_.n_times_award_role_map)) return false;
/* 251 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     int _h_ = 0;
/* 259 */     _h_ += this.n_times_award_role_map.hashCode();
/* 260 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     StringBuilder _sb_ = new StringBuilder();
/* 268 */     _sb_.append("(");
/* 269 */     _sb_.append(this.n_times_award_role_map);
/* 270 */     _sb_.append(")");
/* 271 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 277 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 278 */     lb.add(new xdb.logs.ListenableMap().setVarName("n_times_award_role_map"));
/* 279 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Role2NTimesAwardInfo {
/*     */     private Const() {}
/*     */     
/*     */     Role2NTimesAwardInfo nThis() {
/* 286 */       return Role2NTimesAwardInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 292 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2NTimesAwardInfo copy()
/*     */     {
/* 298 */       return Role2NTimesAwardInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2NTimesAwardInfo toData()
/*     */     {
/* 304 */       return Role2NTimesAwardInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Role2NTimesAwardInfo toBean()
/*     */     {
/* 309 */       return Role2NTimesAwardInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2NTimesAwardInfo toDataIf()
/*     */     {
/* 315 */       return Role2NTimesAwardInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Role2NTimesAwardInfo toBeanIf()
/*     */     {
/* 320 */       return Role2NTimesAwardInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.IdipNTimesAwardInfo> getN_times_award_role_map()
/*     */     {
/* 327 */       Role2NTimesAwardInfo.this._xdb_verify_unsafe_();
/* 328 */       return xdb.Consts.constMap(Role2NTimesAwardInfo.this.n_times_award_role_map);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.IdipNTimesAwardInfo> getN_times_award_role_mapAsData()
/*     */     {
/* 335 */       Role2NTimesAwardInfo.this._xdb_verify_unsafe_();
/*     */       
/* 337 */       Role2NTimesAwardInfo _o_ = Role2NTimesAwardInfo.this;
/* 338 */       Map<Integer, xbean.IdipNTimesAwardInfo> n_times_award_role_map = new HashMap();
/* 339 */       for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : _o_.n_times_award_role_map.entrySet())
/* 340 */         n_times_award_role_map.put(_e_.getKey(), new IdipNTimesAwardInfo.Data((xbean.IdipNTimesAwardInfo)_e_.getValue()));
/* 341 */       return n_times_award_role_map;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 347 */       Role2NTimesAwardInfo.this._xdb_verify_unsafe_();
/* 348 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 354 */       Role2NTimesAwardInfo.this._xdb_verify_unsafe_();
/* 355 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 361 */       return Role2NTimesAwardInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 367 */       return Role2NTimesAwardInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 373 */       Role2NTimesAwardInfo.this._xdb_verify_unsafe_();
/* 374 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 380 */       return Role2NTimesAwardInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 386 */       return Role2NTimesAwardInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 392 */       Role2NTimesAwardInfo.this._xdb_verify_unsafe_();
/* 393 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 399 */       return Role2NTimesAwardInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 405 */       return Role2NTimesAwardInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 411 */       return Role2NTimesAwardInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 417 */       return Role2NTimesAwardInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 423 */       return Role2NTimesAwardInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 429 */       return Role2NTimesAwardInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 435 */       return Role2NTimesAwardInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Role2NTimesAwardInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.IdipNTimesAwardInfo> n_times_award_role_map;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 447 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 452 */       this.n_times_award_role_map = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.Role2NTimesAwardInfo _o1_)
/*     */     {
/* 457 */       if ((_o1_ instanceof Role2NTimesAwardInfo)) { assign((Role2NTimesAwardInfo)_o1_);
/* 458 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 459 */       } else if ((_o1_ instanceof Role2NTimesAwardInfo.Const)) assign(((Role2NTimesAwardInfo.Const)_o1_).nThis()); else {
/* 460 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Role2NTimesAwardInfo _o_) {
/* 465 */       this.n_times_award_role_map = new HashMap();
/* 466 */       for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : _o_.n_times_award_role_map.entrySet()) {
/* 467 */         this.n_times_award_role_map.put(_e_.getKey(), new IdipNTimesAwardInfo.Data((xbean.IdipNTimesAwardInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 472 */       this.n_times_award_role_map = new HashMap();
/* 473 */       for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : _o_.n_times_award_role_map.entrySet()) {
/* 474 */         this.n_times_award_role_map.put(_e_.getKey(), new IdipNTimesAwardInfo.Data((xbean.IdipNTimesAwardInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 480 */       _os_.compact_uint32(this.n_times_award_role_map.size());
/* 481 */       for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : this.n_times_award_role_map.entrySet())
/*     */       {
/* 483 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 484 */         ((xbean.IdipNTimesAwardInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 486 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 493 */       int size = _os_.uncompact_uint32();
/* 494 */       if (size >= 12)
/*     */       {
/* 496 */         this.n_times_award_role_map = new HashMap(size * 2);
/*     */       }
/* 498 */       for (; size > 0; size--)
/*     */       {
/* 500 */         int _k_ = 0;
/* 501 */         _k_ = _os_.unmarshal_int();
/* 502 */         xbean.IdipNTimesAwardInfo _v_ = xbean.Pod.newIdipNTimesAwardInfoData();
/* 503 */         _v_.unmarshal(_os_);
/* 504 */         this.n_times_award_role_map.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 513 */       int _size_ = 0;
/* 514 */       for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : this.n_times_award_role_map.entrySet())
/*     */       {
/* 516 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 517 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 519 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 527 */         for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : this.n_times_award_role_map.entrySet())
/*     */         {
/* 529 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 530 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 535 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 537 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 545 */         boolean done = false;
/* 546 */         while (!done)
/*     */         {
/* 548 */           int tag = _input_.readTag();
/* 549 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 553 */             done = true;
/* 554 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 558 */             int _k_ = 0;
/* 559 */             _k_ = _input_.readInt32();
/* 560 */             int readTag = _input_.readTag();
/* 561 */             if (10 != readTag)
/*     */             {
/* 563 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 565 */             xbean.IdipNTimesAwardInfo _v_ = xbean.Pod.newIdipNTimesAwardInfoData();
/* 566 */             _input_.readMessage(_v_);
/* 567 */             this.n_times_award_role_map.put(Integer.valueOf(_k_), _v_);
/* 568 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 572 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 574 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 583 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 587 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 589 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2NTimesAwardInfo copy()
/*     */     {
/* 595 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2NTimesAwardInfo toData()
/*     */     {
/* 601 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Role2NTimesAwardInfo toBean()
/*     */     {
/* 606 */       return new Role2NTimesAwardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2NTimesAwardInfo toDataIf()
/*     */     {
/* 612 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Role2NTimesAwardInfo toBeanIf()
/*     */     {
/* 617 */       return new Role2NTimesAwardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 627 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 631 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 635 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 639 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 643 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 647 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.IdipNTimesAwardInfo> getN_times_award_role_map()
/*     */     {
/* 654 */       return this.n_times_award_role_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.IdipNTimesAwardInfo> getN_times_award_role_mapAsData()
/*     */     {
/* 661 */       return this.n_times_award_role_map;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 667 */       if (!(_o1_ instanceof Data)) return false;
/* 668 */       Data _o_ = (Data)_o1_;
/* 669 */       if (!this.n_times_award_role_map.equals(_o_.n_times_award_role_map)) return false;
/* 670 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 676 */       int _h_ = 0;
/* 677 */       _h_ += this.n_times_award_role_map.hashCode();
/* 678 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 684 */       StringBuilder _sb_ = new StringBuilder();
/* 685 */       _sb_.append("(");
/* 686 */       _sb_.append(this.n_times_award_role_map);
/* 687 */       _sb_.append(")");
/* 688 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2NTimesAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
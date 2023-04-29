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
/*     */ public final class Role2PetMarkInfo extends XBean implements xbean.Role2PetMarkInfo
/*     */ {
/*     */   private long next_pet_mark_id;
/*     */   private HashMap<Long, xbean.PetMarkInfo> petmarkid2info;
/*     */   private HashMap<Long, Long> petid2petmarkid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.next_pet_mark_id = 1L;
/*  23 */     this.petmarkid2info.clear();
/*  24 */     this.petid2petmarkid.clear();
/*     */   }
/*     */   
/*     */   Role2PetMarkInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.next_pet_mark_id = 1L;
/*  31 */     this.petmarkid2info = new HashMap();
/*  32 */     this.petid2petmarkid = new HashMap();
/*     */   }
/*     */   
/*     */   public Role2PetMarkInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Role2PetMarkInfo(Role2PetMarkInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Role2PetMarkInfo(xbean.Role2PetMarkInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof Role2PetMarkInfo)) { assign((Role2PetMarkInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Role2PetMarkInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.next_pet_mark_id = _o_.next_pet_mark_id;
/*  58 */     this.petmarkid2info = new HashMap();
/*  59 */     for (Map.Entry<Long, xbean.PetMarkInfo> _e_ : _o_.petmarkid2info.entrySet())
/*  60 */       this.petmarkid2info.put(_e_.getKey(), new PetMarkInfo((xbean.PetMarkInfo)_e_.getValue(), this, "petmarkid2info"));
/*  61 */     this.petid2petmarkid = new HashMap();
/*  62 */     for (Map.Entry<Long, Long> _e_ : _o_.petid2petmarkid.entrySet()) {
/*  63 */       this.petid2petmarkid.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  68 */     this.next_pet_mark_id = _o_.next_pet_mark_id;
/*  69 */     this.petmarkid2info = new HashMap();
/*  70 */     for (Map.Entry<Long, xbean.PetMarkInfo> _e_ : _o_.petmarkid2info.entrySet())
/*  71 */       this.petmarkid2info.put(_e_.getKey(), new PetMarkInfo((xbean.PetMarkInfo)_e_.getValue(), this, "petmarkid2info"));
/*  72 */     this.petid2petmarkid = new HashMap();
/*  73 */     for (Map.Entry<Long, Long> _e_ : _o_.petid2petmarkid.entrySet()) {
/*  74 */       this.petid2petmarkid.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     _os_.marshal(this.next_pet_mark_id);
/*  82 */     _os_.compact_uint32(this.petmarkid2info.size());
/*  83 */     for (Map.Entry<Long, xbean.PetMarkInfo> _e_ : this.petmarkid2info.entrySet())
/*     */     {
/*  85 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  86 */       ((xbean.PetMarkInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  88 */     _os_.compact_uint32(this.petid2petmarkid.size());
/*  89 */     for (Map.Entry<Long, Long> _e_ : this.petid2petmarkid.entrySet())
/*     */     {
/*  91 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  92 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     this.next_pet_mark_id = _os_.unmarshal_long();
/*     */     
/* 103 */     int size = _os_.uncompact_uint32();
/* 104 */     if (size >= 12)
/*     */     {
/* 106 */       this.petmarkid2info = new HashMap(size * 2);
/*     */     }
/* 108 */     for (; size > 0; size--)
/*     */     {
/* 110 */       long _k_ = 0L;
/* 111 */       _k_ = _os_.unmarshal_long();
/* 112 */       xbean.PetMarkInfo _v_ = new PetMarkInfo(0, this, "petmarkid2info");
/* 113 */       _v_.unmarshal(_os_);
/* 114 */       this.petmarkid2info.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*     */ 
/* 118 */     int size = _os_.uncompact_uint32();
/* 119 */     if (size >= 12)
/*     */     {
/* 121 */       this.petid2petmarkid = new HashMap(size * 2);
/*     */     }
/* 123 */     for (; size > 0; size--)
/*     */     {
/* 125 */       long _k_ = 0L;
/* 126 */       _k_ = _os_.unmarshal_long();
/* 127 */       long _v_ = 0L;
/* 128 */       _v_ = _os_.unmarshal_long();
/* 129 */       this.petid2petmarkid.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*     */     
/* 132 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 138 */     _xdb_verify_unsafe_();
/* 139 */     int _size_ = 0;
/* 140 */     _size_ += CodedOutputStream.computeInt64Size(1, this.next_pet_mark_id);
/* 141 */     for (Map.Entry<Long, xbean.PetMarkInfo> _e_ : this.petmarkid2info.entrySet())
/*     */     {
/* 143 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 144 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 146 */     for (Map.Entry<Long, Long> _e_ : this.petid2petmarkid.entrySet())
/*     */     {
/* 148 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 149 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getValue()).longValue());
/*     */     }
/* 151 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 160 */       _output_.writeInt64(1, this.next_pet_mark_id);
/* 161 */       for (Map.Entry<Long, xbean.PetMarkInfo> _e_ : this.petmarkid2info.entrySet())
/*     */       {
/* 163 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 164 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 166 */       for (Map.Entry<Long, Long> _e_ : this.petid2petmarkid.entrySet())
/*     */       {
/* 168 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 169 */         _output_.writeInt64(3, ((Long)_e_.getValue()).longValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 174 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 176 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 182 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 185 */       boolean done = false;
/* 186 */       while (!done)
/*     */       {
/* 188 */         int tag = _input_.readTag();
/* 189 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 193 */           done = true;
/* 194 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 198 */           this.next_pet_mark_id = _input_.readInt64();
/* 199 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 203 */           long _k_ = 0L;
/* 204 */           _k_ = _input_.readInt64();
/* 205 */           int readTag = _input_.readTag();
/* 206 */           if (18 != readTag)
/*     */           {
/* 208 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 210 */           xbean.PetMarkInfo _v_ = new PetMarkInfo(0, this, "petmarkid2info");
/* 211 */           _input_.readMessage(_v_);
/* 212 */           this.petmarkid2info.put(Long.valueOf(_k_), _v_);
/* 213 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 217 */           long _k_ = 0L;
/* 218 */           _k_ = _input_.readInt64();
/* 219 */           int readTag = _input_.readTag();
/* 220 */           if (24 != readTag)
/*     */           {
/* 222 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 224 */           long _v_ = 0L;
/* 225 */           _v_ = _input_.readInt64();
/* 226 */           this.petid2petmarkid.put(Long.valueOf(_k_), Long.valueOf(_v_));
/* 227 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 231 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 233 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 242 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 246 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 248 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2PetMarkInfo copy()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return new Role2PetMarkInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2PetMarkInfo toData()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2PetMarkInfo toBean()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return new Role2PetMarkInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2PetMarkInfo toDataIf()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2PetMarkInfo toBeanIf()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 287 */     _xdb_verify_unsafe_();
/* 288 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getNext_pet_mark_id()
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     return this.next_pet_mark_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.PetMarkInfo> getPetmarkid2info()
/*     */   {
/* 303 */     _xdb_verify_unsafe_();
/* 304 */     return xdb.Logs.logMap(new LogKey(this, "petmarkid2info"), this.petmarkid2info);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.PetMarkInfo> getPetmarkid2infoAsData()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/*     */     
/* 313 */     Role2PetMarkInfo _o_ = this;
/* 314 */     Map<Long, xbean.PetMarkInfo> petmarkid2info = new HashMap();
/* 315 */     for (Map.Entry<Long, xbean.PetMarkInfo> _e_ : _o_.petmarkid2info.entrySet())
/* 316 */       petmarkid2info.put(_e_.getKey(), new PetMarkInfo.Data((xbean.PetMarkInfo)_e_.getValue()));
/* 317 */     return petmarkid2info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Long> getPetid2petmarkid()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     return xdb.Logs.logMap(new LogKey(this, "petid2petmarkid"), this.petid2petmarkid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Long> getPetid2petmarkidAsData()
/*     */   {
/* 332 */     _xdb_verify_unsafe_();
/*     */     
/* 334 */     Role2PetMarkInfo _o_ = this;
/* 335 */     Map<Long, Long> petid2petmarkid = new HashMap();
/* 336 */     for (Map.Entry<Long, Long> _e_ : _o_.petid2petmarkid.entrySet())
/* 337 */       petid2petmarkid.put(_e_.getKey(), _e_.getValue());
/* 338 */     return petid2petmarkid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNext_pet_mark_id(long _v_)
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     xdb.Logs.logIf(new LogKey(this, "next_pet_mark_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 350 */         new xdb.logs.LogLong(this, Role2PetMarkInfo.this.next_pet_mark_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 354 */             Role2PetMarkInfo.this.next_pet_mark_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 358 */     });
/* 359 */     this.next_pet_mark_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 365 */     _xdb_verify_unsafe_();
/* 366 */     Role2PetMarkInfo _o_ = null;
/* 367 */     if ((_o1_ instanceof Role2PetMarkInfo)) { _o_ = (Role2PetMarkInfo)_o1_;
/* 368 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 369 */       return false;
/* 370 */     if (this.next_pet_mark_id != _o_.next_pet_mark_id) return false;
/* 371 */     if (!this.petmarkid2info.equals(_o_.petmarkid2info)) return false;
/* 372 */     if (!this.petid2petmarkid.equals(_o_.petid2petmarkid)) return false;
/* 373 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 379 */     _xdb_verify_unsafe_();
/* 380 */     int _h_ = 0;
/* 381 */     _h_ = (int)(_h_ + this.next_pet_mark_id);
/* 382 */     _h_ += this.petmarkid2info.hashCode();
/* 383 */     _h_ += this.petid2petmarkid.hashCode();
/* 384 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 390 */     _xdb_verify_unsafe_();
/* 391 */     StringBuilder _sb_ = new StringBuilder();
/* 392 */     _sb_.append("(");
/* 393 */     _sb_.append(this.next_pet_mark_id);
/* 394 */     _sb_.append(",");
/* 395 */     _sb_.append(this.petmarkid2info);
/* 396 */     _sb_.append(",");
/* 397 */     _sb_.append(this.petid2petmarkid);
/* 398 */     _sb_.append(")");
/* 399 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 405 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 406 */     lb.add(new xdb.logs.ListenableChanged().setVarName("next_pet_mark_id"));
/* 407 */     lb.add(new xdb.logs.ListenableMap().setVarName("petmarkid2info"));
/* 408 */     lb.add(new xdb.logs.ListenableMap().setVarName("petid2petmarkid"));
/* 409 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Role2PetMarkInfo {
/*     */     private Const() {}
/*     */     
/*     */     Role2PetMarkInfo nThis() {
/* 416 */       return Role2PetMarkInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 422 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PetMarkInfo copy()
/*     */     {
/* 428 */       return Role2PetMarkInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PetMarkInfo toData()
/*     */     {
/* 434 */       return Role2PetMarkInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Role2PetMarkInfo toBean()
/*     */     {
/* 439 */       return Role2PetMarkInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PetMarkInfo toDataIf()
/*     */     {
/* 445 */       return Role2PetMarkInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Role2PetMarkInfo toBeanIf()
/*     */     {
/* 450 */       return Role2PetMarkInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getNext_pet_mark_id()
/*     */     {
/* 457 */       Role2PetMarkInfo.this._xdb_verify_unsafe_();
/* 458 */       return Role2PetMarkInfo.this.next_pet_mark_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.PetMarkInfo> getPetmarkid2info()
/*     */     {
/* 465 */       Role2PetMarkInfo.this._xdb_verify_unsafe_();
/* 466 */       return xdb.Consts.constMap(Role2PetMarkInfo.this.petmarkid2info);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.PetMarkInfo> getPetmarkid2infoAsData()
/*     */     {
/* 473 */       Role2PetMarkInfo.this._xdb_verify_unsafe_();
/*     */       
/* 475 */       Role2PetMarkInfo _o_ = Role2PetMarkInfo.this;
/* 476 */       Map<Long, xbean.PetMarkInfo> petmarkid2info = new HashMap();
/* 477 */       for (Map.Entry<Long, xbean.PetMarkInfo> _e_ : _o_.petmarkid2info.entrySet())
/* 478 */         petmarkid2info.put(_e_.getKey(), new PetMarkInfo.Data((xbean.PetMarkInfo)_e_.getValue()));
/* 479 */       return petmarkid2info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Long> getPetid2petmarkid()
/*     */     {
/* 486 */       Role2PetMarkInfo.this._xdb_verify_unsafe_();
/* 487 */       return xdb.Consts.constMap(Role2PetMarkInfo.this.petid2petmarkid);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Long> getPetid2petmarkidAsData()
/*     */     {
/* 494 */       Role2PetMarkInfo.this._xdb_verify_unsafe_();
/*     */       
/* 496 */       Role2PetMarkInfo _o_ = Role2PetMarkInfo.this;
/* 497 */       Map<Long, Long> petid2petmarkid = new HashMap();
/* 498 */       for (Map.Entry<Long, Long> _e_ : _o_.petid2petmarkid.entrySet())
/* 499 */         petid2petmarkid.put(_e_.getKey(), _e_.getValue());
/* 500 */       return petid2petmarkid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNext_pet_mark_id(long _v_)
/*     */     {
/* 507 */       Role2PetMarkInfo.this._xdb_verify_unsafe_();
/* 508 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 514 */       Role2PetMarkInfo.this._xdb_verify_unsafe_();
/* 515 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 521 */       Role2PetMarkInfo.this._xdb_verify_unsafe_();
/* 522 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 528 */       return Role2PetMarkInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 534 */       return Role2PetMarkInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 540 */       Role2PetMarkInfo.this._xdb_verify_unsafe_();
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 547 */       return Role2PetMarkInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 553 */       return Role2PetMarkInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 559 */       Role2PetMarkInfo.this._xdb_verify_unsafe_();
/* 560 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 566 */       return Role2PetMarkInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 572 */       return Role2PetMarkInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 578 */       return Role2PetMarkInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 584 */       return Role2PetMarkInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 590 */       return Role2PetMarkInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 596 */       return Role2PetMarkInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 602 */       return Role2PetMarkInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Role2PetMarkInfo
/*     */   {
/*     */     private long next_pet_mark_id;
/*     */     
/*     */     private HashMap<Long, xbean.PetMarkInfo> petmarkid2info;
/*     */     
/*     */     private HashMap<Long, Long> petid2petmarkid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 618 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 623 */       this.next_pet_mark_id = 1L;
/* 624 */       this.petmarkid2info = new HashMap();
/* 625 */       this.petid2petmarkid = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.Role2PetMarkInfo _o1_)
/*     */     {
/* 630 */       if ((_o1_ instanceof Role2PetMarkInfo)) { assign((Role2PetMarkInfo)_o1_);
/* 631 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 632 */       } else if ((_o1_ instanceof Role2PetMarkInfo.Const)) assign(((Role2PetMarkInfo.Const)_o1_).nThis()); else {
/* 633 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Role2PetMarkInfo _o_) {
/* 638 */       this.next_pet_mark_id = _o_.next_pet_mark_id;
/* 639 */       this.petmarkid2info = new HashMap();
/* 640 */       for (Map.Entry<Long, xbean.PetMarkInfo> _e_ : _o_.petmarkid2info.entrySet())
/* 641 */         this.petmarkid2info.put(_e_.getKey(), new PetMarkInfo.Data((xbean.PetMarkInfo)_e_.getValue()));
/* 642 */       this.petid2petmarkid = new HashMap();
/* 643 */       for (Map.Entry<Long, Long> _e_ : _o_.petid2petmarkid.entrySet()) {
/* 644 */         this.petid2petmarkid.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 649 */       this.next_pet_mark_id = _o_.next_pet_mark_id;
/* 650 */       this.petmarkid2info = new HashMap();
/* 651 */       for (Map.Entry<Long, xbean.PetMarkInfo> _e_ : _o_.petmarkid2info.entrySet())
/* 652 */         this.petmarkid2info.put(_e_.getKey(), new PetMarkInfo.Data((xbean.PetMarkInfo)_e_.getValue()));
/* 653 */       this.petid2petmarkid = new HashMap();
/* 654 */       for (Map.Entry<Long, Long> _e_ : _o_.petid2petmarkid.entrySet()) {
/* 655 */         this.petid2petmarkid.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 661 */       _os_.marshal(this.next_pet_mark_id);
/* 662 */       _os_.compact_uint32(this.petmarkid2info.size());
/* 663 */       for (Map.Entry<Long, xbean.PetMarkInfo> _e_ : this.petmarkid2info.entrySet())
/*     */       {
/* 665 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 666 */         ((xbean.PetMarkInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 668 */       _os_.compact_uint32(this.petid2petmarkid.size());
/* 669 */       for (Map.Entry<Long, Long> _e_ : this.petid2petmarkid.entrySet())
/*     */       {
/* 671 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 672 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */       }
/* 674 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 680 */       this.next_pet_mark_id = _os_.unmarshal_long();
/*     */       
/* 682 */       int size = _os_.uncompact_uint32();
/* 683 */       if (size >= 12)
/*     */       {
/* 685 */         this.petmarkid2info = new HashMap(size * 2);
/*     */       }
/* 687 */       for (; size > 0; size--)
/*     */       {
/* 689 */         long _k_ = 0L;
/* 690 */         _k_ = _os_.unmarshal_long();
/* 691 */         xbean.PetMarkInfo _v_ = xbean.Pod.newPetMarkInfoData();
/* 692 */         _v_.unmarshal(_os_);
/* 693 */         this.petmarkid2info.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/*     */ 
/* 697 */       int size = _os_.uncompact_uint32();
/* 698 */       if (size >= 12)
/*     */       {
/* 700 */         this.petid2petmarkid = new HashMap(size * 2);
/*     */       }
/* 702 */       for (; size > 0; size--)
/*     */       {
/* 704 */         long _k_ = 0L;
/* 705 */         _k_ = _os_.unmarshal_long();
/* 706 */         long _v_ = 0L;
/* 707 */         _v_ = _os_.unmarshal_long();
/* 708 */         this.petid2petmarkid.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*     */       }
/*     */       
/* 711 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 717 */       int _size_ = 0;
/* 718 */       _size_ += CodedOutputStream.computeInt64Size(1, this.next_pet_mark_id);
/* 719 */       for (Map.Entry<Long, xbean.PetMarkInfo> _e_ : this.petmarkid2info.entrySet())
/*     */       {
/* 721 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 722 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 724 */       for (Map.Entry<Long, Long> _e_ : this.petid2petmarkid.entrySet())
/*     */       {
/* 726 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 727 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getValue()).longValue());
/*     */       }
/* 729 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 737 */         _output_.writeInt64(1, this.next_pet_mark_id);
/* 738 */         for (Map.Entry<Long, xbean.PetMarkInfo> _e_ : this.petmarkid2info.entrySet())
/*     */         {
/* 740 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 741 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/* 743 */         for (Map.Entry<Long, Long> _e_ : this.petid2petmarkid.entrySet())
/*     */         {
/* 745 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 746 */           _output_.writeInt64(3, ((Long)_e_.getValue()).longValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 751 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 753 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 761 */         boolean done = false;
/* 762 */         while (!done)
/*     */         {
/* 764 */           int tag = _input_.readTag();
/* 765 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 769 */             done = true;
/* 770 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 774 */             this.next_pet_mark_id = _input_.readInt64();
/* 775 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 779 */             long _k_ = 0L;
/* 780 */             _k_ = _input_.readInt64();
/* 781 */             int readTag = _input_.readTag();
/* 782 */             if (18 != readTag)
/*     */             {
/* 784 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 786 */             xbean.PetMarkInfo _v_ = xbean.Pod.newPetMarkInfoData();
/* 787 */             _input_.readMessage(_v_);
/* 788 */             this.petmarkid2info.put(Long.valueOf(_k_), _v_);
/* 789 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 793 */             long _k_ = 0L;
/* 794 */             _k_ = _input_.readInt64();
/* 795 */             int readTag = _input_.readTag();
/* 796 */             if (24 != readTag)
/*     */             {
/* 798 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 800 */             long _v_ = 0L;
/* 801 */             _v_ = _input_.readInt64();
/* 802 */             this.petid2petmarkid.put(Long.valueOf(_k_), Long.valueOf(_v_));
/* 803 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 807 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 809 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 818 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 822 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 824 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PetMarkInfo copy()
/*     */     {
/* 830 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PetMarkInfo toData()
/*     */     {
/* 836 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Role2PetMarkInfo toBean()
/*     */     {
/* 841 */       return new Role2PetMarkInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PetMarkInfo toDataIf()
/*     */     {
/* 847 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Role2PetMarkInfo toBeanIf()
/*     */     {
/* 852 */       return new Role2PetMarkInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 858 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 862 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 866 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 870 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 874 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 878 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 882 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getNext_pet_mark_id()
/*     */     {
/* 889 */       return this.next_pet_mark_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.PetMarkInfo> getPetmarkid2info()
/*     */     {
/* 896 */       return this.petmarkid2info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.PetMarkInfo> getPetmarkid2infoAsData()
/*     */     {
/* 903 */       return this.petmarkid2info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Long> getPetid2petmarkid()
/*     */     {
/* 910 */       return this.petid2petmarkid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Long> getPetid2petmarkidAsData()
/*     */     {
/* 917 */       return this.petid2petmarkid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNext_pet_mark_id(long _v_)
/*     */     {
/* 924 */       this.next_pet_mark_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 930 */       if (!(_o1_ instanceof Data)) return false;
/* 931 */       Data _o_ = (Data)_o1_;
/* 932 */       if (this.next_pet_mark_id != _o_.next_pet_mark_id) return false;
/* 933 */       if (!this.petmarkid2info.equals(_o_.petmarkid2info)) return false;
/* 934 */       if (!this.petid2petmarkid.equals(_o_.petid2petmarkid)) return false;
/* 935 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 941 */       int _h_ = 0;
/* 942 */       _h_ = (int)(_h_ + this.next_pet_mark_id);
/* 943 */       _h_ += this.petmarkid2info.hashCode();
/* 944 */       _h_ += this.petid2petmarkid.hashCode();
/* 945 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 951 */       StringBuilder _sb_ = new StringBuilder();
/* 952 */       _sb_.append("(");
/* 953 */       _sb_.append(this.next_pet_mark_id);
/* 954 */       _sb_.append(",");
/* 955 */       _sb_.append(this.petmarkid2info);
/* 956 */       _sb_.append(",");
/* 957 */       _sb_.append(this.petid2petmarkid);
/* 958 */       _sb_.append(")");
/* 959 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2PetMarkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class MassWeddingRankInfos extends xdb.XBean implements xbean.MassWeddingRankInfos
/*     */ {
/*     */   private LinkedList<xbean.MassWeddingRankInfo> massweddingrankinfos;
/*     */   private HashMap<Long, Integer> roleid2index;
/*     */   private SetX<Long> notbackcoinsroleids;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.massweddingrankinfos.clear();
/*  23 */     this.roleid2index.clear();
/*  24 */     this.notbackcoinsroleids.clear();
/*     */   }
/*     */   
/*     */   MassWeddingRankInfos(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.massweddingrankinfos = new LinkedList();
/*  31 */     this.roleid2index = new HashMap();
/*  32 */     this.notbackcoinsroleids = new SetX();
/*     */   }
/*     */   
/*     */   public MassWeddingRankInfos()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MassWeddingRankInfos(MassWeddingRankInfos _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MassWeddingRankInfos(xbean.MassWeddingRankInfos _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof MassWeddingRankInfos)) { assign((MassWeddingRankInfos)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MassWeddingRankInfos _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.massweddingrankinfos = new LinkedList();
/*  58 */     for (xbean.MassWeddingRankInfo _v_ : _o_.massweddingrankinfos)
/*  59 */       this.massweddingrankinfos.add(new MassWeddingRankInfo(_v_, this, "massweddingrankinfos"));
/*  60 */     this.roleid2index = new HashMap();
/*  61 */     for (Map.Entry<Long, Integer> _e_ : _o_.roleid2index.entrySet())
/*  62 */       this.roleid2index.put(_e_.getKey(), _e_.getValue());
/*  63 */     this.notbackcoinsroleids = new SetX();
/*  64 */     this.notbackcoinsroleids.addAll(_o_.notbackcoinsroleids);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.massweddingrankinfos = new LinkedList();
/*  70 */     for (xbean.MassWeddingRankInfo _v_ : _o_.massweddingrankinfos)
/*  71 */       this.massweddingrankinfos.add(new MassWeddingRankInfo(_v_, this, "massweddingrankinfos"));
/*  72 */     this.roleid2index = new HashMap();
/*  73 */     for (Map.Entry<Long, Integer> _e_ : _o_.roleid2index.entrySet())
/*  74 */       this.roleid2index.put(_e_.getKey(), _e_.getValue());
/*  75 */     this.notbackcoinsroleids = new SetX();
/*  76 */     this.notbackcoinsroleids.addAll(_o_.notbackcoinsroleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     _os_.compact_uint32(this.massweddingrankinfos.size());
/*  84 */     for (xbean.MassWeddingRankInfo _v_ : this.massweddingrankinfos)
/*     */     {
/*  86 */       _v_.marshal(_os_);
/*     */     }
/*  88 */     _os_.compact_uint32(this.roleid2index.size());
/*  89 */     for (Map.Entry<Long, Integer> _e_ : this.roleid2index.entrySet())
/*     */     {
/*  91 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  92 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  94 */     _os_.compact_uint32(this.notbackcoinsroleids.size());
/*  95 */     for (Long _v_ : this.notbackcoinsroleids)
/*     */     {
/*  97 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  99 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 105 */     _xdb_verify_unsafe_();
/* 106 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 108 */       xbean.MassWeddingRankInfo _v_ = new MassWeddingRankInfo(0, this, "massweddingrankinfos");
/* 109 */       _v_.unmarshal(_os_);
/* 110 */       this.massweddingrankinfos.add(_v_);
/*     */     }
/*     */     
/* 113 */     int size = _os_.uncompact_uint32();
/* 114 */     if (size >= 12)
/*     */     {
/* 116 */       this.roleid2index = new HashMap(size * 2);
/*     */     }
/* 118 */     for (; size > 0; size--)
/*     */     {
/* 120 */       long _k_ = 0L;
/* 121 */       _k_ = _os_.unmarshal_long();
/* 122 */       int _v_ = 0;
/* 123 */       _v_ = _os_.unmarshal_int();
/* 124 */       this.roleid2index.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 127 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 129 */       long _v_ = 0L;
/* 130 */       _v_ = _os_.unmarshal_long();
/* 131 */       this.notbackcoinsroleids.add(Long.valueOf(_v_));
/*     */     }
/* 133 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 139 */     _xdb_verify_unsafe_();
/* 140 */     int _size_ = 0;
/* 141 */     for (xbean.MassWeddingRankInfo _v_ : this.massweddingrankinfos)
/*     */     {
/* 143 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 145 */     for (Map.Entry<Long, Integer> _e_ : this.roleid2index.entrySet())
/*     */     {
/* 147 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 148 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 150 */     for (Long _v_ : this.notbackcoinsroleids)
/*     */     {
/* 152 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*     */     }
/* 154 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 160 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 163 */       for (xbean.MassWeddingRankInfo _v_ : this.massweddingrankinfos)
/*     */       {
/* 165 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 167 */       for (Map.Entry<Long, Integer> _e_ : this.roleid2index.entrySet())
/*     */       {
/* 169 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 170 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 172 */       for (Long _v_ : this.notbackcoinsroleids)
/*     */       {
/* 174 */         _output_.writeInt64(3, _v_.longValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 179 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 181 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 190 */       boolean done = false;
/* 191 */       while (!done)
/*     */       {
/* 193 */         int tag = _input_.readTag();
/* 194 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 198 */           done = true;
/* 199 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 203 */           xbean.MassWeddingRankInfo _v_ = new MassWeddingRankInfo(0, this, "massweddingrankinfos");
/* 204 */           _input_.readMessage(_v_);
/* 205 */           this.massweddingrankinfos.add(_v_);
/* 206 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 210 */           long _k_ = 0L;
/* 211 */           _k_ = _input_.readInt64();
/* 212 */           int readTag = _input_.readTag();
/* 213 */           if (16 != readTag)
/*     */           {
/* 215 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 217 */           int _v_ = 0;
/* 218 */           _v_ = _input_.readInt32();
/* 219 */           this.roleid2index.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 220 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 224 */           long _v_ = 0L;
/* 225 */           _v_ = _input_.readInt64();
/* 226 */           this.notbackcoinsroleids.add(Long.valueOf(_v_));
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
/*     */     catch (java.io.IOException e)
/*     */     {
/* 246 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 248 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRankInfos copy()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return new MassWeddingRankInfos(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRankInfos toData()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MassWeddingRankInfos toBean()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return new MassWeddingRankInfos(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRankInfos toDataIf()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MassWeddingRankInfos toBeanIf()
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
/*     */   public java.util.List<xbean.MassWeddingRankInfo> getMassweddingrankinfos()
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     return xdb.Logs.logList(new xdb.LogKey(this, "massweddingrankinfos"), this.massweddingrankinfos);
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.List<xbean.MassWeddingRankInfo> getMassweddingrankinfosAsData()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/*     */     
/* 304 */     MassWeddingRankInfos _o_ = this;
/* 305 */     java.util.List<xbean.MassWeddingRankInfo> massweddingrankinfos = new LinkedList();
/* 306 */     for (xbean.MassWeddingRankInfo _v_ : _o_.massweddingrankinfos)
/* 307 */       massweddingrankinfos.add(new MassWeddingRankInfo.Data(_v_));
/* 308 */     return massweddingrankinfos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Long, Integer> getRoleid2index()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     return xdb.Logs.logMap(new xdb.LogKey(this, "roleid2index"), this.roleid2index);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Long, Integer> getRoleid2indexAsData()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/*     */     
/* 325 */     MassWeddingRankInfos _o_ = this;
/* 326 */     java.util.Map<Long, Integer> roleid2index = new HashMap();
/* 327 */     for (Map.Entry<Long, Integer> _e_ : _o_.roleid2index.entrySet())
/* 328 */       roleid2index.put(_e_.getKey(), _e_.getValue());
/* 329 */     return roleid2index;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getNotbackcoinsroleids()
/*     */   {
/* 336 */     _xdb_verify_unsafe_();
/* 337 */     return xdb.Logs.logSet(new xdb.LogKey(this, "notbackcoinsroleids"), this.notbackcoinsroleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getNotbackcoinsroleidsAsData()
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/*     */     
/* 345 */     MassWeddingRankInfos _o_ = this;
/* 346 */     Set<Long> notbackcoinsroleids = new SetX();
/* 347 */     notbackcoinsroleids.addAll(_o_.notbackcoinsroleids);
/* 348 */     return notbackcoinsroleids;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     MassWeddingRankInfos _o_ = null;
/* 356 */     if ((_o1_ instanceof MassWeddingRankInfos)) { _o_ = (MassWeddingRankInfos)_o1_;
/* 357 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 358 */       return false;
/* 359 */     if (!this.massweddingrankinfos.equals(_o_.massweddingrankinfos)) return false;
/* 360 */     if (!this.roleid2index.equals(_o_.roleid2index)) return false;
/* 361 */     if (!this.notbackcoinsroleids.equals(_o_.notbackcoinsroleids)) return false;
/* 362 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     int _h_ = 0;
/* 370 */     _h_ += this.massweddingrankinfos.hashCode();
/* 371 */     _h_ += this.roleid2index.hashCode();
/* 372 */     _h_ += this.notbackcoinsroleids.hashCode();
/* 373 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 379 */     _xdb_verify_unsafe_();
/* 380 */     StringBuilder _sb_ = new StringBuilder();
/* 381 */     _sb_.append("(");
/* 382 */     _sb_.append(this.massweddingrankinfos);
/* 383 */     _sb_.append(",");
/* 384 */     _sb_.append(this.roleid2index);
/* 385 */     _sb_.append(",");
/* 386 */     _sb_.append(this.notbackcoinsroleids);
/* 387 */     _sb_.append(")");
/* 388 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 394 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 395 */     lb.add(new xdb.logs.ListenableChanged().setVarName("massweddingrankinfos"));
/* 396 */     lb.add(new xdb.logs.ListenableMap().setVarName("roleid2index"));
/* 397 */     lb.add(new xdb.logs.ListenableSet().setVarName("notbackcoinsroleids"));
/* 398 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MassWeddingRankInfos {
/*     */     private Const() {}
/*     */     
/*     */     MassWeddingRankInfos nThis() {
/* 405 */       return MassWeddingRankInfos.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 411 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRankInfos copy()
/*     */     {
/* 417 */       return MassWeddingRankInfos.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRankInfos toData()
/*     */     {
/* 423 */       return MassWeddingRankInfos.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRankInfos toBean()
/*     */     {
/* 428 */       return MassWeddingRankInfos.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRankInfos toDataIf()
/*     */     {
/* 434 */       return MassWeddingRankInfos.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRankInfos toBeanIf()
/*     */     {
/* 439 */       return MassWeddingRankInfos.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<xbean.MassWeddingRankInfo> getMassweddingrankinfos()
/*     */     {
/* 446 */       MassWeddingRankInfos.this._xdb_verify_unsafe_();
/* 447 */       return xdb.Consts.constList(MassWeddingRankInfos.this.massweddingrankinfos);
/*     */     }
/*     */     
/*     */ 
/*     */     public java.util.List<xbean.MassWeddingRankInfo> getMassweddingrankinfosAsData()
/*     */     {
/* 453 */       MassWeddingRankInfos.this._xdb_verify_unsafe_();
/*     */       
/* 455 */       MassWeddingRankInfos _o_ = MassWeddingRankInfos.this;
/* 456 */       java.util.List<xbean.MassWeddingRankInfo> massweddingrankinfos = new LinkedList();
/* 457 */       for (xbean.MassWeddingRankInfo _v_ : _o_.massweddingrankinfos)
/* 458 */         massweddingrankinfos.add(new MassWeddingRankInfo.Data(_v_));
/* 459 */       return massweddingrankinfos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, Integer> getRoleid2index()
/*     */     {
/* 466 */       MassWeddingRankInfos.this._xdb_verify_unsafe_();
/* 467 */       return xdb.Consts.constMap(MassWeddingRankInfos.this.roleid2index);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, Integer> getRoleid2indexAsData()
/*     */     {
/* 474 */       MassWeddingRankInfos.this._xdb_verify_unsafe_();
/*     */       
/* 476 */       MassWeddingRankInfos _o_ = MassWeddingRankInfos.this;
/* 477 */       java.util.Map<Long, Integer> roleid2index = new HashMap();
/* 478 */       for (Map.Entry<Long, Integer> _e_ : _o_.roleid2index.entrySet())
/* 479 */         roleid2index.put(_e_.getKey(), _e_.getValue());
/* 480 */       return roleid2index;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getNotbackcoinsroleids()
/*     */     {
/* 487 */       MassWeddingRankInfos.this._xdb_verify_unsafe_();
/* 488 */       return xdb.Consts.constSet(MassWeddingRankInfos.this.notbackcoinsroleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getNotbackcoinsroleidsAsData()
/*     */     {
/* 494 */       MassWeddingRankInfos.this._xdb_verify_unsafe_();
/*     */       
/* 496 */       MassWeddingRankInfos _o_ = MassWeddingRankInfos.this;
/* 497 */       Set<Long> notbackcoinsroleids = new SetX();
/* 498 */       notbackcoinsroleids.addAll(_o_.notbackcoinsroleids);
/* 499 */       return notbackcoinsroleids;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 505 */       MassWeddingRankInfos.this._xdb_verify_unsafe_();
/* 506 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 512 */       MassWeddingRankInfos.this._xdb_verify_unsafe_();
/* 513 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 519 */       return MassWeddingRankInfos.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 525 */       return MassWeddingRankInfos.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 531 */       MassWeddingRankInfos.this._xdb_verify_unsafe_();
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 538 */       return MassWeddingRankInfos.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 544 */       return MassWeddingRankInfos.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 550 */       MassWeddingRankInfos.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 557 */       return MassWeddingRankInfos.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 563 */       return MassWeddingRankInfos.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 569 */       return MassWeddingRankInfos.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 575 */       return MassWeddingRankInfos.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 581 */       return MassWeddingRankInfos.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 587 */       return MassWeddingRankInfos.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 593 */       return MassWeddingRankInfos.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MassWeddingRankInfos
/*     */   {
/*     */     private LinkedList<xbean.MassWeddingRankInfo> massweddingrankinfos;
/*     */     
/*     */     private HashMap<Long, Integer> roleid2index;
/*     */     
/*     */     private HashSet<Long> notbackcoinsroleids;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 609 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 614 */       this.massweddingrankinfos = new LinkedList();
/* 615 */       this.roleid2index = new HashMap();
/* 616 */       this.notbackcoinsroleids = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.MassWeddingRankInfos _o1_)
/*     */     {
/* 621 */       if ((_o1_ instanceof MassWeddingRankInfos)) { assign((MassWeddingRankInfos)_o1_);
/* 622 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 623 */       } else if ((_o1_ instanceof MassWeddingRankInfos.Const)) assign(((MassWeddingRankInfos.Const)_o1_).nThis()); else {
/* 624 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MassWeddingRankInfos _o_) {
/* 629 */       this.massweddingrankinfos = new LinkedList();
/* 630 */       for (xbean.MassWeddingRankInfo _v_ : _o_.massweddingrankinfos)
/* 631 */         this.massweddingrankinfos.add(new MassWeddingRankInfo.Data(_v_));
/* 632 */       this.roleid2index = new HashMap();
/* 633 */       for (Map.Entry<Long, Integer> _e_ : _o_.roleid2index.entrySet())
/* 634 */         this.roleid2index.put(_e_.getKey(), _e_.getValue());
/* 635 */       this.notbackcoinsroleids = new HashSet();
/* 636 */       this.notbackcoinsroleids.addAll(_o_.notbackcoinsroleids);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 641 */       this.massweddingrankinfos = new LinkedList();
/* 642 */       for (xbean.MassWeddingRankInfo _v_ : _o_.massweddingrankinfos)
/* 643 */         this.massweddingrankinfos.add(new MassWeddingRankInfo.Data(_v_));
/* 644 */       this.roleid2index = new HashMap();
/* 645 */       for (Map.Entry<Long, Integer> _e_ : _o_.roleid2index.entrySet())
/* 646 */         this.roleid2index.put(_e_.getKey(), _e_.getValue());
/* 647 */       this.notbackcoinsroleids = new HashSet();
/* 648 */       this.notbackcoinsroleids.addAll(_o_.notbackcoinsroleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 654 */       _os_.compact_uint32(this.massweddingrankinfos.size());
/* 655 */       for (xbean.MassWeddingRankInfo _v_ : this.massweddingrankinfos)
/*     */       {
/* 657 */         _v_.marshal(_os_);
/*     */       }
/* 659 */       _os_.compact_uint32(this.roleid2index.size());
/* 660 */       for (Map.Entry<Long, Integer> _e_ : this.roleid2index.entrySet())
/*     */       {
/* 662 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 663 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 665 */       _os_.compact_uint32(this.notbackcoinsroleids.size());
/* 666 */       for (Long _v_ : this.notbackcoinsroleids)
/*     */       {
/* 668 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 670 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 676 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 678 */         xbean.MassWeddingRankInfo _v_ = xbean.Pod.newMassWeddingRankInfoData();
/* 679 */         _v_.unmarshal(_os_);
/* 680 */         this.massweddingrankinfos.add(_v_);
/*     */       }
/*     */       
/* 683 */       int size = _os_.uncompact_uint32();
/* 684 */       if (size >= 12)
/*     */       {
/* 686 */         this.roleid2index = new HashMap(size * 2);
/*     */       }
/* 688 */       for (; size > 0; size--)
/*     */       {
/* 690 */         long _k_ = 0L;
/* 691 */         _k_ = _os_.unmarshal_long();
/* 692 */         int _v_ = 0;
/* 693 */         _v_ = _os_.unmarshal_int();
/* 694 */         this.roleid2index.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 697 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 699 */         long _v_ = 0L;
/* 700 */         _v_ = _os_.unmarshal_long();
/* 701 */         this.notbackcoinsroleids.add(Long.valueOf(_v_));
/*     */       }
/* 703 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 709 */       int _size_ = 0;
/* 710 */       for (xbean.MassWeddingRankInfo _v_ : this.massweddingrankinfos)
/*     */       {
/* 712 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 714 */       for (Map.Entry<Long, Integer> _e_ : this.roleid2index.entrySet())
/*     */       {
/* 716 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 717 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 719 */       for (Long _v_ : this.notbackcoinsroleids)
/*     */       {
/* 721 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*     */       }
/* 723 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 731 */         for (xbean.MassWeddingRankInfo _v_ : this.massweddingrankinfos)
/*     */         {
/* 733 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 735 */         for (Map.Entry<Long, Integer> _e_ : this.roleid2index.entrySet())
/*     */         {
/* 737 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 738 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 740 */         for (Long _v_ : this.notbackcoinsroleids)
/*     */         {
/* 742 */           _output_.writeInt64(3, _v_.longValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 747 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 749 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 757 */         boolean done = false;
/* 758 */         while (!done)
/*     */         {
/* 760 */           int tag = _input_.readTag();
/* 761 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 765 */             done = true;
/* 766 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 770 */             xbean.MassWeddingRankInfo _v_ = xbean.Pod.newMassWeddingRankInfoData();
/* 771 */             _input_.readMessage(_v_);
/* 772 */             this.massweddingrankinfos.add(_v_);
/* 773 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 777 */             long _k_ = 0L;
/* 778 */             _k_ = _input_.readInt64();
/* 779 */             int readTag = _input_.readTag();
/* 780 */             if (16 != readTag)
/*     */             {
/* 782 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 784 */             int _v_ = 0;
/* 785 */             _v_ = _input_.readInt32();
/* 786 */             this.roleid2index.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 791 */             long _v_ = 0L;
/* 792 */             _v_ = _input_.readInt64();
/* 793 */             this.notbackcoinsroleids.add(Long.valueOf(_v_));
/* 794 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 798 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 800 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 809 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 813 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 815 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRankInfos copy()
/*     */     {
/* 821 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRankInfos toData()
/*     */     {
/* 827 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRankInfos toBean()
/*     */     {
/* 832 */       return new MassWeddingRankInfos(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRankInfos toDataIf()
/*     */     {
/* 838 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRankInfos toBeanIf()
/*     */     {
/* 843 */       return new MassWeddingRankInfos(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 849 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 853 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 857 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 861 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 865 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 869 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 873 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<xbean.MassWeddingRankInfo> getMassweddingrankinfos()
/*     */     {
/* 880 */       return this.massweddingrankinfos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<xbean.MassWeddingRankInfo> getMassweddingrankinfosAsData()
/*     */     {
/* 887 */       return this.massweddingrankinfos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, Integer> getRoleid2index()
/*     */     {
/* 894 */       return this.roleid2index;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, Integer> getRoleid2indexAsData()
/*     */     {
/* 901 */       return this.roleid2index;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getNotbackcoinsroleids()
/*     */     {
/* 908 */       return this.notbackcoinsroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getNotbackcoinsroleidsAsData()
/*     */     {
/* 915 */       return this.notbackcoinsroleids;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 921 */       if (!(_o1_ instanceof Data)) return false;
/* 922 */       Data _o_ = (Data)_o1_;
/* 923 */       if (!this.massweddingrankinfos.equals(_o_.massweddingrankinfos)) return false;
/* 924 */       if (!this.roleid2index.equals(_o_.roleid2index)) return false;
/* 925 */       if (!this.notbackcoinsroleids.equals(_o_.notbackcoinsroleids)) return false;
/* 926 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 932 */       int _h_ = 0;
/* 933 */       _h_ += this.massweddingrankinfos.hashCode();
/* 934 */       _h_ += this.roleid2index.hashCode();
/* 935 */       _h_ += this.notbackcoinsroleids.hashCode();
/* 936 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 942 */       StringBuilder _sb_ = new StringBuilder();
/* 943 */       _sb_.append("(");
/* 944 */       _sb_.append(this.massweddingrankinfos);
/* 945 */       _sb_.append(",");
/* 946 */       _sb_.append(this.roleid2index);
/* 947 */       _sb_.append(",");
/* 948 */       _sb_.append(this.notbackcoinsroleids);
/* 949 */       _sb_.append(")");
/* 950 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MassWeddingRankInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
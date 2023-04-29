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
/*     */ public final class SingleRecord extends XBean implements xbean.SingleRecord
/*     */ {
/*     */   private HashMap<Long, Integer> dead2count;
/*     */   private HashMap<Long, Integer> killer2count;
/*     */   private long revivetime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.dead2count.clear();
/*  23 */     this.killer2count.clear();
/*  24 */     this.revivetime = 0L;
/*     */   }
/*     */   
/*     */   SingleRecord(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.dead2count = new HashMap();
/*  31 */     this.killer2count = new HashMap();
/*     */   }
/*     */   
/*     */   public SingleRecord()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SingleRecord(SingleRecord _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SingleRecord(xbean.SingleRecord _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof SingleRecord)) { assign((SingleRecord)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SingleRecord _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.dead2count = new HashMap();
/*  57 */     for (Map.Entry<Long, Integer> _e_ : _o_.dead2count.entrySet())
/*  58 */       this.dead2count.put(_e_.getKey(), _e_.getValue());
/*  59 */     this.killer2count = new HashMap();
/*  60 */     for (Map.Entry<Long, Integer> _e_ : _o_.killer2count.entrySet())
/*  61 */       this.killer2count.put(_e_.getKey(), _e_.getValue());
/*  62 */     this.revivetime = _o_.revivetime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.dead2count = new HashMap();
/*  68 */     for (Map.Entry<Long, Integer> _e_ : _o_.dead2count.entrySet())
/*  69 */       this.dead2count.put(_e_.getKey(), _e_.getValue());
/*  70 */     this.killer2count = new HashMap();
/*  71 */     for (Map.Entry<Long, Integer> _e_ : _o_.killer2count.entrySet())
/*  72 */       this.killer2count.put(_e_.getKey(), _e_.getValue());
/*  73 */     this.revivetime = _o_.revivetime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.compact_uint32(this.dead2count.size());
/*  81 */     for (Map.Entry<Long, Integer> _e_ : this.dead2count.entrySet())
/*     */     {
/*  83 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  84 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  86 */     _os_.compact_uint32(this.killer2count.size());
/*  87 */     for (Map.Entry<Long, Integer> _e_ : this.killer2count.entrySet())
/*     */     {
/*  89 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  90 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  92 */     _os_.marshal(this.revivetime);
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
/* 104 */       this.dead2count = new HashMap(size * 2);
/*     */     }
/* 106 */     for (; size > 0; size--)
/*     */     {
/* 108 */       long _k_ = 0L;
/* 109 */       _k_ = _os_.unmarshal_long();
/* 110 */       int _v_ = 0;
/* 111 */       _v_ = _os_.unmarshal_int();
/* 112 */       this.dead2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/*     */ 
/* 116 */     int size = _os_.uncompact_uint32();
/* 117 */     if (size >= 12)
/*     */     {
/* 119 */       this.killer2count = new HashMap(size * 2);
/*     */     }
/* 121 */     for (; size > 0; size--)
/*     */     {
/* 123 */       long _k_ = 0L;
/* 124 */       _k_ = _os_.unmarshal_long();
/* 125 */       int _v_ = 0;
/* 126 */       _v_ = _os_.unmarshal_int();
/* 127 */       this.killer2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 130 */     this.revivetime = _os_.unmarshal_long();
/* 131 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     int _size_ = 0;
/* 139 */     for (Map.Entry<Long, Integer> _e_ : this.dead2count.entrySet())
/*     */     {
/* 141 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 142 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 144 */     for (Map.Entry<Long, Integer> _e_ : this.killer2count.entrySet())
/*     */     {
/* 146 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 147 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 149 */     _size_ += CodedOutputStream.computeInt64Size(3, this.revivetime);
/* 150 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 156 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 159 */       for (Map.Entry<Long, Integer> _e_ : this.dead2count.entrySet())
/*     */       {
/* 161 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 162 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 164 */       for (Map.Entry<Long, Integer> _e_ : this.killer2count.entrySet())
/*     */       {
/* 166 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 167 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 169 */       _output_.writeInt64(3, this.revivetime);
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
/* 197 */           long _k_ = 0L;
/* 198 */           _k_ = _input_.readInt64();
/* 199 */           int readTag = _input_.readTag();
/* 200 */           if (8 != readTag)
/*     */           {
/* 202 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 204 */           int _v_ = 0;
/* 205 */           _v_ = _input_.readInt32();
/* 206 */           this.dead2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 207 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 211 */           long _k_ = 0L;
/* 212 */           _k_ = _input_.readInt64();
/* 213 */           int readTag = _input_.readTag();
/* 214 */           if (16 != readTag)
/*     */           {
/* 216 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 218 */           int _v_ = 0;
/* 219 */           _v_ = _input_.readInt32();
/* 220 */           this.killer2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 221 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 225 */           this.revivetime = _input_.readInt64();
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
/*     */   public xbean.SingleRecord copy()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new SingleRecord(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SingleRecord toData()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SingleRecord toBean()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return new SingleRecord(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SingleRecord toDataIf()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SingleRecord toBeanIf()
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
/*     */   public Map<Long, Integer> getDead2count()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     return xdb.Logs.logMap(new LogKey(this, "dead2count"), this.dead2count);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getDead2countAsData()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/*     */     
/* 304 */     SingleRecord _o_ = this;
/* 305 */     Map<Long, Integer> dead2count = new HashMap();
/* 306 */     for (Map.Entry<Long, Integer> _e_ : _o_.dead2count.entrySet())
/* 307 */       dead2count.put(_e_.getKey(), _e_.getValue());
/* 308 */     return dead2count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getKiller2count()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     return xdb.Logs.logMap(new LogKey(this, "killer2count"), this.killer2count);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getKiller2countAsData()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/*     */     
/* 325 */     SingleRecord _o_ = this;
/* 326 */     Map<Long, Integer> killer2count = new HashMap();
/* 327 */     for (Map.Entry<Long, Integer> _e_ : _o_.killer2count.entrySet())
/* 328 */       killer2count.put(_e_.getKey(), _e_.getValue());
/* 329 */     return killer2count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRevivetime()
/*     */   {
/* 336 */     _xdb_verify_unsafe_();
/* 337 */     return this.revivetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRevivetime(long _v_)
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     xdb.Logs.logIf(new LogKey(this, "revivetime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 349 */         new xdb.logs.LogLong(this, SingleRecord.this.revivetime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 353 */             SingleRecord.this.revivetime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 357 */     });
/* 358 */     this.revivetime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     SingleRecord _o_ = null;
/* 366 */     if ((_o1_ instanceof SingleRecord)) { _o_ = (SingleRecord)_o1_;
/* 367 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 368 */       return false;
/* 369 */     if (!this.dead2count.equals(_o_.dead2count)) return false;
/* 370 */     if (!this.killer2count.equals(_o_.killer2count)) return false;
/* 371 */     if (this.revivetime != _o_.revivetime) return false;
/* 372 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 378 */     _xdb_verify_unsafe_();
/* 379 */     int _h_ = 0;
/* 380 */     _h_ += this.dead2count.hashCode();
/* 381 */     _h_ += this.killer2count.hashCode();
/* 382 */     _h_ = (int)(_h_ + this.revivetime);
/* 383 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     StringBuilder _sb_ = new StringBuilder();
/* 391 */     _sb_.append("(");
/* 392 */     _sb_.append(this.dead2count);
/* 393 */     _sb_.append(",");
/* 394 */     _sb_.append(this.killer2count);
/* 395 */     _sb_.append(",");
/* 396 */     _sb_.append(this.revivetime);
/* 397 */     _sb_.append(")");
/* 398 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 404 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 405 */     lb.add(new xdb.logs.ListenableMap().setVarName("dead2count"));
/* 406 */     lb.add(new xdb.logs.ListenableMap().setVarName("killer2count"));
/* 407 */     lb.add(new xdb.logs.ListenableChanged().setVarName("revivetime"));
/* 408 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SingleRecord {
/*     */     private Const() {}
/*     */     
/*     */     SingleRecord nThis() {
/* 415 */       return SingleRecord.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleRecord copy()
/*     */     {
/* 427 */       return SingleRecord.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleRecord toData()
/*     */     {
/* 433 */       return SingleRecord.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SingleRecord toBean()
/*     */     {
/* 438 */       return SingleRecord.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleRecord toDataIf()
/*     */     {
/* 444 */       return SingleRecord.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SingleRecord toBeanIf()
/*     */     {
/* 449 */       return SingleRecord.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getDead2count()
/*     */     {
/* 456 */       SingleRecord.this._xdb_verify_unsafe_();
/* 457 */       return xdb.Consts.constMap(SingleRecord.this.dead2count);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getDead2countAsData()
/*     */     {
/* 464 */       SingleRecord.this._xdb_verify_unsafe_();
/*     */       
/* 466 */       SingleRecord _o_ = SingleRecord.this;
/* 467 */       Map<Long, Integer> dead2count = new HashMap();
/* 468 */       for (Map.Entry<Long, Integer> _e_ : _o_.dead2count.entrySet())
/* 469 */         dead2count.put(_e_.getKey(), _e_.getValue());
/* 470 */       return dead2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getKiller2count()
/*     */     {
/* 477 */       SingleRecord.this._xdb_verify_unsafe_();
/* 478 */       return xdb.Consts.constMap(SingleRecord.this.killer2count);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getKiller2countAsData()
/*     */     {
/* 485 */       SingleRecord.this._xdb_verify_unsafe_();
/*     */       
/* 487 */       SingleRecord _o_ = SingleRecord.this;
/* 488 */       Map<Long, Integer> killer2count = new HashMap();
/* 489 */       for (Map.Entry<Long, Integer> _e_ : _o_.killer2count.entrySet())
/* 490 */         killer2count.put(_e_.getKey(), _e_.getValue());
/* 491 */       return killer2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRevivetime()
/*     */     {
/* 498 */       SingleRecord.this._xdb_verify_unsafe_();
/* 499 */       return SingleRecord.this.revivetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRevivetime(long _v_)
/*     */     {
/* 506 */       SingleRecord.this._xdb_verify_unsafe_();
/* 507 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 513 */       SingleRecord.this._xdb_verify_unsafe_();
/* 514 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 520 */       SingleRecord.this._xdb_verify_unsafe_();
/* 521 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 527 */       return SingleRecord.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 533 */       return SingleRecord.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 539 */       SingleRecord.this._xdb_verify_unsafe_();
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 546 */       return SingleRecord.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 552 */       return SingleRecord.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 558 */       SingleRecord.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 565 */       return SingleRecord.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 571 */       return SingleRecord.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 577 */       return SingleRecord.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 583 */       return SingleRecord.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 589 */       return SingleRecord.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 595 */       return SingleRecord.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 601 */       return SingleRecord.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SingleRecord
/*     */   {
/*     */     private HashMap<Long, Integer> dead2count;
/*     */     
/*     */     private HashMap<Long, Integer> killer2count;
/*     */     
/*     */     private long revivetime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 617 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 622 */       this.dead2count = new HashMap();
/* 623 */       this.killer2count = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.SingleRecord _o1_)
/*     */     {
/* 628 */       if ((_o1_ instanceof SingleRecord)) { assign((SingleRecord)_o1_);
/* 629 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 630 */       } else if ((_o1_ instanceof SingleRecord.Const)) assign(((SingleRecord.Const)_o1_).nThis()); else {
/* 631 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SingleRecord _o_) {
/* 636 */       this.dead2count = new HashMap();
/* 637 */       for (Map.Entry<Long, Integer> _e_ : _o_.dead2count.entrySet())
/* 638 */         this.dead2count.put(_e_.getKey(), _e_.getValue());
/* 639 */       this.killer2count = new HashMap();
/* 640 */       for (Map.Entry<Long, Integer> _e_ : _o_.killer2count.entrySet())
/* 641 */         this.killer2count.put(_e_.getKey(), _e_.getValue());
/* 642 */       this.revivetime = _o_.revivetime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 647 */       this.dead2count = new HashMap();
/* 648 */       for (Map.Entry<Long, Integer> _e_ : _o_.dead2count.entrySet())
/* 649 */         this.dead2count.put(_e_.getKey(), _e_.getValue());
/* 650 */       this.killer2count = new HashMap();
/* 651 */       for (Map.Entry<Long, Integer> _e_ : _o_.killer2count.entrySet())
/* 652 */         this.killer2count.put(_e_.getKey(), _e_.getValue());
/* 653 */       this.revivetime = _o_.revivetime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 659 */       _os_.compact_uint32(this.dead2count.size());
/* 660 */       for (Map.Entry<Long, Integer> _e_ : this.dead2count.entrySet())
/*     */       {
/* 662 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 663 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 665 */       _os_.compact_uint32(this.killer2count.size());
/* 666 */       for (Map.Entry<Long, Integer> _e_ : this.killer2count.entrySet())
/*     */       {
/* 668 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 669 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 671 */       _os_.marshal(this.revivetime);
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
/* 682 */         this.dead2count = new HashMap(size * 2);
/*     */       }
/* 684 */       for (; size > 0; size--)
/*     */       {
/* 686 */         long _k_ = 0L;
/* 687 */         _k_ = _os_.unmarshal_long();
/* 688 */         int _v_ = 0;
/* 689 */         _v_ = _os_.unmarshal_int();
/* 690 */         this.dead2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/*     */ 
/* 694 */       int size = _os_.uncompact_uint32();
/* 695 */       if (size >= 12)
/*     */       {
/* 697 */         this.killer2count = new HashMap(size * 2);
/*     */       }
/* 699 */       for (; size > 0; size--)
/*     */       {
/* 701 */         long _k_ = 0L;
/* 702 */         _k_ = _os_.unmarshal_long();
/* 703 */         int _v_ = 0;
/* 704 */         _v_ = _os_.unmarshal_int();
/* 705 */         this.killer2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 708 */       this.revivetime = _os_.unmarshal_long();
/* 709 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 715 */       int _size_ = 0;
/* 716 */       for (Map.Entry<Long, Integer> _e_ : this.dead2count.entrySet())
/*     */       {
/* 718 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 719 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 721 */       for (Map.Entry<Long, Integer> _e_ : this.killer2count.entrySet())
/*     */       {
/* 723 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 724 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 726 */       _size_ += CodedOutputStream.computeInt64Size(3, this.revivetime);
/* 727 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 735 */         for (Map.Entry<Long, Integer> _e_ : this.dead2count.entrySet())
/*     */         {
/* 737 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 738 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 740 */         for (Map.Entry<Long, Integer> _e_ : this.killer2count.entrySet())
/*     */         {
/* 742 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 743 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 745 */         _output_.writeInt64(3, this.revivetime);
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
/* 772 */             long _k_ = 0L;
/* 773 */             _k_ = _input_.readInt64();
/* 774 */             int readTag = _input_.readTag();
/* 775 */             if (8 != readTag)
/*     */             {
/* 777 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 779 */             int _v_ = 0;
/* 780 */             _v_ = _input_.readInt32();
/* 781 */             this.dead2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 786 */             long _k_ = 0L;
/* 787 */             _k_ = _input_.readInt64();
/* 788 */             int readTag = _input_.readTag();
/* 789 */             if (16 != readTag)
/*     */             {
/* 791 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 793 */             int _v_ = 0;
/* 794 */             _v_ = _input_.readInt32();
/* 795 */             this.killer2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 796 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 800 */             this.revivetime = _input_.readInt64();
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
/*     */     public xbean.SingleRecord copy()
/*     */     {
/* 828 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleRecord toData()
/*     */     {
/* 834 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SingleRecord toBean()
/*     */     {
/* 839 */       return new SingleRecord(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleRecord toDataIf()
/*     */     {
/* 845 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SingleRecord toBeanIf()
/*     */     {
/* 850 */       return new SingleRecord(this, null, null);
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
/*     */     public Map<Long, Integer> getDead2count()
/*     */     {
/* 887 */       return this.dead2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getDead2countAsData()
/*     */     {
/* 894 */       return this.dead2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getKiller2count()
/*     */     {
/* 901 */       return this.killer2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getKiller2countAsData()
/*     */     {
/* 908 */       return this.killer2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRevivetime()
/*     */     {
/* 915 */       return this.revivetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRevivetime(long _v_)
/*     */     {
/* 922 */       this.revivetime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 928 */       if (!(_o1_ instanceof Data)) return false;
/* 929 */       Data _o_ = (Data)_o1_;
/* 930 */       if (!this.dead2count.equals(_o_.dead2count)) return false;
/* 931 */       if (!this.killer2count.equals(_o_.killer2count)) return false;
/* 932 */       if (this.revivetime != _o_.revivetime) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ += this.dead2count.hashCode();
/* 941 */       _h_ += this.killer2count.hashCode();
/* 942 */       _h_ = (int)(_h_ + this.revivetime);
/* 943 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 949 */       StringBuilder _sb_ = new StringBuilder();
/* 950 */       _sb_.append("(");
/* 951 */       _sb_.append(this.dead2count);
/* 952 */       _sb_.append(",");
/* 953 */       _sb_.append(this.killer2count);
/* 954 */       _sb_.append(",");
/* 955 */       _sb_.append(this.revivetime);
/* 956 */       _sb_.append(")");
/* 957 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SingleRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
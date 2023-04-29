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
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class FabaoArtifactRecord extends XBean implements xbean.FabaoArtifactRecord
/*     */ {
/*     */   private int expire_time;
/*     */   private int level;
/*     */   private int upgrade_exp;
/*     */   private HashMap<Integer, Integer> properties;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.expire_time = 0;
/*  25 */     this.level = 0;
/*  26 */     this.upgrade_exp = 0;
/*  27 */     this.properties.clear();
/*     */   }
/*     */   
/*     */   FabaoArtifactRecord(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.properties = new HashMap();
/*     */   }
/*     */   
/*     */   public FabaoArtifactRecord()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FabaoArtifactRecord(FabaoArtifactRecord _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FabaoArtifactRecord(xbean.FabaoArtifactRecord _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof FabaoArtifactRecord)) { assign((FabaoArtifactRecord)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FabaoArtifactRecord _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.expire_time = _o_.expire_time;
/*  59 */     this.level = _o_.level;
/*  60 */     this.upgrade_exp = _o_.upgrade_exp;
/*  61 */     this.properties = new HashMap();
/*  62 */     for (Map.Entry<Integer, Integer> _e_ : _o_.properties.entrySet()) {
/*  63 */       this.properties.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  68 */     this.expire_time = _o_.expire_time;
/*  69 */     this.level = _o_.level;
/*  70 */     this.upgrade_exp = _o_.upgrade_exp;
/*  71 */     this.properties = new HashMap();
/*  72 */     for (Map.Entry<Integer, Integer> _e_ : _o_.properties.entrySet()) {
/*  73 */       this.properties.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.expire_time);
/*  81 */     _os_.marshal(this.level);
/*  82 */     _os_.marshal(this.upgrade_exp);
/*  83 */     _os_.compact_uint32(this.properties.size());
/*  84 */     for (Map.Entry<Integer, Integer> _e_ : this.properties.entrySet())
/*     */     {
/*  86 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  87 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     this.expire_time = _os_.unmarshal_int();
/*  97 */     this.level = _os_.unmarshal_int();
/*  98 */     this.upgrade_exp = _os_.unmarshal_int();
/*     */     
/* 100 */     int size = _os_.uncompact_uint32();
/* 101 */     if (size >= 12)
/*     */     {
/* 103 */       this.properties = new HashMap(size * 2);
/*     */     }
/* 105 */     for (; size > 0; size--)
/*     */     {
/* 107 */       int _k_ = 0;
/* 108 */       _k_ = _os_.unmarshal_int();
/* 109 */       int _v_ = 0;
/* 110 */       _v_ = _os_.unmarshal_int();
/* 111 */       this.properties.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     int _size_ = 0;
/* 122 */     _size_ += CodedOutputStream.computeInt32Size(1, this.expire_time);
/* 123 */     _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/* 124 */     _size_ += CodedOutputStream.computeInt32Size(3, this.upgrade_exp);
/* 125 */     for (Map.Entry<Integer, Integer> _e_ : this.properties.entrySet())
/*     */     {
/* 127 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/* 128 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 130 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 139 */       _output_.writeInt32(1, this.expire_time);
/* 140 */       _output_.writeInt32(2, this.level);
/* 141 */       _output_.writeInt32(3, this.upgrade_exp);
/* 142 */       for (Map.Entry<Integer, Integer> _e_ : this.properties.entrySet())
/*     */       {
/* 144 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/* 145 */         _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 161 */       boolean done = false;
/* 162 */       while (!done)
/*     */       {
/* 164 */         int tag = _input_.readTag();
/* 165 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 169 */           done = true;
/* 170 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 174 */           this.expire_time = _input_.readInt32();
/* 175 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 179 */           this.level = _input_.readInt32();
/* 180 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 184 */           this.upgrade_exp = _input_.readInt32();
/* 185 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 189 */           int _k_ = 0;
/* 190 */           _k_ = _input_.readInt32();
/* 191 */           int readTag = _input_.readTag();
/* 192 */           if (32 != readTag)
/*     */           {
/* 194 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 196 */           int _v_ = 0;
/* 197 */           _v_ = _input_.readInt32();
/* 198 */           this.properties.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 199 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 203 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 205 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 214 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 218 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 220 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FabaoArtifactRecord copy()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new FabaoArtifactRecord(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FabaoArtifactRecord toData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FabaoArtifactRecord toBean()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new FabaoArtifactRecord(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FabaoArtifactRecord toDataIf()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FabaoArtifactRecord toBeanIf()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getExpire_time()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return this.expire_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getUpgrade_exp()
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     return this.upgrade_exp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getProperties()
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     return xdb.Logs.logMap(new LogKey(this, "properties"), this.properties);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getPropertiesAsData()
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/*     */     
/* 301 */     FabaoArtifactRecord _o_ = this;
/* 302 */     Map<Integer, Integer> properties = new HashMap();
/* 303 */     for (Map.Entry<Integer, Integer> _e_ : _o_.properties.entrySet())
/* 304 */       properties.put(_e_.getKey(), _e_.getValue());
/* 305 */     return properties;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExpire_time(int _v_)
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     xdb.Logs.logIf(new LogKey(this, "expire_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 317 */         new xdb.logs.LogInt(this, FabaoArtifactRecord.this.expire_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 321 */             FabaoArtifactRecord.this.expire_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 325 */     });
/* 326 */     this.expire_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLevel(int _v_)
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     xdb.Logs.logIf(new LogKey(this, "level")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 338 */         new xdb.logs.LogInt(this, FabaoArtifactRecord.this.level)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 342 */             FabaoArtifactRecord.this.level = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 346 */     });
/* 347 */     this.level = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpgrade_exp(int _v_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     xdb.Logs.logIf(new LogKey(this, "upgrade_exp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 359 */         new xdb.logs.LogInt(this, FabaoArtifactRecord.this.upgrade_exp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 363 */             FabaoArtifactRecord.this.upgrade_exp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 367 */     });
/* 368 */     this.upgrade_exp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 374 */     _xdb_verify_unsafe_();
/* 375 */     FabaoArtifactRecord _o_ = null;
/* 376 */     if ((_o1_ instanceof FabaoArtifactRecord)) { _o_ = (FabaoArtifactRecord)_o1_;
/* 377 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 378 */       return false;
/* 379 */     if (this.expire_time != _o_.expire_time) return false;
/* 380 */     if (this.level != _o_.level) return false;
/* 381 */     if (this.upgrade_exp != _o_.upgrade_exp) return false;
/* 382 */     if (!this.properties.equals(_o_.properties)) return false;
/* 383 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     int _h_ = 0;
/* 391 */     _h_ += this.expire_time;
/* 392 */     _h_ += this.level;
/* 393 */     _h_ += this.upgrade_exp;
/* 394 */     _h_ += this.properties.hashCode();
/* 395 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 401 */     _xdb_verify_unsafe_();
/* 402 */     StringBuilder _sb_ = new StringBuilder();
/* 403 */     _sb_.append("(");
/* 404 */     _sb_.append(this.expire_time);
/* 405 */     _sb_.append(",");
/* 406 */     _sb_.append(this.level);
/* 407 */     _sb_.append(",");
/* 408 */     _sb_.append(this.upgrade_exp);
/* 409 */     _sb_.append(",");
/* 410 */     _sb_.append(this.properties);
/* 411 */     _sb_.append(")");
/* 412 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 418 */     ListenableBean lb = new ListenableBean();
/* 419 */     lb.add(new xdb.logs.ListenableChanged().setVarName("expire_time"));
/* 420 */     lb.add(new xdb.logs.ListenableChanged().setVarName("level"));
/* 421 */     lb.add(new xdb.logs.ListenableChanged().setVarName("upgrade_exp"));
/* 422 */     lb.add(new xdb.logs.ListenableMap().setVarName("properties"));
/* 423 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FabaoArtifactRecord {
/*     */     private Const() {}
/*     */     
/*     */     FabaoArtifactRecord nThis() {
/* 430 */       return FabaoArtifactRecord.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactRecord copy()
/*     */     {
/* 442 */       return FabaoArtifactRecord.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactRecord toData()
/*     */     {
/* 448 */       return FabaoArtifactRecord.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FabaoArtifactRecord toBean()
/*     */     {
/* 453 */       return FabaoArtifactRecord.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactRecord toDataIf()
/*     */     {
/* 459 */       return FabaoArtifactRecord.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FabaoArtifactRecord toBeanIf()
/*     */     {
/* 464 */       return FabaoArtifactRecord.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getExpire_time()
/*     */     {
/* 471 */       FabaoArtifactRecord.this._xdb_verify_unsafe_();
/* 472 */       return FabaoArtifactRecord.this.expire_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 479 */       FabaoArtifactRecord.this._xdb_verify_unsafe_();
/* 480 */       return FabaoArtifactRecord.this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUpgrade_exp()
/*     */     {
/* 487 */       FabaoArtifactRecord.this._xdb_verify_unsafe_();
/* 488 */       return FabaoArtifactRecord.this.upgrade_exp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getProperties()
/*     */     {
/* 495 */       FabaoArtifactRecord.this._xdb_verify_unsafe_();
/* 496 */       return xdb.Consts.constMap(FabaoArtifactRecord.this.properties);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getPropertiesAsData()
/*     */     {
/* 503 */       FabaoArtifactRecord.this._xdb_verify_unsafe_();
/*     */       
/* 505 */       FabaoArtifactRecord _o_ = FabaoArtifactRecord.this;
/* 506 */       Map<Integer, Integer> properties = new HashMap();
/* 507 */       for (Map.Entry<Integer, Integer> _e_ : _o_.properties.entrySet())
/* 508 */         properties.put(_e_.getKey(), _e_.getValue());
/* 509 */       return properties;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExpire_time(int _v_)
/*     */     {
/* 516 */       FabaoArtifactRecord.this._xdb_verify_unsafe_();
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 524 */       FabaoArtifactRecord.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUpgrade_exp(int _v_)
/*     */     {
/* 532 */       FabaoArtifactRecord.this._xdb_verify_unsafe_();
/* 533 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 539 */       FabaoArtifactRecord.this._xdb_verify_unsafe_();
/* 540 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 546 */       FabaoArtifactRecord.this._xdb_verify_unsafe_();
/* 547 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 553 */       return FabaoArtifactRecord.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 559 */       return FabaoArtifactRecord.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 565 */       FabaoArtifactRecord.this._xdb_verify_unsafe_();
/* 566 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 572 */       return FabaoArtifactRecord.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 578 */       return FabaoArtifactRecord.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 584 */       FabaoArtifactRecord.this._xdb_verify_unsafe_();
/* 585 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 591 */       return FabaoArtifactRecord.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 597 */       return FabaoArtifactRecord.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 603 */       return FabaoArtifactRecord.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 609 */       return FabaoArtifactRecord.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 615 */       return FabaoArtifactRecord.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 621 */       return FabaoArtifactRecord.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 627 */       return FabaoArtifactRecord.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FabaoArtifactRecord
/*     */   {
/*     */     private int expire_time;
/*     */     
/*     */     private int level;
/*     */     
/*     */     private int upgrade_exp;
/*     */     
/*     */     private HashMap<Integer, Integer> properties;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 645 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 650 */       this.properties = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.FabaoArtifactRecord _o1_)
/*     */     {
/* 655 */       if ((_o1_ instanceof FabaoArtifactRecord)) { assign((FabaoArtifactRecord)_o1_);
/* 656 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 657 */       } else if ((_o1_ instanceof FabaoArtifactRecord.Const)) assign(((FabaoArtifactRecord.Const)_o1_).nThis()); else {
/* 658 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FabaoArtifactRecord _o_) {
/* 663 */       this.expire_time = _o_.expire_time;
/* 664 */       this.level = _o_.level;
/* 665 */       this.upgrade_exp = _o_.upgrade_exp;
/* 666 */       this.properties = new HashMap();
/* 667 */       for (Map.Entry<Integer, Integer> _e_ : _o_.properties.entrySet()) {
/* 668 */         this.properties.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 673 */       this.expire_time = _o_.expire_time;
/* 674 */       this.level = _o_.level;
/* 675 */       this.upgrade_exp = _o_.upgrade_exp;
/* 676 */       this.properties = new HashMap();
/* 677 */       for (Map.Entry<Integer, Integer> _e_ : _o_.properties.entrySet()) {
/* 678 */         this.properties.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 684 */       _os_.marshal(this.expire_time);
/* 685 */       _os_.marshal(this.level);
/* 686 */       _os_.marshal(this.upgrade_exp);
/* 687 */       _os_.compact_uint32(this.properties.size());
/* 688 */       for (Map.Entry<Integer, Integer> _e_ : this.properties.entrySet())
/*     */       {
/* 690 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 691 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 693 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 699 */       this.expire_time = _os_.unmarshal_int();
/* 700 */       this.level = _os_.unmarshal_int();
/* 701 */       this.upgrade_exp = _os_.unmarshal_int();
/*     */       
/* 703 */       int size = _os_.uncompact_uint32();
/* 704 */       if (size >= 12)
/*     */       {
/* 706 */         this.properties = new HashMap(size * 2);
/*     */       }
/* 708 */       for (; size > 0; size--)
/*     */       {
/* 710 */         int _k_ = 0;
/* 711 */         _k_ = _os_.unmarshal_int();
/* 712 */         int _v_ = 0;
/* 713 */         _v_ = _os_.unmarshal_int();
/* 714 */         this.properties.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 717 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 723 */       int _size_ = 0;
/* 724 */       _size_ += CodedOutputStream.computeInt32Size(1, this.expire_time);
/* 725 */       _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/* 726 */       _size_ += CodedOutputStream.computeInt32Size(3, this.upgrade_exp);
/* 727 */       for (Map.Entry<Integer, Integer> _e_ : this.properties.entrySet())
/*     */       {
/* 729 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/* 730 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 732 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 740 */         _output_.writeInt32(1, this.expire_time);
/* 741 */         _output_.writeInt32(2, this.level);
/* 742 */         _output_.writeInt32(3, this.upgrade_exp);
/* 743 */         for (Map.Entry<Integer, Integer> _e_ : this.properties.entrySet())
/*     */         {
/* 745 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/* 746 */           _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
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
/* 774 */             this.expire_time = _input_.readInt32();
/* 775 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 779 */             this.level = _input_.readInt32();
/* 780 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 784 */             this.upgrade_exp = _input_.readInt32();
/* 785 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 789 */             int _k_ = 0;
/* 790 */             _k_ = _input_.readInt32();
/* 791 */             int readTag = _input_.readTag();
/* 792 */             if (32 != readTag)
/*     */             {
/* 794 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 796 */             int _v_ = 0;
/* 797 */             _v_ = _input_.readInt32();
/* 798 */             this.properties.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 799 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 803 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 805 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 814 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 818 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 820 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactRecord copy()
/*     */     {
/* 826 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactRecord toData()
/*     */     {
/* 832 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FabaoArtifactRecord toBean()
/*     */     {
/* 837 */       return new FabaoArtifactRecord(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactRecord toDataIf()
/*     */     {
/* 843 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FabaoArtifactRecord toBeanIf()
/*     */     {
/* 848 */       return new FabaoArtifactRecord(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 854 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 858 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 862 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 866 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 870 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 874 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 878 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getExpire_time()
/*     */     {
/* 885 */       return this.expire_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 892 */       return this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUpgrade_exp()
/*     */     {
/* 899 */       return this.upgrade_exp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getProperties()
/*     */     {
/* 906 */       return this.properties;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getPropertiesAsData()
/*     */     {
/* 913 */       return this.properties;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExpire_time(int _v_)
/*     */     {
/* 920 */       this.expire_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 927 */       this.level = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUpgrade_exp(int _v_)
/*     */     {
/* 934 */       this.upgrade_exp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 940 */       if (!(_o1_ instanceof Data)) return false;
/* 941 */       Data _o_ = (Data)_o1_;
/* 942 */       if (this.expire_time != _o_.expire_time) return false;
/* 943 */       if (this.level != _o_.level) return false;
/* 944 */       if (this.upgrade_exp != _o_.upgrade_exp) return false;
/* 945 */       if (!this.properties.equals(_o_.properties)) return false;
/* 946 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 952 */       int _h_ = 0;
/* 953 */       _h_ += this.expire_time;
/* 954 */       _h_ += this.level;
/* 955 */       _h_ += this.upgrade_exp;
/* 956 */       _h_ += this.properties.hashCode();
/* 957 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 963 */       StringBuilder _sb_ = new StringBuilder();
/* 964 */       _sb_.append("(");
/* 965 */       _sb_.append(this.expire_time);
/* 966 */       _sb_.append(",");
/* 967 */       _sb_.append(this.level);
/* 968 */       _sb_.append(",");
/* 969 */       _sb_.append(this.upgrade_exp);
/* 970 */       _sb_.append(",");
/* 971 */       _sb_.append(this.properties);
/* 972 */       _sb_.append(")");
/* 973 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FabaoArtifactRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
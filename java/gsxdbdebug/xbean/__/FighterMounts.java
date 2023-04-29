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
/*     */ public final class FighterMounts extends XBean implements xbean.FighterMounts
/*     */ {
/*     */   private long mountuuid;
/*     */   private int mountcfgid;
/*     */   private HashMap<Integer, Integer> skillmap;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.mountuuid = 0L;
/*  23 */     this.mountcfgid = 0;
/*  24 */     this.skillmap.clear();
/*     */   }
/*     */   
/*     */   FighterMounts(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.mountuuid = 0L;
/*  31 */     this.mountcfgid = 0;
/*  32 */     this.skillmap = new HashMap();
/*     */   }
/*     */   
/*     */   public FighterMounts()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FighterMounts(FighterMounts _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FighterMounts(xbean.FighterMounts _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof FighterMounts)) { assign((FighterMounts)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FighterMounts _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.mountuuid = _o_.mountuuid;
/*  58 */     this.mountcfgid = _o_.mountcfgid;
/*  59 */     this.skillmap = new HashMap();
/*  60 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillmap.entrySet()) {
/*  61 */       this.skillmap.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  66 */     this.mountuuid = _o_.mountuuid;
/*  67 */     this.mountcfgid = _o_.mountcfgid;
/*  68 */     this.skillmap = new HashMap();
/*  69 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillmap.entrySet()) {
/*  70 */       this.skillmap.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     _os_.marshal(this.mountuuid);
/*  78 */     _os_.marshal(this.mountcfgid);
/*  79 */     _os_.compact_uint32(this.skillmap.size());
/*  80 */     for (Map.Entry<Integer, Integer> _e_ : this.skillmap.entrySet())
/*     */     {
/*  82 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  83 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     this.mountuuid = _os_.unmarshal_long();
/*  93 */     this.mountcfgid = _os_.unmarshal_int();
/*     */     
/*  95 */     int size = _os_.uncompact_uint32();
/*  96 */     if (size >= 12)
/*     */     {
/*  98 */       this.skillmap = new HashMap(size * 2);
/*     */     }
/* 100 */     for (; size > 0; size--)
/*     */     {
/* 102 */       int _k_ = 0;
/* 103 */       _k_ = _os_.unmarshal_int();
/* 104 */       int _v_ = 0;
/* 105 */       _v_ = _os_.unmarshal_int();
/* 106 */       this.skillmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 115 */     _xdb_verify_unsafe_();
/* 116 */     int _size_ = 0;
/* 117 */     _size_ += CodedOutputStream.computeInt64Size(1, this.mountuuid);
/* 118 */     _size_ += CodedOutputStream.computeInt32Size(2, this.mountcfgid);
/* 119 */     for (Map.Entry<Integer, Integer> _e_ : this.skillmap.entrySet())
/*     */     {
/* 121 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 122 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 124 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 133 */       _output_.writeInt64(1, this.mountuuid);
/* 134 */       _output_.writeInt32(2, this.mountcfgid);
/* 135 */       for (Map.Entry<Integer, Integer> _e_ : this.skillmap.entrySet())
/*     */       {
/* 137 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 138 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 143 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 145 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 151 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 154 */       boolean done = false;
/* 155 */       while (!done)
/*     */       {
/* 157 */         int tag = _input_.readTag();
/* 158 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 162 */           done = true;
/* 163 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 167 */           this.mountuuid = _input_.readInt64();
/* 168 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 172 */           this.mountcfgid = _input_.readInt32();
/* 173 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 177 */           int _k_ = 0;
/* 178 */           _k_ = _input_.readInt32();
/* 179 */           int readTag = _input_.readTag();
/* 180 */           if (24 != readTag)
/*     */           {
/* 182 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 184 */           int _v_ = 0;
/* 185 */           _v_ = _input_.readInt32();
/* 186 */           this.skillmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 187 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 191 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 193 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 202 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 206 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 208 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FighterMounts copy()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return new FighterMounts(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FighterMounts toData()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FighterMounts toBean()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new FighterMounts(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FighterMounts toDataIf()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FighterMounts toBeanIf()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getMountuuid()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     return this.mountuuid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMountcfgid()
/*     */   {
/* 263 */     _xdb_verify_unsafe_();
/* 264 */     return this.mountcfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getSkillmap()
/*     */   {
/* 271 */     _xdb_verify_unsafe_();
/* 272 */     return xdb.Logs.logMap(new LogKey(this, "skillmap"), this.skillmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getSkillmapAsData()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/*     */     
/* 281 */     FighterMounts _o_ = this;
/* 282 */     Map<Integer, Integer> skillmap = new HashMap();
/* 283 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillmap.entrySet())
/* 284 */       skillmap.put(_e_.getKey(), _e_.getValue());
/* 285 */     return skillmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMountuuid(long _v_)
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/* 293 */     xdb.Logs.logIf(new LogKey(this, "mountuuid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 297 */         new xdb.logs.LogLong(this, FighterMounts.this.mountuuid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 301 */             FighterMounts.this.mountuuid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 305 */     });
/* 306 */     this.mountuuid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMountcfgid(int _v_)
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     xdb.Logs.logIf(new LogKey(this, "mountcfgid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 318 */         new xdb.logs.LogInt(this, FighterMounts.this.mountcfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 322 */             FighterMounts.this.mountcfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 326 */     });
/* 327 */     this.mountcfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     FighterMounts _o_ = null;
/* 335 */     if ((_o1_ instanceof FighterMounts)) { _o_ = (FighterMounts)_o1_;
/* 336 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 337 */       return false;
/* 338 */     if (this.mountuuid != _o_.mountuuid) return false;
/* 339 */     if (this.mountcfgid != _o_.mountcfgid) return false;
/* 340 */     if (!this.skillmap.equals(_o_.skillmap)) return false;
/* 341 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 347 */     _xdb_verify_unsafe_();
/* 348 */     int _h_ = 0;
/* 349 */     _h_ = (int)(_h_ + this.mountuuid);
/* 350 */     _h_ += this.mountcfgid;
/* 351 */     _h_ += this.skillmap.hashCode();
/* 352 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 358 */     _xdb_verify_unsafe_();
/* 359 */     StringBuilder _sb_ = new StringBuilder();
/* 360 */     _sb_.append("(");
/* 361 */     _sb_.append(this.mountuuid);
/* 362 */     _sb_.append(",");
/* 363 */     _sb_.append(this.mountcfgid);
/* 364 */     _sb_.append(",");
/* 365 */     _sb_.append(this.skillmap);
/* 366 */     _sb_.append(")");
/* 367 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 373 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 374 */     lb.add(new xdb.logs.ListenableChanged().setVarName("mountuuid"));
/* 375 */     lb.add(new xdb.logs.ListenableChanged().setVarName("mountcfgid"));
/* 376 */     lb.add(new xdb.logs.ListenableMap().setVarName("skillmap"));
/* 377 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FighterMounts {
/*     */     private Const() {}
/*     */     
/*     */     FighterMounts nThis() {
/* 384 */       return FighterMounts.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 390 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterMounts copy()
/*     */     {
/* 396 */       return FighterMounts.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterMounts toData()
/*     */     {
/* 402 */       return FighterMounts.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FighterMounts toBean()
/*     */     {
/* 407 */       return FighterMounts.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterMounts toDataIf()
/*     */     {
/* 413 */       return FighterMounts.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FighterMounts toBeanIf()
/*     */     {
/* 418 */       return FighterMounts.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMountuuid()
/*     */     {
/* 425 */       FighterMounts.this._xdb_verify_unsafe_();
/* 426 */       return FighterMounts.this.mountuuid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMountcfgid()
/*     */     {
/* 433 */       FighterMounts.this._xdb_verify_unsafe_();
/* 434 */       return FighterMounts.this.mountcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getSkillmap()
/*     */     {
/* 441 */       FighterMounts.this._xdb_verify_unsafe_();
/* 442 */       return xdb.Consts.constMap(FighterMounts.this.skillmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getSkillmapAsData()
/*     */     {
/* 449 */       FighterMounts.this._xdb_verify_unsafe_();
/*     */       
/* 451 */       FighterMounts _o_ = FighterMounts.this;
/* 452 */       Map<Integer, Integer> skillmap = new HashMap();
/* 453 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillmap.entrySet())
/* 454 */         skillmap.put(_e_.getKey(), _e_.getValue());
/* 455 */       return skillmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMountuuid(long _v_)
/*     */     {
/* 462 */       FighterMounts.this._xdb_verify_unsafe_();
/* 463 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMountcfgid(int _v_)
/*     */     {
/* 470 */       FighterMounts.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 477 */       FighterMounts.this._xdb_verify_unsafe_();
/* 478 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 484 */       FighterMounts.this._xdb_verify_unsafe_();
/* 485 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 491 */       return FighterMounts.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 497 */       return FighterMounts.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 503 */       FighterMounts.this._xdb_verify_unsafe_();
/* 504 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 510 */       return FighterMounts.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 516 */       return FighterMounts.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 522 */       FighterMounts.this._xdb_verify_unsafe_();
/* 523 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 529 */       return FighterMounts.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 535 */       return FighterMounts.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 541 */       return FighterMounts.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 547 */       return FighterMounts.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 553 */       return FighterMounts.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 559 */       return FighterMounts.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 565 */       return FighterMounts.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FighterMounts
/*     */   {
/*     */     private long mountuuid;
/*     */     
/*     */     private int mountcfgid;
/*     */     
/*     */     private HashMap<Integer, Integer> skillmap;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 581 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 586 */       this.mountuuid = 0L;
/* 587 */       this.mountcfgid = 0;
/* 588 */       this.skillmap = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.FighterMounts _o1_)
/*     */     {
/* 593 */       if ((_o1_ instanceof FighterMounts)) { assign((FighterMounts)_o1_);
/* 594 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 595 */       } else if ((_o1_ instanceof FighterMounts.Const)) assign(((FighterMounts.Const)_o1_).nThis()); else {
/* 596 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FighterMounts _o_) {
/* 601 */       this.mountuuid = _o_.mountuuid;
/* 602 */       this.mountcfgid = _o_.mountcfgid;
/* 603 */       this.skillmap = new HashMap();
/* 604 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillmap.entrySet()) {
/* 605 */         this.skillmap.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 610 */       this.mountuuid = _o_.mountuuid;
/* 611 */       this.mountcfgid = _o_.mountcfgid;
/* 612 */       this.skillmap = new HashMap();
/* 613 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillmap.entrySet()) {
/* 614 */         this.skillmap.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 620 */       _os_.marshal(this.mountuuid);
/* 621 */       _os_.marshal(this.mountcfgid);
/* 622 */       _os_.compact_uint32(this.skillmap.size());
/* 623 */       for (Map.Entry<Integer, Integer> _e_ : this.skillmap.entrySet())
/*     */       {
/* 625 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 626 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 628 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 634 */       this.mountuuid = _os_.unmarshal_long();
/* 635 */       this.mountcfgid = _os_.unmarshal_int();
/*     */       
/* 637 */       int size = _os_.uncompact_uint32();
/* 638 */       if (size >= 12)
/*     */       {
/* 640 */         this.skillmap = new HashMap(size * 2);
/*     */       }
/* 642 */       for (; size > 0; size--)
/*     */       {
/* 644 */         int _k_ = 0;
/* 645 */         _k_ = _os_.unmarshal_int();
/* 646 */         int _v_ = 0;
/* 647 */         _v_ = _os_.unmarshal_int();
/* 648 */         this.skillmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 651 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 657 */       int _size_ = 0;
/* 658 */       _size_ += CodedOutputStream.computeInt64Size(1, this.mountuuid);
/* 659 */       _size_ += CodedOutputStream.computeInt32Size(2, this.mountcfgid);
/* 660 */       for (Map.Entry<Integer, Integer> _e_ : this.skillmap.entrySet())
/*     */       {
/* 662 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 663 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 665 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 673 */         _output_.writeInt64(1, this.mountuuid);
/* 674 */         _output_.writeInt32(2, this.mountcfgid);
/* 675 */         for (Map.Entry<Integer, Integer> _e_ : this.skillmap.entrySet())
/*     */         {
/* 677 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 678 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 683 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 685 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 693 */         boolean done = false;
/* 694 */         while (!done)
/*     */         {
/* 696 */           int tag = _input_.readTag();
/* 697 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 701 */             done = true;
/* 702 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 706 */             this.mountuuid = _input_.readInt64();
/* 707 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 711 */             this.mountcfgid = _input_.readInt32();
/* 712 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 716 */             int _k_ = 0;
/* 717 */             _k_ = _input_.readInt32();
/* 718 */             int readTag = _input_.readTag();
/* 719 */             if (24 != readTag)
/*     */             {
/* 721 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 723 */             int _v_ = 0;
/* 724 */             _v_ = _input_.readInt32();
/* 725 */             this.skillmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 726 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 730 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 732 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 741 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 745 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 747 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterMounts copy()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterMounts toData()
/*     */     {
/* 759 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FighterMounts toBean()
/*     */     {
/* 764 */       return new FighterMounts(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterMounts toDataIf()
/*     */     {
/* 770 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FighterMounts toBeanIf()
/*     */     {
/* 775 */       return new FighterMounts(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 781 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 785 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 789 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 793 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 797 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 801 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 805 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMountuuid()
/*     */     {
/* 812 */       return this.mountuuid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMountcfgid()
/*     */     {
/* 819 */       return this.mountcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getSkillmap()
/*     */     {
/* 826 */       return this.skillmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getSkillmapAsData()
/*     */     {
/* 833 */       return this.skillmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMountuuid(long _v_)
/*     */     {
/* 840 */       this.mountuuid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMountcfgid(int _v_)
/*     */     {
/* 847 */       this.mountcfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 853 */       if (!(_o1_ instanceof Data)) return false;
/* 854 */       Data _o_ = (Data)_o1_;
/* 855 */       if (this.mountuuid != _o_.mountuuid) return false;
/* 856 */       if (this.mountcfgid != _o_.mountcfgid) return false;
/* 857 */       if (!this.skillmap.equals(_o_.skillmap)) return false;
/* 858 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 864 */       int _h_ = 0;
/* 865 */       _h_ = (int)(_h_ + this.mountuuid);
/* 866 */       _h_ += this.mountcfgid;
/* 867 */       _h_ += this.skillmap.hashCode();
/* 868 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 874 */       StringBuilder _sb_ = new StringBuilder();
/* 875 */       _sb_.append("(");
/* 876 */       _sb_.append(this.mountuuid);
/* 877 */       _sb_.append(",");
/* 878 */       _sb_.append(this.mountcfgid);
/* 879 */       _sb_.append(",");
/* 880 */       _sb_.append(this.skillmap);
/* 881 */       _sb_.append(")");
/* 882 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FighterMounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
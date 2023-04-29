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
/*     */ public final class FighterOutFightInfo extends XBean implements xbean.FighterOutFightInfo
/*     */ {
/*     */   private int ocp;
/*     */   private int gender;
/*     */   private HashMap<Integer, Integer> skills;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.ocp = 0;
/*  23 */     this.gender = 0;
/*  24 */     this.skills.clear();
/*     */   }
/*     */   
/*     */   FighterOutFightInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.ocp = 0;
/*  31 */     this.gender = 0;
/*  32 */     this.skills = new HashMap();
/*     */   }
/*     */   
/*     */   public FighterOutFightInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FighterOutFightInfo(FighterOutFightInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FighterOutFightInfo(xbean.FighterOutFightInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof FighterOutFightInfo)) { assign((FighterOutFightInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FighterOutFightInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.ocp = _o_.ocp;
/*  58 */     this.gender = _o_.gender;
/*  59 */     this.skills = new HashMap();
/*  60 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skills.entrySet()) {
/*  61 */       this.skills.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  66 */     this.ocp = _o_.ocp;
/*  67 */     this.gender = _o_.gender;
/*  68 */     this.skills = new HashMap();
/*  69 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skills.entrySet()) {
/*  70 */       this.skills.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     _os_.marshal(this.ocp);
/*  78 */     _os_.marshal(this.gender);
/*  79 */     _os_.compact_uint32(this.skills.size());
/*  80 */     for (Map.Entry<Integer, Integer> _e_ : this.skills.entrySet())
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
/*  92 */     this.ocp = _os_.unmarshal_int();
/*  93 */     this.gender = _os_.unmarshal_int();
/*     */     
/*  95 */     int size = _os_.uncompact_uint32();
/*  96 */     if (size >= 12)
/*     */     {
/*  98 */       this.skills = new HashMap(size * 2);
/*     */     }
/* 100 */     for (; size > 0; size--)
/*     */     {
/* 102 */       int _k_ = 0;
/* 103 */       _k_ = _os_.unmarshal_int();
/* 104 */       int _v_ = 0;
/* 105 */       _v_ = _os_.unmarshal_int();
/* 106 */       this.skills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
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
/* 117 */     _size_ += CodedOutputStream.computeInt32Size(1, this.ocp);
/* 118 */     _size_ += CodedOutputStream.computeInt32Size(2, this.gender);
/* 119 */     for (Map.Entry<Integer, Integer> _e_ : this.skills.entrySet())
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
/* 133 */       _output_.writeInt32(1, this.ocp);
/* 134 */       _output_.writeInt32(2, this.gender);
/* 135 */       for (Map.Entry<Integer, Integer> _e_ : this.skills.entrySet())
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
/* 167 */           this.ocp = _input_.readInt32();
/* 168 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 172 */           this.gender = _input_.readInt32();
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
/* 186 */           this.skills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
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
/*     */   public xbean.FighterOutFightInfo copy()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return new FighterOutFightInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FighterOutFightInfo toData()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FighterOutFightInfo toBean()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new FighterOutFightInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FighterOutFightInfo toDataIf()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FighterOutFightInfo toBeanIf()
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
/*     */   public int getOcp()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     return this.ocp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGender()
/*     */   {
/* 263 */     _xdb_verify_unsafe_();
/* 264 */     return this.gender;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getSkills()
/*     */   {
/* 271 */     _xdb_verify_unsafe_();
/* 272 */     return xdb.Logs.logMap(new LogKey(this, "skills"), this.skills);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getSkillsAsData()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/*     */     
/* 281 */     FighterOutFightInfo _o_ = this;
/* 282 */     Map<Integer, Integer> skills = new HashMap();
/* 283 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skills.entrySet())
/* 284 */       skills.put(_e_.getKey(), _e_.getValue());
/* 285 */     return skills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOcp(int _v_)
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/* 293 */     xdb.Logs.logIf(new LogKey(this, "ocp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 297 */         new xdb.logs.LogInt(this, FighterOutFightInfo.this.ocp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 301 */             FighterOutFightInfo.this.ocp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 305 */     });
/* 306 */     this.ocp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGender(int _v_)
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     xdb.Logs.logIf(new LogKey(this, "gender")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 318 */         new xdb.logs.LogInt(this, FighterOutFightInfo.this.gender)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 322 */             FighterOutFightInfo.this.gender = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 326 */     });
/* 327 */     this.gender = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     FighterOutFightInfo _o_ = null;
/* 335 */     if ((_o1_ instanceof FighterOutFightInfo)) { _o_ = (FighterOutFightInfo)_o1_;
/* 336 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 337 */       return false;
/* 338 */     if (this.ocp != _o_.ocp) return false;
/* 339 */     if (this.gender != _o_.gender) return false;
/* 340 */     if (!this.skills.equals(_o_.skills)) return false;
/* 341 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 347 */     _xdb_verify_unsafe_();
/* 348 */     int _h_ = 0;
/* 349 */     _h_ += this.ocp;
/* 350 */     _h_ += this.gender;
/* 351 */     _h_ += this.skills.hashCode();
/* 352 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 358 */     _xdb_verify_unsafe_();
/* 359 */     StringBuilder _sb_ = new StringBuilder();
/* 360 */     _sb_.append("(");
/* 361 */     _sb_.append(this.ocp);
/* 362 */     _sb_.append(",");
/* 363 */     _sb_.append(this.gender);
/* 364 */     _sb_.append(",");
/* 365 */     _sb_.append(this.skills);
/* 366 */     _sb_.append(")");
/* 367 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 373 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 374 */     lb.add(new xdb.logs.ListenableChanged().setVarName("ocp"));
/* 375 */     lb.add(new xdb.logs.ListenableChanged().setVarName("gender"));
/* 376 */     lb.add(new xdb.logs.ListenableMap().setVarName("skills"));
/* 377 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FighterOutFightInfo {
/*     */     private Const() {}
/*     */     
/*     */     FighterOutFightInfo nThis() {
/* 384 */       return FighterOutFightInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 390 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterOutFightInfo copy()
/*     */     {
/* 396 */       return FighterOutFightInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterOutFightInfo toData()
/*     */     {
/* 402 */       return FighterOutFightInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FighterOutFightInfo toBean()
/*     */     {
/* 407 */       return FighterOutFightInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterOutFightInfo toDataIf()
/*     */     {
/* 413 */       return FighterOutFightInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FighterOutFightInfo toBeanIf()
/*     */     {
/* 418 */       return FighterOutFightInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getOcp()
/*     */     {
/* 425 */       FighterOutFightInfo.this._xdb_verify_unsafe_();
/* 426 */       return FighterOutFightInfo.this.ocp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGender()
/*     */     {
/* 433 */       FighterOutFightInfo.this._xdb_verify_unsafe_();
/* 434 */       return FighterOutFightInfo.this.gender;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getSkills()
/*     */     {
/* 441 */       FighterOutFightInfo.this._xdb_verify_unsafe_();
/* 442 */       return xdb.Consts.constMap(FighterOutFightInfo.this.skills);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getSkillsAsData()
/*     */     {
/* 449 */       FighterOutFightInfo.this._xdb_verify_unsafe_();
/*     */       
/* 451 */       FighterOutFightInfo _o_ = FighterOutFightInfo.this;
/* 452 */       Map<Integer, Integer> skills = new HashMap();
/* 453 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skills.entrySet())
/* 454 */         skills.put(_e_.getKey(), _e_.getValue());
/* 455 */       return skills;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOcp(int _v_)
/*     */     {
/* 462 */       FighterOutFightInfo.this._xdb_verify_unsafe_();
/* 463 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGender(int _v_)
/*     */     {
/* 470 */       FighterOutFightInfo.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 477 */       FighterOutFightInfo.this._xdb_verify_unsafe_();
/* 478 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 484 */       FighterOutFightInfo.this._xdb_verify_unsafe_();
/* 485 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 491 */       return FighterOutFightInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 497 */       return FighterOutFightInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 503 */       FighterOutFightInfo.this._xdb_verify_unsafe_();
/* 504 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 510 */       return FighterOutFightInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 516 */       return FighterOutFightInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 522 */       FighterOutFightInfo.this._xdb_verify_unsafe_();
/* 523 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 529 */       return FighterOutFightInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 535 */       return FighterOutFightInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 541 */       return FighterOutFightInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 547 */       return FighterOutFightInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 553 */       return FighterOutFightInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 559 */       return FighterOutFightInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 565 */       return FighterOutFightInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FighterOutFightInfo
/*     */   {
/*     */     private int ocp;
/*     */     
/*     */     private int gender;
/*     */     
/*     */     private HashMap<Integer, Integer> skills;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 581 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 586 */       this.ocp = 0;
/* 587 */       this.gender = 0;
/* 588 */       this.skills = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.FighterOutFightInfo _o1_)
/*     */     {
/* 593 */       if ((_o1_ instanceof FighterOutFightInfo)) { assign((FighterOutFightInfo)_o1_);
/* 594 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 595 */       } else if ((_o1_ instanceof FighterOutFightInfo.Const)) assign(((FighterOutFightInfo.Const)_o1_).nThis()); else {
/* 596 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FighterOutFightInfo _o_) {
/* 601 */       this.ocp = _o_.ocp;
/* 602 */       this.gender = _o_.gender;
/* 603 */       this.skills = new HashMap();
/* 604 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skills.entrySet()) {
/* 605 */         this.skills.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 610 */       this.ocp = _o_.ocp;
/* 611 */       this.gender = _o_.gender;
/* 612 */       this.skills = new HashMap();
/* 613 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skills.entrySet()) {
/* 614 */         this.skills.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 620 */       _os_.marshal(this.ocp);
/* 621 */       _os_.marshal(this.gender);
/* 622 */       _os_.compact_uint32(this.skills.size());
/* 623 */       for (Map.Entry<Integer, Integer> _e_ : this.skills.entrySet())
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
/* 634 */       this.ocp = _os_.unmarshal_int();
/* 635 */       this.gender = _os_.unmarshal_int();
/*     */       
/* 637 */       int size = _os_.uncompact_uint32();
/* 638 */       if (size >= 12)
/*     */       {
/* 640 */         this.skills = new HashMap(size * 2);
/*     */       }
/* 642 */       for (; size > 0; size--)
/*     */       {
/* 644 */         int _k_ = 0;
/* 645 */         _k_ = _os_.unmarshal_int();
/* 646 */         int _v_ = 0;
/* 647 */         _v_ = _os_.unmarshal_int();
/* 648 */         this.skills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 651 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 657 */       int _size_ = 0;
/* 658 */       _size_ += CodedOutputStream.computeInt32Size(1, this.ocp);
/* 659 */       _size_ += CodedOutputStream.computeInt32Size(2, this.gender);
/* 660 */       for (Map.Entry<Integer, Integer> _e_ : this.skills.entrySet())
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
/* 673 */         _output_.writeInt32(1, this.ocp);
/* 674 */         _output_.writeInt32(2, this.gender);
/* 675 */         for (Map.Entry<Integer, Integer> _e_ : this.skills.entrySet())
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
/* 706 */             this.ocp = _input_.readInt32();
/* 707 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 711 */             this.gender = _input_.readInt32();
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
/* 725 */             this.skills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
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
/*     */     public xbean.FighterOutFightInfo copy()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterOutFightInfo toData()
/*     */     {
/* 759 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FighterOutFightInfo toBean()
/*     */     {
/* 764 */       return new FighterOutFightInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterOutFightInfo toDataIf()
/*     */     {
/* 770 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FighterOutFightInfo toBeanIf()
/*     */     {
/* 775 */       return new FighterOutFightInfo(this, null, null);
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
/*     */     public int getOcp()
/*     */     {
/* 812 */       return this.ocp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGender()
/*     */     {
/* 819 */       return this.gender;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getSkills()
/*     */     {
/* 826 */       return this.skills;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getSkillsAsData()
/*     */     {
/* 833 */       return this.skills;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOcp(int _v_)
/*     */     {
/* 840 */       this.ocp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGender(int _v_)
/*     */     {
/* 847 */       this.gender = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 853 */       if (!(_o1_ instanceof Data)) return false;
/* 854 */       Data _o_ = (Data)_o1_;
/* 855 */       if (this.ocp != _o_.ocp) return false;
/* 856 */       if (this.gender != _o_.gender) return false;
/* 857 */       if (!this.skills.equals(_o_.skills)) return false;
/* 858 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 864 */       int _h_ = 0;
/* 865 */       _h_ += this.ocp;
/* 866 */       _h_ += this.gender;
/* 867 */       _h_ += this.skills.hashCode();
/* 868 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 874 */       StringBuilder _sb_ = new StringBuilder();
/* 875 */       _sb_.append("(");
/* 876 */       _sb_.append(this.ocp);
/* 877 */       _sb_.append(",");
/* 878 */       _sb_.append(this.gender);
/* 879 */       _sb_.append(",");
/* 880 */       _sb_.append(this.skills);
/* 881 */       _sb_.append(")");
/* 882 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FighterOutFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
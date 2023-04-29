/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class RolePetFightSkill extends xdb.XBean implements xbean.RolePetFightSkill
/*     */ {
/*     */   private SetX<Integer> skills;
/*     */   private HashMap<Long, Integer> pet2skill;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.skills.clear();
/*  21 */     this.pet2skill.clear();
/*     */   }
/*     */   
/*     */   RolePetFightSkill(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.skills = new SetX();
/*  28 */     this.pet2skill = new HashMap();
/*     */   }
/*     */   
/*     */   public RolePetFightSkill()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RolePetFightSkill(RolePetFightSkill _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RolePetFightSkill(xbean.RolePetFightSkill _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof RolePetFightSkill)) { assign((RolePetFightSkill)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RolePetFightSkill _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.skills = new SetX();
/*  54 */     this.skills.addAll(_o_.skills);
/*  55 */     this.pet2skill = new HashMap();
/*  56 */     for (Map.Entry<Long, Integer> _e_ : _o_.pet2skill.entrySet()) {
/*  57 */       this.pet2skill.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  62 */     this.skills = new SetX();
/*  63 */     this.skills.addAll(_o_.skills);
/*  64 */     this.pet2skill = new HashMap();
/*  65 */     for (Map.Entry<Long, Integer> _e_ : _o_.pet2skill.entrySet()) {
/*  66 */       this.pet2skill.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.compact_uint32(this.skills.size());
/*  74 */     for (Integer _v_ : this.skills)
/*     */     {
/*  76 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  78 */     _os_.compact_uint32(this.pet2skill.size());
/*  79 */     for (Map.Entry<Long, Integer> _e_ : this.pet2skill.entrySet())
/*     */     {
/*  81 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  82 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  93 */       int _v_ = 0;
/*  94 */       _v_ = _os_.unmarshal_int();
/*  95 */       this.skills.add(Integer.valueOf(_v_));
/*     */     }
/*     */     
/*  98 */     int size = _os_.uncompact_uint32();
/*  99 */     if (size >= 12)
/*     */     {
/* 101 */       this.pet2skill = new HashMap(size * 2);
/*     */     }
/* 103 */     for (; size > 0; size--)
/*     */     {
/* 105 */       long _k_ = 0L;
/* 106 */       _k_ = _os_.unmarshal_long();
/* 107 */       int _v_ = 0;
/* 108 */       _v_ = _os_.unmarshal_int();
/* 109 */       this.pet2skill.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 112 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/* 119 */     int _size_ = 0;
/* 120 */     for (Integer _v_ : this.skills)
/*     */     {
/* 122 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */     }
/* 124 */     for (Map.Entry<Long, Integer> _e_ : this.pet2skill.entrySet())
/*     */     {
/* 126 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 127 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 129 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       for (Integer _v_ : this.skills)
/*     */       {
/* 140 */         _output_.writeInt32(1, _v_.intValue());
/*     */       }
/* 142 */       for (Map.Entry<Long, Integer> _e_ : this.pet2skill.entrySet())
/*     */       {
/* 144 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 145 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
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
/* 174 */           int _v_ = 0;
/* 175 */           _v_ = _input_.readInt32();
/* 176 */           this.skills.add(Integer.valueOf(_v_));
/* 177 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 181 */           long _k_ = 0L;
/* 182 */           _k_ = _input_.readInt64();
/* 183 */           int readTag = _input_.readTag();
/* 184 */           if (16 != readTag)
/*     */           {
/* 186 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 188 */           int _v_ = 0;
/* 189 */           _v_ = _input_.readInt32();
/* 190 */           this.pet2skill.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 191 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 195 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 197 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 206 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 210 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 212 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RolePetFightSkill copy()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new RolePetFightSkill(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RolePetFightSkill toData()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RolePetFightSkill toBean()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new RolePetFightSkill(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RolePetFightSkill toDataIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RolePetFightSkill toBeanIf()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getSkills()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return xdb.Logs.logSet(new xdb.LogKey(this, "skills"), this.skills);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getSkillsAsData()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/*     */     
/* 268 */     RolePetFightSkill _o_ = this;
/* 269 */     Set<Integer> skills = new SetX();
/* 270 */     skills.addAll(_o_.skills);
/* 271 */     return skills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Long, Integer> getPet2skill()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     return xdb.Logs.logMap(new xdb.LogKey(this, "pet2skill"), this.pet2skill);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Long, Integer> getPet2skillAsData()
/*     */   {
/* 286 */     _xdb_verify_unsafe_();
/*     */     
/* 288 */     RolePetFightSkill _o_ = this;
/* 289 */     java.util.Map<Long, Integer> pet2skill = new HashMap();
/* 290 */     for (Map.Entry<Long, Integer> _e_ : _o_.pet2skill.entrySet())
/* 291 */       pet2skill.put(_e_.getKey(), _e_.getValue());
/* 292 */     return pet2skill;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     RolePetFightSkill _o_ = null;
/* 300 */     if ((_o1_ instanceof RolePetFightSkill)) { _o_ = (RolePetFightSkill)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (!this.skills.equals(_o_.skills)) return false;
/* 304 */     if (!this.pet2skill.equals(_o_.pet2skill)) return false;
/* 305 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     int _h_ = 0;
/* 313 */     _h_ += this.skills.hashCode();
/* 314 */     _h_ += this.pet2skill.hashCode();
/* 315 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     StringBuilder _sb_ = new StringBuilder();
/* 323 */     _sb_.append("(");
/* 324 */     _sb_.append(this.skills);
/* 325 */     _sb_.append(",");
/* 326 */     _sb_.append(this.pet2skill);
/* 327 */     _sb_.append(")");
/* 328 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 334 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 335 */     lb.add(new xdb.logs.ListenableSet().setVarName("skills"));
/* 336 */     lb.add(new xdb.logs.ListenableMap().setVarName("pet2skill"));
/* 337 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RolePetFightSkill {
/*     */     private Const() {}
/*     */     
/*     */     RolePetFightSkill nThis() {
/* 344 */       return RolePetFightSkill.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 350 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePetFightSkill copy()
/*     */     {
/* 356 */       return RolePetFightSkill.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePetFightSkill toData()
/*     */     {
/* 362 */       return RolePetFightSkill.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RolePetFightSkill toBean()
/*     */     {
/* 367 */       return RolePetFightSkill.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePetFightSkill toDataIf()
/*     */     {
/* 373 */       return RolePetFightSkill.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RolePetFightSkill toBeanIf()
/*     */     {
/* 378 */       return RolePetFightSkill.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSkills()
/*     */     {
/* 385 */       RolePetFightSkill.this._xdb_verify_unsafe_();
/* 386 */       return xdb.Consts.constSet(RolePetFightSkill.this.skills);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getSkillsAsData()
/*     */     {
/* 392 */       RolePetFightSkill.this._xdb_verify_unsafe_();
/*     */       
/* 394 */       RolePetFightSkill _o_ = RolePetFightSkill.this;
/* 395 */       Set<Integer> skills = new SetX();
/* 396 */       skills.addAll(_o_.skills);
/* 397 */       return skills;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, Integer> getPet2skill()
/*     */     {
/* 404 */       RolePetFightSkill.this._xdb_verify_unsafe_();
/* 405 */       return xdb.Consts.constMap(RolePetFightSkill.this.pet2skill);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, Integer> getPet2skillAsData()
/*     */     {
/* 412 */       RolePetFightSkill.this._xdb_verify_unsafe_();
/*     */       
/* 414 */       RolePetFightSkill _o_ = RolePetFightSkill.this;
/* 415 */       java.util.Map<Long, Integer> pet2skill = new HashMap();
/* 416 */       for (Map.Entry<Long, Integer> _e_ : _o_.pet2skill.entrySet())
/* 417 */         pet2skill.put(_e_.getKey(), _e_.getValue());
/* 418 */       return pet2skill;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 424 */       RolePetFightSkill.this._xdb_verify_unsafe_();
/* 425 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 431 */       RolePetFightSkill.this._xdb_verify_unsafe_();
/* 432 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 438 */       return RolePetFightSkill.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 444 */       return RolePetFightSkill.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 450 */       RolePetFightSkill.this._xdb_verify_unsafe_();
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 457 */       return RolePetFightSkill.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 463 */       return RolePetFightSkill.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 469 */       RolePetFightSkill.this._xdb_verify_unsafe_();
/* 470 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 476 */       return RolePetFightSkill.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 482 */       return RolePetFightSkill.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 488 */       return RolePetFightSkill.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 494 */       return RolePetFightSkill.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 500 */       return RolePetFightSkill.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 506 */       return RolePetFightSkill.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 512 */       return RolePetFightSkill.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RolePetFightSkill
/*     */   {
/*     */     private HashSet<Integer> skills;
/*     */     
/*     */     private HashMap<Long, Integer> pet2skill;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 526 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 531 */       this.skills = new HashSet();
/* 532 */       this.pet2skill = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.RolePetFightSkill _o1_)
/*     */     {
/* 537 */       if ((_o1_ instanceof RolePetFightSkill)) { assign((RolePetFightSkill)_o1_);
/* 538 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 539 */       } else if ((_o1_ instanceof RolePetFightSkill.Const)) assign(((RolePetFightSkill.Const)_o1_).nThis()); else {
/* 540 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RolePetFightSkill _o_) {
/* 545 */       this.skills = new HashSet();
/* 546 */       this.skills.addAll(_o_.skills);
/* 547 */       this.pet2skill = new HashMap();
/* 548 */       for (Map.Entry<Long, Integer> _e_ : _o_.pet2skill.entrySet()) {
/* 549 */         this.pet2skill.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 554 */       this.skills = new HashSet();
/* 555 */       this.skills.addAll(_o_.skills);
/* 556 */       this.pet2skill = new HashMap();
/* 557 */       for (Map.Entry<Long, Integer> _e_ : _o_.pet2skill.entrySet()) {
/* 558 */         this.pet2skill.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 564 */       _os_.compact_uint32(this.skills.size());
/* 565 */       for (Integer _v_ : this.skills)
/*     */       {
/* 567 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 569 */       _os_.compact_uint32(this.pet2skill.size());
/* 570 */       for (Map.Entry<Long, Integer> _e_ : this.pet2skill.entrySet())
/*     */       {
/* 572 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 573 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 575 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 581 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 583 */         int _v_ = 0;
/* 584 */         _v_ = _os_.unmarshal_int();
/* 585 */         this.skills.add(Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 588 */       int size = _os_.uncompact_uint32();
/* 589 */       if (size >= 12)
/*     */       {
/* 591 */         this.pet2skill = new HashMap(size * 2);
/*     */       }
/* 593 */       for (; size > 0; size--)
/*     */       {
/* 595 */         long _k_ = 0L;
/* 596 */         _k_ = _os_.unmarshal_long();
/* 597 */         int _v_ = 0;
/* 598 */         _v_ = _os_.unmarshal_int();
/* 599 */         this.pet2skill.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 602 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 608 */       int _size_ = 0;
/* 609 */       for (Integer _v_ : this.skills)
/*     */       {
/* 611 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */       }
/* 613 */       for (Map.Entry<Long, Integer> _e_ : this.pet2skill.entrySet())
/*     */       {
/* 615 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 616 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 618 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 626 */         for (Integer _v_ : this.skills)
/*     */         {
/* 628 */           _output_.writeInt32(1, _v_.intValue());
/*     */         }
/* 630 */         for (Map.Entry<Long, Integer> _e_ : this.pet2skill.entrySet())
/*     */         {
/* 632 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 633 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 638 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 640 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 648 */         boolean done = false;
/* 649 */         while (!done)
/*     */         {
/* 651 */           int tag = _input_.readTag();
/* 652 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 656 */             done = true;
/* 657 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 661 */             int _v_ = 0;
/* 662 */             _v_ = _input_.readInt32();
/* 663 */             this.skills.add(Integer.valueOf(_v_));
/* 664 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 668 */             long _k_ = 0L;
/* 669 */             _k_ = _input_.readInt64();
/* 670 */             int readTag = _input_.readTag();
/* 671 */             if (16 != readTag)
/*     */             {
/* 673 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 675 */             int _v_ = 0;
/* 676 */             _v_ = _input_.readInt32();
/* 677 */             this.pet2skill.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 678 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 682 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 684 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 693 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 697 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 699 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePetFightSkill copy()
/*     */     {
/* 705 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePetFightSkill toData()
/*     */     {
/* 711 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RolePetFightSkill toBean()
/*     */     {
/* 716 */       return new RolePetFightSkill(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePetFightSkill toDataIf()
/*     */     {
/* 722 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RolePetFightSkill toBeanIf()
/*     */     {
/* 727 */       return new RolePetFightSkill(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 733 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 737 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 741 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 745 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 749 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 753 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 757 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSkills()
/*     */     {
/* 764 */       return this.skills;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSkillsAsData()
/*     */     {
/* 771 */       return this.skills;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, Integer> getPet2skill()
/*     */     {
/* 778 */       return this.pet2skill;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, Integer> getPet2skillAsData()
/*     */     {
/* 785 */       return this.pet2skill;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 791 */       if (!(_o1_ instanceof Data)) return false;
/* 792 */       Data _o_ = (Data)_o1_;
/* 793 */       if (!this.skills.equals(_o_.skills)) return false;
/* 794 */       if (!this.pet2skill.equals(_o_.pet2skill)) return false;
/* 795 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 801 */       int _h_ = 0;
/* 802 */       _h_ += this.skills.hashCode();
/* 803 */       _h_ += this.pet2skill.hashCode();
/* 804 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 810 */       StringBuilder _sb_ = new StringBuilder();
/* 811 */       _sb_.append("(");
/* 812 */       _sb_.append(this.skills);
/* 813 */       _sb_.append(",");
/* 814 */       _sb_.append(this.pet2skill);
/* 815 */       _sb_.append(")");
/* 816 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RolePetFightSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
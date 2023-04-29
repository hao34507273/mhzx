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
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class RandomSkillInfo extends XBean implements xbean.RandomSkillInfo
/*     */ {
/*     */   private xbean.WingSkill phase_up_reset_skill;
/*     */   private HashMap<Integer, xbean.MainSubSkill> index_reset_skill;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.phase_up_reset_skill._reset_unsafe_();
/*  21 */     this.index_reset_skill.clear();
/*     */   }
/*     */   
/*     */   RandomSkillInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.phase_up_reset_skill = new WingSkill(0, this, "phase_up_reset_skill");
/*  28 */     this.index_reset_skill = new HashMap();
/*     */   }
/*     */   
/*     */   public RandomSkillInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RandomSkillInfo(RandomSkillInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RandomSkillInfo(xbean.RandomSkillInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof RandomSkillInfo)) { assign((RandomSkillInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RandomSkillInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.phase_up_reset_skill = new WingSkill(_o_.phase_up_reset_skill, this, "phase_up_reset_skill");
/*  54 */     this.index_reset_skill = new HashMap();
/*  55 */     for (Map.Entry<Integer, xbean.MainSubSkill> _e_ : _o_.index_reset_skill.entrySet()) {
/*  56 */       this.index_reset_skill.put(_e_.getKey(), new MainSubSkill((xbean.MainSubSkill)_e_.getValue(), this, "index_reset_skill"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  61 */     this.phase_up_reset_skill = new WingSkill(_o_.phase_up_reset_skill, this, "phase_up_reset_skill");
/*  62 */     this.index_reset_skill = new HashMap();
/*  63 */     for (Map.Entry<Integer, xbean.MainSubSkill> _e_ : _o_.index_reset_skill.entrySet()) {
/*  64 */       this.index_reset_skill.put(_e_.getKey(), new MainSubSkill((xbean.MainSubSkill)_e_.getValue(), this, "index_reset_skill"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     this.phase_up_reset_skill.marshal(_os_);
/*  72 */     _os_.compact_uint32(this.index_reset_skill.size());
/*  73 */     for (Map.Entry<Integer, xbean.MainSubSkill> _e_ : this.index_reset_skill.entrySet())
/*     */     {
/*  75 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  76 */       ((xbean.MainSubSkill)_e_.getValue()).marshal(_os_);
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     this.phase_up_reset_skill.unmarshal(_os_);
/*     */     
/*  87 */     int size = _os_.uncompact_uint32();
/*  88 */     if (size >= 12)
/*     */     {
/*  90 */       this.index_reset_skill = new HashMap(size * 2);
/*     */     }
/*  92 */     for (; size > 0; size--)
/*     */     {
/*  94 */       int _k_ = 0;
/*  95 */       _k_ = _os_.unmarshal_int();
/*  96 */       xbean.MainSubSkill _v_ = new MainSubSkill(0, this, "index_reset_skill");
/*  97 */       _v_.unmarshal(_os_);
/*  98 */       this.index_reset_skill.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     _size_ += CodedOutputStream.computeMessageSize(1, this.phase_up_reset_skill);
/* 110 */     for (Map.Entry<Integer, xbean.MainSubSkill> _e_ : this.index_reset_skill.entrySet())
/*     */     {
/* 112 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 113 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       _output_.writeMessage(1, this.phase_up_reset_skill);
/* 125 */       for (Map.Entry<Integer, xbean.MainSubSkill> _e_ : this.index_reset_skill.entrySet())
/*     */       {
/* 127 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 128 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 133 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 135 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 144 */       boolean done = false;
/* 145 */       while (!done)
/*     */       {
/* 147 */         int tag = _input_.readTag();
/* 148 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 152 */           done = true;
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 157 */           _input_.readMessage(this.phase_up_reset_skill);
/* 158 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 162 */           int _k_ = 0;
/* 163 */           _k_ = _input_.readInt32();
/* 164 */           int readTag = _input_.readTag();
/* 165 */           if (18 != readTag)
/*     */           {
/* 167 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 169 */           xbean.MainSubSkill _v_ = new MainSubSkill(0, this, "index_reset_skill");
/* 170 */           _input_.readMessage(_v_);
/* 171 */           this.index_reset_skill.put(Integer.valueOf(_k_), _v_);
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RandomSkillInfo copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new RandomSkillInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RandomSkillInfo toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RandomSkillInfo toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new RandomSkillInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RandomSkillInfo toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RandomSkillInfo toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.WingSkill getPhase_up_reset_skill()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.phase_up_reset_skill;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.MainSubSkill> getIndex_reset_skill()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return xdb.Logs.logMap(new xdb.LogKey(this, "index_reset_skill"), this.index_reset_skill);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.MainSubSkill> getIndex_reset_skillAsData()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/*     */     
/* 258 */     RandomSkillInfo _o_ = this;
/* 259 */     Map<Integer, xbean.MainSubSkill> index_reset_skill = new HashMap();
/* 260 */     for (Map.Entry<Integer, xbean.MainSubSkill> _e_ : _o_.index_reset_skill.entrySet())
/* 261 */       index_reset_skill.put(_e_.getKey(), new MainSubSkill.Data((xbean.MainSubSkill)_e_.getValue()));
/* 262 */     return index_reset_skill;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     RandomSkillInfo _o_ = null;
/* 270 */     if ((_o1_ instanceof RandomSkillInfo)) { _o_ = (RandomSkillInfo)_o1_;
/* 271 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 272 */       return false;
/* 273 */     if (!this.phase_up_reset_skill.equals(_o_.phase_up_reset_skill)) return false;
/* 274 */     if (!this.index_reset_skill.equals(_o_.index_reset_skill)) return false;
/* 275 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     int _h_ = 0;
/* 283 */     _h_ += this.phase_up_reset_skill.hashCode();
/* 284 */     _h_ += this.index_reset_skill.hashCode();
/* 285 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     StringBuilder _sb_ = new StringBuilder();
/* 293 */     _sb_.append("(");
/* 294 */     _sb_.append(this.phase_up_reset_skill);
/* 295 */     _sb_.append(",");
/* 296 */     _sb_.append(this.index_reset_skill);
/* 297 */     _sb_.append(")");
/* 298 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 304 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 305 */     lb.add(new xdb.logs.ListenableChanged().setVarName("phase_up_reset_skill"));
/* 306 */     lb.add(new xdb.logs.ListenableMap().setVarName("index_reset_skill"));
/* 307 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RandomSkillInfo {
/*     */     private Const() {}
/*     */     
/*     */     RandomSkillInfo nThis() {
/* 314 */       return RandomSkillInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 320 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RandomSkillInfo copy()
/*     */     {
/* 326 */       return RandomSkillInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RandomSkillInfo toData()
/*     */     {
/* 332 */       return RandomSkillInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RandomSkillInfo toBean()
/*     */     {
/* 337 */       return RandomSkillInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RandomSkillInfo toDataIf()
/*     */     {
/* 343 */       return RandomSkillInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RandomSkillInfo toBeanIf()
/*     */     {
/* 348 */       return RandomSkillInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.WingSkill getPhase_up_reset_skill()
/*     */     {
/* 355 */       RandomSkillInfo.this._xdb_verify_unsafe_();
/* 356 */       return (xbean.WingSkill)xdb.Consts.toConst(RandomSkillInfo.this.phase_up_reset_skill);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.MainSubSkill> getIndex_reset_skill()
/*     */     {
/* 363 */       RandomSkillInfo.this._xdb_verify_unsafe_();
/* 364 */       return xdb.Consts.constMap(RandomSkillInfo.this.index_reset_skill);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.MainSubSkill> getIndex_reset_skillAsData()
/*     */     {
/* 371 */       RandomSkillInfo.this._xdb_verify_unsafe_();
/*     */       
/* 373 */       RandomSkillInfo _o_ = RandomSkillInfo.this;
/* 374 */       Map<Integer, xbean.MainSubSkill> index_reset_skill = new HashMap();
/* 375 */       for (Map.Entry<Integer, xbean.MainSubSkill> _e_ : _o_.index_reset_skill.entrySet())
/* 376 */         index_reset_skill.put(_e_.getKey(), new MainSubSkill.Data((xbean.MainSubSkill)_e_.getValue()));
/* 377 */       return index_reset_skill;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 383 */       RandomSkillInfo.this._xdb_verify_unsafe_();
/* 384 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 390 */       RandomSkillInfo.this._xdb_verify_unsafe_();
/* 391 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 397 */       return RandomSkillInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 403 */       return RandomSkillInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 409 */       RandomSkillInfo.this._xdb_verify_unsafe_();
/* 410 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 416 */       return RandomSkillInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 422 */       return RandomSkillInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 428 */       RandomSkillInfo.this._xdb_verify_unsafe_();
/* 429 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 435 */       return RandomSkillInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 441 */       return RandomSkillInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 447 */       return RandomSkillInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 453 */       return RandomSkillInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 459 */       return RandomSkillInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 465 */       return RandomSkillInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 471 */       return RandomSkillInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RandomSkillInfo
/*     */   {
/*     */     private xbean.WingSkill phase_up_reset_skill;
/*     */     
/*     */     private HashMap<Integer, xbean.MainSubSkill> index_reset_skill;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 485 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 490 */       this.phase_up_reset_skill = new WingSkill.Data();
/* 491 */       this.index_reset_skill = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.RandomSkillInfo _o1_)
/*     */     {
/* 496 */       if ((_o1_ instanceof RandomSkillInfo)) { assign((RandomSkillInfo)_o1_);
/* 497 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 498 */       } else if ((_o1_ instanceof RandomSkillInfo.Const)) assign(((RandomSkillInfo.Const)_o1_).nThis()); else {
/* 499 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RandomSkillInfo _o_) {
/* 504 */       this.phase_up_reset_skill = new WingSkill.Data(_o_.phase_up_reset_skill);
/* 505 */       this.index_reset_skill = new HashMap();
/* 506 */       for (Map.Entry<Integer, xbean.MainSubSkill> _e_ : _o_.index_reset_skill.entrySet()) {
/* 507 */         this.index_reset_skill.put(_e_.getKey(), new MainSubSkill.Data((xbean.MainSubSkill)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 512 */       this.phase_up_reset_skill = new WingSkill.Data(_o_.phase_up_reset_skill);
/* 513 */       this.index_reset_skill = new HashMap();
/* 514 */       for (Map.Entry<Integer, xbean.MainSubSkill> _e_ : _o_.index_reset_skill.entrySet()) {
/* 515 */         this.index_reset_skill.put(_e_.getKey(), new MainSubSkill.Data((xbean.MainSubSkill)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       this.phase_up_reset_skill.marshal(_os_);
/* 522 */       _os_.compact_uint32(this.index_reset_skill.size());
/* 523 */       for (Map.Entry<Integer, xbean.MainSubSkill> _e_ : this.index_reset_skill.entrySet())
/*     */       {
/* 525 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 526 */         ((xbean.MainSubSkill)_e_.getValue()).marshal(_os_);
/*     */       }
/* 528 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 534 */       this.phase_up_reset_skill.unmarshal(_os_);
/*     */       
/* 536 */       int size = _os_.uncompact_uint32();
/* 537 */       if (size >= 12)
/*     */       {
/* 539 */         this.index_reset_skill = new HashMap(size * 2);
/*     */       }
/* 541 */       for (; size > 0; size--)
/*     */       {
/* 543 */         int _k_ = 0;
/* 544 */         _k_ = _os_.unmarshal_int();
/* 545 */         xbean.MainSubSkill _v_ = xbean.Pod.newMainSubSkillData();
/* 546 */         _v_.unmarshal(_os_);
/* 547 */         this.index_reset_skill.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 550 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 556 */       int _size_ = 0;
/* 557 */       _size_ += CodedOutputStream.computeMessageSize(1, this.phase_up_reset_skill);
/* 558 */       for (Map.Entry<Integer, xbean.MainSubSkill> _e_ : this.index_reset_skill.entrySet())
/*     */       {
/* 560 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 561 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 563 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 571 */         _output_.writeMessage(1, this.phase_up_reset_skill);
/* 572 */         for (Map.Entry<Integer, xbean.MainSubSkill> _e_ : this.index_reset_skill.entrySet())
/*     */         {
/* 574 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 575 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 580 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 582 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 590 */         boolean done = false;
/* 591 */         while (!done)
/*     */         {
/* 593 */           int tag = _input_.readTag();
/* 594 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 598 */             done = true;
/* 599 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 603 */             _input_.readMessage(this.phase_up_reset_skill);
/* 604 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 608 */             int _k_ = 0;
/* 609 */             _k_ = _input_.readInt32();
/* 610 */             int readTag = _input_.readTag();
/* 611 */             if (18 != readTag)
/*     */             {
/* 613 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 615 */             xbean.MainSubSkill _v_ = xbean.Pod.newMainSubSkillData();
/* 616 */             _input_.readMessage(_v_);
/* 617 */             this.index_reset_skill.put(Integer.valueOf(_k_), _v_);
/* 618 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 622 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 624 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 633 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 637 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 639 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RandomSkillInfo copy()
/*     */     {
/* 645 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RandomSkillInfo toData()
/*     */     {
/* 651 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RandomSkillInfo toBean()
/*     */     {
/* 656 */       return new RandomSkillInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RandomSkillInfo toDataIf()
/*     */     {
/* 662 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RandomSkillInfo toBeanIf()
/*     */     {
/* 667 */       return new RandomSkillInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 673 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 677 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 681 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 685 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 689 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 693 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 697 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.WingSkill getPhase_up_reset_skill()
/*     */     {
/* 704 */       return this.phase_up_reset_skill;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.MainSubSkill> getIndex_reset_skill()
/*     */     {
/* 711 */       return this.index_reset_skill;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.MainSubSkill> getIndex_reset_skillAsData()
/*     */     {
/* 718 */       return this.index_reset_skill;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 724 */       if (!(_o1_ instanceof Data)) return false;
/* 725 */       Data _o_ = (Data)_o1_;
/* 726 */       if (!this.phase_up_reset_skill.equals(_o_.phase_up_reset_skill)) return false;
/* 727 */       if (!this.index_reset_skill.equals(_o_.index_reset_skill)) return false;
/* 728 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 734 */       int _h_ = 0;
/* 735 */       _h_ += this.phase_up_reset_skill.hashCode();
/* 736 */       _h_ += this.index_reset_skill.hashCode();
/* 737 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 743 */       StringBuilder _sb_ = new StringBuilder();
/* 744 */       _sb_.append("(");
/* 745 */       _sb_.append(this.phase_up_reset_skill);
/* 746 */       _sb_.append(",");
/* 747 */       _sb_.append(this.index_reset_skill);
/* 748 */       _sb_.append(")");
/* 749 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RandomSkillInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
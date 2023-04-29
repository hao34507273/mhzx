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
/*     */ public final class RelatedBoss extends xdb.XBean implements xbean.RelatedBoss
/*     */ {
/*     */   private HashMap<Integer, xbean.BossFights> boss_fights;
/*     */   private SetX<Integer> related_monsters;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.boss_fights.clear();
/*  21 */     this.related_monsters.clear();
/*     */   }
/*     */   
/*     */   RelatedBoss(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.boss_fights = new HashMap();
/*  28 */     this.related_monsters = new SetX();
/*     */   }
/*     */   
/*     */   public RelatedBoss()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RelatedBoss(RelatedBoss _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RelatedBoss(xbean.RelatedBoss _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof RelatedBoss)) { assign((RelatedBoss)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RelatedBoss _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.boss_fights = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.BossFights> _e_ : _o_.boss_fights.entrySet())
/*  55 */       this.boss_fights.put(_e_.getKey(), new BossFights((xbean.BossFights)_e_.getValue(), this, "boss_fights"));
/*  56 */     this.related_monsters = new SetX();
/*  57 */     this.related_monsters.addAll(_o_.related_monsters);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.boss_fights = new HashMap();
/*  63 */     for (Map.Entry<Integer, xbean.BossFights> _e_ : _o_.boss_fights.entrySet())
/*  64 */       this.boss_fights.put(_e_.getKey(), new BossFights((xbean.BossFights)_e_.getValue(), this, "boss_fights"));
/*  65 */     this.related_monsters = new SetX();
/*  66 */     this.related_monsters.addAll(_o_.related_monsters);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.compact_uint32(this.boss_fights.size());
/*  74 */     for (Map.Entry<Integer, xbean.BossFights> _e_ : this.boss_fights.entrySet())
/*     */     {
/*  76 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  77 */       ((xbean.BossFights)_e_.getValue()).marshal(_os_);
/*     */     }
/*  79 */     _os_.compact_uint32(this.related_monsters.size());
/*  80 */     for (Integer _v_ : this.related_monsters)
/*     */     {
/*  82 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*     */     
/*  92 */     int size = _os_.uncompact_uint32();
/*  93 */     if (size >= 12)
/*     */     {
/*  95 */       this.boss_fights = new HashMap(size * 2);
/*     */     }
/*  97 */     for (; size > 0; size--)
/*     */     {
/*  99 */       int _k_ = 0;
/* 100 */       _k_ = _os_.unmarshal_int();
/* 101 */       xbean.BossFights _v_ = new BossFights(0, this, "boss_fights");
/* 102 */       _v_.unmarshal(_os_);
/* 103 */       this.boss_fights.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 106 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 108 */       int _v_ = 0;
/* 109 */       _v_ = _os_.unmarshal_int();
/* 110 */       this.related_monsters.add(Integer.valueOf(_v_));
/*     */     }
/* 112 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/* 119 */     int _size_ = 0;
/* 120 */     for (Map.Entry<Integer, xbean.BossFights> _e_ : this.boss_fights.entrySet())
/*     */     {
/* 122 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 123 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 125 */     for (Integer _v_ : this.related_monsters)
/*     */     {
/* 127 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
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
/* 138 */       for (Map.Entry<Integer, xbean.BossFights> _e_ : this.boss_fights.entrySet())
/*     */       {
/* 140 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 141 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 143 */       for (Integer _v_ : this.related_monsters)
/*     */       {
/* 145 */         _output_.writeInt32(2, _v_.intValue());
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
/* 174 */           int _k_ = 0;
/* 175 */           _k_ = _input_.readInt32();
/* 176 */           int readTag = _input_.readTag();
/* 177 */           if (10 != readTag)
/*     */           {
/* 179 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 181 */           xbean.BossFights _v_ = new BossFights(0, this, "boss_fights");
/* 182 */           _input_.readMessage(_v_);
/* 183 */           this.boss_fights.put(Integer.valueOf(_k_), _v_);
/* 184 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 188 */           int _v_ = 0;
/* 189 */           _v_ = _input_.readInt32();
/* 190 */           this.related_monsters.add(Integer.valueOf(_v_));
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
/*     */   public xbean.RelatedBoss copy()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new RelatedBoss(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RelatedBoss toData()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RelatedBoss toBean()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new RelatedBoss(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RelatedBoss toDataIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RelatedBoss toBeanIf()
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
/*     */   public java.util.Map<Integer, xbean.BossFights> getBoss_fights()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return xdb.Logs.logMap(new xdb.LogKey(this, "boss_fights"), this.boss_fights);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Integer, xbean.BossFights> getBoss_fightsAsData()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/*     */     
/* 269 */     RelatedBoss _o_ = this;
/* 270 */     java.util.Map<Integer, xbean.BossFights> boss_fights = new HashMap();
/* 271 */     for (Map.Entry<Integer, xbean.BossFights> _e_ : _o_.boss_fights.entrySet())
/* 272 */       boss_fights.put(_e_.getKey(), new BossFights.Data((xbean.BossFights)_e_.getValue()));
/* 273 */     return boss_fights;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getRelated_monsters()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return xdb.Logs.logSet(new xdb.LogKey(this, "related_monsters"), this.related_monsters);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getRelated_monstersAsData()
/*     */   {
/* 287 */     _xdb_verify_unsafe_();
/*     */     
/* 289 */     RelatedBoss _o_ = this;
/* 290 */     Set<Integer> related_monsters = new SetX();
/* 291 */     related_monsters.addAll(_o_.related_monsters);
/* 292 */     return related_monsters;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     RelatedBoss _o_ = null;
/* 300 */     if ((_o1_ instanceof RelatedBoss)) { _o_ = (RelatedBoss)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (!this.boss_fights.equals(_o_.boss_fights)) return false;
/* 304 */     if (!this.related_monsters.equals(_o_.related_monsters)) return false;
/* 305 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     int _h_ = 0;
/* 313 */     _h_ += this.boss_fights.hashCode();
/* 314 */     _h_ += this.related_monsters.hashCode();
/* 315 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     StringBuilder _sb_ = new StringBuilder();
/* 323 */     _sb_.append("(");
/* 324 */     _sb_.append(this.boss_fights);
/* 325 */     _sb_.append(",");
/* 326 */     _sb_.append(this.related_monsters);
/* 327 */     _sb_.append(")");
/* 328 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 334 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 335 */     lb.add(new xdb.logs.ListenableMap().setVarName("boss_fights"));
/* 336 */     lb.add(new xdb.logs.ListenableSet().setVarName("related_monsters"));
/* 337 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RelatedBoss {
/*     */     private Const() {}
/*     */     
/*     */     RelatedBoss nThis() {
/* 344 */       return RelatedBoss.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 350 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RelatedBoss copy()
/*     */     {
/* 356 */       return RelatedBoss.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RelatedBoss toData()
/*     */     {
/* 362 */       return RelatedBoss.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RelatedBoss toBean()
/*     */     {
/* 367 */       return RelatedBoss.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RelatedBoss toDataIf()
/*     */     {
/* 373 */       return RelatedBoss.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RelatedBoss toBeanIf()
/*     */     {
/* 378 */       return RelatedBoss.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, xbean.BossFights> getBoss_fights()
/*     */     {
/* 385 */       RelatedBoss.this._xdb_verify_unsafe_();
/* 386 */       return xdb.Consts.constMap(RelatedBoss.this.boss_fights);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, xbean.BossFights> getBoss_fightsAsData()
/*     */     {
/* 393 */       RelatedBoss.this._xdb_verify_unsafe_();
/*     */       
/* 395 */       RelatedBoss _o_ = RelatedBoss.this;
/* 396 */       java.util.Map<Integer, xbean.BossFights> boss_fights = new HashMap();
/* 397 */       for (Map.Entry<Integer, xbean.BossFights> _e_ : _o_.boss_fights.entrySet())
/* 398 */         boss_fights.put(_e_.getKey(), new BossFights.Data((xbean.BossFights)_e_.getValue()));
/* 399 */       return boss_fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getRelated_monsters()
/*     */     {
/* 406 */       RelatedBoss.this._xdb_verify_unsafe_();
/* 407 */       return xdb.Consts.constSet(RelatedBoss.this.related_monsters);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getRelated_monstersAsData()
/*     */     {
/* 413 */       RelatedBoss.this._xdb_verify_unsafe_();
/*     */       
/* 415 */       RelatedBoss _o_ = RelatedBoss.this;
/* 416 */       Set<Integer> related_monsters = new SetX();
/* 417 */       related_monsters.addAll(_o_.related_monsters);
/* 418 */       return related_monsters;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 424 */       RelatedBoss.this._xdb_verify_unsafe_();
/* 425 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 431 */       RelatedBoss.this._xdb_verify_unsafe_();
/* 432 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 438 */       return RelatedBoss.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 444 */       return RelatedBoss.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 450 */       RelatedBoss.this._xdb_verify_unsafe_();
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 457 */       return RelatedBoss.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 463 */       return RelatedBoss.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 469 */       RelatedBoss.this._xdb_verify_unsafe_();
/* 470 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 476 */       return RelatedBoss.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 482 */       return RelatedBoss.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 488 */       return RelatedBoss.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 494 */       return RelatedBoss.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 500 */       return RelatedBoss.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 506 */       return RelatedBoss.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 512 */       return RelatedBoss.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RelatedBoss
/*     */   {
/*     */     private HashMap<Integer, xbean.BossFights> boss_fights;
/*     */     
/*     */     private HashSet<Integer> related_monsters;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 526 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 531 */       this.boss_fights = new HashMap();
/* 532 */       this.related_monsters = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.RelatedBoss _o1_)
/*     */     {
/* 537 */       if ((_o1_ instanceof RelatedBoss)) { assign((RelatedBoss)_o1_);
/* 538 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 539 */       } else if ((_o1_ instanceof RelatedBoss.Const)) assign(((RelatedBoss.Const)_o1_).nThis()); else {
/* 540 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RelatedBoss _o_) {
/* 545 */       this.boss_fights = new HashMap();
/* 546 */       for (Map.Entry<Integer, xbean.BossFights> _e_ : _o_.boss_fights.entrySet())
/* 547 */         this.boss_fights.put(_e_.getKey(), new BossFights.Data((xbean.BossFights)_e_.getValue()));
/* 548 */       this.related_monsters = new HashSet();
/* 549 */       this.related_monsters.addAll(_o_.related_monsters);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 554 */       this.boss_fights = new HashMap();
/* 555 */       for (Map.Entry<Integer, xbean.BossFights> _e_ : _o_.boss_fights.entrySet())
/* 556 */         this.boss_fights.put(_e_.getKey(), new BossFights.Data((xbean.BossFights)_e_.getValue()));
/* 557 */       this.related_monsters = new HashSet();
/* 558 */       this.related_monsters.addAll(_o_.related_monsters);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 564 */       _os_.compact_uint32(this.boss_fights.size());
/* 565 */       for (Map.Entry<Integer, xbean.BossFights> _e_ : this.boss_fights.entrySet())
/*     */       {
/* 567 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 568 */         ((xbean.BossFights)_e_.getValue()).marshal(_os_);
/*     */       }
/* 570 */       _os_.compact_uint32(this.related_monsters.size());
/* 571 */       for (Integer _v_ : this.related_monsters)
/*     */       {
/* 573 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 575 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       int size = _os_.uncompact_uint32();
/* 583 */       if (size >= 12)
/*     */       {
/* 585 */         this.boss_fights = new HashMap(size * 2);
/*     */       }
/* 587 */       for (; size > 0; size--)
/*     */       {
/* 589 */         int _k_ = 0;
/* 590 */         _k_ = _os_.unmarshal_int();
/* 591 */         xbean.BossFights _v_ = xbean.Pod.newBossFightsData();
/* 592 */         _v_.unmarshal(_os_);
/* 593 */         this.boss_fights.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 596 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 598 */         int _v_ = 0;
/* 599 */         _v_ = _os_.unmarshal_int();
/* 600 */         this.related_monsters.add(Integer.valueOf(_v_));
/*     */       }
/* 602 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 608 */       int _size_ = 0;
/* 609 */       for (Map.Entry<Integer, xbean.BossFights> _e_ : this.boss_fights.entrySet())
/*     */       {
/* 611 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 612 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 614 */       for (Integer _v_ : this.related_monsters)
/*     */       {
/* 616 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 618 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 626 */         for (Map.Entry<Integer, xbean.BossFights> _e_ : this.boss_fights.entrySet())
/*     */         {
/* 628 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 629 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 631 */         for (Integer _v_ : this.related_monsters)
/*     */         {
/* 633 */           _output_.writeInt32(2, _v_.intValue());
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
/* 661 */             int _k_ = 0;
/* 662 */             _k_ = _input_.readInt32();
/* 663 */             int readTag = _input_.readTag();
/* 664 */             if (10 != readTag)
/*     */             {
/* 666 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 668 */             xbean.BossFights _v_ = xbean.Pod.newBossFightsData();
/* 669 */             _input_.readMessage(_v_);
/* 670 */             this.boss_fights.put(Integer.valueOf(_k_), _v_);
/* 671 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 675 */             int _v_ = 0;
/* 676 */             _v_ = _input_.readInt32();
/* 677 */             this.related_monsters.add(Integer.valueOf(_v_));
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
/*     */     public xbean.RelatedBoss copy()
/*     */     {
/* 705 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RelatedBoss toData()
/*     */     {
/* 711 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RelatedBoss toBean()
/*     */     {
/* 716 */       return new RelatedBoss(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RelatedBoss toDataIf()
/*     */     {
/* 722 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RelatedBoss toBeanIf()
/*     */     {
/* 727 */       return new RelatedBoss(this, null, null);
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
/*     */     public java.util.Map<Integer, xbean.BossFights> getBoss_fights()
/*     */     {
/* 764 */       return this.boss_fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, xbean.BossFights> getBoss_fightsAsData()
/*     */     {
/* 771 */       return this.boss_fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getRelated_monsters()
/*     */     {
/* 778 */       return this.related_monsters;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getRelated_monstersAsData()
/*     */     {
/* 785 */       return this.related_monsters;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 791 */       if (!(_o1_ instanceof Data)) return false;
/* 792 */       Data _o_ = (Data)_o1_;
/* 793 */       if (!this.boss_fights.equals(_o_.boss_fights)) return false;
/* 794 */       if (!this.related_monsters.equals(_o_.related_monsters)) return false;
/* 795 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 801 */       int _h_ = 0;
/* 802 */       _h_ += this.boss_fights.hashCode();
/* 803 */       _h_ += this.related_monsters.hashCode();
/* 804 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 810 */       StringBuilder _sb_ = new StringBuilder();
/* 811 */       _sb_.append("(");
/* 812 */       _sb_.append(this.boss_fights);
/* 813 */       _sb_.append(",");
/* 814 */       _sb_.append(this.related_monsters);
/* 815 */       _sb_.append(")");
/* 816 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RelatedBoss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*     */ public final class PetFightTeamInfo extends XBean implements xbean.PetFightTeamInfo
/*     */ {
/*     */   private int formation_id;
/*     */   private HashMap<Integer, Long> position2pet;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.formation_id = 0;
/*  21 */     this.position2pet.clear();
/*     */   }
/*     */   
/*     */   PetFightTeamInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.formation_id = 0;
/*  28 */     this.position2pet = new HashMap();
/*     */   }
/*     */   
/*     */   public PetFightTeamInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PetFightTeamInfo(PetFightTeamInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PetFightTeamInfo(xbean.PetFightTeamInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof PetFightTeamInfo)) { assign((PetFightTeamInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PetFightTeamInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.formation_id = _o_.formation_id;
/*  54 */     this.position2pet = new HashMap();
/*  55 */     for (Map.Entry<Integer, Long> _e_ : _o_.position2pet.entrySet()) {
/*  56 */       this.position2pet.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  61 */     this.formation_id = _o_.formation_id;
/*  62 */     this.position2pet = new HashMap();
/*  63 */     for (Map.Entry<Integer, Long> _e_ : _o_.position2pet.entrySet()) {
/*  64 */       this.position2pet.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.formation_id);
/*  72 */     _os_.compact_uint32(this.position2pet.size());
/*  73 */     for (Map.Entry<Integer, Long> _e_ : this.position2pet.entrySet())
/*     */     {
/*  75 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  76 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     this.formation_id = _os_.unmarshal_int();
/*     */     
/*  87 */     int size = _os_.uncompact_uint32();
/*  88 */     if (size >= 12)
/*     */     {
/*  90 */       this.position2pet = new HashMap(size * 2);
/*     */     }
/*  92 */     for (; size > 0; size--)
/*     */     {
/*  94 */       int _k_ = 0;
/*  95 */       _k_ = _os_.unmarshal_int();
/*  96 */       long _v_ = 0L;
/*  97 */       _v_ = _os_.unmarshal_long();
/*  98 */       this.position2pet.put(Integer.valueOf(_k_), Long.valueOf(_v_));
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
/* 109 */     _size_ += CodedOutputStream.computeInt32Size(1, this.formation_id);
/* 110 */     for (Map.Entry<Integer, Long> _e_ : this.position2pet.entrySet())
/*     */     {
/* 112 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 113 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getValue()).longValue());
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
/* 124 */       _output_.writeInt32(1, this.formation_id);
/* 125 */       for (Map.Entry<Integer, Long> _e_ : this.position2pet.entrySet())
/*     */       {
/* 127 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 128 */         _output_.writeInt64(2, ((Long)_e_.getValue()).longValue());
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
/*     */         case 8: 
/* 157 */           this.formation_id = _input_.readInt32();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 162 */           int _k_ = 0;
/* 163 */           _k_ = _input_.readInt32();
/* 164 */           int readTag = _input_.readTag();
/* 165 */           if (16 != readTag)
/*     */           {
/* 167 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 169 */           long _v_ = 0L;
/* 170 */           _v_ = _input_.readInt64();
/* 171 */           this.position2pet.put(Integer.valueOf(_k_), Long.valueOf(_v_));
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
/*     */   public xbean.PetFightTeamInfo copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new PetFightTeamInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetFightTeamInfo toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetFightTeamInfo toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new PetFightTeamInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetFightTeamInfo toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetFightTeamInfo toBeanIf()
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
/*     */   public int getFormation_id()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.formation_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Long> getPosition2pet()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return xdb.Logs.logMap(new xdb.LogKey(this, "position2pet"), this.position2pet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Long> getPosition2petAsData()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/*     */     
/* 258 */     PetFightTeamInfo _o_ = this;
/* 259 */     Map<Integer, Long> position2pet = new HashMap();
/* 260 */     for (Map.Entry<Integer, Long> _e_ : _o_.position2pet.entrySet())
/* 261 */       position2pet.put(_e_.getKey(), _e_.getValue());
/* 262 */     return position2pet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFormation_id(int _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "formation_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogInt(this, PetFightTeamInfo.this.formation_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             PetFightTeamInfo.this.formation_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.formation_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     PetFightTeamInfo _o_ = null;
/* 291 */     if ((_o1_ instanceof PetFightTeamInfo)) { _o_ = (PetFightTeamInfo)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (this.formation_id != _o_.formation_id) return false;
/* 295 */     if (!this.position2pet.equals(_o_.position2pet)) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ += this.formation_id;
/* 305 */     _h_ += this.position2pet.hashCode();
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.formation_id);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.position2pet);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("formation_id"));
/* 327 */     lb.add(new xdb.logs.ListenableMap().setVarName("position2pet"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PetFightTeamInfo {
/*     */     private Const() {}
/*     */     
/*     */     PetFightTeamInfo nThis() {
/* 335 */       return PetFightTeamInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetFightTeamInfo copy()
/*     */     {
/* 347 */       return PetFightTeamInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetFightTeamInfo toData()
/*     */     {
/* 353 */       return PetFightTeamInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PetFightTeamInfo toBean()
/*     */     {
/* 358 */       return PetFightTeamInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetFightTeamInfo toDataIf()
/*     */     {
/* 364 */       return PetFightTeamInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PetFightTeamInfo toBeanIf()
/*     */     {
/* 369 */       return PetFightTeamInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFormation_id()
/*     */     {
/* 376 */       PetFightTeamInfo.this._xdb_verify_unsafe_();
/* 377 */       return PetFightTeamInfo.this.formation_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getPosition2pet()
/*     */     {
/* 384 */       PetFightTeamInfo.this._xdb_verify_unsafe_();
/* 385 */       return xdb.Consts.constMap(PetFightTeamInfo.this.position2pet);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getPosition2petAsData()
/*     */     {
/* 392 */       PetFightTeamInfo.this._xdb_verify_unsafe_();
/*     */       
/* 394 */       PetFightTeamInfo _o_ = PetFightTeamInfo.this;
/* 395 */       Map<Integer, Long> position2pet = new HashMap();
/* 396 */       for (Map.Entry<Integer, Long> _e_ : _o_.position2pet.entrySet())
/* 397 */         position2pet.put(_e_.getKey(), _e_.getValue());
/* 398 */       return position2pet;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFormation_id(int _v_)
/*     */     {
/* 405 */       PetFightTeamInfo.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       PetFightTeamInfo.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       PetFightTeamInfo.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return PetFightTeamInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return PetFightTeamInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       PetFightTeamInfo.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return PetFightTeamInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return PetFightTeamInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       PetFightTeamInfo.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return PetFightTeamInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return PetFightTeamInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return PetFightTeamInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return PetFightTeamInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return PetFightTeamInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return PetFightTeamInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return PetFightTeamInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PetFightTeamInfo
/*     */   {
/*     */     private int formation_id;
/*     */     
/*     */     private HashMap<Integer, Long> position2pet;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.formation_id = 0;
/* 520 */       this.position2pet = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.PetFightTeamInfo _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof PetFightTeamInfo)) { assign((PetFightTeamInfo)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof PetFightTeamInfo.Const)) assign(((PetFightTeamInfo.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PetFightTeamInfo _o_) {
/* 533 */       this.formation_id = _o_.formation_id;
/* 534 */       this.position2pet = new HashMap();
/* 535 */       for (Map.Entry<Integer, Long> _e_ : _o_.position2pet.entrySet()) {
/* 536 */         this.position2pet.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 541 */       this.formation_id = _o_.formation_id;
/* 542 */       this.position2pet = new HashMap();
/* 543 */       for (Map.Entry<Integer, Long> _e_ : _o_.position2pet.entrySet()) {
/* 544 */         this.position2pet.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.marshal(this.formation_id);
/* 551 */       _os_.compact_uint32(this.position2pet.size());
/* 552 */       for (Map.Entry<Integer, Long> _e_ : this.position2pet.entrySet())
/*     */       {
/* 554 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 555 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */       }
/* 557 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 563 */       this.formation_id = _os_.unmarshal_int();
/*     */       
/* 565 */       int size = _os_.uncompact_uint32();
/* 566 */       if (size >= 12)
/*     */       {
/* 568 */         this.position2pet = new HashMap(size * 2);
/*     */       }
/* 570 */       for (; size > 0; size--)
/*     */       {
/* 572 */         int _k_ = 0;
/* 573 */         _k_ = _os_.unmarshal_int();
/* 574 */         long _v_ = 0L;
/* 575 */         _v_ = _os_.unmarshal_long();
/* 576 */         this.position2pet.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */       }
/*     */       
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       _size_ += CodedOutputStream.computeInt32Size(1, this.formation_id);
/* 587 */       for (Map.Entry<Integer, Long> _e_ : this.position2pet.entrySet())
/*     */       {
/* 589 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 590 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getValue()).longValue());
/*     */       }
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         _output_.writeInt32(1, this.formation_id);
/* 601 */         for (Map.Entry<Integer, Long> _e_ : this.position2pet.entrySet())
/*     */         {
/* 603 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 604 */           _output_.writeInt64(2, ((Long)_e_.getValue()).longValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.formation_id = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             int _k_ = 0;
/* 638 */             _k_ = _input_.readInt32();
/* 639 */             int readTag = _input_.readTag();
/* 640 */             if (16 != readTag)
/*     */             {
/* 642 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 644 */             long _v_ = 0L;
/* 645 */             _v_ = _input_.readInt64();
/* 646 */             this.position2pet.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 647 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 651 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 653 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 662 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 666 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 668 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetFightTeamInfo copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetFightTeamInfo toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PetFightTeamInfo toBean()
/*     */     {
/* 685 */       return new PetFightTeamInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetFightTeamInfo toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PetFightTeamInfo toBeanIf()
/*     */     {
/* 696 */       return new PetFightTeamInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 718 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 722 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 726 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFormation_id()
/*     */     {
/* 733 */       return this.formation_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getPosition2pet()
/*     */     {
/* 740 */       return this.position2pet;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getPosition2petAsData()
/*     */     {
/* 747 */       return this.position2pet;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFormation_id(int _v_)
/*     */     {
/* 754 */       this.formation_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (this.formation_id != _o_.formation_id) return false;
/* 763 */       if (!this.position2pet.equals(_o_.position2pet)) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ += this.formation_id;
/* 772 */       _h_ += this.position2pet.hashCode();
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.formation_id);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.position2pet);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PetFightTeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
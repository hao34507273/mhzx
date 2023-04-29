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
/*     */ public final class FabaoArtifactRecords extends XBean implements xbean.FabaoArtifactRecords
/*     */ {
/*     */   private HashMap<Integer, xbean.FabaoArtifactRecord> records;
/*     */   private int equipped_artifact_class;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.records.clear();
/*  21 */     this.equipped_artifact_class = 0;
/*     */   }
/*     */   
/*     */   FabaoArtifactRecords(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.records = new HashMap();
/*     */   }
/*     */   
/*     */   public FabaoArtifactRecords()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FabaoArtifactRecords(FabaoArtifactRecords _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FabaoArtifactRecords(xbean.FabaoArtifactRecords _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof FabaoArtifactRecords)) { assign((FabaoArtifactRecords)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FabaoArtifactRecords _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.records = new HashMap();
/*  53 */     for (Map.Entry<Integer, xbean.FabaoArtifactRecord> _e_ : _o_.records.entrySet())
/*  54 */       this.records.put(_e_.getKey(), new FabaoArtifactRecord((xbean.FabaoArtifactRecord)_e_.getValue(), this, "records"));
/*  55 */     this.equipped_artifact_class = _o_.equipped_artifact_class;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.records = new HashMap();
/*  61 */     for (Map.Entry<Integer, xbean.FabaoArtifactRecord> _e_ : _o_.records.entrySet())
/*  62 */       this.records.put(_e_.getKey(), new FabaoArtifactRecord((xbean.FabaoArtifactRecord)_e_.getValue(), this, "records"));
/*  63 */     this.equipped_artifact_class = _o_.equipped_artifact_class;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.compact_uint32(this.records.size());
/*  71 */     for (Map.Entry<Integer, xbean.FabaoArtifactRecord> _e_ : this.records.entrySet())
/*     */     {
/*  73 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  74 */       ((xbean.FabaoArtifactRecord)_e_.getValue()).marshal(_os_);
/*     */     }
/*  76 */     _os_.marshal(this.equipped_artifact_class);
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*     */     
/*  85 */     int size = _os_.uncompact_uint32();
/*  86 */     if (size >= 12)
/*     */     {
/*  88 */       this.records = new HashMap(size * 2);
/*     */     }
/*  90 */     for (; size > 0; size--)
/*     */     {
/*  92 */       int _k_ = 0;
/*  93 */       _k_ = _os_.unmarshal_int();
/*  94 */       xbean.FabaoArtifactRecord _v_ = new FabaoArtifactRecord(0, this, "records");
/*  95 */       _v_.unmarshal(_os_);
/*  96 */       this.records.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*  99 */     this.equipped_artifact_class = _os_.unmarshal_int();
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     for (Map.Entry<Integer, xbean.FabaoArtifactRecord> _e_ : this.records.entrySet())
/*     */     {
/* 110 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 111 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 113 */     _size_ += CodedOutputStream.computeInt32Size(2, this.equipped_artifact_class);
/* 114 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       for (Map.Entry<Integer, xbean.FabaoArtifactRecord> _e_ : this.records.entrySet())
/*     */       {
/* 125 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 126 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 128 */       _output_.writeInt32(2, this.equipped_artifact_class);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 132 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 134 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 143 */       boolean done = false;
/* 144 */       while (!done)
/*     */       {
/* 146 */         int tag = _input_.readTag();
/* 147 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 151 */           done = true;
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 156 */           int _k_ = 0;
/* 157 */           _k_ = _input_.readInt32();
/* 158 */           int readTag = _input_.readTag();
/* 159 */           if (10 != readTag)
/*     */           {
/* 161 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 163 */           xbean.FabaoArtifactRecord _v_ = new FabaoArtifactRecord(0, this, "records");
/* 164 */           _input_.readMessage(_v_);
/* 165 */           this.records.put(Integer.valueOf(_k_), _v_);
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this.equipped_artifact_class = _input_.readInt32();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 175 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 177 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 186 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 190 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 192 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FabaoArtifactRecords copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new FabaoArtifactRecords(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FabaoArtifactRecords toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FabaoArtifactRecords toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new FabaoArtifactRecords(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FabaoArtifactRecords toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FabaoArtifactRecords toBeanIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.FabaoArtifactRecord> getRecords()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return xdb.Logs.logMap(new xdb.LogKey(this, "records"), this.records);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.FabaoArtifactRecord> getRecordsAsData()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/*     */     
/* 249 */     FabaoArtifactRecords _o_ = this;
/* 250 */     Map<Integer, xbean.FabaoArtifactRecord> records = new HashMap();
/* 251 */     for (Map.Entry<Integer, xbean.FabaoArtifactRecord> _e_ : _o_.records.entrySet())
/* 252 */       records.put(_e_.getKey(), new FabaoArtifactRecord.Data((xbean.FabaoArtifactRecord)_e_.getValue()));
/* 253 */     return records;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getEquipped_artifact_class()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return this.equipped_artifact_class;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEquipped_artifact_class(int _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "equipped_artifact_class")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogInt(this, FabaoArtifactRecords.this.equipped_artifact_class)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             FabaoArtifactRecords.this.equipped_artifact_class = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.equipped_artifact_class = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     FabaoArtifactRecords _o_ = null;
/* 290 */     if ((_o1_ instanceof FabaoArtifactRecords)) { _o_ = (FabaoArtifactRecords)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (!this.records.equals(_o_.records)) return false;
/* 294 */     if (this.equipped_artifact_class != _o_.equipped_artifact_class) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ += this.records.hashCode();
/* 304 */     _h_ += this.equipped_artifact_class;
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.records);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.equipped_artifact_class);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableMap().setVarName("records"));
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("equipped_artifact_class"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FabaoArtifactRecords {
/*     */     private Const() {}
/*     */     
/*     */     FabaoArtifactRecords nThis() {
/* 334 */       return FabaoArtifactRecords.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactRecords copy()
/*     */     {
/* 346 */       return FabaoArtifactRecords.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactRecords toData()
/*     */     {
/* 352 */       return FabaoArtifactRecords.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FabaoArtifactRecords toBean()
/*     */     {
/* 357 */       return FabaoArtifactRecords.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactRecords toDataIf()
/*     */     {
/* 363 */       return FabaoArtifactRecords.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FabaoArtifactRecords toBeanIf()
/*     */     {
/* 368 */       return FabaoArtifactRecords.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FabaoArtifactRecord> getRecords()
/*     */     {
/* 375 */       FabaoArtifactRecords.this._xdb_verify_unsafe_();
/* 376 */       return xdb.Consts.constMap(FabaoArtifactRecords.this.records);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FabaoArtifactRecord> getRecordsAsData()
/*     */     {
/* 383 */       FabaoArtifactRecords.this._xdb_verify_unsafe_();
/*     */       
/* 385 */       FabaoArtifactRecords _o_ = FabaoArtifactRecords.this;
/* 386 */       Map<Integer, xbean.FabaoArtifactRecord> records = new HashMap();
/* 387 */       for (Map.Entry<Integer, xbean.FabaoArtifactRecord> _e_ : _o_.records.entrySet())
/* 388 */         records.put(_e_.getKey(), new FabaoArtifactRecord.Data((xbean.FabaoArtifactRecord)_e_.getValue()));
/* 389 */       return records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getEquipped_artifact_class()
/*     */     {
/* 396 */       FabaoArtifactRecords.this._xdb_verify_unsafe_();
/* 397 */       return FabaoArtifactRecords.this.equipped_artifact_class;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEquipped_artifact_class(int _v_)
/*     */     {
/* 404 */       FabaoArtifactRecords.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       FabaoArtifactRecords.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       FabaoArtifactRecords.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return FabaoArtifactRecords.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return FabaoArtifactRecords.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       FabaoArtifactRecords.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return FabaoArtifactRecords.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return FabaoArtifactRecords.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       FabaoArtifactRecords.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return FabaoArtifactRecords.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return FabaoArtifactRecords.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return FabaoArtifactRecords.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return FabaoArtifactRecords.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return FabaoArtifactRecords.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return FabaoArtifactRecords.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return FabaoArtifactRecords.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FabaoArtifactRecords
/*     */   {
/*     */     private HashMap<Integer, xbean.FabaoArtifactRecord> records;
/*     */     
/*     */     private int equipped_artifact_class;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.records = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.FabaoArtifactRecords _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof FabaoArtifactRecords)) { assign((FabaoArtifactRecords)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof FabaoArtifactRecords.Const)) assign(((FabaoArtifactRecords.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FabaoArtifactRecords _o_) {
/* 531 */       this.records = new HashMap();
/* 532 */       for (Map.Entry<Integer, xbean.FabaoArtifactRecord> _e_ : _o_.records.entrySet())
/* 533 */         this.records.put(_e_.getKey(), new FabaoArtifactRecord.Data((xbean.FabaoArtifactRecord)_e_.getValue()));
/* 534 */       this.equipped_artifact_class = _o_.equipped_artifact_class;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 539 */       this.records = new HashMap();
/* 540 */       for (Map.Entry<Integer, xbean.FabaoArtifactRecord> _e_ : _o_.records.entrySet())
/* 541 */         this.records.put(_e_.getKey(), new FabaoArtifactRecord.Data((xbean.FabaoArtifactRecord)_e_.getValue()));
/* 542 */       this.equipped_artifact_class = _o_.equipped_artifact_class;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.compact_uint32(this.records.size());
/* 549 */       for (Map.Entry<Integer, xbean.FabaoArtifactRecord> _e_ : this.records.entrySet())
/*     */       {
/* 551 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 552 */         ((xbean.FabaoArtifactRecord)_e_.getValue()).marshal(_os_);
/*     */       }
/* 554 */       _os_.marshal(this.equipped_artifact_class);
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 562 */       int size = _os_.uncompact_uint32();
/* 563 */       if (size >= 12)
/*     */       {
/* 565 */         this.records = new HashMap(size * 2);
/*     */       }
/* 567 */       for (; size > 0; size--)
/*     */       {
/* 569 */         int _k_ = 0;
/* 570 */         _k_ = _os_.unmarshal_int();
/* 571 */         xbean.FabaoArtifactRecord _v_ = xbean.Pod.newFabaoArtifactRecordData();
/* 572 */         _v_.unmarshal(_os_);
/* 573 */         this.records.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 576 */       this.equipped_artifact_class = _os_.unmarshal_int();
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       for (Map.Entry<Integer, xbean.FabaoArtifactRecord> _e_ : this.records.entrySet())
/*     */       {
/* 586 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 587 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 589 */       _size_ += CodedOutputStream.computeInt32Size(2, this.equipped_artifact_class);
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         for (Map.Entry<Integer, xbean.FabaoArtifactRecord> _e_ : this.records.entrySet())
/*     */         {
/* 600 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 601 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 603 */         _output_.writeInt32(2, this.equipped_artifact_class);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 607 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 609 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 617 */         boolean done = false;
/* 618 */         while (!done)
/*     */         {
/* 620 */           int tag = _input_.readTag();
/* 621 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 625 */             done = true;
/* 626 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 630 */             int _k_ = 0;
/* 631 */             _k_ = _input_.readInt32();
/* 632 */             int readTag = _input_.readTag();
/* 633 */             if (10 != readTag)
/*     */             {
/* 635 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 637 */             xbean.FabaoArtifactRecord _v_ = xbean.Pod.newFabaoArtifactRecordData();
/* 638 */             _input_.readMessage(_v_);
/* 639 */             this.records.put(Integer.valueOf(_k_), _v_);
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 644 */             this.equipped_artifact_class = _input_.readInt32();
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactRecords copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactRecords toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FabaoArtifactRecords toBean()
/*     */     {
/* 683 */       return new FabaoArtifactRecords(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactRecords toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FabaoArtifactRecords toBeanIf()
/*     */     {
/* 694 */       return new FabaoArtifactRecords(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FabaoArtifactRecord> getRecords()
/*     */     {
/* 731 */       return this.records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FabaoArtifactRecord> getRecordsAsData()
/*     */     {
/* 738 */       return this.records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getEquipped_artifact_class()
/*     */     {
/* 745 */       return this.equipped_artifact_class;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEquipped_artifact_class(int _v_)
/*     */     {
/* 752 */       this.equipped_artifact_class = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (!this.records.equals(_o_.records)) return false;
/* 761 */       if (this.equipped_artifact_class != _o_.equipped_artifact_class) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ += this.records.hashCode();
/* 770 */       _h_ += this.equipped_artifact_class;
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.records);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.equipped_artifact_class);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FabaoArtifactRecords.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
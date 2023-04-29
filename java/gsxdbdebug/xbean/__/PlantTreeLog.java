/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.ByteString;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class PlantTreeLog extends XBean implements xbean.PlantTreeLog
/*     */ {
/*     */   private int log_type;
/*     */   private int timestamp;
/*     */   private ArrayList<String> extradatas;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.log_type = 0;
/*  23 */     this.timestamp = 0;
/*  24 */     this.extradatas.clear();
/*     */   }
/*     */   
/*     */   PlantTreeLog(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.extradatas = new ArrayList();
/*     */   }
/*     */   
/*     */   public PlantTreeLog()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PlantTreeLog(PlantTreeLog _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PlantTreeLog(xbean.PlantTreeLog _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof PlantTreeLog)) { assign((PlantTreeLog)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PlantTreeLog _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.log_type = _o_.log_type;
/*  56 */     this.timestamp = _o_.timestamp;
/*  57 */     this.extradatas = new ArrayList();
/*  58 */     this.extradatas.addAll(_o_.extradatas);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  63 */     this.log_type = _o_.log_type;
/*  64 */     this.timestamp = _o_.timestamp;
/*  65 */     this.extradatas = new ArrayList();
/*  66 */     this.extradatas.addAll(_o_.extradatas);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.log_type);
/*  74 */     _os_.marshal(this.timestamp);
/*  75 */     _os_.compact_uint32(this.extradatas.size());
/*  76 */     for (String _v_ : this.extradatas)
/*     */     {
/*  78 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.log_type = _os_.unmarshal_int();
/*  88 */     this.timestamp = _os_.unmarshal_int();
/*  89 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  91 */       String _v_ = "";
/*  92 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  93 */       this.extradatas.add(_v_);
/*     */     }
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/* 102 */     int _size_ = 0;
/* 103 */     _size_ += CodedOutputStream.computeInt32Size(1, this.log_type);
/* 104 */     _size_ += CodedOutputStream.computeInt32Size(2, this.timestamp);
/* 105 */     for (String _v_ : this.extradatas)
/*     */     {
/*     */       try
/*     */       {
/* 109 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 113 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/*     */     }
/* 116 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 122 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 125 */       _output_.writeInt32(1, this.log_type);
/* 126 */       _output_.writeInt32(2, this.timestamp);
/* 127 */       for (String _v_ : this.extradatas)
/*     */       {
/* 129 */         _output_.writeBytes(3, ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 134 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 136 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 142 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 145 */       boolean done = false;
/* 146 */       while (!done)
/*     */       {
/* 148 */         int tag = _input_.readTag();
/* 149 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 153 */           done = true;
/* 154 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 158 */           this.log_type = _input_.readInt32();
/* 159 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 163 */           this.timestamp = _input_.readInt32();
/* 164 */           break;
/*     */         
/*     */ 
/*     */         case 26: 
/* 168 */           String _v_ = "";
/* 169 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/* 170 */           this.extradatas.add(_v_);
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
/*     */   public xbean.PlantTreeLog copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new PlantTreeLog(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PlantTreeLog toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PlantTreeLog toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new PlantTreeLog(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PlantTreeLog toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PlantTreeLog toBeanIf()
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
/*     */   public int getLog_type()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this.log_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTimestamp()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return this.timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<String> getExtradatas()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     return xdb.Logs.logList(new LogKey(this, "extradatas"), this.extradatas);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<String> getExtradatasAsData()
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/*     */     
/* 264 */     PlantTreeLog _o_ = this;
/* 265 */     List<String> extradatas = new ArrayList();
/* 266 */     extradatas.addAll(_o_.extradatas);
/* 267 */     return extradatas;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLog_type(int _v_)
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     xdb.Logs.logIf(new LogKey(this, "log_type")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 279 */         new xdb.logs.LogInt(this, PlantTreeLog.this.log_type)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 283 */             PlantTreeLog.this.log_type = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 287 */     });
/* 288 */     this.log_type = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTimestamp(int _v_)
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     xdb.Logs.logIf(new LogKey(this, "timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 300 */         new xdb.logs.LogInt(this, PlantTreeLog.this.timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 304 */             PlantTreeLog.this.timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 308 */     });
/* 309 */     this.timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     PlantTreeLog _o_ = null;
/* 317 */     if ((_o1_ instanceof PlantTreeLog)) { _o_ = (PlantTreeLog)_o1_;
/* 318 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 319 */       return false;
/* 320 */     if (this.log_type != _o_.log_type) return false;
/* 321 */     if (this.timestamp != _o_.timestamp) return false;
/* 322 */     if (!this.extradatas.equals(_o_.extradatas)) return false;
/* 323 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 329 */     _xdb_verify_unsafe_();
/* 330 */     int _h_ = 0;
/* 331 */     _h_ += this.log_type;
/* 332 */     _h_ += this.timestamp;
/* 333 */     _h_ += this.extradatas.hashCode();
/* 334 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 340 */     _xdb_verify_unsafe_();
/* 341 */     StringBuilder _sb_ = new StringBuilder();
/* 342 */     _sb_.append("(");
/* 343 */     _sb_.append(this.log_type);
/* 344 */     _sb_.append(",");
/* 345 */     _sb_.append(this.timestamp);
/* 346 */     _sb_.append(",");
/* 347 */     _sb_.append(this.extradatas);
/* 348 */     _sb_.append(")");
/* 349 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 355 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 356 */     lb.add(new xdb.logs.ListenableChanged().setVarName("log_type"));
/* 357 */     lb.add(new xdb.logs.ListenableChanged().setVarName("timestamp"));
/* 358 */     lb.add(new xdb.logs.ListenableChanged().setVarName("extradatas"));
/* 359 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PlantTreeLog {
/*     */     private Const() {}
/*     */     
/*     */     PlantTreeLog nThis() {
/* 366 */       return PlantTreeLog.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 372 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PlantTreeLog copy()
/*     */     {
/* 378 */       return PlantTreeLog.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PlantTreeLog toData()
/*     */     {
/* 384 */       return PlantTreeLog.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PlantTreeLog toBean()
/*     */     {
/* 389 */       return PlantTreeLog.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PlantTreeLog toDataIf()
/*     */     {
/* 395 */       return PlantTreeLog.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PlantTreeLog toBeanIf()
/*     */     {
/* 400 */       return PlantTreeLog.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLog_type()
/*     */     {
/* 407 */       PlantTreeLog.this._xdb_verify_unsafe_();
/* 408 */       return PlantTreeLog.this.log_type;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTimestamp()
/*     */     {
/* 415 */       PlantTreeLog.this._xdb_verify_unsafe_();
/* 416 */       return PlantTreeLog.this.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getExtradatas()
/*     */     {
/* 423 */       PlantTreeLog.this._xdb_verify_unsafe_();
/* 424 */       return xdb.Consts.constList(PlantTreeLog.this.extradatas);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<String> getExtradatasAsData()
/*     */     {
/* 430 */       PlantTreeLog.this._xdb_verify_unsafe_();
/*     */       
/* 432 */       PlantTreeLog _o_ = PlantTreeLog.this;
/* 433 */       List<String> extradatas = new ArrayList();
/* 434 */       extradatas.addAll(_o_.extradatas);
/* 435 */       return extradatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLog_type(int _v_)
/*     */     {
/* 442 */       PlantTreeLog.this._xdb_verify_unsafe_();
/* 443 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimestamp(int _v_)
/*     */     {
/* 450 */       PlantTreeLog.this._xdb_verify_unsafe_();
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 457 */       PlantTreeLog.this._xdb_verify_unsafe_();
/* 458 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 464 */       PlantTreeLog.this._xdb_verify_unsafe_();
/* 465 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 471 */       return PlantTreeLog.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 477 */       return PlantTreeLog.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 483 */       PlantTreeLog.this._xdb_verify_unsafe_();
/* 484 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 490 */       return PlantTreeLog.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 496 */       return PlantTreeLog.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 502 */       PlantTreeLog.this._xdb_verify_unsafe_();
/* 503 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 509 */       return PlantTreeLog.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 515 */       return PlantTreeLog.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 521 */       return PlantTreeLog.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 527 */       return PlantTreeLog.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 533 */       return PlantTreeLog.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 539 */       return PlantTreeLog.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 545 */       return PlantTreeLog.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PlantTreeLog
/*     */   {
/*     */     private int log_type;
/*     */     
/*     */     private int timestamp;
/*     */     
/*     */     private ArrayList<String> extradatas;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 561 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 566 */       this.extradatas = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.PlantTreeLog _o1_)
/*     */     {
/* 571 */       if ((_o1_ instanceof PlantTreeLog)) { assign((PlantTreeLog)_o1_);
/* 572 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 573 */       } else if ((_o1_ instanceof PlantTreeLog.Const)) assign(((PlantTreeLog.Const)_o1_).nThis()); else {
/* 574 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PlantTreeLog _o_) {
/* 579 */       this.log_type = _o_.log_type;
/* 580 */       this.timestamp = _o_.timestamp;
/* 581 */       this.extradatas = new ArrayList();
/* 582 */       this.extradatas.addAll(_o_.extradatas);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 587 */       this.log_type = _o_.log_type;
/* 588 */       this.timestamp = _o_.timestamp;
/* 589 */       this.extradatas = new ArrayList();
/* 590 */       this.extradatas.addAll(_o_.extradatas);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 596 */       _os_.marshal(this.log_type);
/* 597 */       _os_.marshal(this.timestamp);
/* 598 */       _os_.compact_uint32(this.extradatas.size());
/* 599 */       for (String _v_ : this.extradatas)
/*     */       {
/* 601 */         _os_.marshal(_v_, "UTF-16LE");
/*     */       }
/* 603 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 609 */       this.log_type = _os_.unmarshal_int();
/* 610 */       this.timestamp = _os_.unmarshal_int();
/* 611 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 613 */         String _v_ = "";
/* 614 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/* 615 */         this.extradatas.add(_v_);
/*     */       }
/* 617 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 623 */       int _size_ = 0;
/* 624 */       _size_ += CodedOutputStream.computeInt32Size(1, this.log_type);
/* 625 */       _size_ += CodedOutputStream.computeInt32Size(2, this.timestamp);
/* 626 */       for (String _v_ : this.extradatas)
/*     */       {
/*     */         try
/*     */         {
/* 630 */           _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */         }
/*     */         catch (java.io.UnsupportedEncodingException e)
/*     */         {
/* 634 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*     */         }
/*     */       }
/* 637 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 645 */         _output_.writeInt32(1, this.log_type);
/* 646 */         _output_.writeInt32(2, this.timestamp);
/* 647 */         for (String _v_ : this.extradatas)
/*     */         {
/* 649 */           _output_.writeBytes(3, ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 654 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 656 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 664 */         boolean done = false;
/* 665 */         while (!done)
/*     */         {
/* 667 */           int tag = _input_.readTag();
/* 668 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 672 */             done = true;
/* 673 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 677 */             this.log_type = _input_.readInt32();
/* 678 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 682 */             this.timestamp = _input_.readInt32();
/* 683 */             break;
/*     */           
/*     */ 
/*     */           case 26: 
/* 687 */             String _v_ = "";
/* 688 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 689 */             this.extradatas.add(_v_);
/* 690 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 694 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 696 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 705 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 709 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 711 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PlantTreeLog copy()
/*     */     {
/* 717 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PlantTreeLog toData()
/*     */     {
/* 723 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PlantTreeLog toBean()
/*     */     {
/* 728 */       return new PlantTreeLog(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PlantTreeLog toDataIf()
/*     */     {
/* 734 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PlantTreeLog toBeanIf()
/*     */     {
/* 739 */       return new PlantTreeLog(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 745 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 749 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 753 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 757 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 761 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 765 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 769 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLog_type()
/*     */     {
/* 776 */       return this.log_type;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTimestamp()
/*     */     {
/* 783 */       return this.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getExtradatas()
/*     */     {
/* 790 */       return this.extradatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getExtradatasAsData()
/*     */     {
/* 797 */       return this.extradatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLog_type(int _v_)
/*     */     {
/* 804 */       this.log_type = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimestamp(int _v_)
/*     */     {
/* 811 */       this.timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 817 */       if (!(_o1_ instanceof Data)) return false;
/* 818 */       Data _o_ = (Data)_o1_;
/* 819 */       if (this.log_type != _o_.log_type) return false;
/* 820 */       if (this.timestamp != _o_.timestamp) return false;
/* 821 */       if (!this.extradatas.equals(_o_.extradatas)) return false;
/* 822 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 828 */       int _h_ = 0;
/* 829 */       _h_ += this.log_type;
/* 830 */       _h_ += this.timestamp;
/* 831 */       _h_ += this.extradatas.hashCode();
/* 832 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 838 */       StringBuilder _sb_ = new StringBuilder();
/* 839 */       _sb_.append("(");
/* 840 */       _sb_.append(this.log_type);
/* 841 */       _sb_.append(",");
/* 842 */       _sb_.append(this.timestamp);
/* 843 */       _sb_.append(",");
/* 844 */       _sb_.append(this.extradatas);
/* 845 */       _sb_.append(")");
/* 846 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PlantTreeLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
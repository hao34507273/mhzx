/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class RoleBuff extends XBean implements xbean.RoleBuff
/*      */ {
/*      */   private int id;
/*      */   private int count;
/*      */   private long endtime;
/*      */   private int multiple;
/*      */   private long install_time;
/*      */   private int effect_state;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.id = 0;
/*   29 */     this.count = 0;
/*   30 */     this.endtime = 0L;
/*   31 */     this.multiple = 0;
/*   32 */     this.install_time = 0L;
/*   33 */     this.effect_state = 1;
/*      */   }
/*      */   
/*      */   RoleBuff(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.effect_state = 1;
/*      */   }
/*      */   
/*      */   public RoleBuff()
/*      */   {
/*   44 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleBuff(RoleBuff _o_)
/*      */   {
/*   49 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleBuff(xbean.RoleBuff _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   54 */     super(_xp_, _vn_);
/*   55 */     if ((_o1_ instanceof RoleBuff)) { assign((RoleBuff)_o1_);
/*   56 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   57 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   58 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleBuff _o_) {
/*   63 */     _o_._xdb_verify_unsafe_();
/*   64 */     this.id = _o_.id;
/*   65 */     this.count = _o_.count;
/*   66 */     this.endtime = _o_.endtime;
/*   67 */     this.multiple = _o_.multiple;
/*   68 */     this.install_time = _o_.install_time;
/*   69 */     this.effect_state = _o_.effect_state;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   74 */     this.id = _o_.id;
/*   75 */     this.count = _o_.count;
/*   76 */     this.endtime = _o_.endtime;
/*   77 */     this.multiple = _o_.multiple;
/*   78 */     this.install_time = _o_.install_time;
/*   79 */     this.effect_state = _o_.effect_state;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   85 */     _xdb_verify_unsafe_();
/*   86 */     _os_.marshal(this.id);
/*   87 */     _os_.marshal(this.count);
/*   88 */     _os_.marshal(this.endtime);
/*   89 */     _os_.marshal(this.multiple);
/*   90 */     _os_.marshal(this.install_time);
/*   91 */     _os_.marshal(this.effect_state);
/*   92 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   98 */     _xdb_verify_unsafe_();
/*   99 */     this.id = _os_.unmarshal_int();
/*  100 */     this.count = _os_.unmarshal_int();
/*  101 */     this.endtime = _os_.unmarshal_long();
/*  102 */     this.multiple = _os_.unmarshal_int();
/*  103 */     this.install_time = _os_.unmarshal_long();
/*  104 */     this.effect_state = _os_.unmarshal_int();
/*  105 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  111 */     _xdb_verify_unsafe_();
/*  112 */     int _size_ = 0;
/*  113 */     _size_ += CodedOutputStream.computeInt32Size(1, this.id);
/*  114 */     _size_ += CodedOutputStream.computeInt32Size(2, this.count);
/*  115 */     _size_ += CodedOutputStream.computeInt64Size(3, this.endtime);
/*  116 */     _size_ += CodedOutputStream.computeInt32Size(4, this.multiple);
/*  117 */     _size_ += CodedOutputStream.computeInt64Size(5, this.install_time);
/*  118 */     _size_ += CodedOutputStream.computeInt32Size(6, this.effect_state);
/*  119 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  125 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  128 */       _output_.writeInt32(1, this.id);
/*  129 */       _output_.writeInt32(2, this.count);
/*  130 */       _output_.writeInt64(3, this.endtime);
/*  131 */       _output_.writeInt32(4, this.multiple);
/*  132 */       _output_.writeInt64(5, this.install_time);
/*  133 */       _output_.writeInt32(6, this.effect_state);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  137 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  139 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  145 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  148 */       boolean done = false;
/*  149 */       while (!done)
/*      */       {
/*  151 */         int tag = _input_.readTag();
/*  152 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  156 */           done = true;
/*  157 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  161 */           this.id = _input_.readInt32();
/*  162 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  166 */           this.count = _input_.readInt32();
/*  167 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  171 */           this.endtime = _input_.readInt64();
/*  172 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  176 */           this.multiple = _input_.readInt32();
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  181 */           this.install_time = _input_.readInt64();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  186 */           this.effect_state = _input_.readInt32();
/*  187 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  191 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  193 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  202 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  206 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  208 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleBuff copy()
/*      */   {
/*  214 */     _xdb_verify_unsafe_();
/*  215 */     return new RoleBuff(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleBuff toData()
/*      */   {
/*  221 */     _xdb_verify_unsafe_();
/*  222 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleBuff toBean()
/*      */   {
/*  227 */     _xdb_verify_unsafe_();
/*  228 */     return new RoleBuff(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleBuff toDataIf()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleBuff toBeanIf()
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*  241 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getId()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return this.id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCount()
/*      */   {
/*  263 */     _xdb_verify_unsafe_();
/*  264 */     return this.count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEndtime()
/*      */   {
/*  271 */     _xdb_verify_unsafe_();
/*  272 */     return this.endtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMultiple()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return this.multiple;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInstall_time()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return this.install_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getEffect_state()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return this.effect_state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setId(int _v_)
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     Logs.logIf(new LogKey(this, "id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  308 */         new LogInt(this, RoleBuff.this.id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  312 */             RoleBuff.this.id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  316 */     });
/*  317 */     this.id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCount(int _v_)
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     Logs.logIf(new LogKey(this, "count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  329 */         new LogInt(this, RoleBuff.this.count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  333 */             RoleBuff.this.count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  337 */     });
/*  338 */     this.count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEndtime(long _v_)
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     Logs.logIf(new LogKey(this, "endtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  350 */         new xdb.logs.LogLong(this, RoleBuff.this.endtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  354 */             RoleBuff.this.endtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  358 */     });
/*  359 */     this.endtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMultiple(int _v_)
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     Logs.logIf(new LogKey(this, "multiple")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  371 */         new LogInt(this, RoleBuff.this.multiple)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  375 */             RoleBuff.this.multiple = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  379 */     });
/*  380 */     this.multiple = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInstall_time(long _v_)
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     Logs.logIf(new LogKey(this, "install_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  392 */         new xdb.logs.LogLong(this, RoleBuff.this.install_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  396 */             RoleBuff.this.install_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  400 */     });
/*  401 */     this.install_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEffect_state(int _v_)
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*  409 */     Logs.logIf(new LogKey(this, "effect_state")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  413 */         new LogInt(this, RoleBuff.this.effect_state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  417 */             RoleBuff.this.effect_state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  421 */     });
/*  422 */     this.effect_state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  428 */     _xdb_verify_unsafe_();
/*  429 */     RoleBuff _o_ = null;
/*  430 */     if ((_o1_ instanceof RoleBuff)) { _o_ = (RoleBuff)_o1_;
/*  431 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  432 */       return false;
/*  433 */     if (this.id != _o_.id) return false;
/*  434 */     if (this.count != _o_.count) return false;
/*  435 */     if (this.endtime != _o_.endtime) return false;
/*  436 */     if (this.multiple != _o_.multiple) return false;
/*  437 */     if (this.install_time != _o_.install_time) return false;
/*  438 */     if (this.effect_state != _o_.effect_state) return false;
/*  439 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  445 */     _xdb_verify_unsafe_();
/*  446 */     int _h_ = 0;
/*  447 */     _h_ += this.id;
/*  448 */     _h_ += this.count;
/*  449 */     _h_ = (int)(_h_ + this.endtime);
/*  450 */     _h_ += this.multiple;
/*  451 */     _h_ = (int)(_h_ + this.install_time);
/*  452 */     _h_ += this.effect_state;
/*  453 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     StringBuilder _sb_ = new StringBuilder();
/*  461 */     _sb_.append("(");
/*  462 */     _sb_.append(this.id);
/*  463 */     _sb_.append(",");
/*  464 */     _sb_.append(this.count);
/*  465 */     _sb_.append(",");
/*  466 */     _sb_.append(this.endtime);
/*  467 */     _sb_.append(",");
/*  468 */     _sb_.append(this.multiple);
/*  469 */     _sb_.append(",");
/*  470 */     _sb_.append(this.install_time);
/*  471 */     _sb_.append(",");
/*  472 */     _sb_.append(this.effect_state);
/*  473 */     _sb_.append(")");
/*  474 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  480 */     ListenableBean lb = new ListenableBean();
/*  481 */     lb.add(new ListenableChanged().setVarName("id"));
/*  482 */     lb.add(new ListenableChanged().setVarName("count"));
/*  483 */     lb.add(new ListenableChanged().setVarName("endtime"));
/*  484 */     lb.add(new ListenableChanged().setVarName("multiple"));
/*  485 */     lb.add(new ListenableChanged().setVarName("install_time"));
/*  486 */     lb.add(new ListenableChanged().setVarName("effect_state"));
/*  487 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleBuff {
/*      */     private Const() {}
/*      */     
/*      */     RoleBuff nThis() {
/*  494 */       return RoleBuff.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  500 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleBuff copy()
/*      */     {
/*  506 */       return RoleBuff.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleBuff toData()
/*      */     {
/*  512 */       return RoleBuff.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleBuff toBean()
/*      */     {
/*  517 */       return RoleBuff.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleBuff toDataIf()
/*      */     {
/*  523 */       return RoleBuff.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleBuff toBeanIf()
/*      */     {
/*  528 */       return RoleBuff.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getId()
/*      */     {
/*  535 */       RoleBuff.this._xdb_verify_unsafe_();
/*  536 */       return RoleBuff.this.id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCount()
/*      */     {
/*  543 */       RoleBuff.this._xdb_verify_unsafe_();
/*  544 */       return RoleBuff.this.count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtime()
/*      */     {
/*  551 */       RoleBuff.this._xdb_verify_unsafe_();
/*  552 */       return RoleBuff.this.endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMultiple()
/*      */     {
/*  559 */       RoleBuff.this._xdb_verify_unsafe_();
/*  560 */       return RoleBuff.this.multiple;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInstall_time()
/*      */     {
/*  567 */       RoleBuff.this._xdb_verify_unsafe_();
/*  568 */       return RoleBuff.this.install_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEffect_state()
/*      */     {
/*  575 */       RoleBuff.this._xdb_verify_unsafe_();
/*  576 */       return RoleBuff.this.effect_state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setId(int _v_)
/*      */     {
/*  583 */       RoleBuff.this._xdb_verify_unsafe_();
/*  584 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCount(int _v_)
/*      */     {
/*  591 */       RoleBuff.this._xdb_verify_unsafe_();
/*  592 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtime(long _v_)
/*      */     {
/*  599 */       RoleBuff.this._xdb_verify_unsafe_();
/*  600 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMultiple(int _v_)
/*      */     {
/*  607 */       RoleBuff.this._xdb_verify_unsafe_();
/*  608 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInstall_time(long _v_)
/*      */     {
/*  615 */       RoleBuff.this._xdb_verify_unsafe_();
/*  616 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEffect_state(int _v_)
/*      */     {
/*  623 */       RoleBuff.this._xdb_verify_unsafe_();
/*  624 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  630 */       RoleBuff.this._xdb_verify_unsafe_();
/*  631 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  637 */       RoleBuff.this._xdb_verify_unsafe_();
/*  638 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  644 */       return RoleBuff.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  650 */       return RoleBuff.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  656 */       RoleBuff.this._xdb_verify_unsafe_();
/*  657 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  663 */       return RoleBuff.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  669 */       return RoleBuff.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  675 */       RoleBuff.this._xdb_verify_unsafe_();
/*  676 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  682 */       return RoleBuff.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  688 */       return RoleBuff.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  694 */       return RoleBuff.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  700 */       return RoleBuff.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  706 */       return RoleBuff.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  712 */       return RoleBuff.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  718 */       return RoleBuff.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleBuff
/*      */   {
/*      */     private int id;
/*      */     
/*      */     private int count;
/*      */     
/*      */     private long endtime;
/*      */     
/*      */     private int multiple;
/*      */     
/*      */     private long install_time;
/*      */     
/*      */     private int effect_state;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  740 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  745 */       this.effect_state = 1;
/*      */     }
/*      */     
/*      */     Data(xbean.RoleBuff _o1_)
/*      */     {
/*  750 */       if ((_o1_ instanceof RoleBuff)) { assign((RoleBuff)_o1_);
/*  751 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  752 */       } else if ((_o1_ instanceof RoleBuff.Const)) assign(((RoleBuff.Const)_o1_).nThis()); else {
/*  753 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleBuff _o_) {
/*  758 */       this.id = _o_.id;
/*  759 */       this.count = _o_.count;
/*  760 */       this.endtime = _o_.endtime;
/*  761 */       this.multiple = _o_.multiple;
/*  762 */       this.install_time = _o_.install_time;
/*  763 */       this.effect_state = _o_.effect_state;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  768 */       this.id = _o_.id;
/*  769 */       this.count = _o_.count;
/*  770 */       this.endtime = _o_.endtime;
/*  771 */       this.multiple = _o_.multiple;
/*  772 */       this.install_time = _o_.install_time;
/*  773 */       this.effect_state = _o_.effect_state;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  779 */       _os_.marshal(this.id);
/*  780 */       _os_.marshal(this.count);
/*  781 */       _os_.marshal(this.endtime);
/*  782 */       _os_.marshal(this.multiple);
/*  783 */       _os_.marshal(this.install_time);
/*  784 */       _os_.marshal(this.effect_state);
/*  785 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  791 */       this.id = _os_.unmarshal_int();
/*  792 */       this.count = _os_.unmarshal_int();
/*  793 */       this.endtime = _os_.unmarshal_long();
/*  794 */       this.multiple = _os_.unmarshal_int();
/*  795 */       this.install_time = _os_.unmarshal_long();
/*  796 */       this.effect_state = _os_.unmarshal_int();
/*  797 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  803 */       int _size_ = 0;
/*  804 */       _size_ += CodedOutputStream.computeInt32Size(1, this.id);
/*  805 */       _size_ += CodedOutputStream.computeInt32Size(2, this.count);
/*  806 */       _size_ += CodedOutputStream.computeInt64Size(3, this.endtime);
/*  807 */       _size_ += CodedOutputStream.computeInt32Size(4, this.multiple);
/*  808 */       _size_ += CodedOutputStream.computeInt64Size(5, this.install_time);
/*  809 */       _size_ += CodedOutputStream.computeInt32Size(6, this.effect_state);
/*  810 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  818 */         _output_.writeInt32(1, this.id);
/*  819 */         _output_.writeInt32(2, this.count);
/*  820 */         _output_.writeInt64(3, this.endtime);
/*  821 */         _output_.writeInt32(4, this.multiple);
/*  822 */         _output_.writeInt64(5, this.install_time);
/*  823 */         _output_.writeInt32(6, this.effect_state);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  827 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  829 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  837 */         boolean done = false;
/*  838 */         while (!done)
/*      */         {
/*  840 */           int tag = _input_.readTag();
/*  841 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  845 */             done = true;
/*  846 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  850 */             this.id = _input_.readInt32();
/*  851 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  855 */             this.count = _input_.readInt32();
/*  856 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  860 */             this.endtime = _input_.readInt64();
/*  861 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  865 */             this.multiple = _input_.readInt32();
/*  866 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  870 */             this.install_time = _input_.readInt64();
/*  871 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  875 */             this.effect_state = _input_.readInt32();
/*  876 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  880 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  882 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  891 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  895 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  897 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleBuff copy()
/*      */     {
/*  903 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleBuff toData()
/*      */     {
/*  909 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleBuff toBean()
/*      */     {
/*  914 */       return new RoleBuff(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleBuff toDataIf()
/*      */     {
/*  920 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleBuff toBeanIf()
/*      */     {
/*  925 */       return new RoleBuff(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  931 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/*  935 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  943 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/*  947 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  951 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  955 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getId()
/*      */     {
/*  962 */       return this.id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCount()
/*      */     {
/*  969 */       return this.count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtime()
/*      */     {
/*  976 */       return this.endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMultiple()
/*      */     {
/*  983 */       return this.multiple;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInstall_time()
/*      */     {
/*  990 */       return this.install_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEffect_state()
/*      */     {
/*  997 */       return this.effect_state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setId(int _v_)
/*      */     {
/* 1004 */       this.id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCount(int _v_)
/*      */     {
/* 1011 */       this.count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtime(long _v_)
/*      */     {
/* 1018 */       this.endtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMultiple(int _v_)
/*      */     {
/* 1025 */       this.multiple = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInstall_time(long _v_)
/*      */     {
/* 1032 */       this.install_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEffect_state(int _v_)
/*      */     {
/* 1039 */       this.effect_state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1045 */       if (!(_o1_ instanceof Data)) return false;
/* 1046 */       Data _o_ = (Data)_o1_;
/* 1047 */       if (this.id != _o_.id) return false;
/* 1048 */       if (this.count != _o_.count) return false;
/* 1049 */       if (this.endtime != _o_.endtime) return false;
/* 1050 */       if (this.multiple != _o_.multiple) return false;
/* 1051 */       if (this.install_time != _o_.install_time) return false;
/* 1052 */       if (this.effect_state != _o_.effect_state) return false;
/* 1053 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1059 */       int _h_ = 0;
/* 1060 */       _h_ += this.id;
/* 1061 */       _h_ += this.count;
/* 1062 */       _h_ = (int)(_h_ + this.endtime);
/* 1063 */       _h_ += this.multiple;
/* 1064 */       _h_ = (int)(_h_ + this.install_time);
/* 1065 */       _h_ += this.effect_state;
/* 1066 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1072 */       StringBuilder _sb_ = new StringBuilder();
/* 1073 */       _sb_.append("(");
/* 1074 */       _sb_.append(this.id);
/* 1075 */       _sb_.append(",");
/* 1076 */       _sb_.append(this.count);
/* 1077 */       _sb_.append(",");
/* 1078 */       _sb_.append(this.endtime);
/* 1079 */       _sb_.append(",");
/* 1080 */       _sb_.append(this.multiple);
/* 1081 */       _sb_.append(",");
/* 1082 */       _sb_.append(this.install_time);
/* 1083 */       _sb_.append(",");
/* 1084 */       _sb_.append(this.effect_state);
/* 1085 */       _sb_.append(")");
/* 1086 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
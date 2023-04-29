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
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class FightAgainstInfo extends XBean implements xbean.FightAgainstInfo
/*      */ {
/*      */   private long a_corps_id;
/*      */   private long b_corps_id;
/*      */   private int fight_status;
/*      */   private int a_corps_id_result;
/*      */   private int b_corps_id_result;
/*      */   private int cal_fight_result;
/*      */   private long record_id;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.a_corps_id = 0L;
/*   31 */     this.b_corps_id = 0L;
/*   32 */     this.fight_status = 0;
/*   33 */     this.a_corps_id_result = 0;
/*   34 */     this.b_corps_id_result = 0;
/*   35 */     this.cal_fight_result = 0;
/*   36 */     this.record_id = 0L;
/*      */   }
/*      */   
/*      */   FightAgainstInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*      */   }
/*      */   
/*      */   public FightAgainstInfo()
/*      */   {
/*   46 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FightAgainstInfo(FightAgainstInfo _o_)
/*      */   {
/*   51 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FightAgainstInfo(xbean.FightAgainstInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   56 */     super(_xp_, _vn_);
/*   57 */     if ((_o1_ instanceof FightAgainstInfo)) { assign((FightAgainstInfo)_o1_);
/*   58 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   59 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   60 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FightAgainstInfo _o_) {
/*   65 */     _o_._xdb_verify_unsafe_();
/*   66 */     this.a_corps_id = _o_.a_corps_id;
/*   67 */     this.b_corps_id = _o_.b_corps_id;
/*   68 */     this.fight_status = _o_.fight_status;
/*   69 */     this.a_corps_id_result = _o_.a_corps_id_result;
/*   70 */     this.b_corps_id_result = _o_.b_corps_id_result;
/*   71 */     this.cal_fight_result = _o_.cal_fight_result;
/*   72 */     this.record_id = _o_.record_id;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   77 */     this.a_corps_id = _o_.a_corps_id;
/*   78 */     this.b_corps_id = _o_.b_corps_id;
/*   79 */     this.fight_status = _o_.fight_status;
/*   80 */     this.a_corps_id_result = _o_.a_corps_id_result;
/*   81 */     this.b_corps_id_result = _o_.b_corps_id_result;
/*   82 */     this.cal_fight_result = _o_.cal_fight_result;
/*   83 */     this.record_id = _o_.record_id;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   89 */     _xdb_verify_unsafe_();
/*   90 */     _os_.marshal(this.a_corps_id);
/*   91 */     _os_.marshal(this.b_corps_id);
/*   92 */     _os_.marshal(this.fight_status);
/*   93 */     _os_.marshal(this.a_corps_id_result);
/*   94 */     _os_.marshal(this.b_corps_id_result);
/*   95 */     _os_.marshal(this.cal_fight_result);
/*   96 */     _os_.marshal(this.record_id);
/*   97 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  103 */     _xdb_verify_unsafe_();
/*  104 */     this.a_corps_id = _os_.unmarshal_long();
/*  105 */     this.b_corps_id = _os_.unmarshal_long();
/*  106 */     this.fight_status = _os_.unmarshal_int();
/*  107 */     this.a_corps_id_result = _os_.unmarshal_int();
/*  108 */     this.b_corps_id_result = _os_.unmarshal_int();
/*  109 */     this.cal_fight_result = _os_.unmarshal_int();
/*  110 */     this.record_id = _os_.unmarshal_long();
/*  111 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  117 */     _xdb_verify_unsafe_();
/*  118 */     int _size_ = 0;
/*  119 */     _size_ += CodedOutputStream.computeInt64Size(1, this.a_corps_id);
/*  120 */     _size_ += CodedOutputStream.computeInt64Size(2, this.b_corps_id);
/*  121 */     _size_ += CodedOutputStream.computeInt32Size(3, this.fight_status);
/*  122 */     _size_ += CodedOutputStream.computeInt32Size(4, this.a_corps_id_result);
/*  123 */     _size_ += CodedOutputStream.computeInt32Size(5, this.b_corps_id_result);
/*  124 */     _size_ += CodedOutputStream.computeInt32Size(6, this.cal_fight_result);
/*  125 */     _size_ += CodedOutputStream.computeInt64Size(7, this.record_id);
/*  126 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  132 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  135 */       _output_.writeInt64(1, this.a_corps_id);
/*  136 */       _output_.writeInt64(2, this.b_corps_id);
/*  137 */       _output_.writeInt32(3, this.fight_status);
/*  138 */       _output_.writeInt32(4, this.a_corps_id_result);
/*  139 */       _output_.writeInt32(5, this.b_corps_id_result);
/*  140 */       _output_.writeInt32(6, this.cal_fight_result);
/*  141 */       _output_.writeInt64(7, this.record_id);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  145 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  147 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  153 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  156 */       boolean done = false;
/*  157 */       while (!done)
/*      */       {
/*  159 */         int tag = _input_.readTag();
/*  160 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  164 */           done = true;
/*  165 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  169 */           this.a_corps_id = _input_.readInt64();
/*  170 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  174 */           this.b_corps_id = _input_.readInt64();
/*  175 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  179 */           this.fight_status = _input_.readInt32();
/*  180 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  184 */           this.a_corps_id_result = _input_.readInt32();
/*  185 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  189 */           this.b_corps_id_result = _input_.readInt32();
/*  190 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  194 */           this.cal_fight_result = _input_.readInt32();
/*  195 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  199 */           this.record_id = _input_.readInt64();
/*  200 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  204 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  206 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  215 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  219 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  221 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FightAgainstInfo copy()
/*      */   {
/*  227 */     _xdb_verify_unsafe_();
/*  228 */     return new FightAgainstInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FightAgainstInfo toData()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FightAgainstInfo toBean()
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*  241 */     return new FightAgainstInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FightAgainstInfo toDataIf()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FightAgainstInfo toBeanIf()
/*      */   {
/*  253 */     _xdb_verify_unsafe_();
/*  254 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getA_corps_id()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return this.a_corps_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getB_corps_id()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return this.b_corps_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFight_status()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return this.fight_status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getA_corps_id_result()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return this.a_corps_id_result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getB_corps_id_result()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this.b_corps_id_result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCal_fight_result()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return this.cal_fight_result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRecord_id()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return this.record_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setA_corps_id(long _v_)
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     Logs.logIf(new LogKey(this, "a_corps_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  329 */         new LogLong(this, FightAgainstInfo.this.a_corps_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  333 */             FightAgainstInfo.this.a_corps_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  337 */     });
/*  338 */     this.a_corps_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setB_corps_id(long _v_)
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     Logs.logIf(new LogKey(this, "b_corps_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  350 */         new LogLong(this, FightAgainstInfo.this.b_corps_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  354 */             FightAgainstInfo.this.b_corps_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  358 */     });
/*  359 */     this.b_corps_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFight_status(int _v_)
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     Logs.logIf(new LogKey(this, "fight_status")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  371 */         new LogInt(this, FightAgainstInfo.this.fight_status)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  375 */             FightAgainstInfo.this.fight_status = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  379 */     });
/*  380 */     this.fight_status = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setA_corps_id_result(int _v_)
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     Logs.logIf(new LogKey(this, "a_corps_id_result")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  392 */         new LogInt(this, FightAgainstInfo.this.a_corps_id_result)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  396 */             FightAgainstInfo.this.a_corps_id_result = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  400 */     });
/*  401 */     this.a_corps_id_result = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setB_corps_id_result(int _v_)
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*  409 */     Logs.logIf(new LogKey(this, "b_corps_id_result")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  413 */         new LogInt(this, FightAgainstInfo.this.b_corps_id_result)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  417 */             FightAgainstInfo.this.b_corps_id_result = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  421 */     });
/*  422 */     this.b_corps_id_result = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCal_fight_result(int _v_)
/*      */   {
/*  429 */     _xdb_verify_unsafe_();
/*  430 */     Logs.logIf(new LogKey(this, "cal_fight_result")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  434 */         new LogInt(this, FightAgainstInfo.this.cal_fight_result)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  438 */             FightAgainstInfo.this.cal_fight_result = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  442 */     });
/*  443 */     this.cal_fight_result = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecord_id(long _v_)
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     Logs.logIf(new LogKey(this, "record_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  455 */         new LogLong(this, FightAgainstInfo.this.record_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  459 */             FightAgainstInfo.this.record_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  463 */     });
/*  464 */     this.record_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  470 */     _xdb_verify_unsafe_();
/*  471 */     FightAgainstInfo _o_ = null;
/*  472 */     if ((_o1_ instanceof FightAgainstInfo)) { _o_ = (FightAgainstInfo)_o1_;
/*  473 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  474 */       return false;
/*  475 */     if (this.a_corps_id != _o_.a_corps_id) return false;
/*  476 */     if (this.b_corps_id != _o_.b_corps_id) return false;
/*  477 */     if (this.fight_status != _o_.fight_status) return false;
/*  478 */     if (this.a_corps_id_result != _o_.a_corps_id_result) return false;
/*  479 */     if (this.b_corps_id_result != _o_.b_corps_id_result) return false;
/*  480 */     if (this.cal_fight_result != _o_.cal_fight_result) return false;
/*  481 */     if (this.record_id != _o_.record_id) return false;
/*  482 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  488 */     _xdb_verify_unsafe_();
/*  489 */     int _h_ = 0;
/*  490 */     _h_ = (int)(_h_ + this.a_corps_id);
/*  491 */     _h_ = (int)(_h_ + this.b_corps_id);
/*  492 */     _h_ += this.fight_status;
/*  493 */     _h_ += this.a_corps_id_result;
/*  494 */     _h_ += this.b_corps_id_result;
/*  495 */     _h_ += this.cal_fight_result;
/*  496 */     _h_ = (int)(_h_ + this.record_id);
/*  497 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     StringBuilder _sb_ = new StringBuilder();
/*  505 */     _sb_.append("(");
/*  506 */     _sb_.append(this.a_corps_id);
/*  507 */     _sb_.append(",");
/*  508 */     _sb_.append(this.b_corps_id);
/*  509 */     _sb_.append(",");
/*  510 */     _sb_.append(this.fight_status);
/*  511 */     _sb_.append(",");
/*  512 */     _sb_.append(this.a_corps_id_result);
/*  513 */     _sb_.append(",");
/*  514 */     _sb_.append(this.b_corps_id_result);
/*  515 */     _sb_.append(",");
/*  516 */     _sb_.append(this.cal_fight_result);
/*  517 */     _sb_.append(",");
/*  518 */     _sb_.append(this.record_id);
/*  519 */     _sb_.append(")");
/*  520 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  526 */     ListenableBean lb = new ListenableBean();
/*  527 */     lb.add(new ListenableChanged().setVarName("a_corps_id"));
/*  528 */     lb.add(new ListenableChanged().setVarName("b_corps_id"));
/*  529 */     lb.add(new ListenableChanged().setVarName("fight_status"));
/*  530 */     lb.add(new ListenableChanged().setVarName("a_corps_id_result"));
/*  531 */     lb.add(new ListenableChanged().setVarName("b_corps_id_result"));
/*  532 */     lb.add(new ListenableChanged().setVarName("cal_fight_result"));
/*  533 */     lb.add(new ListenableChanged().setVarName("record_id"));
/*  534 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FightAgainstInfo {
/*      */     private Const() {}
/*      */     
/*      */     FightAgainstInfo nThis() {
/*  541 */       return FightAgainstInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  547 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightAgainstInfo copy()
/*      */     {
/*  553 */       return FightAgainstInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightAgainstInfo toData()
/*      */     {
/*  559 */       return FightAgainstInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FightAgainstInfo toBean()
/*      */     {
/*  564 */       return FightAgainstInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightAgainstInfo toDataIf()
/*      */     {
/*  570 */       return FightAgainstInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FightAgainstInfo toBeanIf()
/*      */     {
/*  575 */       return FightAgainstInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getA_corps_id()
/*      */     {
/*  582 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  583 */       return FightAgainstInfo.this.a_corps_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getB_corps_id()
/*      */     {
/*  590 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  591 */       return FightAgainstInfo.this.b_corps_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFight_status()
/*      */     {
/*  598 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  599 */       return FightAgainstInfo.this.fight_status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getA_corps_id_result()
/*      */     {
/*  606 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  607 */       return FightAgainstInfo.this.a_corps_id_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getB_corps_id_result()
/*      */     {
/*  614 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  615 */       return FightAgainstInfo.this.b_corps_id_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCal_fight_result()
/*      */     {
/*  622 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  623 */       return FightAgainstInfo.this.cal_fight_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRecord_id()
/*      */     {
/*  630 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  631 */       return FightAgainstInfo.this.record_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setA_corps_id(long _v_)
/*      */     {
/*  638 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  639 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setB_corps_id(long _v_)
/*      */     {
/*  646 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  647 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFight_status(int _v_)
/*      */     {
/*  654 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  655 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setA_corps_id_result(int _v_)
/*      */     {
/*  662 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  663 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setB_corps_id_result(int _v_)
/*      */     {
/*  670 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  671 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCal_fight_result(int _v_)
/*      */     {
/*  678 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  679 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecord_id(long _v_)
/*      */     {
/*  686 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  687 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  693 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  694 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  700 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  701 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  707 */       return FightAgainstInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  713 */       return FightAgainstInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  719 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  720 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  726 */       return FightAgainstInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  732 */       return FightAgainstInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  738 */       FightAgainstInfo.this._xdb_verify_unsafe_();
/*  739 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  745 */       return FightAgainstInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  751 */       return FightAgainstInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  757 */       return FightAgainstInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  763 */       return FightAgainstInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  769 */       return FightAgainstInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  775 */       return FightAgainstInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  781 */       return FightAgainstInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FightAgainstInfo
/*      */   {
/*      */     private long a_corps_id;
/*      */     
/*      */     private long b_corps_id;
/*      */     
/*      */     private int fight_status;
/*      */     
/*      */     private int a_corps_id_result;
/*      */     
/*      */     private int b_corps_id_result;
/*      */     
/*      */     private int cal_fight_result;
/*      */     
/*      */     private long record_id;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  805 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Data() {}
/*      */     
/*      */ 
/*      */     Data(xbean.FightAgainstInfo _o1_)
/*      */     {
/*  814 */       if ((_o1_ instanceof FightAgainstInfo)) { assign((FightAgainstInfo)_o1_);
/*  815 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  816 */       } else if ((_o1_ instanceof FightAgainstInfo.Const)) assign(((FightAgainstInfo.Const)_o1_).nThis()); else {
/*  817 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FightAgainstInfo _o_) {
/*  822 */       this.a_corps_id = _o_.a_corps_id;
/*  823 */       this.b_corps_id = _o_.b_corps_id;
/*  824 */       this.fight_status = _o_.fight_status;
/*  825 */       this.a_corps_id_result = _o_.a_corps_id_result;
/*  826 */       this.b_corps_id_result = _o_.b_corps_id_result;
/*  827 */       this.cal_fight_result = _o_.cal_fight_result;
/*  828 */       this.record_id = _o_.record_id;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  833 */       this.a_corps_id = _o_.a_corps_id;
/*  834 */       this.b_corps_id = _o_.b_corps_id;
/*  835 */       this.fight_status = _o_.fight_status;
/*  836 */       this.a_corps_id_result = _o_.a_corps_id_result;
/*  837 */       this.b_corps_id_result = _o_.b_corps_id_result;
/*  838 */       this.cal_fight_result = _o_.cal_fight_result;
/*  839 */       this.record_id = _o_.record_id;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  845 */       _os_.marshal(this.a_corps_id);
/*  846 */       _os_.marshal(this.b_corps_id);
/*  847 */       _os_.marshal(this.fight_status);
/*  848 */       _os_.marshal(this.a_corps_id_result);
/*  849 */       _os_.marshal(this.b_corps_id_result);
/*  850 */       _os_.marshal(this.cal_fight_result);
/*  851 */       _os_.marshal(this.record_id);
/*  852 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  858 */       this.a_corps_id = _os_.unmarshal_long();
/*  859 */       this.b_corps_id = _os_.unmarshal_long();
/*  860 */       this.fight_status = _os_.unmarshal_int();
/*  861 */       this.a_corps_id_result = _os_.unmarshal_int();
/*  862 */       this.b_corps_id_result = _os_.unmarshal_int();
/*  863 */       this.cal_fight_result = _os_.unmarshal_int();
/*  864 */       this.record_id = _os_.unmarshal_long();
/*  865 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  871 */       int _size_ = 0;
/*  872 */       _size_ += CodedOutputStream.computeInt64Size(1, this.a_corps_id);
/*  873 */       _size_ += CodedOutputStream.computeInt64Size(2, this.b_corps_id);
/*  874 */       _size_ += CodedOutputStream.computeInt32Size(3, this.fight_status);
/*  875 */       _size_ += CodedOutputStream.computeInt32Size(4, this.a_corps_id_result);
/*  876 */       _size_ += CodedOutputStream.computeInt32Size(5, this.b_corps_id_result);
/*  877 */       _size_ += CodedOutputStream.computeInt32Size(6, this.cal_fight_result);
/*  878 */       _size_ += CodedOutputStream.computeInt64Size(7, this.record_id);
/*  879 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  887 */         _output_.writeInt64(1, this.a_corps_id);
/*  888 */         _output_.writeInt64(2, this.b_corps_id);
/*  889 */         _output_.writeInt32(3, this.fight_status);
/*  890 */         _output_.writeInt32(4, this.a_corps_id_result);
/*  891 */         _output_.writeInt32(5, this.b_corps_id_result);
/*  892 */         _output_.writeInt32(6, this.cal_fight_result);
/*  893 */         _output_.writeInt64(7, this.record_id);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  897 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  899 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  907 */         boolean done = false;
/*  908 */         while (!done)
/*      */         {
/*  910 */           int tag = _input_.readTag();
/*  911 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  915 */             done = true;
/*  916 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  920 */             this.a_corps_id = _input_.readInt64();
/*  921 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  925 */             this.b_corps_id = _input_.readInt64();
/*  926 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  930 */             this.fight_status = _input_.readInt32();
/*  931 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  935 */             this.a_corps_id_result = _input_.readInt32();
/*  936 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  940 */             this.b_corps_id_result = _input_.readInt32();
/*  941 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  945 */             this.cal_fight_result = _input_.readInt32();
/*  946 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/*  950 */             this.record_id = _input_.readInt64();
/*  951 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  955 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  957 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  966 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  970 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  972 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightAgainstInfo copy()
/*      */     {
/*  978 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightAgainstInfo toData()
/*      */     {
/*  984 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FightAgainstInfo toBean()
/*      */     {
/*  989 */       return new FightAgainstInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightAgainstInfo toDataIf()
/*      */     {
/*  995 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FightAgainstInfo toBeanIf()
/*      */     {
/* 1000 */       return new FightAgainstInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1006 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1010 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1014 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1018 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1022 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1026 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1030 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getA_corps_id()
/*      */     {
/* 1037 */       return this.a_corps_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getB_corps_id()
/*      */     {
/* 1044 */       return this.b_corps_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFight_status()
/*      */     {
/* 1051 */       return this.fight_status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getA_corps_id_result()
/*      */     {
/* 1058 */       return this.a_corps_id_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getB_corps_id_result()
/*      */     {
/* 1065 */       return this.b_corps_id_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCal_fight_result()
/*      */     {
/* 1072 */       return this.cal_fight_result;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRecord_id()
/*      */     {
/* 1079 */       return this.record_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setA_corps_id(long _v_)
/*      */     {
/* 1086 */       this.a_corps_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setB_corps_id(long _v_)
/*      */     {
/* 1093 */       this.b_corps_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFight_status(int _v_)
/*      */     {
/* 1100 */       this.fight_status = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setA_corps_id_result(int _v_)
/*      */     {
/* 1107 */       this.a_corps_id_result = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setB_corps_id_result(int _v_)
/*      */     {
/* 1114 */       this.b_corps_id_result = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCal_fight_result(int _v_)
/*      */     {
/* 1121 */       this.cal_fight_result = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecord_id(long _v_)
/*      */     {
/* 1128 */       this.record_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1134 */       if (!(_o1_ instanceof Data)) return false;
/* 1135 */       Data _o_ = (Data)_o1_;
/* 1136 */       if (this.a_corps_id != _o_.a_corps_id) return false;
/* 1137 */       if (this.b_corps_id != _o_.b_corps_id) return false;
/* 1138 */       if (this.fight_status != _o_.fight_status) return false;
/* 1139 */       if (this.a_corps_id_result != _o_.a_corps_id_result) return false;
/* 1140 */       if (this.b_corps_id_result != _o_.b_corps_id_result) return false;
/* 1141 */       if (this.cal_fight_result != _o_.cal_fight_result) return false;
/* 1142 */       if (this.record_id != _o_.record_id) return false;
/* 1143 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1149 */       int _h_ = 0;
/* 1150 */       _h_ = (int)(_h_ + this.a_corps_id);
/* 1151 */       _h_ = (int)(_h_ + this.b_corps_id);
/* 1152 */       _h_ += this.fight_status;
/* 1153 */       _h_ += this.a_corps_id_result;
/* 1154 */       _h_ += this.b_corps_id_result;
/* 1155 */       _h_ += this.cal_fight_result;
/* 1156 */       _h_ = (int)(_h_ + this.record_id);
/* 1157 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1163 */       StringBuilder _sb_ = new StringBuilder();
/* 1164 */       _sb_.append("(");
/* 1165 */       _sb_.append(this.a_corps_id);
/* 1166 */       _sb_.append(",");
/* 1167 */       _sb_.append(this.b_corps_id);
/* 1168 */       _sb_.append(",");
/* 1169 */       _sb_.append(this.fight_status);
/* 1170 */       _sb_.append(",");
/* 1171 */       _sb_.append(this.a_corps_id_result);
/* 1172 */       _sb_.append(",");
/* 1173 */       _sb_.append(this.b_corps_id_result);
/* 1174 */       _sb_.append(",");
/* 1175 */       _sb_.append(this.cal_fight_result);
/* 1176 */       _sb_.append(",");
/* 1177 */       _sb_.append(this.record_id);
/* 1178 */       _sb_.append(")");
/* 1179 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FightAgainstInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
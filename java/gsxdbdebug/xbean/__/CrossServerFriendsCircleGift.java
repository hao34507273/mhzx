/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import ppbio.ByteString;
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
/*      */ public final class CrossServerFriendsCircleGift extends XBean implements xbean.CrossServerFriendsCircleGift
/*      */ {
/*      */   private long receive_gift_role_id;
/*      */   private int receive_gift_role_zone_id;
/*      */   private int item_cfg_id;
/*      */   private int item_grade;
/*      */   private int item_num;
/*      */   private int add_popularity_value;
/*      */   private String message;
/*      */   private boolean is_server_replied;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.receive_gift_role_id = 0L;
/*   33 */     this.receive_gift_role_zone_id = 0;
/*   34 */     this.item_cfg_id = 0;
/*   35 */     this.item_grade = 0;
/*   36 */     this.item_num = 0;
/*   37 */     this.add_popularity_value = 0;
/*   38 */     this.message = "";
/*   39 */     this.is_server_replied = false;
/*      */   }
/*      */   
/*      */   CrossServerFriendsCircleGift(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.message = "";
/*      */   }
/*      */   
/*      */   public CrossServerFriendsCircleGift()
/*      */   {
/*   50 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CrossServerFriendsCircleGift(CrossServerFriendsCircleGift _o_)
/*      */   {
/*   55 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CrossServerFriendsCircleGift(xbean.CrossServerFriendsCircleGift _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   60 */     super(_xp_, _vn_);
/*   61 */     if ((_o1_ instanceof CrossServerFriendsCircleGift)) { assign((CrossServerFriendsCircleGift)_o1_);
/*   62 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   63 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   64 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CrossServerFriendsCircleGift _o_) {
/*   69 */     _o_._xdb_verify_unsafe_();
/*   70 */     this.receive_gift_role_id = _o_.receive_gift_role_id;
/*   71 */     this.receive_gift_role_zone_id = _o_.receive_gift_role_zone_id;
/*   72 */     this.item_cfg_id = _o_.item_cfg_id;
/*   73 */     this.item_grade = _o_.item_grade;
/*   74 */     this.item_num = _o_.item_num;
/*   75 */     this.add_popularity_value = _o_.add_popularity_value;
/*   76 */     this.message = _o_.message;
/*   77 */     this.is_server_replied = _o_.is_server_replied;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   82 */     this.receive_gift_role_id = _o_.receive_gift_role_id;
/*   83 */     this.receive_gift_role_zone_id = _o_.receive_gift_role_zone_id;
/*   84 */     this.item_cfg_id = _o_.item_cfg_id;
/*   85 */     this.item_grade = _o_.item_grade;
/*   86 */     this.item_num = _o_.item_num;
/*   87 */     this.add_popularity_value = _o_.add_popularity_value;
/*   88 */     this.message = _o_.message;
/*   89 */     this.is_server_replied = _o_.is_server_replied;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   95 */     _xdb_verify_unsafe_();
/*   96 */     _os_.marshal(this.receive_gift_role_id);
/*   97 */     _os_.marshal(this.receive_gift_role_zone_id);
/*   98 */     _os_.marshal(this.item_cfg_id);
/*   99 */     _os_.marshal(this.item_grade);
/*  100 */     _os_.marshal(this.item_num);
/*  101 */     _os_.marshal(this.add_popularity_value);
/*  102 */     _os_.marshal(this.message, "UTF-16LE");
/*  103 */     _os_.marshal(this.is_server_replied);
/*  104 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  110 */     _xdb_verify_unsafe_();
/*  111 */     this.receive_gift_role_id = _os_.unmarshal_long();
/*  112 */     this.receive_gift_role_zone_id = _os_.unmarshal_int();
/*  113 */     this.item_cfg_id = _os_.unmarshal_int();
/*  114 */     this.item_grade = _os_.unmarshal_int();
/*  115 */     this.item_num = _os_.unmarshal_int();
/*  116 */     this.add_popularity_value = _os_.unmarshal_int();
/*  117 */     this.message = _os_.unmarshal_String("UTF-16LE");
/*  118 */     this.is_server_replied = _os_.unmarshal_boolean();
/*  119 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  125 */     _xdb_verify_unsafe_();
/*  126 */     int _size_ = 0;
/*  127 */     _size_ += CodedOutputStream.computeInt64Size(1, this.receive_gift_role_id);
/*  128 */     _size_ += CodedOutputStream.computeInt32Size(2, this.receive_gift_role_zone_id);
/*  129 */     _size_ += CodedOutputStream.computeInt32Size(3, this.item_cfg_id);
/*  130 */     _size_ += CodedOutputStream.computeInt32Size(4, this.item_grade);
/*  131 */     _size_ += CodedOutputStream.computeInt32Size(5, this.item_num);
/*  132 */     _size_ += CodedOutputStream.computeInt32Size(6, this.add_popularity_value);
/*      */     try
/*      */     {
/*  135 */       _size_ += CodedOutputStream.computeBytesSize(7, ByteString.copyFrom(this.message, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  139 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  141 */     _size_ += CodedOutputStream.computeBoolSize(8, this.is_server_replied);
/*  142 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  148 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  151 */       _output_.writeInt64(1, this.receive_gift_role_id);
/*  152 */       _output_.writeInt32(2, this.receive_gift_role_zone_id);
/*  153 */       _output_.writeInt32(3, this.item_cfg_id);
/*  154 */       _output_.writeInt32(4, this.item_grade);
/*  155 */       _output_.writeInt32(5, this.item_num);
/*  156 */       _output_.writeInt32(6, this.add_popularity_value);
/*  157 */       _output_.writeBytes(7, ByteString.copyFrom(this.message, "UTF-16LE"));
/*  158 */       _output_.writeBool(8, this.is_server_replied);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  162 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  164 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  170 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  173 */       boolean done = false;
/*  174 */       while (!done)
/*      */       {
/*  176 */         int tag = _input_.readTag();
/*  177 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  181 */           done = true;
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  186 */           this.receive_gift_role_id = _input_.readInt64();
/*  187 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  191 */           this.receive_gift_role_zone_id = _input_.readInt32();
/*  192 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  196 */           this.item_cfg_id = _input_.readInt32();
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  201 */           this.item_grade = _input_.readInt32();
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  206 */           this.item_num = _input_.readInt32();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  211 */           this.add_popularity_value = _input_.readInt32();
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  216 */           this.message = _input_.readBytes().toString("UTF-16LE");
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  221 */           this.is_server_replied = _input_.readBool();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  226 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  228 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  237 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  241 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  243 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossServerFriendsCircleGift copy()
/*      */   {
/*  249 */     _xdb_verify_unsafe_();
/*  250 */     return new CrossServerFriendsCircleGift(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossServerFriendsCircleGift toData()
/*      */   {
/*  256 */     _xdb_verify_unsafe_();
/*  257 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CrossServerFriendsCircleGift toBean()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return new CrossServerFriendsCircleGift(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossServerFriendsCircleGift toDataIf()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CrossServerFriendsCircleGift toBeanIf()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getReceive_gift_role_id()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return this.receive_gift_role_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getReceive_gift_role_zone_id()
/*      */   {
/*  298 */     _xdb_verify_unsafe_();
/*  299 */     return this.receive_gift_role_zone_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItem_cfg_id()
/*      */   {
/*  306 */     _xdb_verify_unsafe_();
/*  307 */     return this.item_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItem_grade()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return this.item_grade;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItem_num()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*  323 */     return this.item_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAdd_popularity_value()
/*      */   {
/*  330 */     _xdb_verify_unsafe_();
/*  331 */     return this.add_popularity_value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getMessage()
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*  339 */     return this.message;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getMessageOctets()
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     return Octets.wrap(getMessage(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_server_replied()
/*      */   {
/*  354 */     _xdb_verify_unsafe_();
/*  355 */     return this.is_server_replied;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReceive_gift_role_id(long _v_)
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*  363 */     Logs.logIf(new LogKey(this, "receive_gift_role_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  367 */         new xdb.logs.LogLong(this, CrossServerFriendsCircleGift.this.receive_gift_role_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  371 */             CrossServerFriendsCircleGift.this.receive_gift_role_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  375 */     });
/*  376 */     this.receive_gift_role_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReceive_gift_role_zone_id(int _v_)
/*      */   {
/*  383 */     _xdb_verify_unsafe_();
/*  384 */     Logs.logIf(new LogKey(this, "receive_gift_role_zone_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  388 */         new LogInt(this, CrossServerFriendsCircleGift.this.receive_gift_role_zone_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  392 */             CrossServerFriendsCircleGift.this.receive_gift_role_zone_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  396 */     });
/*  397 */     this.receive_gift_role_zone_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItem_cfg_id(int _v_)
/*      */   {
/*  404 */     _xdb_verify_unsafe_();
/*  405 */     Logs.logIf(new LogKey(this, "item_cfg_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  409 */         new LogInt(this, CrossServerFriendsCircleGift.this.item_cfg_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  413 */             CrossServerFriendsCircleGift.this.item_cfg_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  417 */     });
/*  418 */     this.item_cfg_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItem_grade(int _v_)
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*  426 */     Logs.logIf(new LogKey(this, "item_grade")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  430 */         new LogInt(this, CrossServerFriendsCircleGift.this.item_grade)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  434 */             CrossServerFriendsCircleGift.this.item_grade = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  438 */     });
/*  439 */     this.item_grade = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItem_num(int _v_)
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     Logs.logIf(new LogKey(this, "item_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  451 */         new LogInt(this, CrossServerFriendsCircleGift.this.item_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  455 */             CrossServerFriendsCircleGift.this.item_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  459 */     });
/*  460 */     this.item_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAdd_popularity_value(int _v_)
/*      */   {
/*  467 */     _xdb_verify_unsafe_();
/*  468 */     Logs.logIf(new LogKey(this, "add_popularity_value")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  472 */         new LogInt(this, CrossServerFriendsCircleGift.this.add_popularity_value)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  476 */             CrossServerFriendsCircleGift.this.add_popularity_value = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  480 */     });
/*  481 */     this.add_popularity_value = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMessage(String _v_)
/*      */   {
/*  488 */     _xdb_verify_unsafe_();
/*  489 */     if (null == _v_)
/*  490 */       throw new NullPointerException();
/*  491 */     Logs.logIf(new LogKey(this, "message")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  495 */         new xdb.logs.LogString(this, CrossServerFriendsCircleGift.this.message)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  499 */             CrossServerFriendsCircleGift.this.message = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  503 */     });
/*  504 */     this.message = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMessageOctets(Octets _v_)
/*      */   {
/*  511 */     _xdb_verify_unsafe_();
/*  512 */     setMessage(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_server_replied(boolean _v_)
/*      */   {
/*  519 */     _xdb_verify_unsafe_();
/*  520 */     Logs.logIf(new LogKey(this, "is_server_replied")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  524 */         new xdb.logs.LogObject(this, Boolean.valueOf(CrossServerFriendsCircleGift.this.is_server_replied))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  528 */             CrossServerFriendsCircleGift.this.is_server_replied = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  532 */     });
/*  533 */     this.is_server_replied = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  539 */     _xdb_verify_unsafe_();
/*  540 */     CrossServerFriendsCircleGift _o_ = null;
/*  541 */     if ((_o1_ instanceof CrossServerFriendsCircleGift)) { _o_ = (CrossServerFriendsCircleGift)_o1_;
/*  542 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  543 */       return false;
/*  544 */     if (this.receive_gift_role_id != _o_.receive_gift_role_id) return false;
/*  545 */     if (this.receive_gift_role_zone_id != _o_.receive_gift_role_zone_id) return false;
/*  546 */     if (this.item_cfg_id != _o_.item_cfg_id) return false;
/*  547 */     if (this.item_grade != _o_.item_grade) return false;
/*  548 */     if (this.item_num != _o_.item_num) return false;
/*  549 */     if (this.add_popularity_value != _o_.add_popularity_value) return false;
/*  550 */     if (!this.message.equals(_o_.message)) return false;
/*  551 */     if (this.is_server_replied != _o_.is_server_replied) return false;
/*  552 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  558 */     _xdb_verify_unsafe_();
/*  559 */     int _h_ = 0;
/*  560 */     _h_ = (int)(_h_ + this.receive_gift_role_id);
/*  561 */     _h_ += this.receive_gift_role_zone_id;
/*  562 */     _h_ += this.item_cfg_id;
/*  563 */     _h_ += this.item_grade;
/*  564 */     _h_ += this.item_num;
/*  565 */     _h_ += this.add_popularity_value;
/*  566 */     _h_ += this.message.hashCode();
/*  567 */     _h_ += (this.is_server_replied ? 1231 : 1237);
/*  568 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  574 */     _xdb_verify_unsafe_();
/*  575 */     StringBuilder _sb_ = new StringBuilder();
/*  576 */     _sb_.append("(");
/*  577 */     _sb_.append(this.receive_gift_role_id);
/*  578 */     _sb_.append(",");
/*  579 */     _sb_.append(this.receive_gift_role_zone_id);
/*  580 */     _sb_.append(",");
/*  581 */     _sb_.append(this.item_cfg_id);
/*  582 */     _sb_.append(",");
/*  583 */     _sb_.append(this.item_grade);
/*  584 */     _sb_.append(",");
/*  585 */     _sb_.append(this.item_num);
/*  586 */     _sb_.append(",");
/*  587 */     _sb_.append(this.add_popularity_value);
/*  588 */     _sb_.append(",");
/*  589 */     _sb_.append("'").append(this.message).append("'");
/*  590 */     _sb_.append(",");
/*  591 */     _sb_.append(this.is_server_replied);
/*  592 */     _sb_.append(")");
/*  593 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  599 */     ListenableBean lb = new ListenableBean();
/*  600 */     lb.add(new ListenableChanged().setVarName("receive_gift_role_id"));
/*  601 */     lb.add(new ListenableChanged().setVarName("receive_gift_role_zone_id"));
/*  602 */     lb.add(new ListenableChanged().setVarName("item_cfg_id"));
/*  603 */     lb.add(new ListenableChanged().setVarName("item_grade"));
/*  604 */     lb.add(new ListenableChanged().setVarName("item_num"));
/*  605 */     lb.add(new ListenableChanged().setVarName("add_popularity_value"));
/*  606 */     lb.add(new ListenableChanged().setVarName("message"));
/*  607 */     lb.add(new ListenableChanged().setVarName("is_server_replied"));
/*  608 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CrossServerFriendsCircleGift {
/*      */     private Const() {}
/*      */     
/*      */     CrossServerFriendsCircleGift nThis() {
/*  615 */       return CrossServerFriendsCircleGift.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  621 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossServerFriendsCircleGift copy()
/*      */     {
/*  627 */       return CrossServerFriendsCircleGift.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossServerFriendsCircleGift toData()
/*      */     {
/*  633 */       return CrossServerFriendsCircleGift.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CrossServerFriendsCircleGift toBean()
/*      */     {
/*  638 */       return CrossServerFriendsCircleGift.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossServerFriendsCircleGift toDataIf()
/*      */     {
/*  644 */       return CrossServerFriendsCircleGift.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CrossServerFriendsCircleGift toBeanIf()
/*      */     {
/*  649 */       return CrossServerFriendsCircleGift.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getReceive_gift_role_id()
/*      */     {
/*  656 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  657 */       return CrossServerFriendsCircleGift.this.receive_gift_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReceive_gift_role_zone_id()
/*      */     {
/*  664 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  665 */       return CrossServerFriendsCircleGift.this.receive_gift_role_zone_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_cfg_id()
/*      */     {
/*  672 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  673 */       return CrossServerFriendsCircleGift.this.item_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_grade()
/*      */     {
/*  680 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  681 */       return CrossServerFriendsCircleGift.this.item_grade;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_num()
/*      */     {
/*  688 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  689 */       return CrossServerFriendsCircleGift.this.item_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAdd_popularity_value()
/*      */     {
/*  696 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  697 */       return CrossServerFriendsCircleGift.this.add_popularity_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMessage()
/*      */     {
/*  704 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  705 */       return CrossServerFriendsCircleGift.this.message;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMessageOctets()
/*      */     {
/*  712 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  713 */       return CrossServerFriendsCircleGift.this.getMessageOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_server_replied()
/*      */     {
/*  720 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  721 */       return CrossServerFriendsCircleGift.this.is_server_replied;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReceive_gift_role_id(long _v_)
/*      */     {
/*  728 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  729 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReceive_gift_role_zone_id(int _v_)
/*      */     {
/*  736 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  737 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_cfg_id(int _v_)
/*      */     {
/*  744 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  745 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_grade(int _v_)
/*      */     {
/*  752 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  753 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_num(int _v_)
/*      */     {
/*  760 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  761 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAdd_popularity_value(int _v_)
/*      */     {
/*  768 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  769 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMessage(String _v_)
/*      */     {
/*  776 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  777 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMessageOctets(Octets _v_)
/*      */     {
/*  784 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  785 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_server_replied(boolean _v_)
/*      */     {
/*  792 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  793 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  799 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  800 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  806 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  807 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  813 */       return CrossServerFriendsCircleGift.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  819 */       return CrossServerFriendsCircleGift.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  825 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  826 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  832 */       return CrossServerFriendsCircleGift.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  838 */       return CrossServerFriendsCircleGift.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  844 */       CrossServerFriendsCircleGift.this._xdb_verify_unsafe_();
/*  845 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  851 */       return CrossServerFriendsCircleGift.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  857 */       return CrossServerFriendsCircleGift.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  863 */       return CrossServerFriendsCircleGift.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  869 */       return CrossServerFriendsCircleGift.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  875 */       return CrossServerFriendsCircleGift.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  881 */       return CrossServerFriendsCircleGift.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  887 */       return CrossServerFriendsCircleGift.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CrossServerFriendsCircleGift
/*      */   {
/*      */     private long receive_gift_role_id;
/*      */     
/*      */     private int receive_gift_role_zone_id;
/*      */     
/*      */     private int item_cfg_id;
/*      */     
/*      */     private int item_grade;
/*      */     
/*      */     private int item_num;
/*      */     
/*      */     private int add_popularity_value;
/*      */     
/*      */     private String message;
/*      */     
/*      */     private boolean is_server_replied;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  913 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  918 */       this.message = "";
/*      */     }
/*      */     
/*      */     Data(xbean.CrossServerFriendsCircleGift _o1_)
/*      */     {
/*  923 */       if ((_o1_ instanceof CrossServerFriendsCircleGift)) { assign((CrossServerFriendsCircleGift)_o1_);
/*  924 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  925 */       } else if ((_o1_ instanceof CrossServerFriendsCircleGift.Const)) assign(((CrossServerFriendsCircleGift.Const)_o1_).nThis()); else {
/*  926 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CrossServerFriendsCircleGift _o_) {
/*  931 */       this.receive_gift_role_id = _o_.receive_gift_role_id;
/*  932 */       this.receive_gift_role_zone_id = _o_.receive_gift_role_zone_id;
/*  933 */       this.item_cfg_id = _o_.item_cfg_id;
/*  934 */       this.item_grade = _o_.item_grade;
/*  935 */       this.item_num = _o_.item_num;
/*  936 */       this.add_popularity_value = _o_.add_popularity_value;
/*  937 */       this.message = _o_.message;
/*  938 */       this.is_server_replied = _o_.is_server_replied;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  943 */       this.receive_gift_role_id = _o_.receive_gift_role_id;
/*  944 */       this.receive_gift_role_zone_id = _o_.receive_gift_role_zone_id;
/*  945 */       this.item_cfg_id = _o_.item_cfg_id;
/*  946 */       this.item_grade = _o_.item_grade;
/*  947 */       this.item_num = _o_.item_num;
/*  948 */       this.add_popularity_value = _o_.add_popularity_value;
/*  949 */       this.message = _o_.message;
/*  950 */       this.is_server_replied = _o_.is_server_replied;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  956 */       _os_.marshal(this.receive_gift_role_id);
/*  957 */       _os_.marshal(this.receive_gift_role_zone_id);
/*  958 */       _os_.marshal(this.item_cfg_id);
/*  959 */       _os_.marshal(this.item_grade);
/*  960 */       _os_.marshal(this.item_num);
/*  961 */       _os_.marshal(this.add_popularity_value);
/*  962 */       _os_.marshal(this.message, "UTF-16LE");
/*  963 */       _os_.marshal(this.is_server_replied);
/*  964 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  970 */       this.receive_gift_role_id = _os_.unmarshal_long();
/*  971 */       this.receive_gift_role_zone_id = _os_.unmarshal_int();
/*  972 */       this.item_cfg_id = _os_.unmarshal_int();
/*  973 */       this.item_grade = _os_.unmarshal_int();
/*  974 */       this.item_num = _os_.unmarshal_int();
/*  975 */       this.add_popularity_value = _os_.unmarshal_int();
/*  976 */       this.message = _os_.unmarshal_String("UTF-16LE");
/*  977 */       this.is_server_replied = _os_.unmarshal_boolean();
/*  978 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  984 */       int _size_ = 0;
/*  985 */       _size_ += CodedOutputStream.computeInt64Size(1, this.receive_gift_role_id);
/*  986 */       _size_ += CodedOutputStream.computeInt32Size(2, this.receive_gift_role_zone_id);
/*  987 */       _size_ += CodedOutputStream.computeInt32Size(3, this.item_cfg_id);
/*  988 */       _size_ += CodedOutputStream.computeInt32Size(4, this.item_grade);
/*  989 */       _size_ += CodedOutputStream.computeInt32Size(5, this.item_num);
/*  990 */       _size_ += CodedOutputStream.computeInt32Size(6, this.add_popularity_value);
/*      */       try
/*      */       {
/*  993 */         _size_ += CodedOutputStream.computeBytesSize(7, ByteString.copyFrom(this.message, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  997 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  999 */       _size_ += CodedOutputStream.computeBoolSize(8, this.is_server_replied);
/* 1000 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1008 */         _output_.writeInt64(1, this.receive_gift_role_id);
/* 1009 */         _output_.writeInt32(2, this.receive_gift_role_zone_id);
/* 1010 */         _output_.writeInt32(3, this.item_cfg_id);
/* 1011 */         _output_.writeInt32(4, this.item_grade);
/* 1012 */         _output_.writeInt32(5, this.item_num);
/* 1013 */         _output_.writeInt32(6, this.add_popularity_value);
/* 1014 */         _output_.writeBytes(7, ByteString.copyFrom(this.message, "UTF-16LE"));
/* 1015 */         _output_.writeBool(8, this.is_server_replied);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1019 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1021 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1029 */         boolean done = false;
/* 1030 */         while (!done)
/*      */         {
/* 1032 */           int tag = _input_.readTag();
/* 1033 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1037 */             done = true;
/* 1038 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1042 */             this.receive_gift_role_id = _input_.readInt64();
/* 1043 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1047 */             this.receive_gift_role_zone_id = _input_.readInt32();
/* 1048 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1052 */             this.item_cfg_id = _input_.readInt32();
/* 1053 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1057 */             this.item_grade = _input_.readInt32();
/* 1058 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1062 */             this.item_num = _input_.readInt32();
/* 1063 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1067 */             this.add_popularity_value = _input_.readInt32();
/* 1068 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 1072 */             this.message = _input_.readBytes().toString("UTF-16LE");
/* 1073 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1077 */             this.is_server_replied = _input_.readBool();
/* 1078 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1082 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1084 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1093 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1097 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1099 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossServerFriendsCircleGift copy()
/*      */     {
/* 1105 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossServerFriendsCircleGift toData()
/*      */     {
/* 1111 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CrossServerFriendsCircleGift toBean()
/*      */     {
/* 1116 */       return new CrossServerFriendsCircleGift(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossServerFriendsCircleGift toDataIf()
/*      */     {
/* 1122 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CrossServerFriendsCircleGift toBeanIf()
/*      */     {
/* 1127 */       return new CrossServerFriendsCircleGift(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1133 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1137 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1141 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1145 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1149 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1153 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1157 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getReceive_gift_role_id()
/*      */     {
/* 1164 */       return this.receive_gift_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReceive_gift_role_zone_id()
/*      */     {
/* 1171 */       return this.receive_gift_role_zone_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_cfg_id()
/*      */     {
/* 1178 */       return this.item_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_grade()
/*      */     {
/* 1185 */       return this.item_grade;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_num()
/*      */     {
/* 1192 */       return this.item_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAdd_popularity_value()
/*      */     {
/* 1199 */       return this.add_popularity_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMessage()
/*      */     {
/* 1206 */       return this.message;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMessageOctets()
/*      */     {
/* 1213 */       return Octets.wrap(getMessage(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_server_replied()
/*      */     {
/* 1220 */       return this.is_server_replied;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReceive_gift_role_id(long _v_)
/*      */     {
/* 1227 */       this.receive_gift_role_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReceive_gift_role_zone_id(int _v_)
/*      */     {
/* 1234 */       this.receive_gift_role_zone_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_cfg_id(int _v_)
/*      */     {
/* 1241 */       this.item_cfg_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_grade(int _v_)
/*      */     {
/* 1248 */       this.item_grade = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_num(int _v_)
/*      */     {
/* 1255 */       this.item_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAdd_popularity_value(int _v_)
/*      */     {
/* 1262 */       this.add_popularity_value = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMessage(String _v_)
/*      */     {
/* 1269 */       if (null == _v_)
/* 1270 */         throw new NullPointerException();
/* 1271 */       this.message = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMessageOctets(Octets _v_)
/*      */     {
/* 1278 */       setMessage(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_server_replied(boolean _v_)
/*      */     {
/* 1285 */       this.is_server_replied = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1291 */       if (!(_o1_ instanceof Data)) return false;
/* 1292 */       Data _o_ = (Data)_o1_;
/* 1293 */       if (this.receive_gift_role_id != _o_.receive_gift_role_id) return false;
/* 1294 */       if (this.receive_gift_role_zone_id != _o_.receive_gift_role_zone_id) return false;
/* 1295 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/* 1296 */       if (this.item_grade != _o_.item_grade) return false;
/* 1297 */       if (this.item_num != _o_.item_num) return false;
/* 1298 */       if (this.add_popularity_value != _o_.add_popularity_value) return false;
/* 1299 */       if (!this.message.equals(_o_.message)) return false;
/* 1300 */       if (this.is_server_replied != _o_.is_server_replied) return false;
/* 1301 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1307 */       int _h_ = 0;
/* 1308 */       _h_ = (int)(_h_ + this.receive_gift_role_id);
/* 1309 */       _h_ += this.receive_gift_role_zone_id;
/* 1310 */       _h_ += this.item_cfg_id;
/* 1311 */       _h_ += this.item_grade;
/* 1312 */       _h_ += this.item_num;
/* 1313 */       _h_ += this.add_popularity_value;
/* 1314 */       _h_ += this.message.hashCode();
/* 1315 */       _h_ += (this.is_server_replied ? 1231 : 1237);
/* 1316 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1322 */       StringBuilder _sb_ = new StringBuilder();
/* 1323 */       _sb_.append("(");
/* 1324 */       _sb_.append(this.receive_gift_role_id);
/* 1325 */       _sb_.append(",");
/* 1326 */       _sb_.append(this.receive_gift_role_zone_id);
/* 1327 */       _sb_.append(",");
/* 1328 */       _sb_.append(this.item_cfg_id);
/* 1329 */       _sb_.append(",");
/* 1330 */       _sb_.append(this.item_grade);
/* 1331 */       _sb_.append(",");
/* 1332 */       _sb_.append(this.item_num);
/* 1333 */       _sb_.append(",");
/* 1334 */       _sb_.append(this.add_popularity_value);
/* 1335 */       _sb_.append(",");
/* 1336 */       _sb_.append("'").append(this.message).append("'");
/* 1337 */       _sb_.append(",");
/* 1338 */       _sb_.append(this.is_server_replied);
/* 1339 */       _sb_.append(")");
/* 1340 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossServerFriendsCircleGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
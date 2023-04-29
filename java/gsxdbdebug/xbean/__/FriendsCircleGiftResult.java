/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
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
/*      */ public final class FriendsCircleGiftResult extends XBean implements xbean.FriendsCircleGiftResult
/*      */ {
/*      */   private long give_gift_role_id;
/*      */   private int give_gift_zone_id;
/*      */   private int item_cfg_id;
/*      */   private int item_grade;
/*      */   private int item_num;
/*      */   private int add_popularity_value;
/*      */   private String message;
/*      */   private boolean is_ssp_replied;
/*      */   private boolean is_cross_server;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.give_gift_role_id = 0L;
/*   35 */     this.give_gift_zone_id = 0;
/*   36 */     this.item_cfg_id = 0;
/*   37 */     this.item_grade = 0;
/*   38 */     this.item_num = 0;
/*   39 */     this.add_popularity_value = 0;
/*   40 */     this.message = "";
/*   41 */     this.is_ssp_replied = false;
/*   42 */     this.is_cross_server = false;
/*      */   }
/*      */   
/*      */   FriendsCircleGiftResult(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*   48 */     this.message = "";
/*      */   }
/*      */   
/*      */   public FriendsCircleGiftResult()
/*      */   {
/*   53 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FriendsCircleGiftResult(FriendsCircleGiftResult _o_)
/*      */   {
/*   58 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FriendsCircleGiftResult(xbean.FriendsCircleGiftResult _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   63 */     super(_xp_, _vn_);
/*   64 */     if ((_o1_ instanceof FriendsCircleGiftResult)) { assign((FriendsCircleGiftResult)_o1_);
/*   65 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   66 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   67 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FriendsCircleGiftResult _o_) {
/*   72 */     _o_._xdb_verify_unsafe_();
/*   73 */     this.give_gift_role_id = _o_.give_gift_role_id;
/*   74 */     this.give_gift_zone_id = _o_.give_gift_zone_id;
/*   75 */     this.item_cfg_id = _o_.item_cfg_id;
/*   76 */     this.item_grade = _o_.item_grade;
/*   77 */     this.item_num = _o_.item_num;
/*   78 */     this.add_popularity_value = _o_.add_popularity_value;
/*   79 */     this.message = _o_.message;
/*   80 */     this.is_ssp_replied = _o_.is_ssp_replied;
/*   81 */     this.is_cross_server = _o_.is_cross_server;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   86 */     this.give_gift_role_id = _o_.give_gift_role_id;
/*   87 */     this.give_gift_zone_id = _o_.give_gift_zone_id;
/*   88 */     this.item_cfg_id = _o_.item_cfg_id;
/*   89 */     this.item_grade = _o_.item_grade;
/*   90 */     this.item_num = _o_.item_num;
/*   91 */     this.add_popularity_value = _o_.add_popularity_value;
/*   92 */     this.message = _o_.message;
/*   93 */     this.is_ssp_replied = _o_.is_ssp_replied;
/*   94 */     this.is_cross_server = _o_.is_cross_server;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  100 */     _xdb_verify_unsafe_();
/*  101 */     _os_.marshal(this.give_gift_role_id);
/*  102 */     _os_.marshal(this.give_gift_zone_id);
/*  103 */     _os_.marshal(this.item_cfg_id);
/*  104 */     _os_.marshal(this.item_grade);
/*  105 */     _os_.marshal(this.item_num);
/*  106 */     _os_.marshal(this.add_popularity_value);
/*  107 */     _os_.marshal(this.message, "UTF-16LE");
/*  108 */     _os_.marshal(this.is_ssp_replied);
/*  109 */     _os_.marshal(this.is_cross_server);
/*  110 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  116 */     _xdb_verify_unsafe_();
/*  117 */     this.give_gift_role_id = _os_.unmarshal_long();
/*  118 */     this.give_gift_zone_id = _os_.unmarshal_int();
/*  119 */     this.item_cfg_id = _os_.unmarshal_int();
/*  120 */     this.item_grade = _os_.unmarshal_int();
/*  121 */     this.item_num = _os_.unmarshal_int();
/*  122 */     this.add_popularity_value = _os_.unmarshal_int();
/*  123 */     this.message = _os_.unmarshal_String("UTF-16LE");
/*  124 */     this.is_ssp_replied = _os_.unmarshal_boolean();
/*  125 */     this.is_cross_server = _os_.unmarshal_boolean();
/*  126 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  132 */     _xdb_verify_unsafe_();
/*  133 */     int _size_ = 0;
/*  134 */     _size_ += CodedOutputStream.computeInt64Size(1, this.give_gift_role_id);
/*  135 */     _size_ += CodedOutputStream.computeInt32Size(2, this.give_gift_zone_id);
/*  136 */     _size_ += CodedOutputStream.computeInt32Size(3, this.item_cfg_id);
/*  137 */     _size_ += CodedOutputStream.computeInt32Size(4, this.item_grade);
/*  138 */     _size_ += CodedOutputStream.computeInt32Size(5, this.item_num);
/*  139 */     _size_ += CodedOutputStream.computeInt32Size(6, this.add_popularity_value);
/*      */     try
/*      */     {
/*  142 */       _size_ += CodedOutputStream.computeBytesSize(7, ByteString.copyFrom(this.message, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  146 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  148 */     _size_ += CodedOutputStream.computeBoolSize(8, this.is_ssp_replied);
/*  149 */     _size_ += CodedOutputStream.computeBoolSize(9, this.is_cross_server);
/*  150 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  156 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  159 */       _output_.writeInt64(1, this.give_gift_role_id);
/*  160 */       _output_.writeInt32(2, this.give_gift_zone_id);
/*  161 */       _output_.writeInt32(3, this.item_cfg_id);
/*  162 */       _output_.writeInt32(4, this.item_grade);
/*  163 */       _output_.writeInt32(5, this.item_num);
/*  164 */       _output_.writeInt32(6, this.add_popularity_value);
/*  165 */       _output_.writeBytes(7, ByteString.copyFrom(this.message, "UTF-16LE"));
/*  166 */       _output_.writeBool(8, this.is_ssp_replied);
/*  167 */       _output_.writeBool(9, this.is_cross_server);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  171 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  173 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  179 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  182 */       boolean done = false;
/*  183 */       while (!done)
/*      */       {
/*  185 */         int tag = _input_.readTag();
/*  186 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  190 */           done = true;
/*  191 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  195 */           this.give_gift_role_id = _input_.readInt64();
/*  196 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  200 */           this.give_gift_zone_id = _input_.readInt32();
/*  201 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  205 */           this.item_cfg_id = _input_.readInt32();
/*  206 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  210 */           this.item_grade = _input_.readInt32();
/*  211 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  215 */           this.item_num = _input_.readInt32();
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  220 */           this.add_popularity_value = _input_.readInt32();
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  225 */           this.message = _input_.readBytes().toString("UTF-16LE");
/*  226 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  230 */           this.is_ssp_replied = _input_.readBool();
/*  231 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  235 */           this.is_cross_server = _input_.readBool();
/*  236 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  240 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  242 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  251 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  255 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  257 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FriendsCircleGiftResult copy()
/*      */   {
/*  263 */     _xdb_verify_unsafe_();
/*  264 */     return new FriendsCircleGiftResult(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FriendsCircleGiftResult toData()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FriendsCircleGiftResult toBean()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return new FriendsCircleGiftResult(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FriendsCircleGiftResult toDataIf()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FriendsCircleGiftResult toBeanIf()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGive_gift_role_id()
/*      */   {
/*  304 */     _xdb_verify_unsafe_();
/*  305 */     return this.give_gift_role_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGive_gift_zone_id()
/*      */   {
/*  312 */     _xdb_verify_unsafe_();
/*  313 */     return this.give_gift_zone_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItem_cfg_id()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return this.item_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItem_grade()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return this.item_grade;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItem_num()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return this.item_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAdd_popularity_value()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     return this.add_popularity_value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getMessage()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*  353 */     return this.message;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getMessageOctets()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     return Octets.wrap(getMessage(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_ssp_replied()
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     return this.is_ssp_replied;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_cross_server()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     return this.is_cross_server;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGive_gift_role_id(long _v_)
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     Logs.logIf(new LogKey(this, "give_gift_role_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  389 */         new xdb.logs.LogLong(this, FriendsCircleGiftResult.this.give_gift_role_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  393 */             FriendsCircleGiftResult.this.give_gift_role_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  397 */     });
/*  398 */     this.give_gift_role_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGive_gift_zone_id(int _v_)
/*      */   {
/*  405 */     _xdb_verify_unsafe_();
/*  406 */     Logs.logIf(new LogKey(this, "give_gift_zone_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  410 */         new LogInt(this, FriendsCircleGiftResult.this.give_gift_zone_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  414 */             FriendsCircleGiftResult.this.give_gift_zone_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  418 */     });
/*  419 */     this.give_gift_zone_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItem_cfg_id(int _v_)
/*      */   {
/*  426 */     _xdb_verify_unsafe_();
/*  427 */     Logs.logIf(new LogKey(this, "item_cfg_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  431 */         new LogInt(this, FriendsCircleGiftResult.this.item_cfg_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  435 */             FriendsCircleGiftResult.this.item_cfg_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  439 */     });
/*  440 */     this.item_cfg_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItem_grade(int _v_)
/*      */   {
/*  447 */     _xdb_verify_unsafe_();
/*  448 */     Logs.logIf(new LogKey(this, "item_grade")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  452 */         new LogInt(this, FriendsCircleGiftResult.this.item_grade)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  456 */             FriendsCircleGiftResult.this.item_grade = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  460 */     });
/*  461 */     this.item_grade = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItem_num(int _v_)
/*      */   {
/*  468 */     _xdb_verify_unsafe_();
/*  469 */     Logs.logIf(new LogKey(this, "item_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  473 */         new LogInt(this, FriendsCircleGiftResult.this.item_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  477 */             FriendsCircleGiftResult.this.item_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  481 */     });
/*  482 */     this.item_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAdd_popularity_value(int _v_)
/*      */   {
/*  489 */     _xdb_verify_unsafe_();
/*  490 */     Logs.logIf(new LogKey(this, "add_popularity_value")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  494 */         new LogInt(this, FriendsCircleGiftResult.this.add_popularity_value)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  498 */             FriendsCircleGiftResult.this.add_popularity_value = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  502 */     });
/*  503 */     this.add_popularity_value = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMessage(String _v_)
/*      */   {
/*  510 */     _xdb_verify_unsafe_();
/*  511 */     if (null == _v_)
/*  512 */       throw new NullPointerException();
/*  513 */     Logs.logIf(new LogKey(this, "message")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  517 */         new xdb.logs.LogString(this, FriendsCircleGiftResult.this.message)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  521 */             FriendsCircleGiftResult.this.message = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  525 */     });
/*  526 */     this.message = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMessageOctets(Octets _v_)
/*      */   {
/*  533 */     _xdb_verify_unsafe_();
/*  534 */     setMessage(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_ssp_replied(boolean _v_)
/*      */   {
/*  541 */     _xdb_verify_unsafe_();
/*  542 */     Logs.logIf(new LogKey(this, "is_ssp_replied")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  546 */         new xdb.logs.LogObject(this, Boolean.valueOf(FriendsCircleGiftResult.this.is_ssp_replied))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  550 */             FriendsCircleGiftResult.this.is_ssp_replied = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  554 */     });
/*  555 */     this.is_ssp_replied = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_cross_server(boolean _v_)
/*      */   {
/*  562 */     _xdb_verify_unsafe_();
/*  563 */     Logs.logIf(new LogKey(this, "is_cross_server")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  567 */         new xdb.logs.LogObject(this, Boolean.valueOf(FriendsCircleGiftResult.this.is_cross_server))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  571 */             FriendsCircleGiftResult.this.is_cross_server = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  575 */     });
/*  576 */     this.is_cross_server = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  582 */     _xdb_verify_unsafe_();
/*  583 */     FriendsCircleGiftResult _o_ = null;
/*  584 */     if ((_o1_ instanceof FriendsCircleGiftResult)) { _o_ = (FriendsCircleGiftResult)_o1_;
/*  585 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  586 */       return false;
/*  587 */     if (this.give_gift_role_id != _o_.give_gift_role_id) return false;
/*  588 */     if (this.give_gift_zone_id != _o_.give_gift_zone_id) return false;
/*  589 */     if (this.item_cfg_id != _o_.item_cfg_id) return false;
/*  590 */     if (this.item_grade != _o_.item_grade) return false;
/*  591 */     if (this.item_num != _o_.item_num) return false;
/*  592 */     if (this.add_popularity_value != _o_.add_popularity_value) return false;
/*  593 */     if (!this.message.equals(_o_.message)) return false;
/*  594 */     if (this.is_ssp_replied != _o_.is_ssp_replied) return false;
/*  595 */     if (this.is_cross_server != _o_.is_cross_server) return false;
/*  596 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  602 */     _xdb_verify_unsafe_();
/*  603 */     int _h_ = 0;
/*  604 */     _h_ = (int)(_h_ + this.give_gift_role_id);
/*  605 */     _h_ += this.give_gift_zone_id;
/*  606 */     _h_ += this.item_cfg_id;
/*  607 */     _h_ += this.item_grade;
/*  608 */     _h_ += this.item_num;
/*  609 */     _h_ += this.add_popularity_value;
/*  610 */     _h_ += this.message.hashCode();
/*  611 */     _h_ += (this.is_ssp_replied ? 1231 : 1237);
/*  612 */     _h_ += (this.is_cross_server ? 1231 : 1237);
/*  613 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  619 */     _xdb_verify_unsafe_();
/*  620 */     StringBuilder _sb_ = new StringBuilder();
/*  621 */     _sb_.append("(");
/*  622 */     _sb_.append(this.give_gift_role_id);
/*  623 */     _sb_.append(",");
/*  624 */     _sb_.append(this.give_gift_zone_id);
/*  625 */     _sb_.append(",");
/*  626 */     _sb_.append(this.item_cfg_id);
/*  627 */     _sb_.append(",");
/*  628 */     _sb_.append(this.item_grade);
/*  629 */     _sb_.append(",");
/*  630 */     _sb_.append(this.item_num);
/*  631 */     _sb_.append(",");
/*  632 */     _sb_.append(this.add_popularity_value);
/*  633 */     _sb_.append(",");
/*  634 */     _sb_.append("'").append(this.message).append("'");
/*  635 */     _sb_.append(",");
/*  636 */     _sb_.append(this.is_ssp_replied);
/*  637 */     _sb_.append(",");
/*  638 */     _sb_.append(this.is_cross_server);
/*  639 */     _sb_.append(")");
/*  640 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  646 */     ListenableBean lb = new ListenableBean();
/*  647 */     lb.add(new ListenableChanged().setVarName("give_gift_role_id"));
/*  648 */     lb.add(new ListenableChanged().setVarName("give_gift_zone_id"));
/*  649 */     lb.add(new ListenableChanged().setVarName("item_cfg_id"));
/*  650 */     lb.add(new ListenableChanged().setVarName("item_grade"));
/*  651 */     lb.add(new ListenableChanged().setVarName("item_num"));
/*  652 */     lb.add(new ListenableChanged().setVarName("add_popularity_value"));
/*  653 */     lb.add(new ListenableChanged().setVarName("message"));
/*  654 */     lb.add(new ListenableChanged().setVarName("is_ssp_replied"));
/*  655 */     lb.add(new ListenableChanged().setVarName("is_cross_server"));
/*  656 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FriendsCircleGiftResult {
/*      */     private Const() {}
/*      */     
/*      */     FriendsCircleGiftResult nThis() {
/*  663 */       return FriendsCircleGiftResult.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  669 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendsCircleGiftResult copy()
/*      */     {
/*  675 */       return FriendsCircleGiftResult.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendsCircleGiftResult toData()
/*      */     {
/*  681 */       return FriendsCircleGiftResult.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FriendsCircleGiftResult toBean()
/*      */     {
/*  686 */       return FriendsCircleGiftResult.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendsCircleGiftResult toDataIf()
/*      */     {
/*  692 */       return FriendsCircleGiftResult.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FriendsCircleGiftResult toBeanIf()
/*      */     {
/*  697 */       return FriendsCircleGiftResult.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGive_gift_role_id()
/*      */     {
/*  704 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  705 */       return FriendsCircleGiftResult.this.give_gift_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGive_gift_zone_id()
/*      */     {
/*  712 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  713 */       return FriendsCircleGiftResult.this.give_gift_zone_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_cfg_id()
/*      */     {
/*  720 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  721 */       return FriendsCircleGiftResult.this.item_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_grade()
/*      */     {
/*  728 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  729 */       return FriendsCircleGiftResult.this.item_grade;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_num()
/*      */     {
/*  736 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  737 */       return FriendsCircleGiftResult.this.item_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAdd_popularity_value()
/*      */     {
/*  744 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  745 */       return FriendsCircleGiftResult.this.add_popularity_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMessage()
/*      */     {
/*  752 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  753 */       return FriendsCircleGiftResult.this.message;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMessageOctets()
/*      */     {
/*  760 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  761 */       return FriendsCircleGiftResult.this.getMessageOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_ssp_replied()
/*      */     {
/*  768 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  769 */       return FriendsCircleGiftResult.this.is_ssp_replied;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_cross_server()
/*      */     {
/*  776 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  777 */       return FriendsCircleGiftResult.this.is_cross_server;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGive_gift_role_id(long _v_)
/*      */     {
/*  784 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  785 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGive_gift_zone_id(int _v_)
/*      */     {
/*  792 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  793 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_cfg_id(int _v_)
/*      */     {
/*  800 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  801 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_grade(int _v_)
/*      */     {
/*  808 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  809 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_num(int _v_)
/*      */     {
/*  816 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  817 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAdd_popularity_value(int _v_)
/*      */     {
/*  824 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  825 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMessage(String _v_)
/*      */     {
/*  832 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  833 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMessageOctets(Octets _v_)
/*      */     {
/*  840 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  841 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_ssp_replied(boolean _v_)
/*      */     {
/*  848 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  849 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_cross_server(boolean _v_)
/*      */     {
/*  856 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  857 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  863 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  864 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  870 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  871 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  877 */       return FriendsCircleGiftResult.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  883 */       return FriendsCircleGiftResult.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  889 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  890 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  896 */       return FriendsCircleGiftResult.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  902 */       return FriendsCircleGiftResult.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  908 */       FriendsCircleGiftResult.this._xdb_verify_unsafe_();
/*  909 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  915 */       return FriendsCircleGiftResult.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  921 */       return FriendsCircleGiftResult.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  927 */       return FriendsCircleGiftResult.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  933 */       return FriendsCircleGiftResult.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  939 */       return FriendsCircleGiftResult.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  945 */       return FriendsCircleGiftResult.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  951 */       return FriendsCircleGiftResult.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FriendsCircleGiftResult
/*      */   {
/*      */     private long give_gift_role_id;
/*      */     
/*      */     private int give_gift_zone_id;
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
/*      */     private boolean is_ssp_replied;
/*      */     
/*      */     private boolean is_cross_server;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  979 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  984 */       this.message = "";
/*      */     }
/*      */     
/*      */     Data(xbean.FriendsCircleGiftResult _o1_)
/*      */     {
/*  989 */       if ((_o1_ instanceof FriendsCircleGiftResult)) { assign((FriendsCircleGiftResult)_o1_);
/*  990 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  991 */       } else if ((_o1_ instanceof FriendsCircleGiftResult.Const)) assign(((FriendsCircleGiftResult.Const)_o1_).nThis()); else {
/*  992 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FriendsCircleGiftResult _o_) {
/*  997 */       this.give_gift_role_id = _o_.give_gift_role_id;
/*  998 */       this.give_gift_zone_id = _o_.give_gift_zone_id;
/*  999 */       this.item_cfg_id = _o_.item_cfg_id;
/* 1000 */       this.item_grade = _o_.item_grade;
/* 1001 */       this.item_num = _o_.item_num;
/* 1002 */       this.add_popularity_value = _o_.add_popularity_value;
/* 1003 */       this.message = _o_.message;
/* 1004 */       this.is_ssp_replied = _o_.is_ssp_replied;
/* 1005 */       this.is_cross_server = _o_.is_cross_server;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1010 */       this.give_gift_role_id = _o_.give_gift_role_id;
/* 1011 */       this.give_gift_zone_id = _o_.give_gift_zone_id;
/* 1012 */       this.item_cfg_id = _o_.item_cfg_id;
/* 1013 */       this.item_grade = _o_.item_grade;
/* 1014 */       this.item_num = _o_.item_num;
/* 1015 */       this.add_popularity_value = _o_.add_popularity_value;
/* 1016 */       this.message = _o_.message;
/* 1017 */       this.is_ssp_replied = _o_.is_ssp_replied;
/* 1018 */       this.is_cross_server = _o_.is_cross_server;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1024 */       _os_.marshal(this.give_gift_role_id);
/* 1025 */       _os_.marshal(this.give_gift_zone_id);
/* 1026 */       _os_.marshal(this.item_cfg_id);
/* 1027 */       _os_.marshal(this.item_grade);
/* 1028 */       _os_.marshal(this.item_num);
/* 1029 */       _os_.marshal(this.add_popularity_value);
/* 1030 */       _os_.marshal(this.message, "UTF-16LE");
/* 1031 */       _os_.marshal(this.is_ssp_replied);
/* 1032 */       _os_.marshal(this.is_cross_server);
/* 1033 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1039 */       this.give_gift_role_id = _os_.unmarshal_long();
/* 1040 */       this.give_gift_zone_id = _os_.unmarshal_int();
/* 1041 */       this.item_cfg_id = _os_.unmarshal_int();
/* 1042 */       this.item_grade = _os_.unmarshal_int();
/* 1043 */       this.item_num = _os_.unmarshal_int();
/* 1044 */       this.add_popularity_value = _os_.unmarshal_int();
/* 1045 */       this.message = _os_.unmarshal_String("UTF-16LE");
/* 1046 */       this.is_ssp_replied = _os_.unmarshal_boolean();
/* 1047 */       this.is_cross_server = _os_.unmarshal_boolean();
/* 1048 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1054 */       int _size_ = 0;
/* 1055 */       _size_ += CodedOutputStream.computeInt64Size(1, this.give_gift_role_id);
/* 1056 */       _size_ += CodedOutputStream.computeInt32Size(2, this.give_gift_zone_id);
/* 1057 */       _size_ += CodedOutputStream.computeInt32Size(3, this.item_cfg_id);
/* 1058 */       _size_ += CodedOutputStream.computeInt32Size(4, this.item_grade);
/* 1059 */       _size_ += CodedOutputStream.computeInt32Size(5, this.item_num);
/* 1060 */       _size_ += CodedOutputStream.computeInt32Size(6, this.add_popularity_value);
/*      */       try
/*      */       {
/* 1063 */         _size_ += CodedOutputStream.computeBytesSize(7, ByteString.copyFrom(this.message, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1067 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1069 */       _size_ += CodedOutputStream.computeBoolSize(8, this.is_ssp_replied);
/* 1070 */       _size_ += CodedOutputStream.computeBoolSize(9, this.is_cross_server);
/* 1071 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1079 */         _output_.writeInt64(1, this.give_gift_role_id);
/* 1080 */         _output_.writeInt32(2, this.give_gift_zone_id);
/* 1081 */         _output_.writeInt32(3, this.item_cfg_id);
/* 1082 */         _output_.writeInt32(4, this.item_grade);
/* 1083 */         _output_.writeInt32(5, this.item_num);
/* 1084 */         _output_.writeInt32(6, this.add_popularity_value);
/* 1085 */         _output_.writeBytes(7, ByteString.copyFrom(this.message, "UTF-16LE"));
/* 1086 */         _output_.writeBool(8, this.is_ssp_replied);
/* 1087 */         _output_.writeBool(9, this.is_cross_server);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1091 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1093 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1101 */         boolean done = false;
/* 1102 */         while (!done)
/*      */         {
/* 1104 */           int tag = _input_.readTag();
/* 1105 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1109 */             done = true;
/* 1110 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1114 */             this.give_gift_role_id = _input_.readInt64();
/* 1115 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1119 */             this.give_gift_zone_id = _input_.readInt32();
/* 1120 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1124 */             this.item_cfg_id = _input_.readInt32();
/* 1125 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1129 */             this.item_grade = _input_.readInt32();
/* 1130 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1134 */             this.item_num = _input_.readInt32();
/* 1135 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1139 */             this.add_popularity_value = _input_.readInt32();
/* 1140 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 1144 */             this.message = _input_.readBytes().toString("UTF-16LE");
/* 1145 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1149 */             this.is_ssp_replied = _input_.readBool();
/* 1150 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1154 */             this.is_cross_server = _input_.readBool();
/* 1155 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1159 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1161 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1170 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1174 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1176 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendsCircleGiftResult copy()
/*      */     {
/* 1182 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendsCircleGiftResult toData()
/*      */     {
/* 1188 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FriendsCircleGiftResult toBean()
/*      */     {
/* 1193 */       return new FriendsCircleGiftResult(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendsCircleGiftResult toDataIf()
/*      */     {
/* 1199 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FriendsCircleGiftResult toBeanIf()
/*      */     {
/* 1204 */       return new FriendsCircleGiftResult(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1210 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1214 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1218 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1222 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1226 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1230 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1234 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGive_gift_role_id()
/*      */     {
/* 1241 */       return this.give_gift_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGive_gift_zone_id()
/*      */     {
/* 1248 */       return this.give_gift_zone_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_cfg_id()
/*      */     {
/* 1255 */       return this.item_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_grade()
/*      */     {
/* 1262 */       return this.item_grade;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_num()
/*      */     {
/* 1269 */       return this.item_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAdd_popularity_value()
/*      */     {
/* 1276 */       return this.add_popularity_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMessage()
/*      */     {
/* 1283 */       return this.message;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMessageOctets()
/*      */     {
/* 1290 */       return Octets.wrap(getMessage(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_ssp_replied()
/*      */     {
/* 1297 */       return this.is_ssp_replied;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_cross_server()
/*      */     {
/* 1304 */       return this.is_cross_server;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGive_gift_role_id(long _v_)
/*      */     {
/* 1311 */       this.give_gift_role_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGive_gift_zone_id(int _v_)
/*      */     {
/* 1318 */       this.give_gift_zone_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_cfg_id(int _v_)
/*      */     {
/* 1325 */       this.item_cfg_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_grade(int _v_)
/*      */     {
/* 1332 */       this.item_grade = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_num(int _v_)
/*      */     {
/* 1339 */       this.item_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAdd_popularity_value(int _v_)
/*      */     {
/* 1346 */       this.add_popularity_value = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMessage(String _v_)
/*      */     {
/* 1353 */       if (null == _v_)
/* 1354 */         throw new NullPointerException();
/* 1355 */       this.message = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMessageOctets(Octets _v_)
/*      */     {
/* 1362 */       setMessage(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_ssp_replied(boolean _v_)
/*      */     {
/* 1369 */       this.is_ssp_replied = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_cross_server(boolean _v_)
/*      */     {
/* 1376 */       this.is_cross_server = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1382 */       if (!(_o1_ instanceof Data)) return false;
/* 1383 */       Data _o_ = (Data)_o1_;
/* 1384 */       if (this.give_gift_role_id != _o_.give_gift_role_id) return false;
/* 1385 */       if (this.give_gift_zone_id != _o_.give_gift_zone_id) return false;
/* 1386 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/* 1387 */       if (this.item_grade != _o_.item_grade) return false;
/* 1388 */       if (this.item_num != _o_.item_num) return false;
/* 1389 */       if (this.add_popularity_value != _o_.add_popularity_value) return false;
/* 1390 */       if (!this.message.equals(_o_.message)) return false;
/* 1391 */       if (this.is_ssp_replied != _o_.is_ssp_replied) return false;
/* 1392 */       if (this.is_cross_server != _o_.is_cross_server) return false;
/* 1393 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1399 */       int _h_ = 0;
/* 1400 */       _h_ = (int)(_h_ + this.give_gift_role_id);
/* 1401 */       _h_ += this.give_gift_zone_id;
/* 1402 */       _h_ += this.item_cfg_id;
/* 1403 */       _h_ += this.item_grade;
/* 1404 */       _h_ += this.item_num;
/* 1405 */       _h_ += this.add_popularity_value;
/* 1406 */       _h_ += this.message.hashCode();
/* 1407 */       _h_ += (this.is_ssp_replied ? 1231 : 1237);
/* 1408 */       _h_ += (this.is_cross_server ? 1231 : 1237);
/* 1409 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1415 */       StringBuilder _sb_ = new StringBuilder();
/* 1416 */       _sb_.append("(");
/* 1417 */       _sb_.append(this.give_gift_role_id);
/* 1418 */       _sb_.append(",");
/* 1419 */       _sb_.append(this.give_gift_zone_id);
/* 1420 */       _sb_.append(",");
/* 1421 */       _sb_.append(this.item_cfg_id);
/* 1422 */       _sb_.append(",");
/* 1423 */       _sb_.append(this.item_grade);
/* 1424 */       _sb_.append(",");
/* 1425 */       _sb_.append(this.item_num);
/* 1426 */       _sb_.append(",");
/* 1427 */       _sb_.append(this.add_popularity_value);
/* 1428 */       _sb_.append(",");
/* 1429 */       _sb_.append("'").append(this.message).append("'");
/* 1430 */       _sb_.append(",");
/* 1431 */       _sb_.append(this.is_ssp_replied);
/* 1432 */       _sb_.append(",");
/* 1433 */       _sb_.append(this.is_cross_server);
/* 1434 */       _sb_.append(")");
/* 1435 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FriendsCircleGiftResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */